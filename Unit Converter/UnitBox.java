import javax.swing.JFormattedTextField;
import java.text.DecimalFormat;

class UnitBox extends JFormattedTextField{
	public String unit;
	public String type;
	public double multiplier;

	//base is anything, can be metres, litres, pints, etc

	public UnitBox(String type, String unit, double multiplier){
		super(new DecimalFormat("#.0")); // initialise Formatted Text Field

		this.type = type;
		this.unit = unit;
		this.multiplier = multiplier;
	}

	void setBase(double metresValue){ // set the value in base
		double newVal = metresValue * multiplier; // convert the value into local measurement
		setValue(newVal); // set the value
	}

	double getBase(){ // return the currect value in base, so that the converter can deal with it
		double value = Double.parseDouble(getValue().toString()); 
		
		return value/multiplier; // return value as metres by dividing by multiplier
	}
}
