package INF380;

import java.util.ArrayList;
import java.util.List;

public class PolitiqueA1 extends PolitiqueA{
	
	public PolitiqueA1(){
		
	}
	

	/*public void addP(District d){
		
		for(int i = 0;i<d.getHome().size();i++){
			
			if((d.getHome().get(i).getP()-d.getHome().get(i).getC())>0){
				this.p = this.p + d.getHome().get(i).getP()-d.getHome().get(i).getC();
				d.getHome().get(i).setAP(d.getHome().get(i).getC());
				d.getHome().get(i).setAPC(d.getHome().get(i).getCC());
				d.getHome().get(i).setAPO(d.getHome().get(i).getCO());
			}
			else if(d.getHome().get(i).getP()<d.getHome().get(i).getC() && d.getHome().get(i).getCC()<d.getHome().get(i).getP()){
				d.getHome().get(i).setAP(d.getHome().get(i).getP());
				d.getHome().get(i).setAPC(d.getHome().get(i).getCC());
				d.getHome().get(i).setAPO(d.getHome().get(i).getP()-d.getHome().get(i).getCC());
			}
			else if(d.getHome().get(i).getP()<d.getHome().get(i).getCC()){
				d.getHome().get(i).setAP(d.getHome().get(i).getP());
				d.getHome().get(i).setAPC(d.getHome().get(i).getP());
				d.getHome().get(i).setAPO(0);
			}
		}
	}*/


	@Override
	public List<Integer> getP(List<Integer> p, List<Integer> c) {
		// TODO Auto-generated method stub
		int stockplus = 0;
		List<Integer> stock = new ArrayList<Integer>();
		for(int i=0;i<p.size();i++){
			if(p.get(i)>c.get(i)){
				stockplus = p.get(i)-c.get(i);
			}
			else if(p.get(i)<=c.get(i)){
				stockplus = 0;
			}
			stock.add(stockplus);
		}
		
		
		return stock;
	}


	@Override
	public void haha() {
		// TODO Auto-generated method stub
		System.out.println("1");
	}


	@Override
	public List<Integer> setAP(List<Integer> p, List<Integer> c) {
		// TODO Auto-generated method stub
		List<Integer> apt = new ArrayList<Integer>();
		int apti  = 0;
		for(int i=0;i<p.size();i++){
			if(p.get(i)>c.get(i)){
				apti = c.get(i);
			}
			else if(p.get(i)<c.get(i)){
				apti = p.get(i);
			}
			apt.add(i,apti);
		}
		return apt;
	}

}