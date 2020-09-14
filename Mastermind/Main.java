import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public Main(){
        Difficulty difficulty;
        
        int numTries = 0;
        
        Scanner in = new Scanner(System.in);

        System.out.print("Difficulty: [E/M/H]: ");
        String difStr = in.nextLine();

        switch(difStr.toLowerCase().charAt(0)){
            case 'e':
                difficulty = Difficulty.EASY;
                break;
            case 'h':
                difficulty = Difficulty.HARD;
                break;
            default:
                difficulty = Difficulty.MEDIUM;
                break;
        }

        Generator generator = new Generator(difficulty);

        generator.genNumber();

        System.out.println(generator.getNumber());
        
        while(true){
            numTries++;
            System.out.print("=> ");
            int guess = in.nextInt();
            
            if(generator.getNumber() == guess){
                break;
            }

            if(difficulty == Difficulty.EASY) {
                ArrayList<Integer> correct = generator.getLocations(guess);
                System.out.println("Correct Locations Are: " + correct.toString());
            }
        }
        
        System.out.printf("Well done! It only took you %d tries!%n", numTries);
    }

    public static void main(String[] args){
        new Main();
    }
}
