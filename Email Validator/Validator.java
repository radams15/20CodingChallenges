import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator{
    
    private final Pattern emailRegex = Pattern.compile("[\\S]+@[\\S]+\\.[\\S]+", Pattern.MULTILINE);
    private final Pattern dotRegex = Pattern.compile("[\\S]*@[\\S]*\\.", Pattern.MULTILINE);
    private final Pattern extRegex = Pattern.compile("[\\S]*@[\\S]*\\.[\\S]+", Pattern.MULTILINE);
    
    public ArrayList<String> getErrors(String email){
        ArrayList<String> out = new ArrayList<>();
        
        Matcher regexMatcher = emailRegex.matcher(email);
        
        if(email.contains(" ")){
            out.add("Spaces In Email!");
            return out;
        }
        
        if(regexMatcher.find()){
            return out;
        }else{
            if(!email.contains("@")){
                out.add("No '@' In Email!");
            }else{
                String[] split = email.split("@");
                if(split[0].equals("")){
                    out.add("Nothing Before The '@' Sign!");
                }
                if(split.length > 1 && split[1].equals("")){
                    out.add("Nothing After The '@' Sign!");
                }
            }
            
            Matcher dotMatcher = dotRegex.matcher(email);
            if(!dotMatcher.find()){
                out.add("No Dot After '@' Sign!");
            }
            
            Matcher extMatcher = extRegex.matcher(email);
            if(!extMatcher.find()){
                out.add("No Domain Extension!");
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
