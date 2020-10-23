import java.util.ArrayList;

class Elf extends Character{
	
	void setTraits(){
		characterClass = "Elf";
		strength = 3;
		dexterity = 8;
		intelligence = 9;
		
		abilities.add("Bow");
		abilities.add("Fire");
		abilities.add("Enlightenment");
	};
		
	public Elf(String gender){
		super(gender);
		setTraits();
	}
	public Elf(String gender, String name){
		super(gender, name);
		setTraits();
	}
}
