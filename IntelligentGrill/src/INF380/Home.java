package INF380;

import java.util.List;

public class Home {
	
	//
	private int p; //production
	private int c; //consommation totale
	private int cc; //consommation critique
	private int co; //consommation optionelle
	private int ap; //appropriation totale
	private int apc; //appropriation critique
	private int apo; //appropriation optionlle
	
	
	private double v; //ratio p/c
	private double sati;//satisfaction
	private List<Double> stf_list;  // list of satisfactions
	private double sati_l;// long term satisfaction
	
	
	public Home(){	
		
	}
	
	public void setP(int p) {
		this.p=p;
	}
	
	public void setC(int c) {
		this.c=c;
	}
	
	public void setCC(int cc) {
		this.cc=cc;
	}
	
	public void setCO(int co) {
		this.co=co;
	}
	
	public void setAP(int ap) {
		this.ap=ap;
	}
	
	public void setAPC(int apc) {
		this.apc=apc;
	}
	
	public void setAPO(int apo) {
		this.apo=apo;
	}
	
	public void setV() {
		v = p/c;
	} 
	
	public void setSATI(double stf) {
		this.sati = stf;
	}
	
	public void setSATI_l(double stf) {
		this.sati_l = stf;
	}
	
	public double getSati() {
		return sati;
	}
	
	public int getP() {
		return p;
	} 
	
	public int getC() {
		return c;
	} 
	
	public int getCC() {
		return cc;
	} 
	
	public int getCO() {
		return co;
	} 
	
	public int getAP() {
		return ap;
	}
	
	public int getAPC() {
		return apc;
	}
	
	public int getAPO() {
		return apo;
	}
	
	public double getV() {
		return v;
	} 
	
	public List<Double> getStf_list(){
		return stf_list;
	}
	

}
