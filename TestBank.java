import java.util.Scanner;
//SAAD ALAGEEL 441100902
//MONDAY 1-3
public class TestBank {

	int choice;
	Scanner scanner;
	public void printMenu(){
		System.out.println("******************************");
		System.out.println("* 1- Add Client.             *");
		System.out.println("* 2- Close a client account. *");
		System.out.println("* 3- Deposit.                *");
		System.out.println("* 4- Withdraw.               *");
		System.out.println("* 5- Transfer                *");
		System.out.println("* 6- Transfer to another bank*");
		System.out.println("* 7- Display balance.        *");
		System.out.println("* 8- Find the richest client.*");
		System.out.println("*  9- Exit.                  *");
		System.out.println("******************************");
		scanner = new Scanner(System.in);
		choice = scanner.nextInt();
	}
	
	public static void main(String[] args){
		Bank b1= new Bank(5);
		Bank b2 = new Bank(2);
		b2.addClient("Mike", 1000);
		b2.addClient("Joe", 3000);
		
		TestBank testBank = new TestBank();
		testBank.p(b1,b2);
	}

	private void p(Bank b1,Bank b2) {
		boolean result;
		printMenu();
		switch(choice){
		
		case 1:
			System.out.print("Enter name and balance: ");
			String name = scanner.next();
			double balance = scanner.nextDouble();
			result = b1.addClient(name, balance);
			if(result){
				System.out.println("DONE");
			}else{
				System.out.println("ERROR");
			}
			p(b1,b2);
			break;
		case 2:

			System.out.print("Enter name : ");
			String clientToDelet = scanner.next();
			result  = b1.deleteClient(clientToDelet);
			if(result){
				System.out.println("DONE");
			}else{
				System.out.println("ERROR");
			}
			p(b1,b2);
			
		break;
		
		
		case 3:
			System.out.print("Enter name and amount: ");
			String depoName = scanner.next();
			double depAmt = scanner.nextDouble();
			result = b1.deposit(depoName, depAmt);
			if(result){
				System.out.println("DONE");
			}else{
				System.out.println("ERROR");
			}
			p(b1,b2);
			
			break;
			
		case 4:
			System.out.print("Enter name and amount: ");
			String withName = scanner.next();
			double withAmt = scanner.nextDouble();
			result = b1.withdraw(withName, withAmt);
			if(result){
				System.out.println("DONE");
			}else{
				System.out.println("ERROR");
			}
			p(b1,b2);
			
			break;
			
		case 5:
			System.out.print("Enter from name, to name and amount: ");
			String fromName = scanner.next();
			String toName = scanner.next();
			double amt = scanner.nextDouble();
			result = b1.transfer(fromName, toName, amt);
			if(result){
				System.out.println("DONE");
			}else{
				System.out.println("ERROR");
			}
			p(b1,b2);
			
			break;
			
			
		case 6:
			System.out.print("Enter from name (this bank), to name (other bank), and amount: ");
			String fName = scanner.next();
			String tName = scanner.next();
			double bankAmt = scanner.nextDouble();
			result = b1.transferToBank(fName, b2, tName, bankAmt);
			if(result){
				System.out.println("DONE");
			}else{
				System.out.println("ERROR");
			}
			p(b1,b2);
			
			break;
			
		case 7:
			System.out.print("Enter name: ");
			String dName = scanner.next();
			b1.display(dName);
			p(b1,b2);
			
			break;
		case 8:
			String maxName  = b1.findMax();
			if(maxName == null){
				System.out.println("No clients");
			}else{
				System.out.println(maxName);				
			}
			p(b1,b2);
			break;
			
		case 9:
			System.out.println("Good Bye!");
			System.exit(0);
			break;
		default:
			System.out.println("Wrong input");
			p(b1,b2);
			break;
		}
	}
}
