import javax.swing.JOptionPane;


public class AdvTicketPrice 
{
	public static void main(String[] args) 
	{
		//Variables
		String AdvTicket_Day;
		String ageString;
		int age;
		
		//Input
		AdvTicket_Day = JOptionPane.showInputDialog(null,"Which day are you buying the ticket?",
				"Advanced version of Ticket Price Program", JOptionPane.QUESTION_MESSAGE);
		
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
					JOptionPane.showMessageDialog(null,"RM10");
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
	}
}