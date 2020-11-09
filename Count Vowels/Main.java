import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;

class Main{
	
	public Main(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("File name: ");
		String path = in.nextLine();
		
		try{
			File file = new File(path);
			
			Scanner fileIn = new Scanner(file);
			
			ArrayList<char> chars = new ArrayList<>();
			
			while(fileIn.hasNext()){
				total += countVowels(fileIn.nextLine());
			}
			
			
			System.out.printf("In total the file contains %d Vowels\n", total);
		}catch(java.io.IOException e){
			System.out.println("File does not exist!");
			System.exit(1);
		}
	}
	
	public int countVowels(String input){
		int out = 0;
		ArrayList<char> out = new ArrayList<>();
		
		for(char s : input.toCharArray()){
			switch(s){
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					out++;
			}
		}
		return out;
	}
	
	public static void main(String[] args){
		new Main();
	}
}
