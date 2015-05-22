package INF380;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Home {
	
	private List<Integer> p = new ArrayList<Integer>(); //production
	private List<Integer> c = new ArrayList<Integer>(); //consommation totale
	private List<Integer> cc = new ArrayList<Integer>(); //consommation critique
	private List<Integer> co = new ArrayList<Integer>(); //consommation optionelle
	private List<Integer> ap = new ArrayList<Integer>(); //appropriation totale
	private List<Integer> apc = new ArrayList<Integer>(); //appropriation critique
	private List<Integer> apo = new ArrayList<Integer>(); //appropriation optionlle
	
	
	private List<Double> v = new ArrayList<Double>(); //ratio p/c
	private List<Double> stf_list = new ArrayList<Double>();  // list of satisfactions
	private double sati_l;// long term satisfaction
	
	private PolitiqueA poli;
	
	public PolitiqueA getPoli(){
		return poli;
	}
	
	Properties prop = new Properties();
	
	String flag;
	
	int flag1=0;
	
	public Home() throws IOException{	
		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		prop.load(fis);
        fis.close();
        flag=prop.getProperty("flag");
        
        flag1=Integer.parseInt(flag);
        
        //System.out.println(flag1);
        
        if(flag1==1){
        	poli = new PolitiqueA1();
        	//System.out.println("1");
        	//flag1=0;
        }
        	
        if(flag1==2){
        	poli = new PolitiqueA2();  
        	//System.out.println("2");
        }
        
        //System.out.println(flag1);
        	 
	}
	
	public List<Integer> getStockplus(){
		List<Integer> stockplus = new ArrayList<Integer>();
		stockplus = poli.getP(this.p,this.c);
		return stockplus;
	}
	
	public void setP(List<Integer> p) {
		this.p=p;
	}
	
	public void setC(List<Integer> c) {
		this.c=c;
	}
	
	public void setCC(List<Integer> cc) {
		this.cc=cc;
	}
	
	public void setCO(List<Integer> co) {
		this.co=co;
	}
	
	public void setAP(List<Integer> ap) {
		this.ap=ap;
	}
	
	public void setAPC(List<Integer> apc) {
		this.apc=apc;
	}
	
	public void setAPO(List<Integer> apo) {
		this.apo=apo;
	}
	
	public void setV() {
		double p1;
		double c1;
		for(int i= 0; i<p.size();i++){
			p1=p.get(i).doubleValue();
			c1=c.get(i).doubleValue();
			v.set(i, p1/c1);
		}
		
	} 
	
	public void setSati_l(double sati_l){
		this.sati_l=sati_l;
	}
	
	public void setSATI_l(double stf) {
		this.sati_l = stf;
	}
	
	
	public List<Integer> getP() {
		return p;
	} 
	
	public List<Integer> getC() {
		return c;
	} 
	
	public List<Integer> getCC() {
		return cc;
	} 
	
	public List<Integer> getCO() {
		return co;
	} 
	
	public List<Integer> getAP() {
		return ap;
	}
	
	public List<Integer> getAPC() {
		return apc;
	}
	
	public List<Integer> getAPO() {
		return apo;
	}
	
	public List<Double> getV() {
		return v;
	} 
	
	public List<Double> getStf_list(){
		return stf_list;
	}
	
	public double getSati_l(){
		return sati_l;
	}
	

}