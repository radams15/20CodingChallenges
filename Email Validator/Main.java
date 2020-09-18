class Main{

    public Main(){
        Validator v = new Validator();
        
        System.out.println(v.getErrors("test1 @gmail.com"));
    }
    
    public static void main(String[] args){
        new Main();
    }
}
