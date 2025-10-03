public class CinemaCity{

	Cinema cinemas[] = new Cinema[3];
	String cityName;
	
	CinemaCity(String cityName){
		for(int i = 0; i < cinemas.length; i++)
			cinemas[i] = new Cinema("Cinema "+i, 5);
			
		this.cityName = cityName;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(cityName);
		
		for(int i = 0; i < cinemas.length; i++)
			str.append("\n "+cinemas[i]);
			
		return str.toString();
	}
	



}