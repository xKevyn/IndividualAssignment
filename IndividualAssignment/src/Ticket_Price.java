import javax.swing.JOptionPane;


public class Ticket_Price {
	public static void main(String[] args) 
	{
		
		String Ticket_Day;
		
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
	}
}
	
