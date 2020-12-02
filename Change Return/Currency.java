import java.util.ArrayList;

class Currency{
	
	public double[] coins; // the different coins available

	public Currency(double[] coinSet){
		coins = coinSet;
	}
	
	private double largestCoinFits(double number){
		for(double coin : coins){
			if(number-coin > -0.009){ // account for double precision loss, fairly badly
				return coin;
			}
		}
		
		return -1;
	}

	public ArrayList<Double> getCoins(double change){
		ArrayList<Double> out = new ArrayList<>();
		

		while(true){
			double largestCoin = largestCoinFits(change);
			if(largestCoin == -1) break;
			out.add(largestCoin);
			change -= largestCoin;
		}

		return out;
	}
}
