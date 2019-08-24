import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public class AdvTicketPrice 
{
	public static void main(String[] args) 
	{
		//Variables
		String AdvTicket_Day;
		String[] day = {"Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int age;
		
		//Background Color
		UI();
		
		//Drop down list input for user to select
		AdvTicket_Day = (String) JOptionPane.showInputDialog(null,"Which day are you buying the ticket?",
				"Advanced version of Ticket Price Program", JOptionPane.PLAIN_MESSAGE,null,day,day[0]);
		
		//Displaying different ticket price for each different day user selected and age they are
		switch(AdvTicket_Day.toLowerCase())
		{
			//Monday to Thursday have the same price
			case "monday":
			case "tuesday":
			case "wednesday":
			case "thursday":
				age = age();
				
				//Kids and elders are free
				if (age <= 9 || age >= 66)
				{
					JOptionPane.showMessageDialog(null,"Your Ticket Price is FREE!!!");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Your ticket price is RM10");
				}
				break;
			//Friday to Sunday have the same price
			case "friday":
			case "sunday":
			case "saturday":
				age = age();
				
				//Kids and elders gets a discount of RM10
				if (age <= 9 || age >= 66)
				{
					JOptionPane.showMessageDialog(null,"Your ticket price is RM10");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Your ticket price is RM20");
				}
				break;
			default:
				System.exit(0);
				break;
	
		}
	}
	public static int age()
	{
		String ageString;
		int age;
		
		ageString = JOptionPane.showInputDialog(null,"Please enter your age", "Age", JOptionPane.INFORMATION_MESSAGE);
		age = Integer.parseInt(ageString);//convert from string to integer
		
		return age;
	}
	//Changing JOptionPane's background color to light purple
	public static void UI()
	{
		UIManager.put("OptionPane.background", new ColorUIResource(200, 198, 247));
		UIManager.put("Panel.background", new ColorUIResource(200, 198, 247));
	}
}