import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class BMI_Calculator {
	public static void main(String[] args) 
	{
		//Variables
		String heightType;
		String weightType;
		double BMI_Index = 0;
		
		//Images
		ImageIcon bmi = new ImageIcon("bmi.PNG");
		
		
		//Clarification
		JOptionPane.showMessageDialog(null,"Please note that this calculator is only applicable to people who are 20 years old or older", "BMI Calculator", JOptionPane.INFORMATION_MESSAGE, bmi);
		
		//Selection of measurement
		heightType = JOptionPane.showInputDialog(null,"Please select a measurement for height\n[ Inches / Meter ]", "Measurement for Height", JOptionPane.INFORMATION_MESSAGE);
		weightType = JOptionPane.showInputDialog(null,"Please select a measurement for weight\n[ Pounds / Kilogram ]", "Measurement for Weight", JOptionPane.INFORMATION_MESSAGE);
		
		BMI_Index = measurementInput(heightType,weightType);
		
		//Display
		JOptionPane.showMessageDialog(null,"This is your BMI Index\n"
				+ BMI_Index);//display user's bmi to them
		//providing information to user about what user's bmi tells about their weight
		Result(BMI_Index);
	}
	//type differentiation and value conversion
	public static double measurementInput(String heightType, String weightType)
	{	
		double height = 0;
		double weight = 0;
		
		switch(heightType.toLowerCase())
		{
			case "inches":
				String heightInInches = JOptionPane.showInputDialog(null,"Please enter your height in inches", "Height", JOptionPane.INFORMATION_MESSAGE);
				height = (Double.parseDouble(heightInInches)) * 0.0254;
				break;
			
			case "meter":
				String heightInMeter = JOptionPane.showInputDialog(null,"Please enter your height in m", "Height", JOptionPane.INFORMATION_MESSAGE);
				height = Double.parseDouble(heightInMeter);
				break;
			
			default:
				JOptionPane.showMessageDialog(null,"Please select a valid measurement for height");
				System.exit(0);
				break;
		}
		
		switch(weightType.toLowerCase())
		{
		case "pounds":
		
			String weightInPounds = JOptionPane.showInputDialog(null,"Please enter your weight in pounds", "Weight", JOptionPane.INFORMATION_MESSAGE);
			weight = (Double.parseDouble(weightInPounds)) * 0.45359237;
			break;
		case "kilogram":
			String weightInKg = JOptionPane.showInputDialog(null,"Please enter your weight in kg", "Weight", JOptionPane.INFORMATION_MESSAGE);
			weight = Double.parseDouble(weightInKg);
			break;
		default:
			JOptionPane.showMessageDialog(null,"Please select a valid measurement for weight");
			System.exit(0);
			break;
		}		
		double BMI_Index = (double) Math.round((weight/(height*height)) * 100)/ 100;//calculate bmi(two decimal places)
		return BMI_Index;
	}
	public static void Result(double BMI_Index)
	{
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
