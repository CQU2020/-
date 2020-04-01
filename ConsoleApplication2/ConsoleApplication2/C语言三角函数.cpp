#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

float pwr(float x, int n)
{
	int i = 0;
	float powers = 1;
	// printf("n = %d\n",n);
	if (n == 0)
	{
		//     printf("yes\n");
		return 1;
	}
	for (i = 1; i <= n; i++)
	{
		powers = powers * x;
	}
	// printf("power = %f\n",powers);
	return powers;
}
int fac(int n)
{
	int i = 0;
	float pdt = 1;
	if (n == 0 || n == 1)
	{
		//     printf("yes\n");
		return 1;
	}
	for (i = 2; i <= n; i++)
	{
		pdt = pdt * i;
	}
	// printf("pdt = %f\n",pdt); 
	return pdt;
}
int main()
{
	int k = 0, i = 0, j = 0, cons = 1;
	float x = 0, s = 0, c = 0, sin = 0, cos = 0, tan = 0, y = 0;     //用y将弧度制转换为角度制 
	const float pi = 3.1415926;
	printf("输入角度:");
	scanf("%f", &y);
	x = y*pi / 180;
	for (k = 1; k <= 11; k++)
	{
		i = 2 * k - 1;
		j = 2 * k - 2;
		s = cons*pwr(x, i) / fac(i);
		c = cons*pwr(x, j) / fac(j);
		cons = -1 * cons;
		//  printf("cons = %d\n",cons);
		sin = sin + s;
		cos = cos + c;
	}
	tan = sin / cos;
	printf("sin(%.0f) = %f cos(%.0f) = %f tan(%.0f) = %f", y, sin, y, cos, y, tan);
	return 0;
}