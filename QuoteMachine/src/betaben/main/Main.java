package betaben.main;

import java.util.ArrayList;

public class Main {

	public static ArrayList<Quote> quotes = new ArrayList<Quote>();
	
	public static void main(String[] args) {
		
		quotes.add(new Quote("If a man does his best, what else is there?", "General George S. Patton"));

		for(Quote q : quotes){
			System.out.println(q.getQuote());
			System.out.println(" - " + q.getQuotee());
		}
		
	}

}
