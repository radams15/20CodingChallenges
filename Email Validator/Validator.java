import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator{

    private final Pattern emailRegex = Pattern.compile("[\\S]+@[\\S]+\\.[\\S]+", Pattern.MULTILINE);
    
   
    private String convertToHuman(String check){
        if(check.equals("user")){
            return "No Account Before The '@'";
        }else if(check.equals("domain")){
            return "No Domain Name Entered";
        }else if(check.equals("extension")){
            return "No Website Extension";
        }
        return "Unspecified Error";
    }
    
    public ArrayList<String> getErrors(String email){
        ArrayList<String> out = new ArrayList<>();
        
        Matcher matcher = emailRegex.matcher(email);
        
        if(email.contains(" ")){
            out.add("Spaces In Email!");
        }
        
        if(matcher.find()){
            return out;
        }else{
            if(email.contains("@")){
                out.add("No '@' In Email!");
            }
            
            
        }
        
        
        
        return out;        
    }
    
    public boolean isValid(String email){
        if(getErrors(email).size() == 0){
            return true;
        }
        return false;
    }
    
}
