import java.util.Scanner;
import java.util.HashMap;

import java.io.File;

class Main{
	
	public Main(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("File name: ");
		String path = in.nextLine();
		
		try{
			File file = new File(path);
			
			Scanner fileIn = new Scanner(file);
			
			HashMap<Character, Integer> chars = new HashMap<>();
			
			while(fileIn.hasNext()){
				HashMap<Character, Integer> toMerge = (countVowels(fileIn.nextLine()));
				toMerge.forEach((chr, count) -> {
					if(chars.get(chr) == null){
						chars.put(chr, count);
					}else{
						chars.put(chr, chars.get(chr)+count);
					}
				});
			}
			
			
			System.out.println(chars);
		}catch(java.io.IOException e){
			System.out.println("File does not exist!");
			System.exit(1);
		}
	}
	
	public HashMap<Character, Integer> countVowels(String input){
		HashMap<Character, Integer> out = new HashMap<>();
		
		for(char s : input.toLowerCase().toCharArray()){
			switch(s){
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					if(out.get(s) == null){
						out.put(s, 1);
					}else{
						out.put(s, out.get(s)+1);
					}
			}
		}
		return out;
	}
	
	public static void main(String[] args){
		new Main();
	}
}
