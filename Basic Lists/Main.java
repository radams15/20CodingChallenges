import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;

class Main{
	
	private ArrayList<String> dataList;
	private Scanner in;
	
	private void add(){
		String piece;
		while(true){
			System.out.print("\t=> ");
			piece = in.nextLine();
			
			if(piece.equals("")){
				break;
			}
			
			dataList.add(piece);
		}
	}
	
	private void print(ArrayList<String> toPrint){
		System.out.println("Data Is As Follows: ");
		for(String data : toPrint){
			System.out.printf("\t%s%n", data);
		}
	}
	
	private ArrayList<String> readFile(String fileName){
		ArrayList<String> out = new ArrayList<>();

		File file = new File(fileName);

		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()){
				String data = reader.nextLine();
				out.add(data);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return out;
	}
	
    private void writeToFile(ArrayList<String> data, String fileName){
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);

            StringBuilder outBuilder = new StringBuilder();
            data.stream().forEach(a -> {
                outBuilder.append(a);
                outBuilder.append("\n");
            });

            writer.write(outBuilder.toString());

            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


	
	private void slice(){
		System.out.print("Range [x-y]: ");
		String raw = in.nextLine();
		
		String[] parts = raw.split("-");
		
		if(parts.length == 2){
			int from = Integer.parseInt(parts[0]);
			int to = Integer.parseInt(parts[1]);
			
			if(to < dataList.size() && from >= 0 && from < to){
				System.out.println(to + "-" + dataList.size());
				for(int i=from ; i<=to ; i++){
					System.out.println(dataList.get(i));
				}
			}
		}
	}
	
	private void remove(){
		System.out.print("To Remove => ");
		try{
			int toRemove = in.nextInt();
			in.nextLine();
			if(toRemove <= dataList.size() && toRemove >= 0){
				System.out.println("Removing: " + dataList.get(toRemove));
				dataList.remove(toRemove);
			}else{
				System.out.println("Element does not exist!");
			}
		}catch(Exception e){}
	}
	
	private void save(){
		System.out.print("File Name => ");
		String file = in.nextLine();
		
		if(!file.equals("")){
			writeToFile(dataList, file);
		}
	}
	
	private void open(){
		System.out.print("File Name => ");
		String file = in.nextLine();
		
		if(!file.equals("")){
			dataList = readFile(file);
		}
	}
	
	private void lower(){
		for(int i=0 ; i<dataList.size() ; i++){
			dataList.set(i, dataList.get(i).toLowerCase());
		}
	}	
	
	
	public Main(){
		in = new Scanner(System.in);
		dataList = new ArrayList<>();
		
		String line;
		boolean running = true;
		while(running){
			System.out.print("% ");
			line = in.nextLine();
			
			if(line.equals("")){
				continue;
			}
			
			char op = line.toLowerCase().charAt(0);
			
			switch(op){
				case 'a': // add
					add();
					break;
					
				case 'p': // print
					print(dataList);
					break;
					
				case 'q': // quit
					running = false;
					break;
					
				case 's': // slice
					slice();
					break;
					
				case 'r': // remove
					remove();
					break;
					
				case 'i': // insert to file
					save();
					break;
					
				case 'o': // open
					open();
					break;
					
				case 'l': // lowercase
					lower();
					break;
			}
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
}
