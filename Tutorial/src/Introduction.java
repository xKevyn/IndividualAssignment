import java.util.Scanner;

import javax.swing.JOptionPane;

public class Introduction {

	public static void main(String[] args) //main method
	{
		int saving_acc = 500;
		int current_acc = 500;
		int amount_withdraw;
		int age;
		int times = 0;
		String program;
		String pin;
		String User_Pin;
		String inchesString;
		String poundsString;
		String ageString;
		String Ticket_Day;
		String AdvTicket_Day;
		String transaction;
		String acc_type;
		String amount_withdrawString;
		double inches;
		double pounds;
		
		
		program = JOptionPane.showInputDialog(null,"Welcome!\n"
					+ "Which program are you interested to use?\n"
					+ "[ BMI Calculator "
					+ "/ Ticket Price Info "
					+ "/ Advanced Ticket Price Info "
					+ "/ ATM Machine ]", "Program", JOptionPane.INFORMATION_MESSAGE); //Prompt user to choose which program they want to use
		
		switch(program.toLowerCase()) //to help minimize typing errors
		{
			default:
				JOptionPane.showMessageDialog(null, "Please enter a valid program without any typing errors");// notify user when they enter invalid inputs
				break;
			//BMI Calculator Program
			case "bmi calculator":
				JOptionPane.showMessageDialog(null,"Noted that this only works for people that are 20 years old and above");//information for user
				
				inchesString = JOptionPane.showInputDialog(null,"Please enter your height in inches?", "Height", JOptionPane.INFORMATION_MESSAGE);//prompt user
				inches = Double.parseDouble(inchesString);//convert from string to double
				poundsString = JOptionPane.showInputDialog(null,"Please enter your weight in pounds?", "Weight", JOptionPane.INFORMATION_MESSAGE);//prompt user
				pounds = Double.parseDouble(poundsString);//convert from string to double
				
				//bmi only works with kg and cm
				double height = inches*0.0254;//convert inches to cm	
				double weight = pounds*0.45359237;//convert pounds to kg
				double BMI_Index = weight/(height*height);//calculate bmi
				
				JOptionPane.showMessageDialog(null,"This is your BMI Index\n"
						+ BMI_Index);//display user's bmi to them
					//providing information to user about what user's bmi tells about their weight
					if(BMI_Index <=18.5)
					{
						JOptionPane.showMessageDialog(null,"You're underweight!");
					}
					else if(BMI_Index <= 24.9)
					{
						JOptionPane.showMessageDialog(null,"Your weight is normal.");
					}
					else if(BMI_Index >= 30)
					{
						JOptionPane.showMessageDialog(null,"You're obese!");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You're overweight!!!");
					}
				break;
			//Ticket Price Program
			case "ticket price info":
				Ticket_Day = JOptionPane.showInputDialog(null,"Which day are you buying the ticket?", "Ticket Price Program", JOptionPane.INFORMATION_MESSAGE);//prompt
			
				//Displaying different ticket price for each different day user selected
				switch(Ticket_Day.toLowerCase())
				{
					case "monday":
					case "tuesday":
					case "wednesday":
						JOptionPane.showMessageDialog(null,"RM5");
						break;
					case "thursday":
						JOptionPane.showMessageDialog(null,"RM10");
						break;
					case "friday":
					case "sunday":
						JOptionPane.showMessageDialog(null,"RM20");
						break;
					case "saturday":
						JOptionPane.showMessageDialog(null,"RM30");
						break;
					default:
						JOptionPane.showMessageDialog(null,"Please enter a valid Day");//show error message to the user
						break;
				}
				break;
			//Advanced version of Ticket Price Program
			case "advanced ticket price info":
				AdvTicket_Day = JOptionPane.showInputDialog(null,"Which day are you buying the ticket?",
						"Advanced version of Ticket Price Program", JOptionPane.INFORMATION_MESSAGE);//prompt
				
				//Displaying different ticket price for each different day user selected and age they are
				switch(AdvTicket_Day.toLowerCase())
				{
					//Monday to Thursday have the same price
					case "monday":
					case "tuesday":
					case "wednesday":
					case "thursday":
						ageString = JOptionPane.showInputDialog(null,"Please enter your age", "Age", JOptionPane.INFORMATION_MESSAGE);
						age = Integer.parseInt(ageString);
						
						//Kids and elders are free
						if (age <= 9 || age >= 66)
						{
							JOptionPane.showMessageDialog(null,"Your Ticket Price is FREE!!!");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"RM10");
						}
						break;
					//Friday to Sunday have the same price
					case "friday":
					case "sunday":
					case "saturday":
						ageString = JOptionPane.showInputDialog(null,"Please enter your age", "Age", JOptionPane.INFORMATION_MESSAGE);
						age = Integer.parseInt(ageString);
						
						//Kids and elders gets a discount of RM10
						if (age <= 9 || age >= 66)
						{
							JOptionPane.showMessageDialog(null,"RM10");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"RM20");
						}
						break;
					default:
						JOptionPane.showMessageDialog(null,"Please enter a valid Day");//show error message to the user
						break;
				
				}
				break;
			//ATM Machine Program
			case "atm machine":
				do
				{
					pin = JOptionPane.showInputDialog(null,"Please enter your pin", "Pin", JOptionPane.INFORMATION_MESSAGE);//prompt
					User_Pin = "123456789";//user's registered pin
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
							break;
					}
							
					
				}
				
				
		}
	}
}
