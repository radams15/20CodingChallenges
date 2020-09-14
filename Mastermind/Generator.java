import java.util.ArrayList;

class Generator{
    private Difficulty difficulty;
    
    private int number;
    
    private int getRandomNumber(int min, int max){
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    
    private int getRandomNumber(int length){
        int min = (int) Math.pow(10, length-1);
        int max = (int)  Math.pow(10, length)-1;
        return getRandomNumber(min, max);
    }

    public Generator(Difficulty difficulty){
        this.difficulty = difficulty;
    }
    
    public int genNumber(){
        if(difficulty == Difficulty.HARD){
            number = getRandomNumber(5);
        }else{
            number = getRandomNumber(4);
        }
        return number;
    }

    public ArrayList<Integer> getLocations(int attempt){
        ArrayList<Integer> out = new ArrayList<>();
        String attemptStr = String.valueOf(attempt);
        String numberStr = String.valueOf(number);

        if(attemptStr.length() != numberStr.length()){
            return out;
        }

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
