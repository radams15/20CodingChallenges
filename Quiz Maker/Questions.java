import java.io.IOException;
import java.io.File;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

class Questions{
	
	private HashMap<String, String> questions;
	private Random random;
	
	public Questions(String path) throws IOException{
		File file = new File(path);
		random = new Random();
		
		Scanner reader = new Scanner(file);
		
		questions = new HashMap<>();
		
		while(reader.hasNext()){
			String[] split = reader.nextLine().split(";");
			if(split.length == 2){
				questions.put(split[0], split[1]);
			}
		}
	}
	
	public HashMap<String, String> getSelection(int num){
		HashMap<String, String> out = new HashMap<>();
		
		if(num >= questions.size()){
			num = questions.size();
		}
		
		while(out.size() < num){
			String key = getRandomKey();
			out.put(key, questions.get(key));
		}
		
		return out;
	}
	
	private String getRandomKey(){
		Object[] keys = questions.keySet().toArray();
		int arrayLength = keys.length;
		return (String) keys[random.nextInt(arrayLength)];
	}
}
