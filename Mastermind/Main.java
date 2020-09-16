import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Integer;

class Main{

    private final String saveFile = "saves.txt";

    public Main(){
        Difficulty difficulty;
        
        int numTries = 0;
        
        Scanner in = new Scanner(System.in);
        
        printScores();
        
        System.out.println("");

        System.out.print("Difficulty: [E/M/H]: ");
        String difStr = in.nextLine(); // get the  string for easy, medium or hard
        
        if(difStr.length() == 0){
            System.out.println("No Input Supplied, Exiting");
            System.exit(1);
        }

        switch(difStr.toLowerCase().charAt(0)){
            case 'e':
                difficulty = Difficulty.EASY;
                break;
            case 'h':
                difficulty = Difficulty.HARD;
                break;
            default: // medium or no entry means medium difficulty
                difficulty = Difficulty.MEDIUM;
                break;
        }

        Generator generator = new Generator(difficulty); // initialise the generator with the desired difficulty

        generator.genNumber(); // get the generator to create a new random number

        System.out.println(generator.getNumber());
        
        while(true){
            numTries++;
            System.out.print("=> ");
            int guess = in.nextInt(); // get the next integer input
            
            if(generator.getNumber() == guess){ // answer is correct!
                break;
            }

            if(difficulty == Difficulty.EASY) { // if easy, show correct locations
                ArrayList<Integer> correct = generator.getLocations(guess);
                System.out.println("Correct Locations Are: " + correct.toString());
            }
        }
        
        in.nextLine(); // consume the \n from the nextInt()
        
        System.out.printf("Well done! It only took you %d tries!%n", numTries); // they won - tell them how many tries it took
        
        System.out.print("Save To File? [Y/N]: ");
        String input = in.nextLine();
        if(input.length() != 0 && input.toLowerCase().charAt(0) == 'y'){
            System.out.print("Name: ");
            String name = in.nextLine();
            if(name.length() != 0){
                writeToFile(name, numTries);
            }
        }
    }
    
    private void printScores(){
        HashMap<String, Integer> scores = getScores();
        System.out.println("Scores: ");
        for(HashMap.Entry<String, Integer> part : scores.entrySet()){
            System.out.printf("\t%s => %d%n", part.getKey(), part.getValue());
        }
    }
    
    private HashMap<String, Integer> getScores(){
        HashMap<String, Integer> out = new HashMap<>();

        File file = new File(saveFile);

        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                String[] dataSplit = data.split(",");
                out.put(dataSplit[0], Integer.parseInt(dataSplit[1]));
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return out;
    }

    private void writeToFile(String name, int score){
        HashMap<String, Integer> scores = getScores();
        
        File file = new File(saveFile);
        
        try {
            FileWriter writer = new FileWriter(file);

            StringBuilder outBuilder = new StringBuilder();
            
            for(HashMap.Entry<String, Integer> part : scores.entrySet()){
                outBuilder.append(part.getKey());
                outBuilder.append(",");
                outBuilder.append(part.getValue());
                outBuilder.append("\n");
            }
            
            outBuilder.append(name);
            outBuilder.append(",");
            outBuilder.append(score);
            outBuilder.append("\n");

            writer.write(outBuilder.toString());

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Main();
    }
}
