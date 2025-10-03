public class ScreenDemo{
	public static void main(String[] args){
		Screen screen = new Screen();
		
		screen.findById("8-007");
		screen.findByCoordinates(2,4);
		screen.booked("8-007");
		screen.cancelSeat("8-007");
		
		System.out.println("===Total Seats Are====");
		screen.countTotalSeats();
		
		System.out.println();
		System.out.println("===Total Available Seats Are====");
		
		screen.countAvailableSeats();
		
		System.out.println();
		System.out.println("===Count By Type===");
		screen.countByType();

	
	}


}