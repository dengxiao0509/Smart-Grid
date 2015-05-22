package INF380;

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

	
	public int getP(){
		return this.p;  
	}

	@Override
	public List<Integer> getP(List<Integer> p, List<Integer> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void haha() {
		// TODO Auto-generated method stub
		System.out.println("2");
	}
	

}
