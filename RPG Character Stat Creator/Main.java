import java.util.Scanner;

class Main{
	
	public Main(){
		Scanner in = new Scanner(System.in);

		System.out.print("What Type Of Character? ");
		String userInput = in.nextLine().toLowerCase();

		System.out.print("Gender: ");
		String gender = in.nextLine();

		Character player;

		if(userInput.equals("elf")){
			player = new Elf(gender);
		}else if(userInput.equals("orc")){
			player = new Orc(gender);
		}else{
			player = new Human(gender);
		}
		
		System.out.println(player.serialise());
		
		System.out.print("File to write to: ");
		String file = in.nextLine();
		
		player.writeToFile(file);
		
		System.out.printf("Written data to %s!%n", file);
	}
	
	public static void main(String[] args){
		new Main();
	}
}
