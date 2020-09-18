import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class Validator{
    final Pattern emailPattern = Pattern.compile("(?<user>[\\S]+)?@(?<domain>[\\S]+)?\\.(?<extension>[\\S]+)?", Pattern.MULTILINE);
    
    final String[] toCheck = {"user", "domain", "extension"};
    
    private String convertToHuman(String check){
        if(check.equals("user")){
            return "No Account Before The '@'"
        }else if(check.equals("domain"){
            return ""
        }
    }
    
    public ArrayList<String> getErrors(String email){
        ArrayList<String> out = new ArrayList<>();
        
        Matcher matcher = emailPattern.matcher(email);
        
        matcher.matches();
        
        for(String check : toCheck){
            if(matcher.group(check) == null){
                out.add(check);
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
