import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

class Main{
	private final String wordList = "words";
	
	private ArrayList<String> findWords(String toFind, ArrayList<String> wordList, boolean anyPos){
		ArrayList<String> out = new ArrayList<>();
		if(anyPos){
			for(String word : wordList){
				if(word.contains(toFind)){
					out.add(word);
				}
			}
		}else{
			char toFindChr = toFind.charAt(0);
			for(String word : wordList){
				if(word.charAt(0) == toFindChr){
					out.add(word);
				}
			}
		}
		
		return out;
	}
	
	private ArrayList<String> readWords(){
		ArrayList<String> out = new ArrayList<>();
		File file = new File(wordList);
		
		try{
			Scanner reader = new Scanner(file);
			
			while(reader.hasNext()){
				out.add(reader.nextLine());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return out;
	}
	
	public Main(){
		ArrayList<String> words = readWords();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("To Find: ");
		String toFind = scanner.nextLine();
		
		if(toFind.length() == 0){
			return;
		}
		
		System.out.print("Just First Char? [Y/n]: ");
		String choice = scanner.nextLine();
		if(choice.length() == 0){
			return;
		}
		boolean findAll = choice.toLowerCase().charAt(0) == 'n';
		
		ArrayList<String> found = findWords(toFind, words, findAll);
		System.out.println(found);
	}
	
	public static void main(String[] args){
		new Main();
	}
}
