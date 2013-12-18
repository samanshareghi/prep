#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char* StrReverse(char*);
char* StrReverse1(char*);
char* StrReverse2(char*);
void StrReverse3(char*);
void StrReverse4(char*);

int main(void)
{

	char str[50];
	int temp=0;

	printf("Enter a string: ");
	scanf("%s", str);
	printf("The reverse of the string is: %s\n", StrReverse(str));
	printf("The reverse of the string is: %s\n", StrReverse1(str));
	printf("The reverse of the string is: %s\n", StrReverse2(str));

	StrReverse3(str);
	printf("The reverse of the string is: %s\n", str);
	
	//Get back the original string
	StrReverse3(str);
	
	//Reverse it again
	printf("The reverse of the string is: ");
	StrReverse4(str);
	printf("\n");

	scanf("%d", &temp);

}


char* StrReverse(char* str)
{
	char *temp, *ptr;
	int len, i;

	temp=str;
	for(len=0; *temp !='\0';temp++, len++);
	
	ptr=malloc(sizeof(char)*(len+1));
	
	for(i=len-1; i>=0; i--) 
		ptr[len-i-1]=str[i];
	
	ptr[len]='\0';
	return ptr;
}

char* StrReverse1(char* str)
{
	char *temp, *ptr;
	int len, i;

	temp=str;
	for(len=0; *temp !='\0';temp++, len++);
	
	ptr=malloc(sizeof(char)*(len+1));
	
	for(i=len-1; i>=0; i--) 
		*(ptr+len-i-1)=*(str+i);
	
	*(ptr+len)='\0';
	return ptr;
}

char* StrReverse2(char* str)
{
	int i, j, len;
	char temp;
	char *ptr=NULL;
	i=j=len=temp=0;

	len=strlen(str);
	ptr=malloc(sizeof(char)*(len+1));
	ptr=strcpy(ptr,str);
	for (i=0, j=len-1; i<=j; i++, j--)
	{
		temp=ptr[i];
		ptr[i]=ptr[j];
		ptr[j]=temp;
	}
	return ptr;
}

void StrReverse3(char* str)
{
	int i, j, len;
	char temp;
	i=j=len=temp=0;

	len=strlen(str);
	for (i=0, j=len-1; i<=j; i++, j--)
	{
		temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
}



/*A coooooooooool way of reversing a string by recursion. I found it at this web address
http://www.geocities.com/cyberkabila/datastructure/datastructuresright_reversestring.htm
*/

void foo(char *str)
{
	if(*str)
	{
		foo(str+1);
		putchar(*str);
	}
}