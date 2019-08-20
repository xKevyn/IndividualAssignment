import javax.swing.JOptionPane;


public class Ticket_Price 
{
	public static void main(String[] args) 
	{
		//Variable
		String Ticket_Day;
		String ticketNumString;
		int ticketNum;
		
		//Input
		Ticket_Day = JOptionPane.showInputDialog(null,"Which day are you buying the ticket?", "Ticket Price Program", JOptionPane.QUESTION_MESSAGE);//prompt
		ticketNumString = JOptionPane.showInputDialog(null,"How many tickets would you like to buy?", "Ticket Price Program", JOptionPane.QUESTION_MESSAGE);//prompt
		ticketNum = Integer.parseInt(ticketNumString);
		
		//Displaying different ticket price for each different day user selected
		switch(Ticket_Day.toLowerCase())
		{
			case "monday":
			case "tuesday":
			case "wednesday":
				TotalTicketPrice(5,ticketNum);
				break;
			case "thursday":
				TotalTicketPrice(10,ticketNum);
				break;
			case "friday":
			case "sunday":
				TotalTicketPrice(20,ticketNum);
				break;
			case "saturday":
				TotalTicketPrice(30,ticketNum);
				break;
			default:
				JOptionPane.showMessageDialog(null,"Please enter a valid Day");//show error message to the user
				break;

		}
	}
	public static void TotalTicketPrice(int ticketPrice, int ticketNum)
	{
		int Total;
		Total = ticketPrice * ticketNum;
		JOptionPane.showMessageDialog(null,"Your total movie ticket price is RM" + Total);
	}
}
	
