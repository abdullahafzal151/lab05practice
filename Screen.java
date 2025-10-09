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
	
	//Constructor for custom row lenght screens
	Screen(String screenName, int [] rowLength){
		this.screenName = screenName;
		
		seats = new Seat[rowLength.length][];
	
		for(int i = 0; i < seats.length; i++){
			seats[i] = new Seat[rowLength[i]];
			for(int j = 0; j < rowLength[i]; j++){
			
			if(i < 2){
				type = SeatType.REGULAR;
				price = 500;
			} else if(i >=2 && i <=5){
				type = SeatType.PREMIUM;
				price = 750;
			} else if(i > 5 && i < 9){
				type = SeatType.VIP;
				price = 1000;
			} else if(i == 9){
				type = SeatType.RECLINER;
				price = 1200;
			}
			
			seats[i][j] = new Seat(i, j, type, price, true);	
			
			}
		}
	
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
	public boolean bookSeat(int row, int col){
	
		if(seats[row][col].getIsavailable()){
			seats[row][col].setIsavailable(false);
			return true;
		} else{
			System.out.println("Seat Already Booked");
			return false;
		}
	
	
	}
	
	//Canceling the Seat
	public boolean cancelSeat(int row, int col) {
		boolean isAvailable = false;
    		for (int i = 0; i < seats.length; i++) {
        		for (int j = 0; j < seats[i].length; j++) {
            		if (seats[i][j] == seats[row][col]) {
                			if (!seats[i][j].getIsavailable()) {
                    			seats[i][j].setIsavailable(true);
                    			isAvailable = true;
                    			return isAvailable;
                    			//System.out.println("The seat has been successfully canceled");
               			 } else {
                    			//System.out.println("Seat is already not booked");
                    			return isAvailable; 
               			 }
          	  		}
       		 }
  	 	 }	
    		//System.out.println("Seat with this ID not found");
    		return isAvailable;
	}
	
	//Count Total Number Of Seats
	public int getTotalSeatCount(){
		int totalSeatsCount = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				totalSeatsCount++;
			}	
		}
		return totalSeatsCount;
	}
	
	//Count total Available Seats	
	public int getAvailableSeatCount(){
	
		int totalAvailableCount = 0;
		
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				if(seats[i][j].getIsavailable() == true)
					totalAvailableCount++;
			}	
		}
		return totalAvailableCount;

	
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
	
	public void displayLayout(){
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				System.out.print(" [" + seats[i][j].getId() + ":" + seats[i][j].getIsavailable() + "]");
			
			}
			System.out.println();
			System.out.println();
		
		}
	
	}
	
	public void displayVerbose() {
        System.out.println("  Screen: " + screenName);
        for (int i = 0; i < seats.length; i++) {
            System.out.print("   Row " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }	

	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < seats.length; i++){
			str.append("\n");
			//str.append("===Row: "+(i+1)+"===\n");
			for(int j = 0; j < seats[i].length; j++){
				//str.append("Seat#: "+seats[i][j]);
				str.append(seats[i][j]);

			}
		}
		return str.toString();
	}

}