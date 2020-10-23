class NameGenerator{
	
	private static final String[] ends = new String[]{"sha", "ba", "la", "an", "can", "when", "wan"};
	private static final String[] middles = new String[]{"lo", "le", "le", "wah", "weh", "ka", "ke", "koo"};
	
	private static int randRange(int max, int min){
		return (int)(Math.random()* (max - min + 1) + min);
	}
	
	public static String generate(){
		String start = ends[randRange(0, ends.length-1)];
		String middle = middles[randRange(0, middles.length-1)];
		String end = ends[randRange(0, ends.length-1)];
		
		return start+middle+end;
	}
}
