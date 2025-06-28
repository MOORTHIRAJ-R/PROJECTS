package exceptionHandling;

import java.util.Scanner;

// Custom Exception Classes 

class LimitExceededException extends Exception{
	public LimitExceededException (String msg) {
		super(msg);
	}
}
class NegativeAmountException extends Exception{
	public NegativeAmountException (String msg) {
		super(msg);
	}
}class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException (String msg) {
		super(msg);
	}
}

// Main class

public class BankAtmSimulator {

	
	static int AccountBalance = 50000;
	
	// Check Balance
	
	public static void checkBalance() {
		System.out.println("Your Currunt Account Balance is $"+AccountBalance);
	}
	
	// Deposit 
	
	public static void deposit(int Deposit) throws NegativeAmountException{
		if(Deposit <0) throw new NegativeAmountException("Deposit Must be a Positive");
		else {
			System.out.println("Deposit Successfull $"+ Deposit);
			AccountBalance+=Deposit;
		}
		checkBalance();
	}
	// Withdrawal 
	
	public static void withdrawal(int Amount) throws InsufficientBalanceException,LimitExceededException{
		if(AccountBalance < Amount ) throw new InsufficientBalanceException("Insufficient Balance ! Please Check Your Balance");
		
		 if(Amount >10000)throw new LimitExceededException("Limit Exceeded ! Please Enter less than 10000 $");
		
		System.out.println("Withdrawal Successfully Completed.."+ Amount);
		AccountBalance-= Amount;
		checkBalance();
	
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        int Choice;
        
        do {
        	System.out.println("----------- ATM Menu -----------");
        	System.out.println("1.Check Bank Balance");
        	System.out.println("2.Withdrawal");
        	System.out.println("3.Deposit");
        	System.out.println("4.Exit");
        	Choice = sc.nextInt();
        	try {
        		switch(Choice) {
        		case 1 : checkBalance();
        		break;
        		
        		case 2 : 
        			System.out.println("Enter your Withdrawal Amount ");
        			int WithdrawalAmount = sc.nextInt();
        			withdrawal(WithdrawalAmount);
        			break;
        		 
        		case 3 : 
        			System.out.println("Enter your Deposit Amount ");
        	     	int DepositAmount = sc.nextInt();
        	    	deposit(DepositAmount);
        		break;
        		
        		case 4 : System.out.println("Exiting....Thank you For Using Our ATM");
        		break;
        		
        		default : System.out.println("Invalid Choice");
        		}
        	}catch(Exception e ) {
        		System.out.println(e.getMessage());
        	}
        	
        }while(Choice !=4);
	}

}