package INF380;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class PolitiqueD1 extends PolitiqueD{
	
	int pTotal;
	List<Integer>c_o;
	List<Integer>c_c;
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();  
	//Map<Integer,Integer> mapco=new HashMap<>();  
	public PolitiqueD1(){
		
		
	}
	
	protected Comparator<Integer> comparator(){
		return new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				if(map.get(arg0)>map.get(arg1)){
					return -1;
				}
				else if(map.get(arg0)<map.get(arg1)){
					return 1;
				}
				else{
					return 0;
					//return arg0.compareTo(arg1);
				}
			}
			
		};
		
	}
	
	 //@SuppressWarnings("unchecked")
	private static HashMap<Integer,Integer> sortByValues(HashMap<Integer,Integer> map) { 
		List<Entry<Integer,Integer>> list = new LinkedList<Entry<Integer,Integer>>(map.entrySet());

	       // Defined Custom Comparator here
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return (o1.getValue() - o2.getValue());
			}
		});

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap<Integer,Integer> sortedHashMap = new LinkedHashMap<Integer,Integer>();
	       for (Iterator<Entry<Integer,Integer>> it = list.iterator(); it.hasNext();) {
	              Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) it.next();
	              sortedHashMap.put(Integer.parseInt(entry.getKey().toString()), Integer.parseInt(entry.getValue().toString()));
	       } 
	       return sortedHashMap;
	  }
	
	
	
	
	public void distribuer(int pTotal,District d){
		this.pTotal = pTotal;
		
		//Collections.sort(c_c);
		//Collections.sort(c_o);
		int n = d.getHome().size();
		for(int i=0;i<n;i++){
			c_c.set(i, (d.getHome().get(i).getCC()-d.getHome().get(i).getAPC()));
			map.put(i, (d.getHome().get(i).getCC()-d.getHome().get(i).getAPC()));
		}
		Map<Integer, Integer> maps = sortByValues(map); 

		
		
		for(int i:maps.keySet()){
			if(this.pTotal>=maps.get(i)){
				this.pTotal = this.pTotal - maps.get(i);
				maps.replace(i, 0);
				
			}
			else if(maps.get(i)>this.pTotal&&this.pTotal>=0){
				
				maps.replace(i, maps.get(i)-this.pTotal);
				this.pTotal = 0;
				
				//c_c.set(i, c_c.get(i)-pTotal);
			}
			else{
				break;
			}
		}
		
		for(int i=0;i<n;i++){
			c_c.set(i, maps.get(i));
			d.getHome().get(i).setAPC((d.getHome().get(i).getCC()-maps.get(i)));
		}
		
		
		
		
		
		
		map.clear();
		for(int i=0;i<n;i++){
			map.put(i,(d.getHome().get(i).getCO()-d.getHome().get(i).getAPO()));
		}
		Map<Integer, Integer> maps1 = sortByValues(map); 

		
		
		for(int i:maps1.keySet()){
			if(this.pTotal>=maps1.get(i)){
				this.pTotal = this.pTotal - maps1.get(i);
				maps1.replace(i, 0);
				
			}
			else if(maps1.get(i)>this.pTotal&&this.pTotal>=0){
				maps1.replace(i, maps1.get(i)-this.pTotal);
				this.pTotal = 0;
				//c_c.set(i, c_c.get(i)-pTotal);
			}
			else{
				break;
			}
		}
		for(int i=0;i<n;i++){
			c_o.set(i, maps1.get(i));
			d.getHome().get(i).setAPO((d.getHome().get(i).getCO()-maps1.get(i)));
		}
		
		
		/*for(int i=0;i<n;i++){
			if(pTotal>=c_o.get(i)){
				c_o.set(i, 0);
				pTotal = pTotal - c_o.get(i);
			}
			else if(c_o.get(i)>pTotal&&pTotal>=0){
				c_o.set(i, c_o.get(i)-pTotal);
			}
			else{
				break;
			}
		}*/
		
	}
	
	public int getPT(){
		return pTotal;
	}
	public List<Integer> getCC(){
		return c_c;
	}
	public List<Integer> getCO(){
		return c_o;
	}
	
	

}
