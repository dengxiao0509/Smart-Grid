package INF380;

import java.util.ArrayList;
import java.util.List;

public class District {
	
	private List<Double> stf_list = new ArrayList<Double>();  // list of satisfactions
	private double sati_l;// long term satisfaction
	
	private List<Home> home = new ArrayList<Home>();
	
	private List<Integer> p = new ArrayList<Integer>();//production totale
	
	public District(){	
	}
	
	public void setSati_short() {
		//TO DO
	}
	
	public void setSati_l(){
		//TO DO
	}
	
	public void addHome(Home h){
		home.add(h);
	}
	
	public List<Home> getHome(){
		return  home;
	}
	
	public List<Double> getSati_short(){
		return stf_list;
	}
	
	public double getSati_l(){
		return sati_l;
	}
	
	public void addP(List<Integer> p){
		int p1 = 0;
		for(int i=0;i<p.size();i++){
			p1 = this.p.get(i)+p.get(i);
			this.p.set(i,p1);
		}
	}
	

}
