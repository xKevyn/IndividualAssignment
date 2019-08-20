import javax.swing.JOptionPane;


public class AdvTicketPrice 
{
	public static void main(String[] args) 
	{
		//Variables
		String AdvTicket_Day;
		String ageString;
		String ticketNumString;
		int ticketNum;
		int age;
		
		//Input
		AdvTicket_Day = JOptionPane.showInputDialog(null,"Which day are you buying the ticket?",
				"Advanced version of Ticket Price Program", JOptionPane.QUESTION_MESSAGE);
		ticketNumString = JOptionPane.showInputDialog(null,"How many tickets would you like to buy?", "Ticket Price Program", JOptionPane.QUESTION_MESSAGE);//prompt
		ticketNum = Integer.parseInt(ticketNumString);
		
		//Displaying different ticket price for each different day user selected and age they are
		switch(AdvTicket_Day.toLowerCase())
		{
			//Monday to Thursday have the same price
			case "monday":
			case "tuesday":
			case "wednesday":
			case "thursday":
				ageString = JOptionPane.showInputDialog(null,"Please enter your age", "Age", JOptionPane.INFORMATION_MESSAGE);
				age = Integer.parseInt(ageString);//convert from string to integer
				
				//Kids and elders are free
				if (age <= 9 || age >= 66)
				{
					JOptionPane.showMessageDialog(null,"Your Ticket Price is FREE!!!");
				}
				else
				{
					TotalTicketPrice(10,ticketNum);
				}
				break;
			//Friday to Sunday have the same price
			case "friday":
			case "sunday":
			case "saturday":
				ageString = JOptionPane.showInputDialog(null,"Please enter your age", "Age", JOptionPane.INFORMATION_MESSAGE);
				age = Integer.parseInt(ageString);//convert from string to integer
				
				//Kids and elders gets a discount of RM10
				if (age <= 9 || age >= 66)
				{
					TotalTicketPrice(10,ticketNum);
				}
				else
				{
					TotalTicketPrice(20,ticketNum);
				}
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
