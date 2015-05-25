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
import java.util.Set;


public class PolitiqueD1 extends PolitiqueD{
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
				return (o2.getValue() - o1.getValue());
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
	
	
	
	
	public void distribuer(List<Integer> p,District d){
		this.p = p;
		
		int n = d.getHome().get(0).getP().size();
		int nn = d.getHome().size();
		
		//distribuer the ap if there is any
		for(int j=0;j<n;j++){
			for(int i=0;i<nn;i++){
				if(d.getHome().get(i).getAP().get(j)>=d.getHome().get(i).getCC().get(j)){
					d.getHome().get(i).setAPC(j, d.getHome().get(i).getCC().get(j));
					d.getHome().get(i).setAPO(j, (d.getHome().get(i).getAP().get(j)-d.getHome().get(i).getCC().get(j)));
				}
				else{
					d.getHome().get(i).setAPC(j, d.getHome().get(i).getAP().get(j));
					d.getHome().get(i).setAPO(j, 0);
				}
				//System.out.println("          "+d.getHome().get(i).getAPO().get(j));
			}
			
		}
		
		
		
		for(int j=0;j<n;j++){
			
			
			//first distribuer the cc
			//the one who need the ressources most will first get them, if equals, who produce most can get first.
			for(int i=0;i<nn;i++){
				map.put(i, (d.getHome().get(i).getCC().get(j)-d.getHome().get(i).getAPC().get(j)));
			}
			for(int i:map.keySet()){
				if(d.getHome().get(i).getP().get(j) !=0){
					map.put(i, map.get(i)*d.getHome().get(i).getP().get(j));
				}
			}
			Map<Integer, Integer> maps1 = sortByValues(map); 
			for(int i:maps1.keySet()){
				if(d.getHome().get(i).getP().get(j) !=0){
					maps1.put(i, maps1.get(i)/d.getHome().get(i).getP().get(j));
				}
			}
	
			for(int i:maps1.keySet()){
				if(this.p.get(j)>=maps1.get(i)){
					this.p.set(j, this.p.get(j) - maps1.get(i));
					maps1.replace(i, 0);					
				}
				else if(maps1.get(i)>this.p.get(j)){					
					maps1.replace(i, maps1.get(i)-this.p.get(j));
					this.p.set(j, 0);
				}
				else if(this.p.get(j)==0){
					break;
				}
			}
			
			for(int i=0;i<nn;i++){
				d.getHome().get(i).setAPC(j,(d.getHome().get(i).getCC().get(j)-maps1.get(i)));
			}
			
			
			
			
			
			//then distribuer the co
			//the one who need the ressources most will first get them, if equals, who produce most can get first.
			map.clear();
			for(int i=0;i<nn;i++){
				map.put(i,(d.getHome().get(i).getCO().get(j)-d.getHome().get(i).getAPO().get(j)));
			}
			for(int i:map.keySet()){
				if(d.getHome().get(i).getP().get(j) !=0){
					map.put(i, map.get(i)*d.getHome().get(i).getP().get(j));
				}
			}
			Map<Integer, Integer> maps2 = sortByValues(map); 
			for(int i:maps2.keySet()){
				if(d.getHome().get(i).getP().get(j) !=0){
					maps2.put(i, maps2.get(i)/d.getHome().get(i).getP().get(j));
				}
			}
				
			for(int i:maps2.keySet()){
				if(this.p.get(j)>=maps2.get(i)){
					this.p.set(j, this.p.get(j) - maps2.get(i));
					maps2.replace(i, 0);
					
				}
				else if(maps2.get(i)>this.p.get(j)){
					maps2.replace(i, maps2.get(i)-this.p.get(j));
					this.p.set(j, 0);
				}
				else if(this.p.get(j)==0){
					break;
				}
			}

			for(int i=0;i<nn;i++){
				d.getHome().get(i).setAPO(j,(d.getHome().get(i).getCO().get(j)-maps2.get(i)));
			}
			
			
			//calculate the ap by the cc and co
			for(int i=0;i<nn;i++){
				d.getHome().get(i).setAP(j,(d.getHome().get(i).getAPC().get(j)+d.getHome().get(i).getAPO().get(j)));
			}
			maps1.clear();
			maps2.clear();
			map.clear();
		}
		
	}
	
	public List<Integer> getPT(){
		return p;
	}
	public List<Integer> getAP(){
		return null;
	}
	public List<Integer> getAPC(){
		return null;
	}
	public List<Integer> getAPO(){
		return null;
	}
	

}
