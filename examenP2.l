%option noyywrap
%{
    #include <stdio.h>
    #include <string.h>

    int comentarios = 0;

    // Palabras reservadas de C++
    char *reservadas[] = {
        "int","float","double","char","void","if","else","for","while",
        "do","switch","case","break","continue","return","class","struct",
        "public","private","protected","virtual","const","new","delete",
        "try","catch","throw","namespace","using","include","template",
        "this","operator","true","false","long","short","signed","unsigned"
    };
    int nreservadas = sizeof(reservadas) / sizeof(reservadas[0]);

    int es_reservada(char *lexema) {
        int i;  // Declarada fuera del for para compatibilidad con C90
        for (i = 0; i < nreservadas; i++) {
            if (strcmp(lexema, reservadas[i]) == 0)
                return 1;
        }
        return 0;
    }
%}

DIGITO      [0-9]
LETRA       [a-zA-Z_]
ID          {LETRA}({LETRA}|{DIGITO})*
NUMERO      {DIGITO}+(\.{DIGITO}+)?
OP_ARIT     [\+\-\*/%]
OP_LOGICO   (==|!=|<=|>=|&&|\|\||!)
SIMBOLOS    [;:,(){}\[\]<>]

%%

"//".*                          { comentarios++; printf("Comentario de una linea detectado.\n"); }
"/*"([^*]|\*+[^*/])*\*+"/"      { comentarios++; printf("Comentario multiple detectado.\n"); }
{NUMERO}                        { printf("Constante numerica detectada: %s\n", yytext); }
{OP_ARIT}                       { printf("Operador aritmetico detectado: %s\n", yytext); }
{OP_LOGICO}                     { printf("Operador logico detectado: %s\n", yytext); }
{SIMBOLOS}                      { printf("Simbolo especial detectado: %s\n", yytext); }
{ID}                            {
                                    if (es_reservada(yytext))
                                        printf("Palabra reservada detectada: %s\n", yytext);
                                    else
                                        printf("Variable detectada: %s\n", yytext);
                                }
[ \t\n]+                        ; // Ignorar espacios y saltos de línea
.                               ; // Ignorar otros caracteres

%%

int main() {
    FILE *yyin = fopen("codigo.txt", "r");
    if (!yyin) {
        printf("No se pudo abrir el archivo codigo.txt\n");
        return 1;
    }
    printf("Analizando archivo codigo.txt...\n\n");
    yylex();
    printf("\nTotal de comentarios detectados: %d\n", comentarios);
    fclose(yyin);
    return 0;
}
