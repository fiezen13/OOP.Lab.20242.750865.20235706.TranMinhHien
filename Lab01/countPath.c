//dem so duong di tren luoi o, chi duoc di sang phai 
//hoac di xuong duoi
#include<stdio.h>

int countPaths(int i, int j, int D, int C){
	if(i==D || j==C) return 1;
	else{
		return countPaths(i+1,j,D,C)+countPaths(i,j+1,D,C);
	}	
}

int main()
{
	printf("%d kmkmkmkmkmk", countPaths(2,3,4,4));
}
gfy
