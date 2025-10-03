public class Cinema{

	Screen screens[];
	String name;
	
	Cinema(String name, int n){
		screens = new Screen[n];
		for(int i = 0; i < screens.length; i++)
			screens[i] = new Screen();
		this.name = name;		
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