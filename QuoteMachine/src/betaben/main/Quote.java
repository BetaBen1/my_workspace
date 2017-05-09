package betaben.main;

public class Quote {

	private String quote;
	private String quotee;
	
	public Quote(String quote, String quotee){
		this.quote = quote;
		this.quotee = quotee;
	}
	
	public String getQuote(){
		return quote;
	}
	
	public String getQuotee(){
		return quotee;
	}
	
}
