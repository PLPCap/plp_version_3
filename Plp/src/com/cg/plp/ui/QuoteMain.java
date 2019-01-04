package com.cg.plp.ui;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.plp.bean.AccountCreationBean;
//import com.cg.plp.bean.UserCreationBean;
import com.cg.plp.bean.UserLoginBean;
import com.cg.plp.service.IQuoteService;
import com.cg.plp.service.QuoteServiceImpl;

public class QuoteMain {

	static Scanner sc=new Scanner(System.in);
	static UserLoginBean userLoginBean=null;
	//static UserCreationBean userCreationBean=null;
	static AccountCreationBean accountCreationBean=null;
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException
	
	
	{
		System.out.println("*******************Welcome To Online Insurance Quote Generation****************");
		System.out.println("Login Id:");
		String id=sc.next();
		System.out.println("Password:");
		String pass=sc.next();
		//System.out.print("1.user\t 2.Agent\t 3.Admin");
		userLoginBean=new UserLoginBean();
		userLoginBean.setLoginId(id);
		userLoginBean.setPassword(pass);
		
		IQuoteService iQuoteService=new QuoteServiceImpl();
		
		int role_code=iQuoteService.checkValidLogin(userLoginBean);
		System.out.println(role_code);
		if(role_code==3)
		{
			System.out.println("Admin Priviledges Granted!!!");
			System.out.println("1.New Profile creation");
			System.out.println("2.Account creation");
			System.out.println("3.Policy creation");
			System.out.println("4.View Policy");
			System.out.println("5.Report generation");
			
			
			System.out.println("Enter your option: ");
			int option=sc.nextInt();
			
			
			
			switch(option)
			{
				case 1:
					System.out.println("Enter the following details:-> ");
					System.out.println("Login Id:");
					String id1=sc.next();
					System.out.println("Password:");
					String pass1=sc.next();
					System.out.println("Role Code:");
					int role1=sc.nextInt();
					userLoginBean.setLoginId(id1);
					userLoginBean.setPassword(pass1);
					userLoginBean.setRoleCode(role1);
					iQuoteService.profileCreation(userLoginBean);
					break;
			
				case 2:
					System.out.println("Enter the following details:-> ");
					System.out.println("Insured Name: ");
					String name=sc.next();
					AccountCreationBean accountCreationBean=new AccountCreationBean();
					accountCreationBean.setInsuredName(name);
					//accountCreationBean.setInsuredName(sc.next());
					System.out.println("Insured Street: ");
					accountCreationBean.setInsuredStreet(sc.next());
					System.out.println("Insured City: ");
					accountCreationBean.setInsuredCity(sc.next());
					System.out.println("Insured State: ");
					accountCreationBean.setInsuredState(sc.next());
					System.out.println("Insured Zip: ");
					accountCreationBean.setInsuredZip(sc.nextInt());
					
					System.out.println("Business Segment: ");
					System.out.println("Please enter from the following options:\n1.Vehicle\n2.Shop\n3.Apartment");
					int segment=sc.nextInt();
					
					
					switch(segment)
					{
					case 1:
						String segment1="Vehicle";
						accountCreationBean.setBusinessSegment(segment1);
						break;
					case 2:
						String segment2="Shop";
						accountCreationBean.setBusinessSegment(segment2);
						break;
					case 3:

						String segment3="Apartment";
						accountCreationBean.setBusinessSegment(segment3);
						break;
					}
					
					
					
					//accountCreationBean.setBusinessSegment(sc.next());
					
					System.out.println("Account Number: ");
					accountCreationBean.setAccountNo(Math.random()*100000);
					
					iQuoteService.accountCreation(accountCreationBean);
					
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 0:
					System.exit(0);
					break;
			
			
			
			}
			
			
			
			
			
			
			
		}
		
		
	}

}
