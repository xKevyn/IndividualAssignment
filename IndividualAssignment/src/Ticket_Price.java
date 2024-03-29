import javax.swing.JOptionPane;


public class Ticket_Price 
{
	public static void main(String[] args) 
	{
		Display();
	}
	public static void Display()
	{
		//Variable
		String Ticket_Day;
		int ticketNum;
		
		//Input
		Ticket_Day = JOptionPane.showInputDialog(null,"Which day are you buying the ticket?",
				"Ticket Price Program", JOptionPane.QUESTION_MESSAGE);//To provide different information based on the day
		
		//Based on they price for the day and the ticket number the user want to buy
		//Display the total price of the tickets to the user
		switch(Ticket_Day.toLowerCase())
		{
			//These three days holds the same value of ticket price so they are group together
			case "monday":
			case "tuesday":
			case "wednesday":
				ticketNum = TicketNum();
				TotalTicketPrice(5,ticketNum);//The price of the day is RM5
				break;
			case "thursday":
				ticketNum = TicketNum();
				TotalTicketPrice(10,ticketNum);//The price of the day is RM10
				break;
			//These three days holds the same value of ticket price so they are group together
			case "friday":
			case "sunday":
				ticketNum = TicketNum();
				TotalTicketPrice(20,ticketNum);//The price of the day is RM20
				break;
			case "saturday":
				ticketNum = TicketNum();
				TotalTicketPrice(30,ticketNum);//The price of the day is RM30
				break;
			default:
				JOptionPane.showMessageDialog(null,"Please enter a valid Day");//show error message to the user
				break;

		}
	}
	//This method input the ticket price of the day and the ticket number and calculates the total ticket price
	public static void TotalTicketPrice(int ticketPrice, int ticketNum)
	{
		int Total;
		
		//Calculation for the total ticket price
		Total = ticketPrice * ticketNum;
		JOptionPane.showMessageDialog(null,"Your total movie ticket price is RM" + Total);
	}
	
	/**This method is mainly to correct a flaw that was in this program - If a user input a invalid day,
	 *  the program will continues to ask the user input ticket number. In order to correct this,
	 *  the input statement for the number of tickets will need to be executed inside the switch statement.
	 *  This method is to shorten the code, increasing the readability
	**/	
	public static int TicketNum()
	{
		String ticketNumString;
		int ticketNum = 0;
		
		ticketNumString = JOptionPane.showInputDialog(null,"How many tickets would you like to buy?",
				"Ticket Price Program", JOptionPane.QUESTION_MESSAGE);//To calculate the total price of tickets if the user are buying multiple tickets
		
		if(isNumeric(ticketNumString) == false)
		{
			//If the input for ticket number is not a number
			//Show an error message and terminate the program
			JOptionPane.showMessageDialog(null,"Please enter a valid value");
			System.exit(0);
		}
		else
		{
		//convert string to integer so that it can be used for calculation
		ticketNum = Integer.parseInt(ticketNumString);
		}
		return ticketNum;
		
	}
	//This method is used for detecting whether the input for ticket number is a number or not
	public static boolean isNumeric(String ticketNumString)
	{
		//Detect the Input String
		try
		{
			Integer.parseInt(ticketNumString);
		}
		//See if this specific error(not number, is null) will occur or not?
		catch(NumberFormatException | NullPointerException nfe)
		{
			//if yes, return false 
			return false;
		}
		//if no, return true
		return true;
		
	}
}
	
