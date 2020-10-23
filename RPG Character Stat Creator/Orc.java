import java.util.ArrayList;

class Orc extends Character{
	
	void setTraits(){
		characterClass = "Orc";
		strength = 10;
		dexterity = 3;
		intelligence = 3;
		
		abilities.add("Smash");
		abilities.add("Destroy");
		abilities.add("Crush");
	};
		
	public Orc(String gender){
		super(gender);
		setTraits();
	}
	public Orc(String gender, String name){
		super(gender, name);
		setTraits();
	}
}
