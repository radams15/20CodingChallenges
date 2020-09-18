class Main{

    public Main(){
        Validator v = new Validator();
        
        System.out.println(v.isValid("test1@gmail.org"));
    }
    
    public static void main(String[] args){
        new Main();
    }
}
