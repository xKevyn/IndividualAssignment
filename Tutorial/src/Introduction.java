import java.util.Scanner;

public class Introduction {

	public static void main(String[] args) //main method
	{
		System.out.println("Welcome!\n"
				+ "Which program are you interested to use?\n"
				+ "BMI Calculator\n"
				+ "Ticket Price Info\n"
				+ "Advanced Ticket Price Info\n"
				+ "ATM Machine");
		Scanner scanner = new Scanner(System.in);
		String program = scanner.nextLine();
		switch(program)
		{
			default:
				System.out.println("Please enter a valid program without any typing errors");
			case "BMI Calculator":
				System.out.println("Noted that this only works for people that are 20 years old and above");
				System.out.println("Hey,What your height in inches");
				double inches = scanner.nextDouble();
				System.out.println("Hey,What your weight in pounds");
				double pounds = scanner.nextDouble();
				double height = inches*0.0254;
				double weight = pounds*0.45359237;		
				double BMI_Index = weight/(height*height);
				System.out.println("This is your BMI Index\n"
						+ BMI_Index);
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
			case "Ticket Price Info":
				System.out.println("Which day are you buying the ticket?");
				String Ticket_Day = scanner.nextLine();
				switch(Ticket_Day)
				{
					case "Monday":
					case "Tuesday":
					case "Wednesday":
						System.out.println("RM5");
						break;
					case "Thursday":
						System.out.println("RM10");
						break;
					case "Friday":
					case "Sunday":
						System.out.println("RM20");
						break;
					case "Saturday":
						System.out.println("RM30");
						break;
					default:
						System.out.println("Please enter a valid Day");
						break;
				}
				break;
			case "Advanced Ticket Price Info":
				System.out.println("Which day are you buying the ticket?");
				String AdvTicket_Day = scanner.nextLine();
				switch(AdvTicket_Day)
				{
					case "Monday":
					case "Tuesday":
					case "Wednesday":
					case "Thursday":
						System.out.println("Please enter your age");
						int age = scanner.nextInt();
						if (age <= 9 || age >= 64)
						{
							System.out.println("Your Ticket Price is FREE!!!");
						}
						else
						{
							System.out.println("RM10");
						}
						break;
					case "Friday":
					case "Sunday":
					case "Saturday":
						System.out.println("Please enter your age");
						int age2 = scanner.nextInt();
						if (age2 <= 9 || age2 >= 64)
						{
							System.out.println("RM10");
						}
						else
						{
							System.out.println("RM20");
						}
						break;
					default:
						System.out.println("Please enter a valid Day");
						break;
				
				}
				break;
			case "ATM Machine":
				System.out.println("Please enter your pin");
				String pin = scanner.nextLine();
				String User_Pin = "123456789";
				if(pin.equals(User_Pin))
				{		
				System.out.println("Please select a transaction\n"
						+ "Transfer\n"
						+ "Deposit money\n"
						+ "Setting\n"
						+ "Balance Enquiry\n"
						+ "Withdraw Money\n"
						+ "Bill Pay");
				String transaction = scanner.nextLine();
					switch(transaction)
					{
						default:
							System.out.println("Please select a valid transaction");
							break;
						case "Transfer":
						case "Deposit money":
						case "Setting":
						case "Balance Enquiry":
						case "Bill Pay":
							System.out.println("This function is currently not supported\n"
									+ "Please use something else");
							break;
						case "Withdraw Money":
							System.out.println("Select your account type\n"
									+ "Savings\n"
									+ "Current");
							String acc_type = scanner.nextLine();
								switch(acc_type)
								{
									case "Savings":
										System.out.println("You're not allow to withdraw sens");
										int saving_acc = 500;
										System.out.println("Current Balance:RM" + saving_acc);
										System.out.println("Enter amount to withdraw");
										int amount_withdraw = scanner.nextInt();
										saving_acc -= amount_withdraw;
										System.out.println("New Balance:RM" + saving_acc);
										System.out.println("Please take your money");
										break;
									case "Current":
										System.out.println("You're not allow to withdraw sens");
										int current_acc = 500;
										System.out.println("Current Balance:RM" + current_acc);
										System.out.println("Enter amount to withdraw");
										int amount_withdraw2 = scanner.nextInt();
										current_acc -= amount_withdraw2;
										System.out.println("New Balance:RM" + current_acc);
										System.out.println("Please take your money");
										break;
									default:
										System.out.println("Please select a valid account type");
										break;
										
								}
							break;
					}
							
					
				}
				
	
		}

	}
}