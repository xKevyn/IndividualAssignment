import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JLabel;


public class AdvTicketPrice 
{
	//can be used in every method
	static Font font = new Font("Comic Sans MS", Font.BOLD, 14);
	
	public static void main(String[] args) 
	{
		Display();
	}
	public static void Display()
	{
		//Variables
		String AdvTicket_Day;
		String[] day = {"Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int age;
		
		//Font change
		JLabel dayInput = new JLabel("Which day are you buying the ticket?");
		dayInput.setFont(font);
		
		//Background Color
		UI();
		
		//Drop down list input for user to select
		AdvTicket_Day = (String) JOptionPane.showInputDialog(null,dayInput,
				"Advanced version of Ticket Price Program", JOptionPane.PLAIN_MESSAGE,null,day,day[0]);
		
		//Displaying different ticket price for each different day user selected and age they are
		switch(AdvTicket_Day.toLowerCase())
		{
			//Monday to Thursday have the same price
			case "monday":
			case "tuesday":
			case "wednesday":
			case "thursday":
				age = Age();
				
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
				age = Age();
				
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
	//shorten the code
	public static int Age()
	{
		String ageString;
		int age;
		
		//Font change
		JLabel ageInput = new JLabel("Please enter your age");
		ageInput.setFont(font);
		
		ageString = JOptionPane.showInputDialog(null,ageInput, "Age", JOptionPane.PLAIN_MESSAGE);
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