public class Cinema{

	Screen screens[];
	private String name;
	
	int screenCount = 0;
	
	Cinema(String name, int n){
		screens = new Screen[n];
		for(int i = 0; i < screens.length; i++)
			screens[i] = new Screen("Screen: " + (i+1));
		this.name = name;		
	}
	
	public void addScreen(String name, int[] rowlength){
			screens[screenCount++] = new Screen(name , rowlength);
	}
	
	public void findByName(String name){
		for(int i = 0; i < screens.length; i++){
			if(screens[i].getScreen().equals(name)){
				System.out.println("Yes Screen Found");
				return;
			} 
		}
		System.out.println("Screen Not Found!");
	}
	
	public void displayLayout(){
		for(int i = 0; i < screens.length; i++){
			System.out.println(screens[i].getScreen() + "|" + " Total Seats: " + screens[i].getTotalSeatCount() + "|" + " Available Seats: " + screens[i].getAvailableSeatCount());
		}
	}
	
	public String getCinemaName(){
		return name;
	}
	
	 public void displayVerbose() {
        System.out.println("Cinema: " + name);
        for (int i = 0; i < screens.length; i++) {
            System.out.println("  >> " + screens[i].getScreen());
            screens[i].displayVerbose();
        }
    	}
    	
    	public boolean booking(int screen_index, int row, int col){
    		
    		return screens[screen_index].bookSeat(row, col);
    	}
    	
    	//For Cancelling the booking
    	public boolean cancelBooking(int screen_index, int row, int col) {
    	
    		boolean result = screens[screen_index].cancelSeat(row, col);
    		if(result == true){
    			return true;
    		} else{
    			return false;
    		}
    	}
    	
    	

    	
    	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(name);
		
		for(int i = 0; i < screens.length; i++)
			str.append("\n====================SCREEN: "+(i+1)+"====================\n"+screens[i]);
			
		return str.toString();
	}
	


}