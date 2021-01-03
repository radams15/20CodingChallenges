import java.util.ArrayList;
import java.util.Scanner;

class Main{
    Scanner in;

    ArrayList<Character> found = new ArrayList<>();
    int numFound = 0;

    private void begin(String word, int tries){
        word = word.toLowerCase();

        for(int i=0 ; i<word.length() ; i++){
            found.add('_');
        }

        for(int i=tries ; i>=0 ; i--){
            System.out.print("Guess: ");
            String next = in.nextLine();
            Character guess = null;

            if(next.length() > 0){
                guess = next.charAt(0);
            }

            if(guess != null) {
                for (int x = 0; x < word.length(); x++) {
                    if (word.charAt(x) == guess) {
                        found.set(x, guess);
                        numFound++;
                    }
                }

                System.out.printf("%d tries left!%n", i);
                System.out.println(found);
            }

            if(numFound == word.length()) break;
        }
    }

    public Main(){
        in = new Scanner(System.in);

        System.out.print("Word: ");
        String word = "";
        while(word.length() == 0) {
            word = in.nextLine();
        }

        System.out.print("Guesses: ");
        int guesses = in.nextInt();
        in.nextLine();

        begin(word, guesses);
    }

    public static void main(String[] args){
        new Main();
    }
}