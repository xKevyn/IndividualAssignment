import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ATM_Machine 
{
	public static void main(String[] args) 
	{
		//Variables
		String pin;
		String transaction;
		String acc_type;
		String id;
		String bill;
		final String User_Pin = "123456";//user's registered pin
		int electricBill = 150;
		int waterBill = 20;
		int saving_acc = 500;
		int current_acc = 0;
		
		//to cut the code
		final String acc_typeSEL = "Select your account type\n"
				+ "1.Savings\n"
				+ "2.Current";
		final String bill_typeSEL = "Select your bill to pay\n"
				+ "1.Electric bill\n"
				+ "2.Water bill";
		final String transactionSEL = "Please select a transaction\n"
				+ "1.Transfer\n"
				+ "2.Deposit money\n"
				+ "3.Balance Enquiry\n"			
				+ "4.Bill Pay\n"
				+ "5.Withdraw Money\n";
		
		//Declaration of Registered id list
		ArrayList<String> idList = new ArrayList<String>();
		
		//Initializing idList
		idList.add("123456789");
		idList.add("325363744");
		idList.add("324928734");
		idList.add("193850726");
		idList.add("908462745");
		
		//Loop for inputing pin (maximum 3 times)
		JOptionPane.showMessageDialog(null,"Please insert your card", "Please insert your card", JOptionPane.INFORMATION_MESSAGE);
		
		pin = Pin();
		//if the pin is correct proceed to the next step
		if(pin.equals(User_Pin))
		{		
			transaction = JOptionPane.showInputDialog(null,transactionSEL);//user can select the functionality they want to use
			
			//functionality options
			switch(transaction)
			{
				default:
					JOptionPane.showMessageDialog(null,"Please select a valid transaction");//showing error message to user
					break;
				case "1":
					//Input
					do
					{
						id = JOptionPane.showInputDialog(null,"Please insert the account id that you want to transfer to", 
								"Transfer", JOptionPane.INFORMATION_MESSAGE);
					}
					while(idList.contains(id) == false);
						
					//If the id entered is correct, proceed to the next step
					if(idList.contains(id))
					{
						//Input
						acc_type = JOptionPane.showInputDialog(null,acc_typeSEL,"Account Type", JOptionPane.INFORMATION_MESSAGE);
								
						//current or saving account
						switch(acc_type)
						{
						case "1":
						Transfer(saving_acc);
						
						break;
						case "2":
						Transfer(current_acc);
						
						break;
						default:
						JOptionPane.showMessageDialog(null,"Please select a valid account type");//show error message to user
						break;
						}					
					}
					break;
				case "2":
					//Input
					acc_type = JOptionPane.showInputDialog(null,acc_typeSEL, "Account Type", JOptionPane.INFORMATION_MESSAGE);
					
					//current or saving account
					switch(acc_type)
					{
					case "1":
					Deposit(saving_acc);
					break;
					case "2":
					Deposit(current_acc);
					break;
					}
					break;
				case "3":
					//Displaying the balance of current account and saving account
					JOptionPane.showMessageDialog(null,"Balance\nSaving Account:" + saving_acc + "\nCurrent Account:" + current_acc);
					break;
				case "4":
					//Input
					acc_type = JOptionPane.showInputDialog(null,acc_typeSEL, JOptionPane.INFORMATION_MESSAGE);
					
					//current or saving account
					switch(acc_type)
					{
						case "1":
							//Input
							JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
							bill = JOptionPane.showInputDialog(null,bill_typeSEL,"Bill Type", JOptionPane.INFORMATION_MESSAGE);
							
							//electric or water bill
							switch(bill)
							{
								case "1":									
									Bill(saving_acc, electricBill);
									
									break;
								case "2":
									Bill(saving_acc, waterBill);
									break;
								default:
									JOptionPane.showMessageDialog(null,"Please select a valid bill type");
									break;
							}
							break;
						case "2":
							JOptionPane.showMessageDialog(null,"Current Balance:RM" + current_acc);//show the current balance user have
							bill = JOptionPane.showInputDialog(null,bill_typeSEL,"Bill Type", JOptionPane.INFORMATION_MESSAGE);
							switch(bill)
							{
								case "1":
									Bill(current_acc, electricBill);
									
									break;
								case "2":
									Bill(current_acc, waterBill);
									
									break;
								default:
									JOptionPane.showMessageDialog(null,"Please select a valid bill type");
									break;
							}
							break;
							default:
								JOptionPane.showMessageDialog(null,"Please select a valid account type");
								break;
					}
					break;
				case "5":
					acc_type = JOptionPane.showInputDialog(null,acc_typeSEL,"Account Type", JOptionPane.INFORMATION_MESSAGE);

						//current or saving account
						switch(acc_type)
						{
							case "1":
								Withdraw(saving_acc);
								break;
							case "2":
								Withdraw(current_acc);							
								break;
							default:
								JOptionPane.showMessageDialog(null,"Please select a valid account type");//show error message to user
								break;
						}
			}					
		}
	}
	public static String Pin()
	{
		String pin;
		final String User_Pin = "123456";//user's registered pin
		int times = 0;
		
		do
		{	
			//putting it after the times++ statement so that when user enter the correct pin and when the user exceed three times of tries this wont show
			if(times > 0)	
			{
				JOptionPane.showMessageDialog(null,"The pin is incorrect, please try again");
			}
			pin = JOptionPane.showInputDialog(null,"Please enter your pin", "Pin", JOptionPane.INFORMATION_MESSAGE);//prompt
			times++;
			if(times == 3)
			{
				JOptionPane.showMessageDialog(null,"You have exceed the maximum number of tries");
			}
		}
		//user can reenter the pin if its wrong but when it exceed three tries, user can no longer attempt to enter pin anymore
		while(pin.equals(User_Pin) == false && times < 3);
		
		return pin;
	}
	public static void Transfer(int acc_type)
	{
		int amount;
		
		JOptionPane.showMessageDialog(null,"Current Balance:RM" + acc_type);//show the current balance user have
		amount = Amount();		
		
		if(acc_type > amount)
		{
			acc_type -= amount;	
			
			JOptionPane.showMessageDialog(null,"You have successfully transfer the money");//notify user that the process is succeed
			JOptionPane.showMessageDialog(null,"New Balance:RM" + acc_type);//show the new balance after transferring
		}
		else
		{
			JOptionPane.showMessageDialog(null,"You have failed to transfer the money");//notify user that the process is succeed
			
			acc_type += amount;
		}
	}
	public static void Deposit(int acc_type)
	{
		int amount;
		
		JOptionPane.showMessageDialog(null,"You're not allow to deposit cents, RM1 Note, RM5 Note");
		JOptionPane.showMessageDialog(null,"Current Balance:RM" + acc_type);//show the current balance user have
		
		amount = Amount();
		
		acc_type += amount;
		
		JOptionPane.showMessageDialog(null,"Please insert your money");//notify user to insert their money
		JOptionPane.showMessageDialog(null,"New Balance:RM" + acc_type);//show the new balance after depositing
	}
	public static void Bill(int acc_type, int bill_type)
	{
		if(acc_type > bill_type)
		{
			JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
			acc_type -= bill_type;
			JOptionPane.showMessageDialog(null,"New Balance: RM" + acc_type);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
		}
	}
	public static void Withdraw(int acc_type)
	{
		int amount;
		
		JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents");
		JOptionPane.showMessageDialog(null,"Current Balance:RM" + acc_type);//show the current balance user have
		amount = Amount();
		
		if(acc_type > amount)
		{
			acc_type -= amount;
			
			JOptionPane.showMessageDialog(null,"New Balance:RM" + acc_type);//show the new balance after withdrawing
			JOptionPane.showMessageDialog(null,"Please take your money");//notify user to take their money
		}
		else
		{
			JOptionPane.showMessageDialog(null,"You have failed to withdraw the money");//notify user that the process is succeed
			
			acc_type += amount;
		}
	}
	public static int Amount()
	{
		String amountString;
		int amount;
		
		amountString = JOptionPane.showInputDialog(null,"Enter amount", "Amount", JOptionPane.INFORMATION_MESSAGE);//prompt
		amount = Integer.parseInt(amountString);
		
		return amount;
	}
}
