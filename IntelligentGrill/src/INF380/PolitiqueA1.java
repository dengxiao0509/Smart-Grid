package INF380;

public class PolitiqueA1 extends PolitiqueA{
	
	public PolitiqueA1(){
		
	}
	

	public void addP(District d){
		
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
	}
	
	public int getP(){
		return this.p;  
	
	}

}
