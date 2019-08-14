import javax.swing.JOptionPane;

public class ATM_Machine {
	public static void main(String[] args) 
	{
		String pin;
		String transaction;
		final String User_Pin = "123456789";//user's registered pin
		String acc_type;
		String amount_withdrawString;
		int times = 0;
		int amount_withdraw;
		int saving_acc = 500;
		int current_acc = 0;
		
		do
		{
			pin = JOptionPane.showInputDialog(null,"Please enter your pin", "Pin", JOptionPane.INFORMATION_MESSAGE);//prompt
			times += 1;
			if(times == 3)
			{
				JOptionPane.showMessageDialog(null,"You have exceed the maximum number of tries");
			}
		}
		while(pin.equals(User_Pin) == false && times < 3);//user can reenter the pin if its wrong
		
		//if the pin is correct proceed to the next step
		if(pin.equals(User_Pin))
		{		
			transaction = JOptionPane.showInputDialog(null,"Please select a transaction\n"
								+ "[ Transfer "
								+ "/ Deposit money "
								+ "/ Setting "
								+ "/ Balance Enquiry "
								+ "/ Withdraw Money "
								+ "/ Bill Pay ]");//user can select the functionality they want to use
			
			//functionality options
			switch(transaction.toLowerCase())
			{
				default:
					JOptionPane.showMessageDialog(null,"Please select a valid transaction");//prompt
					break;
				case "transfer":
				case "deposit money":
				case "setting":
				case "balance enquiry":
				case "bill pay":
					JOptionPane.showMessageDialog(null,"This function is currently not supported\n"
									+ "Please use something else");//the question did'nt ask to complete the other function
					break;
				case "withdraw money":
					acc_type = JOptionPane.showInputDialog(null,"Select your account type\n"
																+ "Savings\n"
																+ "Current","Account Type", JOptionPane.INFORMATION_MESSAGE);

						//current or saving account
						switch(acc_type.toLowerCase())
						{
							case "savings":
								JOptionPane.showMessageDialog(null,"You're not allow to withdraw sens");
								JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
								amount_withdrawString = JOptionPane.showInputDialog(null,"Enter amount to withdraw", "Amount withdraw", JOptionPane.INFORMATION_MESSAGE);//prompt
								amount_withdraw = Integer.parseInt(amount_withdrawString);
								saving_acc -= amount_withdraw;
								
								JOptionPane.showMessageDialog(null,"New Balance:RM" + saving_acc);//show the new balance after withdrawing
								JOptionPane.showMessageDialog(null,"Please take your money");//notify user to take their money
								break;
							case "current":
								JOptionPane.showMessageDialog(null,"You're not allow to withdraw sens");
								JOptionPane.showMessageDialog(null,"Current Balance:RM" + saving_acc);//show the current balance user have
								amount_withdrawString = JOptionPane.showInputDialog(null,"Enter amount to withdraw", "Amount withdraw", JOptionPane.INFORMATION_MESSAGE);//prompt
								amount_withdraw = Integer.parseInt(amount_withdrawString);
								current_acc -= amount_withdraw;
								
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
