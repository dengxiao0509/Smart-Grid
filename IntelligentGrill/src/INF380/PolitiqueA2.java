package INF380;

import java.util.ArrayList;
import java.util.List;

public class PolitiqueA2 extends PolitiqueA{
	
    public PolitiqueA2(){
		
	}
    
    /*public void addP(District d){
		for(int i = 0;i<d.getHome().size();i++){
			this.p = this.p + d.getHome().get(i).getP();
			d.getHome().get(i).setAP(0);
			d.getHome().get(i).setAPC(0);
			d.getHome().get(i).setAPO(0);
		}	
    }*/

	@Override
	public List<Integer> getP(List<Integer> p, List<Integer> c) {
		List<Integer> stock = new ArrayList<Integer>();
		for(Integer item : p){
			//ap.add(0);
			stock.add(item);
		}
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public void haha() {
		// TODO Auto-generated method stub
		System.out.println("2");
	}

	@Override
	public List<Integer> setAP(List<Integer> p, List<Integer> c) {
		// TODO Auto-generated method stub
		List<Integer> apt = new ArrayList<Integer>();
		for(int i=0;i<p.size();i++){
			apt.add(1);
		}
		for(int i=0;i<p.size();i++){
			apt.set(i,0);
		}
		
		return apt;
	}
	

}