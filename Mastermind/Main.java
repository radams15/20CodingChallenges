class Main{
    public Main(){
        Difficulty difficulty = Difficulty.MEDIUM;
        
        Generator generator = new Generator(difficulty);
        
        System.out.println(generator.getNumber());
    }

    public static void main(String[] args){
        new Main();
    }
}
