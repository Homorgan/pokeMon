# include <iostream>
//# include <apstring>
//# include <apvector>


struct STUDENT_TYPE
{
     apstring name, course;
     double average, finalExam;
};

//function prototypes
STUDENT_TYPE get_student( );
void print_student(STUDENT_TYPE & pupil);

int main(void)
{ 

     //declare the array of students
     apvector <STUDENT_TYPE> list(10); 

    // input the list of students
    for(int i = 0; i < 10; i++)
    {
         cout<<"Please enter information for student " << i+1 << endl << endl;
         list[ i ] = get_student( );  //use function to get individual info
    }

     // print the array of students one struct at a time
     for(int j = 0; j < 10; j++)
     {
          print_student(list [ j ] );
     }

     return 0;
}

//function to read in structure information (returns a structure)
STUDENT_TYPE get_student( )
{ 
     STUDENT_TYPE pupil;
     apstring dummy;

     cout << "Enter the name (last name, first name): ";
     getline( cin, pupil.name);
     cout << "Enter the course name: ";
    getline( cin, pupil.course);
    cout << "Enter the course average: ";
    cin>>pupil.average;
    cout << "Enter the final exam grade: ";
    cin>> pupil.finalExam;
   
    getline(cin,dummy);
    cout<<endl <<endl;

    return pupil;
}

//function to print structure
void print_student(STUDENT_TYPE &pupil)
{
      cout << "Name:	" <<pupil.name<< endl;
      cout << "Course:	" <<pupil.course <<endl;
      cout << "Average:	" << pupil.average << endl;
     cout << "Final Exam: " << pupil.finalExam << endl <<endl;
    return;
}