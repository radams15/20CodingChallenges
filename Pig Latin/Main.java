class Main{
	public Main(){
		Translator translator = new Translator();
		
		
		String input = "i am eating a banana on a stupid day";
		
		String output = translator.translate(input);
		
		System.out.println(output);
	}
	
	public static void main(String[] args){
		new Main();
	}
}
