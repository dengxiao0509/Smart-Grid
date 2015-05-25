package INF380;

import java.util.ArrayList;
import java.util.List;

public abstract class PolitiqueA { // politique de production
	
	List<Integer> stock = new ArrayList<Integer>();
	

	//abstract public void addP(District d);
	abstract public List<Integer> getP(List<Integer> p, List<Integer> c);
	abstract public List<Integer> setAP(List<Integer> p, List<Integer> c);
	abstract public void haha();//for debug



}