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
		String amountString;
		String id;
		String bill;
		String confirmationString;
		final String acc_typeSEL = "Select your account type\n"
				+ "[ 1.Savings /"
				+ " 2.Current ]";
		final String bill_typeSEL = "Select your bill to pay\n"
				+ "[ 1.Electric bill /"
				+ " 2.Water bill ]";
		final String ConfirmationSEL = "Are you sure you want to pay the bill\n"
				+ "[ 1.Yes /"
				+ " 2.No ]";
		final String User_Pin = "123456";//user's registered pin
		int electricBill = 150;
		int waterBill = 20;
		int times = 0;
		int amount;
		int saving_acc = 500;
		int current_acc = 0;
		int confirmation;
		
		//Initializing idList
		ArrayList<String> idList = new ArrayList<String>();//Registered ids
		idList.add("123456789");
		idList.add("325363744");
		idList.add("324928734");
		idList.add("193850726");
		idList.add("908462745");
		
		//Loop for inputing pin (maximum 3 times)
		JOptionPane.showMessageDialog(null,"Please insert your card");
		
		do
		{
			pin = JOptionPane.showInputDialog(null,"Please enter your pin", "Pin", JOptionPane.INFORMATION_MESSAGE);//prompt
			times++;
			if(times == 3)
			{
				JOptionPane.showMessageDialog(null,"You have exceed the maximum number of tries");
			}
		}
		//user can reenter the pin if its wrong but when it exceed three tries, user can no longer attempt to enter pin anymore
		while(pin.equals(User_Pin) == false && times < 3);
		
		//if the pin is correct proceed to the next step
		if(pin.equals(User_Pin))
		{		
			transaction = JOptionPane.showInputDialog(null,"Please select a transaction\n"
								+ "[ 1.Transfer "
								+ "/ 2.Deposit money "
								+ "/ 3.Balance Enquiry "
								+ "/ 4.Bill Pay "
								+ "/ 5.Withdraw Money ]");//user can select the functionality they want to use
			
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
						JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
						amountString = JOptionPane.showInputDialog(null,"Enter amount to transfer", "Amount transfer", JOptionPane.INFORMATION_MESSAGE);//prompt
						amount = Integer.parseInt(amountString);
						
						saving_acc -= amount;
						
						if(saving_acc > 0)
						{
						JOptionPane.showMessageDialog(null,"You have successfully transfer the money");//notify user that the process is succeed
						JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after transferring
						}
						else
						{
							JOptionPane.showMessageDialog(null,"You have failed to transfer the money");//notify user that the process is succeed
							saving_acc += amount;
						}
						
						break;
						case "2":
						JOptionPane.showMessageDialog(null,"Current Balance:RM" + current_acc);//show the current balance user have
						amountString = JOptionPane.showInputDialog(null,"Enter amount to transfer", "Amount transfer", JOptionPane.INFORMATION_MESSAGE);//prompt
						amount = Integer.parseInt(amountString);
						
						current_acc -= amount;
						
						if(current_acc > 0)
						{
						JOptionPane.showMessageDialog(null,"You have successfully transfer the money");//notify user that the process is succeed
						JOptionPane.showMessageDialog(null,"New Balance:RM" + current_acc);//show the new balance after transferring
						}
						else
						{
							JOptionPane.showMessageDialog(null,"You have failed to transfer the money");//notify user that the process is succeed
							saving_acc += amount;
						}
						
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
					JOptionPane.showMessageDialog(null,"You're not allow to deposit cents, RM1 Note, RM5 Note");
					JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
					
					amountString = JOptionPane.showInputDialog(null,"Enter amount to deposit", "Amount deposit", JOptionPane.INFORMATION_MESSAGE);//prompt
					amount = Integer.parseInt(amountString);
					
					saving_acc += amount;
					
					JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after depositing
					JOptionPane.showMessageDialog(null,"Please insert your money");//notify user to insert their money
					break;
					case "2":
					JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents, RM1 Note, RM5 Note");
					JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
					
					amountString = JOptionPane.showInputDialog(null,"Enter amount to deposit", "Amount deposit", JOptionPane.INFORMATION_MESSAGE);//prompt
					amount = Integer.parseInt(amountString);
					
					current_acc += amount;
					
					JOptionPane.showMessageDialog(null,"New Balance:RM" + current_acc);//show the new balance after depositing
					JOptionPane.showMessageDialog(null,"Please insert your money");//notify user to insert their money
					break;
					default:
					JOptionPane.showMessageDialog(null,"Please select a valid account type");//show error message to user
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
					
					//curent or saving account
					switch(acc_type)
					{
						case "1":
							//Input
							bill = JOptionPane.showInputDialog(null,"Select your bill to pay\n"
									+ "[ 1.Electric bill /"
									+ " 2.Water bill ]","Bill Type", JOptionPane.INFORMATION_MESSAGE);
							
							//electric or water bill
							switch(bill)
							{
								case "1":
									confirmationString = JOptionPane.showInputDialog(null,ConfirmationSEL,"Confirmation", JOptionPane.QUESTION_MESSAGE);
									confirmation = Integer.parseInt(confirmationString);
									
									if((confirmation <= 1 && confirmation != 0) && (saving_acc > 0))
									{
										JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
										saving_acc -= electricBill;
										JOptionPane.showMessageDialog(null,"New Balance: RM" + saving_acc);
									}
									else
									{
										JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
									}
									
									break;
								case "2":
									confirmationString = JOptionPane.showInputDialog(null,ConfirmationSEL,"Confirmation", JOptionPane.QUESTION_MESSAGE);
									confirmation = Integer.parseInt(confirmationString);
									
									if((confirmation <= 1 && confirmation != 0) && (saving_acc > 0))
									{
										JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
										saving_acc -= waterBill;
										JOptionPane.showMessageDialog(null,"New Balance: RM" + saving_acc);
									}
									else
									{
										JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
									}
									break;
								default:
									JOptionPane.showMessageDialog(null,"Please select a valid bill type");
									break;
							}
							break;
						case "2":
							bill = JOptionPane.showInputDialog(null,bill_typeSEL,"Bill Type", JOptionPane.INFORMATION_MESSAGE);
							switch(bill)
							{
								case "1":
									confirmationString = JOptionPane.showInputDialog(null,ConfirmationSEL,"Confirmation", JOptionPane.QUESTION_MESSAGE);
									confirmation = Integer.parseInt(confirmationString);
									
									if((confirmation <= 1 && confirmation != 0) && (current_acc > 0))
									{
										JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
										current_acc -= electricBill;
										JOptionPane.showMessageDialog(null,"New Balance: RM" + current_acc);
									}
									else
									{
										JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
									}
									
									break;
								case "2":
									confirmationString = JOptionPane.showInputDialog(null,ConfirmationSEL,"Confirmation", JOptionPane.QUESTION_MESSAGE);
									confirmation = Integer.parseInt(confirmationString);
									
									if((confirmation <= 1 && confirmation != 0) && (current_acc > 0))
									{
										JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
										current_acc -= waterBill;
										JOptionPane.showMessageDialog(null,"New Balance: RM" + current_acc);
									}
									else
									{
										JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
									}
									
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
								JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents");
								JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
								amountString = JOptionPane.showInputDialog(null,"Enter amount to withdraw", "Amount withdraw", JOptionPane.INFORMATION_MESSAGE);//prompt
								amount = Integer.parseInt(amountString);
								
								saving_acc -= amount;
								
								if(saving_acc > 0)
								{
								JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after withdrawing
								JOptionPane.showMessageDialog(null,"Please take your money");//notify user to take their money
								}
								else
								{
									JOptionPane.showMessageDialog(null,"You have failed to withdraw the money");//notify user that the process is succeed
									saving_acc += amount;
								}
								
								break;
							case "2":
								JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents");
								JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
								amountString = JOptionPane.showInputDialog(null,"Enter amount to withdraw", "Amount withdraw", JOptionPane.INFORMATION_MESSAGE);//prompt
								amount = Integer.parseInt(amountString);
								
								current_acc -= amount;
								
								if(current_acc > 0)
								{
								JOptionPane.showMessageDialog(null,"New Balance:RM" + current_acc);//show the new balance after withdrawing
								JOptionPane.showMessageDialog(null,"Please take your money");//notify user to take their money
								}
								else
								{
									JOptionPane.showMessageDialog(null,"You have failed to withdraw the money");//notify user that the process is succeed
									current_acc += amount;
								}
								
								break;
							default:
								JOptionPane.showMessageDialog(null,"Please select a valid account type");//show error message to user
								break;
						}
			}					
		}
	}
}
