import java.util.Scanner;

class Main{
	public Main(){
		Scanner in = new Scanner(System.in);
		
		Translator translator = new Translator();
		
		while(true){
			System.out.print("=> ");
			String input = in.nextLine();
			String output = translator.translate(input);
			
			System.out.println(output);
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
}
