import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.*;

public class Main {

    private final Scanner in;

    private double calculateAverage(ArrayList<Double> list){
        double sum = list.stream().mapToDouble(Double::doubleValue).sum(); // sum all the data using a stream
        double len = list.size(); // get the length of the list

        return sum/len; // find the average by dividing the sum by the len
    }

    private double calculateMedian(ArrayList<Double> list){
        double middle_num = (list.size()+1) / 2.0f;

        middle_num -= 1; // to account for arrays starting at 0

        if(middle_num % 1 == 0){ // check if is whole number
            return list.get((int)middle_num);
        }else{ // two middle numbers
            double leftNum = list.get((int) Math.floor(middle_num)); // get the number to the left of the median
            double rightNum = list.get((int) Math.ceil(middle_num)); // get the number to the right of the median

            return (leftNum+rightNum)/2.0f; // calculate the mean of the two median numbers
        }
    }

    private double calculateMode(ArrayList<Double> list){
        HashMap<Double, Integer> occurrences = new HashMap<>();

        for(Double num : list){
            if(occurrences.containsKey(num)){ // if num already in occurrences
                occurrences.put(num, occurrences.get(num)+1);
            }else{
                occurrences.put(num, 1);
            }
        }

        return Collections.max(occurrences.entrySet(), Map.Entry.comparingByValue()).getKey(); // find the max with a stream of the hashmap, by comparing the values (the counts) Then get the key
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

    public void mainAverage(){
        System.out.println("Simply Enter Numbers After Each Prompt, And Enter The Letter 'c' To Calculate The Average");

        ArrayList<Double> nums = getNums(); // use the helper method to get the numbers into a nice ArrayList

        double mean = calculateAverage(nums); // calculate the average of all the numbers
        double median = calculateMedian(nums);
        double mode = calculateMode(nums);

        if(Double.isNaN(mean)){
            System.out.println("Sorry, no values were input");
        }else {
            System.out.printf("Averages:%n\tMean Is: %f%n\tMedian Is: %f%n\tMode Is: %f%n%n", mean, median, mode);
        }

        System.out.print("Write To File? [y/n]"); // prompt to ask user to write the data to a file
        String answer = in.nextLine(); // get the next line of input

        if(answer.length() == 0 || Character.toLowerCase(answer.charAt(0)) == 'y'){ // if there is no input or the first char is 'n'
            System.out.print("File Name: ");
            String fileName = in.nextLine();

            writeToFile(nums, fileName);
        }
    }

    public void mainRead(){
        System.out.print("File Name => ");
        String file = in.nextLine();
        ArrayList<Double> nums = readFile(file);
        System.out.println("Your Numbers Were: " + nums.toString());
    }

    public Main(){
        in = new Scanner(System.in); // initialise the scanner for data input
        System.out.print("Read A Result? [y/n] ");

        String answer = in.nextLine(); // get the next line of input

        if(answer.length() == 0 || Character.toLowerCase(answer.charAt(0)) == 'y'){ // if there is no input or the first char is 'n'
            mainRead();
        }else{
            mainAverage();
        }
    }

    public static void main(String[] args){
        new Main(); // initialise the class and run the initialiser method
    }
}
