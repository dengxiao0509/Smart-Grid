package INF380;        

import com.csvreader.CsvReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList; 
import java.util.List;  

public class Initialize {
	public Initialize() throws Exception{
		/*
		District dis = new District();
		File file = new File("files");
		dis = initial_district(file);
		 */
	}
	public static Home Ini(Home home_n,File file) throws Exception{
		List<String[]> csvList = new ArrayList<String[]>();  
		List<Integer> p = new ArrayList<Integer>(); //production
		List<Integer> c = new ArrayList<Integer>(); //consommation totale
		List<Integer> cc = new ArrayList<Integer>(); //consommation critique
		List<Integer> co = new ArrayList<Integer>(); //consommation optionelle

		String filePath = file.getAbsolutePath();
		//System.out.println("The file path is: "+filePath);
		if (isCsv(filePath)) {  
			CsvReader reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
			reader.readHeaders(); // ������ͷ
			while (reader.readRecord()) {
				csvList.add(reader.getValues());
			}
			reader.close(); 

			for (int r_list = 0; r_list < csvList.size(); r_list++) {
				for (int c_list = 0; c_list < csvList.get(r_list).length; c_list++) {
					int cell = 0;
					try{
						cell = Integer.parseInt(csvList.get(r_list)[c_list]);
					}
					catch(NumberFormatException NFE){
						System.out.println("The format is wrong.");
					}
					if(c_list==0) p.add(cell);
					else if(c_list==1) c.add(cell);   
					else if(c_list==2) cc.add(cell);
					else if(c_list==3) co.add(cell);
					else System.out.print("error!");		                
				}
				//System.out.print("\n");
			}


			home_n.setP(p);
			home_n.setC(c);
			home_n.setCC(cc);
			home_n.setCO(co);
			//0524
			int ls_size = home_n.getP().size();
			//generate a list filled with 1, size is equal to p
			List<Integer> temp = new ArrayList<Integer>(); 
			for(int i=0;i<ls_size;i++){
				temp.add(1);
			}
			for(int i=0;i<ls_size;i++){
				temp.set(i,0);
			}
			home_n.setAP(temp);
			home_n.setAPC(temp);
			home_n.setAPO(temp);


			List<Integer> p_app_temp = new ArrayList<Integer>();

			for(int j=0;j<ls_size;j++) {
				
				

				p_app_temp.add(home_n.getP().get(j)-home_n.getAP().get(j));

			}

			home_n.setP_app_dif(p_app_temp);


			//0524

		} else { 
			System.out.println("This is not a CSV file!");  
		}
		return home_n;
	}


	public static District initial_district(File f) throws Exception{
		District d=new District();
		File[] listFiles = f.listFiles();
		//String filePath;
		for(File file: listFiles){
			//filePath=file.getAbsolutePath();
			Home h=new Home();
			h=Ini(h,file);
			d.addHome(h);
			System.out.println(file);
		}
		return d;
	}

	// judge whether it is a CSV file
	private static boolean isCsv(String fileName) { 
		return fileName.matches("^.+\\.(?i)(csv)$"); 
	}



	// method test
	public static void main(String[] args) throws Exception {

		//Initialize su = new Initialize();
		/*
		Home h1 = new Home();
		Home h2 = new Home();
		Home h3 = new Home();
		Home h4 = new Home();
		Home h5 = new Home();
		Home h6 = new Home();
		su.Ini(h1,1);
		su.Ini(h2,2);
		su.Ini(h3,3);
		su.Ini(h4,4);
		su.Ini(h5,5);
		su.Ini(h6,6);
		 */
		//File f = new File("D://workspace//IntelligentGrill_version2//IntelligentGrill//files");
		District dis;
		File f = new File("files");
		dis = initial_district(f);
	}
}
