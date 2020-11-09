import java.util.Scanner;

class Main{
	
	public Main(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("What should be checked? ");
		String toCheck = in.nextLine();
		
		if(toCheck.equals(reverse(toCheck))){
			System.out.println("It is a palindrome");
		}else{
			System.out.println("It is not a palindrome");
		}
	}
	
	private String reverse(String in){
		StringBuilder out = new StringBuilder();
		
		for(int i=in.length()-1 ; i>=0 ; i--){
			out.append(in.charAt(i));
		}
		
		return out.toString();
	}
	
	public static void main(String[] args){
		new Main();
	}
}
