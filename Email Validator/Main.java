import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class Main{

    public Main(){
        Validator validator = new Validator();
        Scanner in = new Scanner(System.in);
        
        System.out.print("File? [Y/n]: ");
        String choice = in.nextLine();
        
        if(choice.length() != 0 && choice.charAt(0) == 'y'){
            System.out.print("File Name: ");
            String fileName = in.nextLine();
            if(fileName.length() != 0){
                File file = new File(fileName);
                if(! file.exists()){
                    System.out.println("File Does Not Exist!");
                    System.exit(1);
                }
                
                try{
                    Scanner fileIn = new Scanner(file);
                    
                    while(fileIn.hasNext()){
                        String line = fileIn.nextLine();
                        ArrayList<String> errors = validator.getErrors(line);
                        System.out.printf("%s: ", line);
                        if(errors.size() == 0){
                            System.out.println("No Errors");
                        }else{
                        System.out.println("Errors:");
                            for(String error : errors){
                                System.out.println("\t"+error);
                            }
                        }
                    }
                }catch(java.io.FileNotFoundException e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }else{
            System.out.print("Email To Test: ");
            String toTest = in.nextLine();
            
            if(toTest.length() != 0){
                ArrayList<String> errors = validator.getErrors(toTest);
                if(errors.size() == 0){
                    System.out.println("No Errors");
                }else{
                System.out.println("Errors:");
                    for(String error : errors){
                        System.out.println("\t"+error);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args){
        new Main();
    }
}
