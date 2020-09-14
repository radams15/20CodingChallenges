class Generator{
    private Difficulty difficulty;
    
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
    
    public int getNumber(){
        return getRandomNumber(4);
    }
}
