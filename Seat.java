public class Seat{

	private String id;
	SeatType type;
	double price;
	boolean isAvailable;
	
	int rows;
	int cols;
	
		
	Seat(int rows, int cols, SeatType type, double price, boolean isAvailable){
	
		this.rows = rows;
		this.cols = cols;
		id = String.format("%d-%03d", rows, cols);
		this.type = type;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getCols(){
		return cols;
	}
	
	public SeatType getSeatType(){
		return type;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	
	@Override
	public String toString(){
		return String.format("%s %s %.2f %b \n",id,type,price,isAvailable);
	
	}
	
	@Override
	public boolean equals(Object o){
		Seat seat = (Seat) o;
		return rows == seat.rows && cols == seat.cols;
		
	}

}