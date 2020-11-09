import java.util.Scanner;

import java.io.File;

class Main{
	
	public Main(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("File name: ");
		String path = in.nextLine();
		
		try{
			File file = new File(path);
			
			Scanner fileIn = new Scanner(file);
			
			int total = 0;
			
			while(fileIn.hasNext()){
				total += countWords(fileIn.nextLine());
			}
			
			
			System.out.printf("In total the file contains %d words\n", total);
		}catch(java.io.IOException e){
			System.out.println("File does not exist!");
			System.exit(1);
		}
	}
	
	public int countWords(String input){
		return input.split(" ").length;
	}
	
	public static void main(String[] args){
		new Main();
	}
}
