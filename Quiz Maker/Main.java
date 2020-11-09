import java.util.Scanner;
import java.util.HashMap;

import java.io.IOException;


class Main{
	public Main(){
		Scanner in = new Scanner(System.in);
		
		try{
			Questions questions = new Questions("general.questions");
			
			float correct = 0;
			int requested = 5;
			
			HashMap<String, String> selection = questions.getSelection(requested);
			
			float total = selection.size();
			
			for(String question : selection.keySet()){
				System.out.println(question);
				String attempt = in.nextLine();
				
				if(attempt.toLowerCase().equals(selection.get(question).toLowerCase())){
					correct++;
					System.out.println("Correct!\n");
				}else{
					System.out.println("Incorrect!\n");
				}
			}
			
			System.out.printf("You Got %.0f out of %.0f, %.1f%%\n", correct, total, (correct/total)*100.0f);
			
		}catch(IOException e){
			System.out.println("Question File Does Not Exist! Please create questions file.");
			System.exit(1);
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
}
