import java.util.Scanner;

class Main{
    final String saveFile = "out.txt";

    public Main(){
        Scanner in = new Scanner(System.in);
        Storage storage = new Storage(saveFile);
        
        while(true){
            System.out.print("Username => "); 
            String username = in.nextLine();
            
            String existingPassword = storage.getPassword(username);
            if(existingPassword != null){
                System.out.print("Previous Password => "); 
                String oldPassword = in.nextLine();
                
                if(!existingPassword.equals(oldPassword)){
                    System.out.println("Old password does not match inputted password!");
                    continue;
                }
            }
            
            System.out.print("New Password => ");
            String attempt = in.nextLine();
            System.out.print("Again => ");
            String attempt1 = in.nextLine();
            
            Strength strength = Validator.getStrength(attempt);
            System.out.printf("Your Password Is: %s%n", Validator.strengthToString(strength));
            
            if(Validator.isValid(attempt, attempt1)){
                storage.save(username, attempt);
                break;
            }
            
            for(String error : Validator.getErrors(attempt, attempt1)){
                System.out.printf("\t%s%n", error);
            }
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
