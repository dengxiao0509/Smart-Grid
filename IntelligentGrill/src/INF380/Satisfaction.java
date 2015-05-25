package INF380;


import java.util.List;

public class Satisfaction {



	public Satisfaction(){	

	}


	/* calculate the Gini index of a series of numbers, stored in a list as input
	 * return the result
	 */
	public static double calcul_gini(List<Double> list){

		double sum=0;
		double mean=0;
		
		
		mean=calcul_mean(list);
		
		
		//gini equation
		for(Double k : list){
			for(Double j : list){
			sum+= Math.abs(k-j);	
			}
		}
		
		return 0.5*(1/mean)*(1/(Math.pow(list.size(), 2)))*sum;

	}
	
	public static double calcul_mean(List<Double> list){
	
		double sum=0;
		for(Double i : list){
			sum = sum + i;
		}

		return sum/list.size();
		
	}


}