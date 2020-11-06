import java.util.ArrayList;

class Generator{
    private Difficulty difficulty;
    
    private final static int hardLength = 5;
    private final static int normalLength = 4;
    
    private int number;
    
    private int getRandomNumber(int min, int max){
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    
    private int getRandomNumber(int length){ // generates random numbers of size length
        int min = (int) Math.pow(10, length-1);
        int max = (int)  Math.pow(10, length)-1;
        return getRandomNumber(min, max);
    }

    public Generator(Difficulty difficulty){
        this.difficulty = difficulty;
    }
    
    public int genNumber(){
        if(difficulty == Difficulty.HARD){
            return getRandomNumber(hardLength);
        }
        return getRandomNumber(normalLength);
    }
    
    private String shorten(String s, int size){ // shortens the string to a desired size
        return s.substring(0, Math.min(s.length(), size));
    }
    
    private String shorten(String s){ // overloaded shorten to automatically decide size based on difficulty
        if(difficulty == Difficulty.HARD){
            return shorten(s, hardLength);
        }
        return shorten(s, normalLength);
    }

    public ArrayList<Integer> getLocations(int attempt){
        ArrayList<Integer> out = new ArrayList<>();
        String attemptStr = String.valueOf(attempt);
        String numberStr = String.valueOf(number);
        
        attemptStr = shorten(attemptStr);
        numberStr = shorten(numberStr);

        for(int i=0 ; i<attemptStr.length() ; i++){
            char attemptChr = attemptStr.charAt(i);
            char numberChr = numberStr.charAt(i);
            if(attemptChr == numberChr){
                out.add(i);
            }
        }

        return out;
    }
    
    public int getNumber(){
        return number;
    }
}
