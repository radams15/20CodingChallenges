import java.util.ArrayList;

import java.io.FileWriter;
import java.io.File;

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
		return "Class: " + characterClass + "\nGender: " + gender + "\nName: " + name + "\nStrength: " + strength + "\nDexterity: " + dexterity + "\nIntelligence: " + intelligence + "\nAbilities: " + String.join(";", abilities);
	}
	
	public void writeToFile(String fileName){
	   File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(serialise());

            writer.close();
        }catch(Exception e){
            System.out.println("File Error!");
        }
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
