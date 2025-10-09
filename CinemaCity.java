public class CinemaCity{

	Cinema cinemas[] = new Cinema[3];
	String cityName;
	
	CinemaCity(String cityName){
		for(int i = 0; i < cinemas.length; i++)
			cinemas[i] = new Cinema("=== Cinema "+(i+1)+" === ", 5);
			
		this.cityName = cityName;
	}
	
	
	public void displayLayout(){
		for(int i = 0; i < cinemas.length; i++){
			System.out.println("\n"+cinemas[i].getCinemaName()+"Layout=== ");
			cinemas[i].displayLayout();
		}
	}
	
	public void displayVerbose() {
        System.out.println("=== CITY: " + cityName + " ===");
        for (int i = 0; i < cinemas.length; i++) {
            System.out.println("\n--- Cinema " + (i + 1) + " ---");
            cinemas[i].displayVerbose();
        }
    }
    
    	public void findScreenInCity(String screenName){
    		for(int i = 0; i < cinemas.length; i++){
    			System.out.println("Searching in: "+ cinemas[i].getCinemaName());
    			cinemas[i].findByName(screenName);
    		}
    
    	}
    	
    	
    	public void booking(int cinema_index, int screen_index, int row, int col){
    		
    		boolean result = cinemas[cinema_index].booking(screen_index, row, col);
    		if(result == true){
    			System.out.println("Seat Booked Successfully");
    		} else {
    			System.out.println("Cannot Find That Seat");
    		}
    	}
    	
    	public void cancelBooking(int cinema_index, int screen_index, int row, int col) {
    	
    		boolean result = cinemas[cinema_index].cancelBooking(screen_index,row, col);
    		if(result == true){
    			System.out.println("Seat Of this Screen Of that Cinema is Cancelled Successfully");
    		} else{
    			System.out.println("Cannot find that seat");
    		}
    	
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