package practice.admin;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import practice.configure.HBUtil;
import practice.service.RBI;
import practice.serviceimpl.Axis;
public class Bank {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		RBI r=new Axis();
		boolean flag=true;
			
		while(flag)
		{
			System.out.println("Welcome to Axis Bank : ");
			System.out.println("Enter 1 to create Account : ");
			System.out.println("Enter 2 to view Account Details : ");
			System.out.println("Enter 3 to depost Money : ");
			System.out.println("Enter 4 to Withdraw Money :");
			System.out.println("Enter 5 to view Balance : ");
			System.out.println("Enter 6 to update Details : ");
			System.out.println("Enter 7 to see All Account Details : ");
			System.out.println("Enter 8 to delete Account : ");
			System.out.println("Enter  to Exit : ");
			
			System.out.println("********------*******-------******");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				r.createAccount();
				break;
			case 2:
				r.viewAccountDetails();
				break;
			case 3:
				r.depositeMoney();
				break;
			case 4:
				r.withdrawMoney();
				break;
			case 5:
				r.viewBalance();
				break;
			case 6:
				r.updateDetails();
				break;
			case 7 :
				r.viewAllAccountDetails();
				break;
				
			case 8:
				r.deleteAccount();
				break;
			case 9:
				SessionFactory sf = HBUtil.getsessionFactory();
				sf.close();
				System.out.println("Thank You For Visiting us :- ");
				flag=false;
				
				default:
					break;
				}
			}
		
		
		}
}
