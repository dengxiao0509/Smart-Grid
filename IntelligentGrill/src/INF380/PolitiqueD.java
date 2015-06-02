package INF380;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public abstract class PolitiqueD {//politique de distribution
	List<Integer> p = new ArrayList<Integer>();
	/*List<Integer> ap = new ArrayList<Integer>();
	List<Integer> apc= new ArrayList<Integer>();
	List<Integer> apo= new ArrayList<Integer>();*/
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();  
	
	abstract void distribuer(List<Integer> p,District d);
	abstract List<Integer> getPT();
	abstract List<Integer> getAP();
	abstract List<Integer> getAPC();
	abstract List<Integer> getAPO();
	protected abstract Comparator<Integer> comparator();


}
