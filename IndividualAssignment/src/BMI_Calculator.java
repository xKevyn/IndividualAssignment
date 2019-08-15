import javax.swing.JOptionPane;


public class BMI_Calculator 
{
	public static void main(String[] args) 
	{
		//Variables
		String inchesString;
		String poundsString;
		double inches;
		double pounds;
		
		//Clarification
		JOptionPane.showMessageDialog(null,"Noted that this only works for people that are 20 years old and above");//information for user
		
		//Input
		inchesString = JOptionPane.showInputDialog(null,"Please enter your height in inches", "Height", JOptionPane.INFORMATION_MESSAGE);//prompt user
		inches = Double.parseDouble(inchesString);//convert from string to double
		poundsString = JOptionPane.showInputDialog(null,"Please enter your weight in pounds", "Weight", JOptionPane.INFORMATION_MESSAGE);//prompt user
		pounds = Double.parseDouble(poundsString);//convert from string to double
		
		//Conversion(bmi only works with kg and cm)
		double height = inches*0.0254;//convert inches to cm	
		double weight = pounds*0.45359237;//convert pounds to kg
		double BMI_Index = (double) Math.round((weight/(height*height)) * 100)/ 100;//calculate bmi(two decimal places)
		
		//Display
		JOptionPane.showMessageDialog(null,"This is your BMI Index\n"
				+ BMI_Index);//display user's bmi to them
			//providing information to user about what user's bmi tells about their weight
			if(BMI_Index <=18.5)
			{
				JOptionPane.showMessageDialog(null,"You're underweight!");
			}
			else if(BMI_Index <= 24.9)
			{
				JOptionPane.showMessageDialog(null,"Your weight is normal.");
			}
			else if(BMI_Index >= 30)
			{
				JOptionPane.showMessageDialog(null,"You're obese!");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You're overweight!!!");
			}
	}
}
