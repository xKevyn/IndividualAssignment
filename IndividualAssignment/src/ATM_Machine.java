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
		String confirmation;
		final String User_Pin = "123456789";//user's registered pin
		int electricBill = 150;
		int waterBill = 20;
		int times = 0;
		int amount;
		int saving_acc = 500;
		int current_acc = 0;
		ArrayList<String> idList = new ArrayList<String>();//Registered ids
		idList.add("123456789");
		idList.add("325363744");
		idList.add("324928734");
		idList.add("193850726");
		idList.add("908462745");
		
		//Loop for inputing pin (maximum 3 times)
		do
		{
			pin = JOptionPane.showInputDialog(null,"Please enter your pin", "Pin", JOptionPane.INFORMATION_MESSAGE);//prompt
			times += 1;
			if(times == 3)
			{
				JOptionPane.showMessageDialog(null,"You have exceed the maximum number of tries");
			}
		}
		//user can reenter the pin if its wrong but when it exceed thrice user can no longer attempt to enter pin anymore
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
					id = JOptionPane.showInputDialog(null,"Please insert the account id that you want to transfer to", 
								"Transfer", JOptionPane.INFORMATION_MESSAGE);
					//If the id entered is correct, proceed to the next step
					if(idList.contains(id))
					{
						//Input
						acc_type = JOptionPane.showInputDialog(null,"Select your account type\n"
								+ "[ 1.Savings /"
								+ " 2.Current ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
								
						//current or saving account
						switch(acc_type.toLowerCase())
						{
						case "1":
						JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
						amountString = JOptionPane.showInputDialog(null,"Enter amount to transfer", "Amount transfer", JOptionPane.INFORMATION_MESSAGE);//prompt
						amount = Integer.parseInt(amountString);
						saving_acc -= amount;
						
						JOptionPane.showMessageDialog(null,"You have successfully transfer the money");//notify user that the process is succeed
						JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after transferring
						break;
						case "2":
						JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
						amountString = JOptionPane.showInputDialog(null,"Enter amount to transfer", "Amount transfer", JOptionPane.INFORMATION_MESSAGE);//prompt
						amount = Integer.parseInt(amountString);
						current_acc -= amount;
						
						JOptionPane.showMessageDialog(null,"You have successfully transfer the money");//notify user that the process is succeed
						JOptionPane.showMessageDialog(null,"New Balance:RM" + current_acc);//show the new balance after transferring
						break;
						default:
						JOptionPane.showMessageDialog(null,"Please select a valid account type");//show error message to user
						break;
						}					
					}												
					break;
				case "2":
					//Input
					acc_type = JOptionPane.showInputDialog(null,"Select your account type\n"
							+ "[ 1.Savings /"
							+ " 2.Current ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
					
					//current or saving account
					switch(acc_type)
					{
					case "1":
					JOptionPane.showMessageDialog(null,"You're not allow to deposit cents, RM1 Note, RM5 Note");
					JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
					amountString = JOptionPane.showInputDialog(null,"Enter amount to deposit", "Amount deposit", JOptionPane.INFORMATION_MESSAGE);//prompt
					amount = Integer.parseInt(amountString);
					saving_acc -= amount;
					
					JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after depositing
					JOptionPane.showMessageDialog(null,"Please insert your money");//notify user to insert their money
					break;
					case "2":
					JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents, RM1 Note, RM5 Note");
					JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
					amountString = JOptionPane.showInputDialog(null,"Enter amount to deposit", "Amount deposit", JOptionPane.INFORMATION_MESSAGE);//prompt
					amount = Integer.parseInt(amountString);
					current_acc -= amount;
					
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
					acc_type = JOptionPane.showInputDialog(null,"Select your account type\n"
							+ "[ 1.Savings /"
							+ " 2.Current ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
					
					//curent or saving account
					switch(acc_type)
					{
						case "1":
							//Input
							bill = acc_type = JOptionPane.showInputDialog(null,"Select your bill to pay\n"
									+ "[ 1.Electric bill /"
									+ " 2.Water bill ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
							
							//electric or water bill
							switch(bill)
							{
								case "1":
									confirmation = JOptionPane.showInputDialog(null,"Are you sure you want to pay the bill\n"
											+ "[ 1.Yes /"
											+ " 2.No ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
									switch(confirmation)
									{
										case "1":
											JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
											saving_acc -= electricBill;
											JOptionPane.showMessageDialog(null,"New Balance: RM" + saving_acc);
											break;
										case "2":
											return;
									}
									break;
								case "2":
									confirmation = JOptionPane.showInputDialog(null,"Are you sure you want to pay the bill\n"
											+ "[ 1.Yes /"
											+ " 2.No ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
									switch(confirmation)
									{
										case "1":
											JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
											saving_acc -= waterBill;
											JOptionPane.showMessageDialog(null,"New Balance: RM" + saving_acc);
											break;
										case "2":
											return;
									}
									break;
							}
							break;
						case "2":
							bill = acc_type = JOptionPane.showInputDialog(null,"Select your bill to pay\n"
									+ "[ 1.Electric bill /"
									+ " 2.Water bill ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
							switch(bill)
							{
								case "1":
									confirmation = JOptionPane.showInputDialog(null,"Are you sure you want to pay the bill\n"
											+ "[ 1.Yes /"
											+ " 2.No ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
									switch(confirmation)
									{
										case "1":
											JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
											current_acc -= electricBill;
											JOptionPane.showMessageDialog(null,"New Balance: RM" + current_acc);
											break;
										case "2":
											JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
											break;
									}
									break;
								case "2":
									confirmation = JOptionPane.showInputDialog(null,"Are you sure you want to pay the bill\n"
											+ "[ 1.Yes /"
											+ " 2.No ]","Account Type", JOptionPane.INFORMATION_MESSAGE);
									switch(confirmation)
									{
										case "1":
											JOptionPane.showMessageDialog(null,"You have successfully paid your bill");
											current_acc -= waterBill;
											JOptionPane.showMessageDialog(null,"New Balance: RM" + current_acc);
											break;
										case "2":
											JOptionPane.showMessageDialog(null,"You have failed to pay your bill");
											break;
									}
									break;
							}
							break;
					}
					break;
				case "5":
					acc_type = JOptionPane.showInputDialog(null,"Select your account type\n"
																+ "[ 1.Savings /"
																+ " 2.Current ]","Account Type", JOptionPane.INFORMATION_MESSAGE);

						//current or saving account
						switch(acc_type)
						{
							case "1":
								JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents");
								JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
								amountString = JOptionPane.showInputDialog(null,"Enter amount to withdraw", "Amount withdraw", JOptionPane.INFORMATION_MESSAGE);//prompt
								amount = Integer.parseInt(amountString);
								saving_acc -= amount;
								
								JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after withdrawing
								JOptionPane.showMessageDialog(null,"Please take your money");//notify user to take their money
								break;
							case "2":
								JOptionPane.showMessageDialog(null,"You're not allow to withdraw cents");
								JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
								amountString = JOptionPane.showInputDialog(null,"Enter amount to withdraw", "Amount withdraw", JOptionPane.INFORMATION_MESSAGE);//prompt
								amount = Integer.parseInt(amountString);
								current_acc -= amount;
								
								JOptionPane.showMessageDialog(null,"New Balance:RM" + current_acc);//show the new balance after withdrawing
								JOptionPane.showMessageDialog(null,"Please take your money");//notify user to take their money
								break;
							default:
								JOptionPane.showMessageDialog(null,"Please select a valid account type");//show error message to user
								break;
						}
			}					
		}
	}
}
