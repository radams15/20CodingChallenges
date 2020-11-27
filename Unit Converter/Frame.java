import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame{
	
	private ArrayList<UnitBox> distanceFields = new ArrayList<>();
	private ArrayList<UnitBox> volumeFields = new ArrayList<>();
	private ArrayList<UnitBox> areaFields = new ArrayList<>();
	
	private UnitBox makeNumberInput(String type, String unit, double multiplier){
		UnitBox field = new UnitBox(type, unit, multiplier);
		
		field.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				UnitBox source = (UnitBox) actionEvent.getSource();
				double value = Double.parseDouble(source.getValue().toString());

				applyConversion(value, source);
			}
		});

		return field;
	}
	
	private void applyConversion(double in, UnitBox source){

		if(source.type.equals("d")){
			double newMetres = source.getBase();
			for(UnitBox box : distanceFields){
				if(! box.unit.equals(source.unit)){
					box.setBase(newMetres);
				}
			}
		}else if(source.type.equals("v")){
			double newLitres = source.getBase();
			for(UnitBox box : volumeFields){
				if(! box.unit.equals(source.unit)){
					box.setBase(newLitres);
				}
			}
		}else if(source.type.equals("a")){
			double newHectares = source.getBase();
			for(UnitBox box : areaFields){
				if(! box.unit.equals(source.unit)){
					box.setBase(newHectares);
				}
			}
		}
	}
	
	public Frame(){
		JPanel listPane = new JPanel();
		
		GridLayout layout = new GridLayout(0, 2);
		
		listPane.setLayout(layout);
		
		UnitBox m = makeNumberInput("d", "m", 1);
		JLabel lm = new JLabel("Metres");
		listPane.add(lm);
		listPane.add(m);
		distanceFields.add(m);
		
		UnitBox ft = makeNumberInput("d", "ft", 3.28084);
		JLabel lft = new JLabel("Feet");
		listPane.add(lft);
		listPane.add(ft);
		distanceFields.add(ft);

		UnitBox mi = makeNumberInput("d", "mi", 0.0009999975145);
		JLabel lmi = new JLabel("Miles");
		listPane.add(lmi);
		listPane.add(mi);
		distanceFields.add(mi);

		UnitBox lt = makeNumberInput("v", "lt", 1);
		JLabel llt = new JLabel("Litres");
		listPane.add(llt);
		listPane.add(lt);
		volumeFields.add(lt);

		UnitBox pt = makeNumberInput("v", "pt", 1.75975);
		JLabel lpt = new JLabel("Pints");
		listPane.add(lpt);
		listPane.add(pt);
		volumeFields.add(pt);

		UnitBox qt = makeNumberInput("v", "qt", 0.879877);
		JLabel lqt = new JLabel("Quarts");
		listPane.add(lqt);
		listPane.add(qt);
		volumeFields.add(qt);

		UnitBox hc = makeNumberInput("a", "hc", 1);
		JLabel lhc = new JLabel("Hectares");
		listPane.add(lhc);
		listPane.add(hc);
		areaFields.add(hc);

		UnitBox ac = makeNumberInput("a", "ac", 2.47105);
		JLabel lac = new JLabel("Acres");
		listPane.add(lac);
		listPane.add(ac);
		areaFields.add(ac);
		
		add(listPane);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
