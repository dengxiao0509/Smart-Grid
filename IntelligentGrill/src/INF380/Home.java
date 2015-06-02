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
	private List<Integer> apo = new ArrayList<Integer>(); //appropriation optionelle

	private List<Double> v= new ArrayList<Double>(); // ration p/v

	private List<Integer> p_app_dif= new ArrayList<Integer>(); // p - app


	private List<Double> stf_list = new ArrayList<Double>();  // list of short terme satisfactions in different periods

	//DENG XIAO
	//private double sati_l;// long term satisfaction
	private double stf_lt_v;  // long term satisfaction, variance
	private double stf_lt_m;  // long term satisfaction, mean
	//DENG XIAO

	private PolitiqueA poli;

	public PolitiqueA getPoli(){
		return poli;
	}
	Properties prop = new Properties();

	String flag;

	int flag1=0;


	///////////////////////////////////////////////////////////
	////////////////////// DENG XIAO //////////////////////////
	///////////////////////////////////////////////////////////

	/*calculate the short term satisfaction of one home in different periods,
	 * results are stored in the list "stf_list"
	 * 
	 */

	public void stf_st(double x,double y,double a, double b,double c,double d){

		double stf=0;
		double m=0;
		double k;

		//number of periods
		int per_num= this.p.size();

		for(int i=0;i< per_num;i++){

			//get the data of this home in the ist period
			double pi = p.get(i);
			double api = ap.get(i);
			double apci =apc.get(i);
			double apoi =apo.get(i);
			double cci = cc.get(i);
			double coi = co.get(i);
			double p_appi=p_app_dif.get(i);


			m= x*(apci/cci) + y*(apoi/coi); 

			// all demand is satisfied 
			if(m==1){

				if(pi>api)    k=a*(p_appi)/pi;
				else  k=b*(p_appi)/api;

				stf=1+k;
			}

			else{   //m<1

				if(api<pi)	{

					double give_sum=0;
					double my_p_sum=0;

					if(i==0) k=0;

					else if(i==1) {
						give_sum += p_appi+ p_app_dif.get(0);
						// I give some electricity to others before and now
						if(give_sum>0){
							my_p_sum += pi+p.get(0);
							k=-c*(give_sum/my_p_sum);
						}
						// I receive some electricity from others before and now
						else k=0;
					}
					else{

						//calculate sum(p_i-app_i) ,  including 2 periods before and this period
						give_sum+= p_appi+p_app_dif.get(i-1)+p_app_dif.get(i-2);
						// I give some electricity to others before and now
						if(give_sum>0){
							my_p_sum+= pi+p.get(i-1)+p.get(i-2);
							k=-c*(give_sum/my_p_sum);
						}
						// I receive some electricity from others before and now
						else k=0;
					}
			

					stf=m*(api/pi)+k;
				}


				else  {
					double sumBefore=0;
					if(i==0) k=0;
					else if(i==1) {
						sumBefore=p_app_dif.get(0);
						k=-d*(sumBefore-(api-pi))/sumBefore;
					}
				
					else{
						sumBefore=p_app_dif.get(i-1)+p_app_dif.get(i-2);
						k=-d*(sumBefore-(api-pi))/sumBefore;
					}
					
					stf=m+k;             
				}
			}
			this.stf_list.add(stf);

		}
	}

	/*calculate the long term satisfaction of one home, 
	 * including the mean and the variance( Gini coefficient) 
	 * 
	 * the results are stored in "stf_lt_v" and "stf_lt_m"
	 */

	public void stf_lt(){

		// the mean 
		stf_lt_m=Satisfaction.calcul_mean(stf_list);

		// the variance (Gini index) 
		stf_lt_v=Satisfaction.calcul_gini(stf_list);

	}
	///////////////////////////////////////////////////////////
	////////////////////// DENG XIAO //////////////////////////
	///////////////////////////////////////////////////////////





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
		ap = poli.setAP(this.p, this.c);
		return stockplus;
	}


	//DENG
	public void setP(List<Integer> p) {
		for(Integer item: p) this.p.add(item);
	}

	public void setC(List<Integer> c) {
		for(Integer item: c) this.c.add(item);
	}

	public void setCC(List<Integer> cc) {
		for(Integer item: cc) this.cc.add(item);
	}

	public void setCO(List<Integer> co) {
		for(Integer item: co) this.co.add(item);
	}

	public void setAP(List<Integer> ap) {
		for(Integer item: ap) this.ap.add(item);
	}
	public void setAP(int i,int api) {
		this.ap.set(i, api);
	}
	public void setAPC(List<Integer> apc) {
		for(Integer item: apc) this.apc.add(item);
	}
	public void setAPC(int i,int apci) {
		this.apc.set(i,apci);
	}
	public void setAPO(List<Integer> apo) {
		for(Integer item: apo) this.apo.add(item);
	}
	public void setAPO(int i,int apoi) {
		this.apo.set(i,apoi);
	}
	public void setP_app_dif( List<Integer> l){
		for(Integer item: l) this.p_app_dif.add(item);
	}

	//DENG




	public void setV() {
		double p1;
		double c1;
		for(int i= 0; i<p.size();i++){
			p1=p.get(i).doubleValue();
			c1=c.get(i).doubleValue();
			v.set(i, p1/c1);
		}

	} 

	//DENG 
	/*
		public void setSati_l(double sati_l){
			this.sati_l=sati_l;
		}
	 */
	public double getStf_lt_v(){
		return this.stf_lt_v;
	}

	public double getStf_lt_m(){
		return this.stf_lt_m;
	}


	//DENG 

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

	public List<Integer> getP_app_dif(){
		return this.p_app_dif;
	}

	//DENG 
	/*
		public double getSati_l(){
			return sati_l;
		}
	 */




}