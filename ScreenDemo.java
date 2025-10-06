public class ScreenDemo{
	public static void main(String[] args){
		Screen screen = new Screen("Screen 01");
		
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
		
		System.out.println(screen.getScreen());
		
		System.out.println(screen.getSeat("8-007"));
		
		screen.setRowType(1, SeatType.PREMIUM, 750);
		//System.out.println(screen.toString());
		
		
		System.out.println("=====Checking Get Seat By Row And Col");
		System.out.println(screen.getSeat(2, 5));
		System.out.println("The type of seat you want at first 1st priority is: \n"+ screen.findFirstAvailable(SeatType.PREMIUM));
		
		System.out.println("======CHECKING LIST AVAILABLE METHOD");
		Seat result[] = screen.listAvailable(SeatType.PREMIUM);
		for (int i = 0; i < result.length; i++) {
    			System.out.println(result[i]);
			}

	
	}


}