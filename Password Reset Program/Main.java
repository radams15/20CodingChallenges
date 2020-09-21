import java.util.Scanner;

class Main{

    public Main(){
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.print("New Password => ");
            String attempt = in.nextLine();
            
            if(Validator.isValid(attempt)){
                break;
            }
            
            for(String error : Validator.getErrors(attempt)){
                System.out.printf("\t%s%n", error);
            }
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
