import java.util.Scanner;

public class Introduction {

	public static void main(String[] args) //main method
	{
		System.out.println("Welcome!\n"
				+ "Which program are you interested to use?\n"
				+ "BMI Calculator\n"
				+ "Ticket Price Info\n"
				+ "Advanced Ticket Price Info\n"
				+ "ATM Machine"); //providing options for user to choose from
		Scanner scanner = new Scanner(System.in);//scanner for user input
		String program = scanner.nextLine(); //accepts string input
		switch(program.toLowerCase()) //to help minimize typing errors
		{
			default:
				System.out.println("Please enter a valid program without any typing errors");// notify user when they enter invalid inputs
				break;
			case "bmi calculator":
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
			case "ticket price info":
				System.out.println("Which day are you buying the ticket?");
				String Ticket_Day = scanner.nextLine();
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
						System.out.println("Please enter a valid Day");
						break;
				}
				break;
			case "advanced ticket price info":
				System.out.println("Which day are you buying the ticket?");
				String AdvTicket_Day = scanner.nextLine();
				switch(AdvTicket_Day.toLowerCase())
				{
					case "monday":
					case "tuesday":
					case "wednesday":
					case "thursday":
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
					case "friday":
					case "sunday":
					case "saturday":
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
			case "atm machine":
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
					switch(transaction.toLowerCase())
					{
						default:
							System.out.println("Please select a valid transaction");
							break;
						case "transfer":
						case "deposit money":
						case "setting":
						case "balance enquiry":
						case "bill pay":
							System.out.println("This function is currently not supported\n"
									+ "Please use something else");
							break;
						case "withdraw money":
							System.out.println("Select your account type\n"
									+ "Savings\n"
									+ "Current");
							String acc_type = scanner.nextLine();
								switch(acc_type.toLowerCase())
								{
									case "savings":
										System.out.println("You're not allow to withdraw sens");
										int saving_acc = 500;
										System.out.println("Current Balance:RM" + saving_acc);
										System.out.println("Enter amount to withdraw");
										int amount_withdraw = scanner.nextInt();
										saving_acc -= amount_withdraw;
										System.out.println("New Balance:RM" + saving_acc);
										System.out.println("Please take your money");
										break;
									case "current":
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
		scanner.close();
	}
}