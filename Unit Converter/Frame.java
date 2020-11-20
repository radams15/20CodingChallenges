import javax.swing.*;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame{
	
	private ArrayList<UnitBox> fields = new ArrayList<>();
	
	private void makeNumberInput(String unit, double multiplier){
		UnitBox field = new UnitBox(unit, multiplier);
		
		field.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				UnitBox source = (UnitBox) actionEvent.getSource();
				double value = Double.parseDouble(source.getValue().toString());

				applyConversion(value, source);
			}
		});

		fields.add(field);
	}
	
	private void applyConversion(double in, UnitBox source){
		double newMetres = source.getMetres();

		for(UnitBox box : fields){
			if(! box.unit.equals(source.unit)){
				box.setMetres(newMetres);
			}
		}
	}
	
	public Frame(){
		JPanel listPane = new JPanel();
		
		BoxLayout layout = new BoxLayout(listPane, BoxLayout.PAGE_AXIS);
		
		listPane.setLayout(layout);
		
		makeNumberInput("m", 1);
		
		makeNumberInput("ft", 3.28084);
		
		
		for(UnitBox field : fields){
			listPane.add(field);
		}
		
		
		add(listPane);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
