class Main{
	
	public Main(){
		Orc player = new Orc("male");
		
		String serialised = player.serialise();
		
		Character p1 = Character.load(serialised);
		
		System.out.println(serialised+"\n");
		System.out.println(p1.serialise());
	}
	
	public static void main(String[] args){
		new Main();
	}
}
