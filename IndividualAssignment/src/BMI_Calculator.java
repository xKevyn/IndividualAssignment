import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class BMI_Calculator {
	public static void main(String[] args) 
	{
		Display();
	}
	public static void Display()
	{
		//Variables
		int heightType;
		int weightType;
		double BMI_Index = 0;
		
		//Images
		ImageIcon bmi = new ImageIcon("bmi.PNG");
		String[] HeightOption = {"Inches","Meter"};
		String[] WeightOption = {"Pounds", "Kilogram"};
		
		//Clarification
		JOptionPane.showMessageDialog(null,"Please note that this calculator is only applicable to people who are 20 years old or older", 
				"BMI Calculator", JOptionPane.INFORMATION_MESSAGE, bmi);
		
		//Selection of measurement
		heightType = JOptionPane.showOptionDialog(null,"Inches or Meter", "Measurement for Height", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,HeightOption,HeightOption[0]);
		weightType = JOptionPane.showOptionDialog(null,"Pounds or Kilogram", "Measurement for Weight", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,WeightOption,WeightOption[0]);
		
		//Method calling
		BMI_Index = measurementInput(heightType,weightType);
		
		//Display
		JOptionPane.showMessageDialog(null,"This is your BMI Index\n"
				+ BMI_Index);//display user's BMI to them
		
		//providing information to user about what user's BMI tells about their weight
		Result(BMI_Index);
	}
	//Calculates the bmi index
	public static double measurementInput(int heightType, int weightType)//the chosen type input will be inputed into this method
	{	
		double height;
		double weight;
		
		height = HeightInput(heightType);
		weight = WeightInput(weightType);
		
		double BMI_Index = (double) Math.round((weight/(height*height)) * 100)/ 100;//calculate bmi(two decimal places)
		return BMI_Index;
	}
	
	//differentiate the type of measurement and convert the value if necessary
	public static double WeightInput(int weightType)
	{	
		double weight;
		
		if(weightType == 0)//Pounds = 0, Kilogram = 1
		{
			String weightInPounds = JOptionPane.showInputDialog(null,"Please enter your weight in pounds", "Weight", JOptionPane.INFORMATION_MESSAGE);
			weight = (Double.parseDouble(weightInPounds)) * 0.45359237;//converts to kilogram
			return weight;
		}
		else
		{
			String weightInKg = JOptionPane.showInputDialog(null,"Please enter your weight in kg", "Weight", JOptionPane.INFORMATION_MESSAGE);
			weight = Double.parseDouble(weightInKg);
			return weight;
		}
	}
	
	//differentiate the type of measurement and convert the value if necessary
	public static double HeightInput(int heightType)
	{	
		double height;
		
		if(heightType == 0)//Inches = 0, Meter = 1
		{
			String heightInInches = JOptionPane.showInputDialog(null,"Please enter your height in inches", "Height", JOptionPane.INFORMATION_MESSAGE);
			height = (Double.parseDouble(heightInInches)) * 0.0254;//converts to meter
			return height;
		}
		else
		{
			String heightInMeter = JOptionPane.showInputDialog(null,"Please enter your height in m", "Height", JOptionPane.INFORMATION_MESSAGE);
			height = Double.parseDouble(heightInMeter);
			return height;
		}
	}
	//Determine and interpret the bmi index
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
