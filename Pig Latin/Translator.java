class Translator{
	
	public String[] constonants = new String[]{
			"a",
			"b",
			"c",
			"d",
			"f",
			"g",
			"h",
			"j",
			"k",
			"l",
			"m",
			"n",
			"p",
			"q",
			"r",
			"s",
			"t",
			"v",
			"w",
			"x",
			"y",
			"z"
	};
	public String[] constonantSounds = new String[]{ // https://i2.wp.com/impact.chartered.college/wp-content/uploads/2018/05/Screenshot-2018-05-15-12.20.20.png?w=507&ssl=1
			"st",
			"br",
			"sp",
			"gr",
			"fl",
			"cr",
			"cl",
			"bl",
			"tr",
			"sl",
			"dr",
			"fr",
			"sw",
			"pl",
			"pr",
			"gl",
			"str",
			"thr",
			"sc",
			"sm",
			"sn",
			"scr",
			"squ",
			"spr",
			"spl",
			"shr"
	};
	
	
	public Translator(){
	
	}
	
	
	public String translate(String input){
		
		StringBuilder out = new StringBuilder();
		
		for(String word : input.split(" ")){
			
			StringBuilder wordBuilder = new StringBuilder();
			
			
			boolean found = false;
			for(String constonantSound : constonantSounds){
				if(word.startsWith(constonantSound)){
					
					wordBuilder.append(word.replaceFirst(constonantSound, ""));
					
					wordBuilder.append(constonantSound);
					wordBuilder.append("ay");
					
					found = true;
				}
			}
			if(!found){
				found = false;
				for(String constonant : constonants){
					if(word.startsWith(constonant)){
						
						wordBuilder.append(word.replaceFirst(constonant, ""));
						
						wordBuilder.append(constonant);
						wordBuilder.append("ay");
						
						found = true;
					}
				}
				
				if(!found){
					wordBuilder.append(word);
				}
			}
			
			wordBuilder.append(" ");
			
			out.append(wordBuilder.toString());
			
		}
		
		return out.toString();
	}
}
