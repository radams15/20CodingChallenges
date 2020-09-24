import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;

class Storage{
    private final File file;
    private final static String delimiter = ",";
    
    public Storage(String saveFile){
        file = new File(saveFile);
    }
    
    private void writeToFile(HashMap<String, String> data){
        StringBuilder outBuilder = new StringBuilder();
        
        for(String username : data.keySet()){
            outBuilder.append(username);
            outBuilder.append(delimiter);
            outBuilder.append(data.get(username));
            outBuilder.append("\n");
        }
        
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(outBuilder.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private HashMap<String, String> getPasswords(){
        HashMap<String, String> out = new HashMap<>();

        try{
            Scanner s = new Scanner(file);
                while(s.hasNext()){
                String data = s.nextLine();
                
                String[] split = data.split(delimiter);
                if(split.length == 2){
                    out.put(split[0], split[1]);
                }
            }
        }catch(Exception e){
            return out;
        }
        
        return out;
    }
    
    public String getPassword(String username){
        HashMap<String, String> existing = getPasswords();
        
        try{
            return existing.get(username);
        }catch(Exception e){
            return null;
        }
    }
    
    public void save(String username, String password){
        HashMap<String, String> existing = getPasswords();
        existing.put(username, password);
        writeToFile(existing);
    }
}
