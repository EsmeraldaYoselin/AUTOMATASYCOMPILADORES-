#include <iostream>
#include <string>
#include <cctype>
#include <iomanip>

using namespace std;

int main() {

	cout<<left<<setw(20)<<"Entrada"<<setw(20)<<"Salida"<<endl;
	cout<<string(32, '-')<<endl;

	for(int x=0; x<3; x++){
		string cad;
		bool num=true;
		bool letra=true;

		cout<<x+1<<"-";
		cin>>cad;

		for(int y=0; y<cad.size(); y++){
			char c=cad[y];
			if(!isdigit(c)){
				num=false;
			}
			if(!isalpha(c)){
				letra=false;
			}
		}

		string r;
		if(num){
			r="Numero entero";
		} 
		else if(letra){
			r="Palabra";
		} 
		else{
			r="Compuesta";
		}

		cout<<left<<setw(20)<<cad<<setw(20)<<r<<endl;
	}

	return 0;
}


