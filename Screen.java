public class Screen{

	Seat seats[][] = new Seat[10][];
	SeatType type;
	double price;
	
		
	Screen(){
	
		
		for(int i = 0; i < seats.length; i++)
			seats[i] = new Seat[10+i];	
			
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(i < 2){
					type = SeatType.REGULAR;
					price = 500;
				} else if(i>=2 && i<=5){
					type = SeatType.PREMIUM;
					price = 750;
				} else if(i>5 && i<9){
					type = SeatType.VIP;
					price = 1000;
				} else if(i==9){
					type = SeatType.RECLINER;
					price = 1200;
				}
				seats[i][j] = new Seat(i, j, type, price, true);
				}
		}
	}
	
	
	public void findById(String id){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].id.equals(id)){
					System.out.println("Seat Of this id is found "+ seats[i][j]);
					return;
				}
			}
		}
		System.out.println("Not Found");
		
	}
	
	public void findByCoordinates(int row, int col){
	
		Seat seat = seats[row][col]; 
    		System.out.println("Seat found: " + seat);
		
	}
	
	public void booked(String id){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].id.equals(id)){
					if(seats[i][j].isAvailable == true){
						System.out.println("The seat you want is available and we book for you");
						seats[i][j].isAvailable = false;
						return;
					} else
						System.out.println("Seat already booked!");
						return;
				}
					
			}
		}
		System.out.println("Not found the seat of this id");
	}
	
	public void cancelSeat(String id){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].id.equals(id)){
					if(seats[i][j].isAvailable == false){
						System.out.println("The seat has been successfully canceled");
						seats[i][j].isAvailable = true;
						return;
					} else
						System.out.println("Seat is already not booked");
						return;
				}
			}
		}
		System.out.println("Not found the seat of this id");
	}
	
	public void countTotalSeats(){
		int totalSeatsCount = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				totalSeatsCount++;
			}	
		}
		System.out.println("Total Number of Seats Are: "+totalSeatsCount);
	}
	
	public void countAvailableSeats(){
	
		int totalAvailableCount = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].isAvailable == true)
					totalAvailableCount++;
			}	
		}
		System.out.println("Total Available Seats Are: "+totalAvailableCount);

	
	}
	
	public void countByType(){
		int regularCount = 0;
		int premiumCount = 0;
		int vipCount = 0;
		int reclinerCount = 0;
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].type == SeatType.REGULAR)
					regularCount++;
				else if(seats[i][j].type == SeatType.PREMIUM)
					premiumCount++;
				else if(seats[i][j].type == SeatType.VIP)
					vipCount++;
				else if(seats[i][j].type == SeatType.RECLINER)
					reclinerCount++;
			}
		}
		System.out.println("Total Regular Seats Are: "+regularCount);
		System.out.println("Total Premium Seats Are: "+premiumCount);
		System.out.println("Total VIP Seats Are: "+vipCount);
		System.out.println("Total Recliner Seats Are: "+reclinerCount);

	
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < seats.length; i++){
			str.append("\n");
			str.append("===Row: "+(i+1)+"===\n");
			for(int j = 0; j < seats[i].length; j++){
				str.append("Seat#: "+seats[i][j]);
			}
		}
		return str.toString();
	}

}