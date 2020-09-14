import java.util.Scanner;

class Main{
    public Main(){
        Difficulty difficulty = Difficulty.MEDIUM;
        
        Generator generator = new Generator(difficulty);
        
        generator.genNumber();
        
        int numTries = 0;
        
        System.out.println(generator.getNumber());
        
        Scanner in = new Scanner(System.in);
        
        while(true){
            numTries++;
            System.out.print("=> ");
            int guess = in.nextInt();
            
            if(generator.getNumber() == guess){
                break;
            }
        }
        
        System.out.printf("Well done! It only took you %d tries!%n", numTries);
    }

    public static void main(String[] args){
        new Main();
    }
}
