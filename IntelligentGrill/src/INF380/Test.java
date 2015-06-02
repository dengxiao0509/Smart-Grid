package INF380;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {


	public static void main(String[] args) throws Exception {


		////////////WEN JIA//////////////////////////
		District dis;
		File f = new File("files2");
		//Initialize ini = new Initialize();
		dis = Initialize.initial_district(f);
		////////////WEN JIA//////////////////////////
		
		
		
		
		/*
		/////////SUN///////////////////////////////
		for(int i=0;i<dis.getHome().get(0).getP().size();i++){
			dis.getP().add(i, 0);
		}
		for(int i=0;i<dis.getHome().get(0).getP().size();i++){
			List<Integer> stock = dis.getHome().get(i).getStockplus();
			dis.addP(stock);
		}
		PolitiqueD1 d1 = new PolitiqueD1();
		d1.distribuer(dis.getP(),dis);
		/////////////////////////////////////////////		
		
		
		*/
		
		
/////////SUN///////////////////////////////
		for(int i=0;i<dis.getHome().get(0).getP().size();i++){
			dis.getP().add(i, 0);
		}
		for(int i=0;i<dis.getHome().size();i++){
			Home h = dis.getHome().get(i);
			int j=1;
			//System.out.println("P:"+h.getP().get(j).toString()+" C:"+h.getC().get(j)+" AP:"+h.getAP().get(j)+" APC:"+h.getAPC().get(j)+" APO:"+h.getAPO().get(j));
			
			List<Integer> stock = dis.getHome().get(i).getStockplus();
			
			//System.out.println("P:"+h.getP().get(j).toString()+" C:"+h.getC().get(j)+" AP:"+h.getAP().get(j)+" APC:"+h.getAPC().get(j)+" APO:"+h.getAPO().get(j));
			dis.addP(stock);
		}
		/*System.out.println(dis.getP().get(0));
		System.out.println(dis.getP().get(1));
		System.out.println(dis.getP().get(2));*/
		PolitiqueD1 d1 = new PolitiqueD1();
		d1.distribuer(dis.getP(),dis);
		/*System.out.println(dis.getP().get(0));
		System.out.println(dis.getP().get(1));
		System.out.println(dis.getP().get(2));*/
		/////////////////////////////////////////////	
		
		
		for(int j=0;j<dis.getHome().get(0).getP().size();j++){
			int num = 1;
			System.out.println("");
			System.out.println("");
			System.out.println("The "+(j+1)+" period");
			for(Home h:dis.getHome()){
			
				
				System.out.println("home "+num+"");
				System.out.println("P:"+h.getP().get(j).toString()+" C:"+h.getC().get(j)+" AP:"+h.getAP().get(j)+" APC:"+h.getAPC().get(j)+" APO:"+h.getAPO().get(j));
				
				num++;
			}
	}
		
		////////////DENG ///////////////////////////////
		int homeid = 1;
		System.out.println("");
		System.out.println("");
		for(Home h:dis.getHome()){
		//System.out.println(h.getAP().size());
			
			//input: x,y,a,b,c,d
			h.stf_st(0.7, 0.3,0.1,0.1,0.2,0.1);
			
			
			System.out.println("home "+homeid);
			int hp = 1;
			for(double j : h.getStf_list()){
			System.out.println("period "+hp+"       "+j);
			hp++;
			}
			h.stf_lt();
			homeid++;
			
			System.out.println("home long term satisfaction : mean = "+h.getStf_lt_m());
			System.out.println("home long term satisfaction : gini = "+h.getStf_lt_v());
			System.out.println("");
			System.out.println("");

		}
		
		
		
		dis.stf_dis_st();
		dis.stf_dis_lt();
		System.out.println("district satisfaction : gini ="+dis.getStf_v_lt());
		System.out.println("district satisfaction : mean ="+dis.getStf_m_lt());
		
		////////////////////////////////////////////////
		
		
		
		
		/* DENG
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


		int size = home.size();//size of home
		int sizeP = home.get(0).getP().size();//size of production

		for(int i=0; i<size; i++){
			List<Integer> stock = home.get(i).getStockplus();
		    district.addP(stock);
		}
		//

		//TO DO:

		//TO DO:
				 */
	}

}
