import java.util.ArrayList;

class Human extends Character{
	
	void setTraits(){
		characterClass = "Human";
		strength = 5;
		dexterity = 5;
		intelligence = 7;
		
		abilities.add("Think");
		abilities.add("Fire");
		abilities.add("Build");
	};
		
	public Human(String gender){
		super(gender);
		setTraits();
	}
	public Human(String gender, String name){
		super(gender, name);
		setTraits();
	}
}
