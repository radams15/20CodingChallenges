import java.util.ArrayList;


class Validator{
    public static final int minLength = 8;

    private static boolean hasCapsAndLowers(String str){
        boolean caps = false;
        boolean lowers = false;
        
        for(int i=0 ; i<str.length() ; i++){
            if(Character.isUpperCase(str.charAt(i))){
                caps = true;
            }else  if(Character.isLowerCase(str.charAt(i))){
                lowers = true;
            }
        }
        
        return (caps == true) && (lowers == true);
    }

    public static ArrayList<String> getErrors(String pass, String pass1){
        ArrayList<String> out = new ArrayList<>();
        
        if(pass.length()< minLength){
            out.add(String.format("Password Must Have %d Characters!", minLength));
        }
        
        if(!hasCapsAndLowers(pass)){
            out.add("Password must have upper and lower case letters!");
        }
        
        if(!pass.equals(pass1)){
            out.add("Passwords are not identical!");
        }
        
        return out;
    }
    
    public static boolean isValid(String pass, String pass1){
        if(getErrors(pass, pass1).size() == 0){
            return true;
        }
        return false;
    }
    
}
