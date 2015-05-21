package INF380;

import java.util.List;

public class Satisfaction {

// m stands for the contribution of the ratio of demand and appropriate   

private double r_c=0;
private double r_o=0;


public Satisfaction(double ratio_c,double ratio_o){	
	//System.out.println("hello");
	r_c=ratio_c;
	r_o=ratio_o;
}

/*calculate the short term satisfaction of one home
 * 
 * input is one class home to be calculated
 * after execution, one satisfaction will be added to its list of satisfaction
 */
public void calcul_st(Home home){
	
	double stf=0;
	double m=0;
	int app=home.getAP();
	int apc=home.getAPC();
	int apo=home.getAPO();
	int cc = home.getCC();
	int co = home.getCO();
	int p = home.getP();
	
	m= r_c*(apc/cc)+r_o*(apo/co); 
	
	// all demand is satisfied 
	if(m==1){
		stf=1;
	}
	else{
		if(app<p)	stf=m*(app/p);
		else  stf=m;              // if app > production, no complain
	}
	home.getStf_list().add(stf);
	//home.setSATI(stf);
	
}
/*calculate the long term satisfaction of one home
 * 
 * input is one class home to be calculated
 * after execution, we assign the value of long term satisfaction of the input class
 */
public void calcul_lt(Home home){

	List<Double> stf_list= home.getStf_list();
	double stf_l=0;
	double sum_stf=0;

	for(Double i : stf_list){
		sum_stf = sum_stf + i;
	}
	
	//long term satisfaction is the mean of all short term satisfactions
	stf_l=sum_stf/stf_list.size();
	home.setSATI_l(stf_l);
}


}
