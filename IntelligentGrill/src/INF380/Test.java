package INF380;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {


	public static void main(String[] args) throws IOException {


		// !!!!!!!!!!!!!!!!!!!
		List<Double> p = new ArrayList<Double>();
		p.add(1.0);
		p.add(2.0);
		p.add(3.0);

		double m=Satisfaction.calcul_mean(p);
		double v=Satisfaction.calcul_gini(p);

		System.out.println("mean "+m);
		System.out.println("variance" +v);

		Home h1=new Home();
		List<Integer> l = new ArrayList<Integer>();
		l.add(3);
		h1.setP(l);
	    h1.setAP(l);

		l.clear();
		l.add(2);
		h1.setCC(l);

		h1.setCO(l);
		h1.setAPC(l);

		l.clear();
		l.add(1);
		h1.setAPO(l);
	
		
		h1.stf_st(0.7,0.3);
		h1.stf_lt();

		System.out.println("Stf short term = "+ h1.getStf_list().get(0));
		System.out.println("Stf long term m = "+ h1.getStf_lt_m());
		System.out.println("Stf long term v = "+ h1.getStf_lt_v());		



				/*
		District district = new District();

		List<Home> home = new ArrayList<Home>();

		Home home1 = new Home(); 
		PolitiqueA p = home1.getPoli();
		//p.haha();

		Initialize ini = new Initialize();

		//TO DO: 根据文件数新建home, 对home赋值，添加到List中，最后得到District

		int size = home.size();//size of home
		int sizeP = home.get(0).getP().size();//size of production(长期下所有的情况)

		for(int i=0; i<size; i++){
			List<Integer> stock = home.get(i).getStockplus();
		    district.addP(stock);
		}
		//收集所有的production

		//TO DO: 分配

		//TO DO: 算满意度
				 */
	}

}
