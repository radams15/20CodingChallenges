import javax.swing.JFormattedTextField;
import java.text.DecimalFormat;

class UnitBox extends JFormattedTextField{

	public String unit;
	public double multiplier;

	public UnitBox(String unit, double multiplier){
		super(new DecimalFormat("#.0"));

		this.unit = unit;
		this.multiplier = multiplier;
	}

	void setMetres(double metresValue){
		double newVal = metresValue * multiplier;
		setValue(newVal);
	}

	double getMetres(){
		double value = Double.parseDouble(getValue().toString()); 
		
		return value/multiplier;
	}
}
