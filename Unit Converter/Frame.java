import javax.swing.*;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class Frame extends JFrame{
	
	private ArrayList<JFormattedTextField> fields = new ArrayList<>();
	
	private JFormattedTextField makeNumberInput(NumberCallback c, String returnData){
		JFormattedTextField field = new JFormattedTextField(new DecimalFormat("#.0"));
		ActionListener actionListener = new ActionListener() {
		  public void actionPerformed(ActionEvent actionEvent) {
			JFormattedTextField source = (JFormattedTextField) actionEvent.getSource();
			double value = Double.parseDouble(source.getValue().toString());
			
			c.callback(value, returnData);
			
		  }
		};
		
		field.addActionListener(actionListener); 
		
		return field;
	}
	
	private void applyConversion(double in, String inUnit){
		for(JFormattedTextField field : fields){
			field.setValue(in);
		}
	}
	
	public Frame(){
		JPanel listPane = new JPanel();
		
		BoxLayout layout = new BoxLayout(listPane, BoxLayout.PAGE_AXIS);
		
		listPane.setLayout(layout);
		
		
		JFormattedTextField metres = makeNumberInput(
		(double d, String unit) -> {
				applyConversion(d, unit);
		}, "m");
		
		fields.add(metres);
		
		JFormattedTextField feet = makeNumberInput(
		(double d, String unit) -> {
				applyConversion(d, unit);
		}, "ft");
		fields.add(feet);
		
		
		for(JFormattedTextField field : fields){
			listPane.add(field);
		}
		
		
		add(listPane);
	}
}
