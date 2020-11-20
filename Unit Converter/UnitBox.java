import javax.swing.JFormattedTextField;
import java.text.DecimalFormat;

class UnitBox extends JFormattedTextField{

	public String unit;
	public double multiplier;

	public UnitBox(String unit, double multiplier){
		super(new DecimalFormat("#.0")); // initialise Formatted Text Field

		this.unit = unit;
		this.multiplier = multiplier;
	}

	void setMetres(double metresValue){ // set the value in metres
		double newVal = metresValue * multiplier; // convert the value into local measurement
		setValue(newVal); // set the value
	}

	double getMetres(){ // return the currect value in metres, so that the converter can deal with it
		double value = Double.parseDouble(getValue().toString()); 
		
		return value/multiplier; // return value as metres by dividing by multiplier
	}
}
