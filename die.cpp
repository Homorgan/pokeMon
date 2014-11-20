#include <iostream>
#include <ctime>
#define WIDTH 5
#define HEIGHT 5

using namespace std;
int jimmy [HEIGHT][WIDTH];
int tmp;
int rep;
int n,m;
double time_S;
clock_t start, finish;
int main(int argc, char *argv[]) {
		int numfaces;
		start = clock();
		srand (time(NULL));
		cout << "How many sides will your die have :";
		cin >> numfaces;
		cout << "You rolled " << (rand() %numfaces+1) << "\n";
		  for (n=0; n<HEIGHT; n++)
		{
		    for (m=0; m<WIDTH; m++)
		    {
		      jimmy[n][m]=(rand() %numfaces+1);
			  printf ("%4d", jimmy [n][m]);
		    }
		cout << "\n";
		}
		cout << "What number do you wish to replace?\n";
		cin >> tmp;
		cout << "Repace " << tmp << " with what number? ";
		cin >> rep;
		for (n=0; n<HEIGHT; n++)
				{
				    for (m=0; m<WIDTH; m++)
				    {
					if (tmp == jimmy[n][m]) {
						jimmy[n][m] = rep;
					}
					}	
				}
		for (n=0; n<HEIGHT; n++) {
			for (m=0; m<WIDTH; m++) {
				printf ("%4d", jimmy [n][m]);
			}
			cout << "\n";
		}
		finish = clock();
		time_S = (double(finish) - double(start))/CLOCKS_PER_SEC;
		cout << time_S << " " << CLOCKS_PER_SEC;
		return 0;
}