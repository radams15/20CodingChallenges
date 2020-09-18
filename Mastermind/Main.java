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
        
        printHighScore();
        
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

        //System.out.println(generator.getNumber());
        
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
            String name = in.nextLine(); // get their name
            if(name.length() != 0){
                writeToFile(name, numTries); // write the file if they input something
            }
        }
    }
    
    private void printHighScore(){
        HashMap<String, Integer> scores = getScores();
        
        int lowest = 9999; // nobody will take 9999 attempt to get a number, i hope...
        String lowestName = null;
        
        for(HashMap.Entry<String, Integer> part : scores.entrySet()){
            if(part.getValue() < lowest){ // find the lowest key in the hashmap
                lowest = part.getValue();
                lowestName = part.getKey();
            }
        }
        
        if(lowestName != null){ /// there is a value that has been selected
            System.out.printf("High Score: %s with %d%n", lowestName, lowest);
        }
    }
    
    private HashMap<String, Integer> getScores(){
        HashMap<String, Integer> out = new HashMap<>();

        File file = new File(saveFile); // open the file

        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine(); // read the line
                String[] dataSplit = data.split(","); // split the line by the delimiter
                out.put(dataSplit[0], Integer.parseInt(dataSplit[1])); // add to the hashmap
            }

        }catch(IOException e){ // there was an error, e.g the file does not exist.
            //e.printStackTrace();
        }

        return out;
    }

    private void writeToFile(String name, int score){
        HashMap<String, Integer> scores = getScores();
        
        File file = new File(saveFile);
        
        try {
            FileWriter writer = new FileWriter(file);

            StringBuilder outBuilder = new StringBuilder();
            
            for(HashMap.Entry<String, Integer> part : scores.entrySet()){ // add the existing scores in
                outBuilder.append(part.getKey());
                outBuilder.append(",");
                outBuilder.append(part.getValue());
                outBuilder.append("\n");
            }
            
            outBuilder.append(name); // add the new score in
            outBuilder.append(",");
            outBuilder.append(score);
            outBuilder.append("\n");

            writer.write(outBuilder.toString()); // write the data to the file

            writer.close(); // close the file writer
        }catch(IOException e){ // some sort of error with the file occured, e.g read only for some reason
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Main();
    }
}
