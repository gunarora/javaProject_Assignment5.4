package javaProject_Assignment5; //Package declaration is mandatory

/*Write a program that will compute an Employee's salary
and manage their leave details. */

//Pf = 12% of basic hra
//= 50% of basic
//total_sal = basic + hra – pf

//Importing scanner class for taking input from user
import java.util.Scanner;

//Employee Class - Main Class
public  class Employe {
	//Declare variables
	int empId;
	String empName;
	int	total_leaves=20;
	double total_salary;
	int Employee_Leave_Balance =4; 

	//Methods 
	 void calculate_balance_leaves()
	 {
		 System.out.println("print Balance Leaves");
	 }
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		return false; //by default, leave not available		
	};
	 void calculate_salary()
	 {
		 System.out.println("Get total salary from formula:");
	 }
	
	 //Main method started
	 public static void main(String[] args) {
		 
		 //object initialized for user input
			Scanner sc  = new Scanner(System.in);
			//Object created
			Employe emp = new Employe();
			//Taking inputs from user
			System.out.println("Please Enter Employe id");
			emp.empId = sc.nextInt();
			System.out.println("Please Enter Employe Name");
			emp.empName = sc.next();
			
			//Object created
			PermanentEmp pEmp = new PermanentEmp();
			//Taking inputs from user
			System.out.println("Please Enter Basic Salary");
			pEmp.basic = sc.nextDouble();
			//Calling object to calculate salary
			pEmp.calculate_salary(pEmp.basic);
			
			//Object created
			TemporaryEmp tEmp = new TemporaryEmp();
			//Taking inputs from user
			 System.out.println("Enter Number of Working Hours:");
			 tEmp.workinghrs = sc.nextInt();
			 //logic applied
			 tEmp.rate = 50 * tEmp.workinghrs;
			//Calling object to calculate salary
			tEmp.calculate_salary(tEmp.rate);
			
			
			//Leaves Managemnt
			//Calling objects
			pEmp.print_leave_details();
			pEmp.calculate_balance_leaves();
			pEmp.avail_leave(2, 'P');
			
			tEmp.calculate_balance_leaves();
			tEmp.avail_leave(3, 'C');
			

		}
	
}

//Permanent Employee class 
class PermanentEmp extends Employe
{
	//Declaring variables
	int paid_leave, sick_leave, casual_leave;
	int balance_leaves;
	double basic, hra,pf;
	
	//Print leave details
	void print_leave_details() {
		paid_leave = 8;
		sick_leave = 5;
		casual_leave = 5;
		System.out.println("Paid Leave =" + paid_leave );
		System.out.println("Sick Leave =" + sick_leave );
		System.out.println("Casual Lleave =" + casual_leave );
	};
	
	//methods
	 void calculate_balance_leaves() {
		 balance_leaves = total_leaves - (paid_leave+sick_leave+casual_leave);
		 System.out.println("Balance Leave =" + balance_leaves );
	 };
	 //available leaves
	 boolean avail_leave(int no_of_leaves,char type_of_leave)
	 {
		 if((no_of_leaves >0) || ((type_of_leave == 'P') || (type_of_leave == 'S') || (type_of_leave == 'C')))
		 {
			 System.out.println("no_of_leaves = " + no_of_leaves + " and type_of_leave= "+type_of_leave );	
		 return true;
		 }
		 else 
		 {
			 System.out.println("no_of_leaves = " + no_of_leaves + " and type_of_leave= "+type_of_leave );
			 return false;
		 }
	 }
	 
	 void calculate_salary(double basic)
	 {
		 double pf = (double)(basic*(12/100.0f));
			double hra = (double)(basic*(50/100.0f));
			total_salary = basic + hra;// – pf;
			total_salary = total_salary-pf;
			System.out.println("total Salary = " + total_salary);
	 }
}

//Temporary class
class TemporaryEmp extends Employe
{
	//Declare variables
	int workinghrs,Balance_Leaves;
	double rate;
	
	//Methods
	 void calculate_balance_leaves() {		 
		 Balance_Leaves = (total_leaves - Employee_Leave_Balance);
		 System.out.println("Balance Leaves =" + Balance_Leaves );
	 };
	 
		 boolean avail_leave(int no_of_leaves,char type_of_leave)
		 { 
			 if((no_of_leaves >0) || ((type_of_leave == 'P') || (type_of_leave == 'S') || (type_of_leave == 'C')))
			 {
				 System.out.println("no_of_leaves = " + no_of_leaves + " and type_of_leave= "+type_of_leave );	
			 return true;
			 }
			 else 
			 {
				 System.out.println("no_of_leaves = " + no_of_leaves + " and type_of_leave= "+type_of_leave );
				 return false;
			 }
		 };
	
	
	void calculate_salary(double sal)
	{
		System.out.println("Temporary Emp's total Salary " + rate);
	}
}


