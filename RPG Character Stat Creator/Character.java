import java.util.ArrayList;
import java.util.Arrays;

class Character{
	String characterClass;
	String gender;
	String name;
	
	int strength;
	int dexterity;
	int intelligence;
	
	ArrayList<String> abilities;
	
	private String generateName(){
		return NameGenerator.generate();
	}
	
	public String serialise(){
		return characterClass + "\n" + gender + "\n" + name + "\n" + strength + "\n" + dexterity + "\n" + intelligence + "\n" + String.join(";", abilities);
	}
	
	public static Character load(String data){
		String[] split = data.split("\n");
		
		Character out = new Character(split[2], split[1]);
		out.characterClass = split[0];
		out.strength = Integer.parseInt(split[3]);
		out.dexterity = Integer.parseInt(split[4]);
		out.intelligence = Integer.parseInt(split[5]);
		
		out.abilities = new ArrayList<>(Arrays.asList(split[6].split(";")));
		
		return out;
	}
	
	public Character(String name, String gender){
		this.name = name;
		this.gender = gender;
		abilities = new ArrayList<>();
	}
	
	public Character(String gender){
		this.name = generateName();
		this.gender = gender;
		abilities = new ArrayList<>();
	}
}
