package INF380;

import java.util.ArrayList;
import java.util.List;

public class District {

	//DENG 
	
	//short term satisfactions of the district
	
	// list: ist element is the mean of satisfactions of all the homes in ist period 
	private List<Double> stf_m_list = new ArrayList<Double>();  
    // Idem, but this is variance  
	private List<Double> stf_v_list = new ArrayList<Double>(); 
	
	private double stf_m_lt;// long term satisfaction of the diatrict (mean)
	private double stf_v_lt;// (variance)
	//DENG

	private List<Home> home = new ArrayList<Home>();

	private List<Integer> p = new ArrayList<Integer>();//production totale

	public District(){	
	}

	//DENG 
	/*calculate the short term satisfactions of the whole district in different periods
	 * 
	 * results are stored in stf_list
	 */
	public void stf_dis_st() {

		//list used to store all the homes' satisfactions in one period,size is equal to the number of homes
		List<Double> home_stf = new ArrayList<Double>();

		//number of periods
		int per_num=p.size();

		
		for(int i=0;i<per_num;i++){
			home_stf.clear();
			
			//calculate the satisfaction of district in  period  i 
			for(Home h:home){
				home_stf.add(h.getStf_list().get(i));
			}
			
			System.out.println("we have "+home_stf.size()+ " homes in this district");
			
			stf_m_list.add(Satisfaction.calcul_mean(home_stf));
			stf_v_list.add(Satisfaction.calcul_gini(home_stf));
		}
	}

	//calculate the long term satisfaction of the whole district
	public void stf_dis_lt(){
		
		
		//size is the same as number of homes
		List<Double> stf_homes_mean = new ArrayList<Double>();
		
		for(Home h:home){
			stf_homes_mean.add(h.getStf_lt_m());
		}
			
		
		stf_m_lt = Satisfaction.calcul_mean(stf_homes_mean);
		stf_v_lt = Satisfaction.calcul_gini(stf_homes_mean);
	}
	//DENG


	public void addHome(Home h){
		home.add(h);
	}

	public List<Home> getHome(){
		return  home;
	}

	//DENG
	public List<Double> getStf_m_list(){
		return stf_m_list;
	}
	
	public List<Double> getStf_v_list(){
		return stf_v_list;
	}


	public double getStf_m_lt(){
		return stf_m_lt;
	}
	
	public double getStf_v_lt(){
		return stf_v_lt;
	}
	//DENG
	
	
	public void addP(List<Integer> p){
		int p1 = 0;
		for(int i=0;i<p.size();i++){
			p1 = this.p.get(i)+p.get(i);
			this.p.set(i,p1);
		}
	}


}
