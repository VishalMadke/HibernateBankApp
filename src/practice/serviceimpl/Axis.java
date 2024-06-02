package practice.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import practice.configure.HBUtil;
import practice.model.Account;
import practice.service.RBI;

public class Axis implements RBI {

	Account ac = null;
	Scanner sc = new Scanner(System.in);

	public void createAccount() {

		ac = new Account();
		SessionFactory sf = HBUtil.getsessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Welcome to Account Opening Section : ");
		System.out.println("Enter Account number");
		ac.setAcNo(sc.nextLong());

		System.out.println("Enter Account Name");
		ac.setAcName(sc.next() + sc.nextLine());

		System.out.println("Enter Address");
		ac.setAcAddress(sc.next() + sc.nextLine());

		System.out.println("Enter Mobile No");
		ac.setMobileNo(sc.nextLong());

		System.out.println("Enter Adhar NO");
		ac.setAdharNo(sc.nextLong());

		System.out.println("Enter Pan");
		ac.setPanNo(sc.next());

		System.out.println("Enter Gender ");
		ac.setGender(sc.next());

		System.out.println("Enter Balance");
		ac.setBalance(sc.nextDouble());

		System.out.println("Thank You For visiting.....");
		System.out.println("***************************");
		System.out.println();

		session.save(ac);
		tx.commit();
		System.out.println("Thank You ");
	}

	public void viewAccountDetails() {

		SessionFactory sf = HBUtil.getsessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Account Number To sea Details : ");
		Account ac = session.get(Account.class, sc.nextLong());
		if (ac != null) {
			System.out.println("********-------------*********--------");
			System.out.println();
			System.out.println("Account Holder Name : " + ac.getAcName() + "\n Account holder Address " + " : "
					+ ac.getAcAddress() + " \n Account Holder Mobile No : " + ac.getMobileNo() + " \n"
					+ "Account Holder Aadhar No : " + ac.getAdharNo() + "\n Account Holder PanNo " + " : "
					+ ac.getPanNo() + "\n Account Holder Gender : " + ac.getGender() + "\n "
					+ "Account Holder balance : " + ac.getBalance());

			tx.commit();
			System.out.println("Thank You for visiting.....!");
			System.out.println("********-------------*********--------");
			System.out.println();
		} else {System.out.println();
			System.out.println("Can't find Out Account With this Number : ");
			System.out.println("<<<<<***********>>>>>");
		}
	}

	public void depositeMoney() {

		SessionFactory sf = HBUtil.getsessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Account No to Deposite Money");
		Account ac = session.get(Account.class, sc.nextLong());
		if (ac != null) {
			double avbal = ac.getBalance();

			System.out.println("Enter Amount You want to deposite : ");
			int damo = sc.nextInt();
			if (damo >= 100 && damo <= 10000) {
				double newbalance = avbal + damo;
				ac.setBalance(newbalance);
				tx.commit();
				System.out.println("Amount Deposited successfully....!");
			} else {
				System.out.println("Enter amount between 100 to 10000");
				System.out.println("Try Again");
				System.out.println();
			}
		} else {

			System.out.println("Can't find Out Account With This AcNo : ");
			System.out.println("");
		}
	}

	public void withdrawMoney() {
		SessionFactory sf = HBUtil.getsessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Account Number You Want Withdraw Money from : ");
		Account ac = session.get(Account.class, sc.nextLong());

		if (ac != null) {
			double avbal = ac.getBalance();
			System.out.println("Enter Amount to Withdraw Money : ");
			double wamo = sc.nextDouble();
			if (wamo >= 100 && wamo <= 10000) {
				double newbal = avbal - wamo;

				ac.setBalance(newbal);
				System.out.println("Account Withdraw Successfull....!");
				tx.commit();
			} else {
				System.out.println("Enter Amount between 100 - 10000 ");
				System.out.println("Thank You For Visiting...Try Again");
				System.out.println();
			}
		} else {
			System.out.println("Cannot Find Out Account With this Number : ");
			System.out.println();
		}

	}

	public void viewBalance() {
		SessionFactory sf = HBUtil.getsessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Account Number to check balance : ");

		Account ac = session.get(Account.class, sc.nextLong());
		if (ac != null) {
			String acName = ac.getAcName();
			double avbal = ac.getBalance();
			System.out.println();
			System.out.println("User Name : " + acName);
			System.out.println("Available Balanace : " + avbal);
			System.out.println();
		} else {
			System.out.println("cannot find out Account with this AcNo : ");
			System.out.println();
		}
	}

	public void updateDetails() {
		SessionFactory sf = HBUtil.getsessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(
				"Enter : \n 1 to update name : \n 2 for update mobileNo : \n 3 for aadharNo : \n 4 for PanNo : \n 5 for Exit : ");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter Account number to Update Name : ");
			Account ac = session.get(Account.class, sc.nextLong());

			if (ac != null) {
				System.out.println("Enter Name To replace : ");
				ac.setAcName(sc.next() + sc.nextLine());
				tx.commit();
				System.out.println("Name Updated Successfully...!");
			} else {
				System.out.println("Cannot find out Account with this Acno : ");
			}
			break;

		case 2:

			System.out.println("Enter Account Number to update Mobile No : ");
			ac = session.get(Account.class, sc.nextLong());
			if (ac != null) {
				System.out.println("Enter Account number to update : ");
				ac.setMobileNo(sc.nextLong());
				tx.commit();
				System.out.println("Mobile Number Updated Successfully");
			} else {
				System.out.println("Cannot find out Account with this number : ");
				System.out.println();
			}
			break;

		case 3:
			System.out.println("Enter Account Number to update Aadhar No : ");
			ac = session.get(Account.class, sc.nextLong());
			if (ac != null) {
				System.out.println("Enter new Adhar Number to update Aadhar :");
				ac.setAdharNo(sc.nextLong());
				tx.commit();
				session.close();
				System.out.println("Adhar Updated Successfully...!");
				System.out.println();
			} else {
				System.out.println("Cannot Find out Account With  this Acno ");
				System.out.println();
			}
			break;

		case 4:
			System.out.println("Enter Account Number To Update PAN no : ");
			ac = session.get(Account.class, sc.nextLong());
			if (ac != null) {
				System.out.println();
				System.out.println("Enter new Pan No to update : ");
				ac.setPanNo(sc.next());
				tx.commit();
				session.close();
				System.out.println("Pan No updated Successfully...!");
				System.out.println();
			} else {
				System.out.println("Can't find out Account with this number ");
				System.out.println();
			}
			break;

		case 5:
			System.out.println("Thank You For Visiting..... Visit Again");
			System.out.println();
			break;
		}
	}

	@SuppressWarnings("deprecation")
	public void viewAllAccountDetails() {
				SessionFactory sf = HBUtil.getsessionFactory();
				Session session = sf.openSession();
				@SuppressWarnings("unchecked")
				Query<Account>query = session.createSQLQuery("select * from Account ").addEntity(Account.class);
				List <Account>list = query.getResultList();
				
				Iterator <Account>itr = list.iterator();
				while(itr.hasNext())
				{
					Account ac = (Account)itr.next();
					System.out.println("Account Holder Name : " + ac.getAcName() + "\n Account holder Address " + " : "
							+ ac.getAcAddress() + " \n Account Holder Mobile No : " + ac.getMobileNo() + " \n"
							+ "Account Holder Aadhar No : " + ac.getAdharNo() + "\n Account Holder PanNo " + " : "
							+ ac.getPanNo() + "\n Account Holder Gender : " + ac.getGender() + "\n "
							+ "Account Holder balance : " + ac.getBalance());
					
					System.out.println();
					
					System.out.println("******************************");
				}	
		}
	
		@SuppressWarnings("deprecation")
		public void deleteAccount() {
				SessionFactory sf = HBUtil.getsessionFactory();
				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();
				System.out.println();
				System.out.println("Enter Account Number to delete Account : ");
				int Acno = sc.nextInt();
				Query query = session.createSQLQuery("delete from Account where Acno = ?").addEntity(Account.class);
				
				query.setParameter(0, Acno);
				query.executeUpdate();
				tx.commit();
		
				System.out.println(" Deleted Successfully...!");
				
	}
}