import java.util.Scanner;

public class Introduction {

	public static void main(String[] args) //main method
	{
		String pin;
		String User_Pin;
		int saving_acc = 500;
		int current_acc = 500;
		int amount_withdraw;
		int age;
		
		System.out.println("Welcome!\n"
				+ "Which program are you interested to use?\n"
				+ "BMI Calculator\n"
				+ "Ticket Price Info\n"
				+ "Advanced Ticket Price Info\n"
				+ "ATM Machine"); //providing options for user to choose from
		
		Scanner scanner = new Scanner(System.in);//scanner for user input
		String program = scanner.nextLine(); //getting input(program) from user
		
		switch(program.toLowerCase()) //to help minimize typing errors
		{
			default:
				System.out.println("Please enter a valid program without any typing errors");// notify user when they enter invalid inputs
				break;
			//BMI Calculator Program
			case "bmi calculator":
				System.out.println("Noted that this only works for people that are 20 years old and above");//information for user
				
				System.out.println("Hey,What your height in inches");//prompt user
				double inches = scanner.nextDouble();//getting input(inches) from user
				System.out.println("Hey,What your weight in pounds");//prompt user
				double pounds = scanner.nextDouble();//getting input(pounds) from user
				
				//bmi only works with kg and cm
				double height = inches*0.0254;//convert inches to cm
				double weight = pounds*0.45359237;//convert pounds to kg
				double BMI_Index = weight/(height*height);//calculate bmi
				
				System.out.println("This is your BMI Index\n"
						+ BMI_Index);//display user's bmi to them
					//providing information to user about what user's bmi tells about their weight
					if(BMI_Index <=18.5)
					{
						System.out.println("You're underweight!");
					}
					else if(BMI_Index <= 24.9)
					{
						System.out.println("Your weight is normal.");
					}
					else if(BMI_Index >= 30)
					{
						System.out.println("You're obese!");
					}
					else
					{
						System.out.println("You're overweight!!!");
					}
				break;
			//Ticket Price Program
			case "ticket price info":
				System.out.println("Which day are you buying the ticket?");//prompt
				String Ticket_Day = scanner.nextLine();//getting input(ticket day) from user
				
				//Displaying different ticket price for each different day user selected
				switch(Ticket_Day.toLowerCase())
				{
					case "monday":
					case "tuesday":
					case "wednesday":
						System.out.println("RM5");
						break;
					case "thursday":
						System.out.println("RM10");
						break;
					case "friday":
					case "sunday":
						System.out.println("RM20");
						break;
					case "saturday":
						System.out.println("RM30");
						break;
					default:
						System.out.println("Please enter a valid Day");//show error message to the user
						break;
				}
				break;
			//Advanced version of Ticket Price Program
			case "advanced ticket price info":
				System.out.println("Which day are you buying the ticket?");//prompt
				String AdvTicket_Day = scanner.nextLine();//getting input(ticket day) from user
				
				//Displaying different ticket price for each different day user selected and age they are
				switch(AdvTicket_Day.toLowerCase())
				{
					//Monday to Thursday have the same price
					case "monday":
					case "tuesday":
					case "wednesday":
					case "thursday":
						System.out.println("Please enter your age");
						age = scanner.nextInt();
						
						//Kids and elders are free
						if (age <= 9 || age >= 66)
						{
							System.out.println("Your Ticket Price is FREE!!!");
						}
						else
						{
							System.out.println("RM10");
						}
						break;
					//Friday to Sunday have the same price
					case "friday":
					case "sunday":
					case "saturday":
						System.out.println("Please enter your age");
						age = scanner.nextInt();
						
						//Kids and elders gets a discount of RM10
						if (age <= 9 || age >= 66)
						{
							System.out.println("RM10");
						}
						else
						{
							System.out.println("RM20");
						}
						break;
					default:
						System.out.println("Please enter a valid Day");//show error message to the user
						break;
				
				}
				break;
			//ATM Machine Program
			case "atm machine":
				do
				{
					System.out.println("Please enter your pin");//prompt

					pin = scanner.nextLine();//getting input(pin) from user
					User_Pin = "123456789";//user's registered pin
				}
				while(pin.equals(User_Pin) == false);//user can reenter the pin if its wrong
				
				//if the pin is correct proceed to the next step
				if(pin.equals(User_Pin))
				{		
				System.out.println("Please select a transaction\n"
						+ "Transfer\n"
						+ "Deposit money\n"
						+ "Setting\n"
						+ "Balance Enquiry\n"
						+ "Withdraw Money\n"
						+ "Bill Pay");//user can select the functionality they want to use
				String transaction = scanner.nextLine();
					
					//functionality options
					switch(transaction.toLowerCase())
					{
						default:
							System.out.println("Please select a valid transaction");//prompt
							break;
						case "transfer":
						case "deposit money":
						case "setting":
						case "balance enquiry":
						case "bill pay":
							System.out.println("This function is currently not supported\n"
									+ "Please use something else");//the question did'nt ask to complete the other function
							break;
						case "withdraw money":
							System.out.println("Select your account type\n"
									+ "Savings\n"
									+ "Current");
							
							String acc_type = scanner.nextLine();//getting input(acc_type) from user
								
								//current or saving account
								switch(acc_type.toLowerCase())
								{
									case "savings":
										System.out.println("You're not allow to withdraw sens");
										System.out.println("Current Balance:RM" + saving_acc);//show the current balance user have
										System.out.println("Enter amount to withdraw");//prompt
										
										amount_withdraw = scanner.nextInt();
										saving_acc -= amount_withdraw;
										
										System.out.println("New Balance:RM" + saving_acc);//show the new balance after withdrawing
										System.out.println("Please take your money");//notify user to take their money
										break;
									case "current":
										System.out.println("You're not allow to withdraw sens");
										System.out.println("Current Balance:RM" + current_acc);//show the current balance user have
										System.out.println("Enter amount to withdraw");//prompt
										
										amount_withdraw = scanner.nextInt();
										current_acc -= amount_withdraw;
										
										System.out.println("New Balance:RM" + current_acc);//show the new balance after withdrawing
										System.out.println("Please take your money");//notify user to take their money
										break;
									default:
										System.out.println("Please select a valid account type");//show error message to user
										break;
										
								}
							break;
					}
							
					
				}
				
				
		}
		scanner.close();
	}
}
