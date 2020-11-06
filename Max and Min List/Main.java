import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Collections;
import java.util.*;

public class Main {

    private final Scanner in;

    private double calculateAverage(ArrayList<Double> list){
        double sum = list.stream().mapToDouble(Double::doubleValue).sum(); // sum all the data using a stream
        double len = list.size(); // get the length of the list

        return sum/len; // find the average by dividing the sum by the len
    }

    private void writeToFile(ArrayList<Double> data, String fileName){
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);

            StringBuilder outBuilder = new StringBuilder();
            data.stream().forEach(a -> {
                outBuilder.append(a.toString());
                outBuilder.append("\n");
            });

            writer.write(outBuilder.toString());

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private ArrayList<Double> readFile(String fileName){
        ArrayList<Double> out = new ArrayList<>();

        File file = new File(fileName);

        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                out.add(Double.parseDouble(data));
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return out;
    }

    private ArrayList<Double> getNums(){
        ArrayList<Double> nums = new ArrayList<>();

        boolean stillInputting = true;
        while( stillInputting ){
            System.out.print("=> ");

            String data = in.nextLine(); // get the next line of input

            if(data.length() == 0){ // no data
                continue; // another input
            }

            switch( Character.toLowerCase(data.charAt(0)) ){ // switch for the lowercase of the first character
                // i would have used an if statement but used a switch to show a skill
                case 'c': // if char is c
                    stillInputting = false; // break the loop
                    break;

                default:
                    try {
                        double doubleData = Double.parseDouble(data); // parse the double
                        nums.add(doubleData);
                    }catch(NumberFormatException e){ // string is invalid number
                        continue; // restart the loop
                    }
                    break;
            }
        }

        return nums;
    }
    
	private double[] getMaxMin(ArrayList<Double> list){
		double min = Collections.min(list);
		double max = Collections.max(list);
		
		return new double[]{min, max};
	};

    public void mainAverage(){
		System.out.print("File To Open: ");
		String fileName = in.nextLine();
		
		ArrayList<Double> boundaries;
		
		if(!fileName.equals("")){
			boundaries = readFile(fileName);
		}else{
			System.out.print("Boundaries [num, num]: ");
			String[] boundariesString = in.nextLine().split(",");
			
			boundaries = new ArrayList<>();
			for(int i=0 ; i<2 ; i++){
				boundaries.add(Double.parseDouble(boundariesString[i]));
			}
		}
		
		ArrayList<Double> nums = new ArrayList<>();

        boolean stillInputting = true;
        while( stillInputting ){
            System.out.print("=> ");

            String data = in.nextLine(); // get the next line of input

            if(data.length() == 0){ // no data
                continue; // another input
            }

            switch( Character.toLowerCase(data.charAt(0)) ){ // switch for the lowercase of the first character
                // i would have used an if statement but used a switch to show a skill
                case 'c': // if char is c
                    stillInputting = false; // break the loop
                    break;

                default:
                    try {
                        double doubleData = Double.parseDouble(data); // parse the double
                        if(doubleData < boundaries.get(1) && doubleData > boundaries.get(0)){
							nums.add(doubleData);
							
							double[] maxMin = getMaxMin(nums);
							System.out.printf("Min: %f, Max: %f\n", maxMin[0], maxMin[1]);
						}
                    }catch(NumberFormatException e){ // string is invalid number
                        continue; // restart the loop
                    }
                    break;
            }
        }
        System.out.print("File To Save: ");
		fileName = in.nextLine();
		writeToFile(boundaries, fileName);
    }

    public void mainRead(){
        System.out.print("File Name => ");
        String file = in.nextLine();
        ArrayList<Double> nums = readFile(file);
        System.out.println("Your Numbers Were: " + nums.toString());
    }

    public Main(){
        in = new Scanner(System.in); // initialise the scanner for data input
		mainRead();
    }

    public static void main(String[] args){
        new Main(); // initialise the class and run the initialiser method
    }
}
