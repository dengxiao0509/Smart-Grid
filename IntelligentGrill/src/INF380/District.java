package INF380;

import java.util.ArrayList;
import java.util.List;

public class District {
	
	double sati;//satisfaction of the district
	
	List<Home> home = new ArrayList<Home>();
	
	int p;//production
	
	public District(){	
	}
	
	public void setSATI() {
	}
	
	public void addHome(Home h){
		home.add(h);
	}
	
	public List<Home> getHome(){
		return  home;
	}
	public double getSATI(){
		return sati;
	}
	
	public void setP(int p){
		this.p=p;
	}
	

}
