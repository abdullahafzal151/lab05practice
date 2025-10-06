public class Screen{

	Seat seats[][] = new Seat[10][];
	SeatType type;
	double price;
	String screenName;
		
	//Constructor For Only ScreenName
	Screen(String screenName){
		this();
		this.screenName = screenName;
	}
		
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
	
	//Finding Seat By Its Id
	public void findById(String id){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getId().equals(id)){
					System.out.println("Seat Of this id is found "+ seats[i][j]);
					return;
				}
			}
		}
		System.out.println("Not Found");
		
	}
	//Finding Seat By Its Coordinates
	public void findByCoordinates(int row, int col){
	
		Seat seat = seats[row][col]; 
    		System.out.println("Seat found: " + seat);
		
	}
	
	//Booked the Seat
	public void booked(String id){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getId().equals(id)){
					if(seats[i][j].getIsavailable() == true){
						System.out.println("The seat you want is available and we book for you");
						seats[i][j].setIsavailable(false);
						return;
					} else
						System.out.println("Seat already booked!");
						return;
				}
					
			}
		}
		System.out.println("Not found the seat of this id");
	}
	
	//Canceling the Seat
	public void cancelSeat(String id){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getId().equals(id)){
					if(seats[i][j].getIsavailable() == false){
						System.out.println("The seat has been successfully canceled");
						seats[i][j].setIsavailable(true);
						return;
					} else{
						System.out.println("Seat is already not booked");
						return;
						}
				}
			}
		}
		System.out.println("Not found the seat of this id");
	}
	
	//Count Total Number Of Seats
	public void countTotalSeats(){
		int totalSeatsCount = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				totalSeatsCount++;
			}	
		}
		System.out.println("Total Number of Seats Are: "+totalSeatsCount);
	}
	
	//Count total Available Seats	
	public void countAvailableSeats(){
	
		int totalAvailableCount = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getIsavailable() == true)
					totalAvailableCount++;
			}	
		}
		System.out.println("Total Available Seats Are: "+totalAvailableCount);

	
	}
	
	//Count Seats By their Types
	public void countByType(){
		int regularCount = 0;
		int premiumCount = 0;
		int vipCount = 0;
		int reclinerCount = 0;
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getSeatType() == SeatType.REGULAR)
					regularCount++;
				else if(seats[i][j].getSeatType() == SeatType.PREMIUM)
					premiumCount++;
				else if(seats[i][j].getSeatType() == SeatType.VIP)
					vipCount++;
				else if(seats[i][j].getSeatType() == SeatType.RECLINER)
					reclinerCount++;
			}
		}
		System.out.println("Total Regular Seats Are: "+regularCount);
		System.out.println("Total Premium Seats Are: "+premiumCount);
		System.out.println("Total VIP Seats Are: "+vipCount);
		System.out.println("Total Recliner Seats Are: "+reclinerCount);

	
	}
	
		
	//Returning a Single Screen
	public String getScreen(){
		return screenName;
	}
	
	public Seat getSeat(String id){
	
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getId().equals(id)){
					return seats[i][j];
					}
				}
			}
			return null;
		
	}
	
	//Returning a Single Seat
	public Seat getSeat(int row, int col){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getRows() == row && seats[i][j].getCols() == col){
					return seats[i][j];
				}
			}
		}
		
		return null;
	}
	
	//Changing The Entire Row
	public void setRowType(int row, SeatType type, double price){
		for(int j = 0; j < seats[row].length; j++){
			seats[row][j].setSeatType(type);
        		seats[row][j].setPrice(price);
		}
	
	}
	
	//Finding First Available Seat
	public Seat findFirstAvailable(SeatType type){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getSeatType() == type){
					return seats[i][j];
				}
			}
		}
		return null;
	}
	
	//Returning an Array of the specific Type 
	public Seat[] listAvailable(SeatType type){
		int count = 0;	
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getSeatType() == type){
					count++;
				}	
			}
		}
		
		Seat availableSeats[] = new Seat[count];
		int index = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getSeatType() == type){
					availableSeats[index] = seats[i][j];
					index++;
				}
			}
		
		}
		return availableSeats;
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