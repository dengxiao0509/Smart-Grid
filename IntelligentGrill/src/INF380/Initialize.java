package INF380;        

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList; 
import java.util.List;  

public class Initialize {
	public Home Ini(Home home_n,int n) throws IOException{
		List<String[]> csvList = new ArrayList<String[]>();  
		String filePath = "C:\\Users\\Administrator\\Desktop\\INF380-projet\\IntelligentGrill\\IntelligentGrill\\src\\INF380\\file6.csv";
		if (isCsv(filePath)) {  
			CsvReader reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
			 while (reader.readRecord()) {
				 csvList.add(reader.getValues());
			 }
			 reader.close(); 
			/* System.out.println("This is for test\n");
			 System.out.println(Integer.parseInt(csvList.get(0)[n-1]));
			 System.out.println(Integer.parseInt(csvList.get(1)[n-1]));
			 System.out.println(Integer.parseInt(csvList.get(2)[n-1]));
			 System.out.println(Integer.parseInt(csvList.get(3)[n-1]));
			 */
			 int inte=Integer.parseInt(csvList.get(0)[n-1]);
			 home_n.setP(Integer.parseInt(csvList.get(0)[n-1]));
			 home_n.setC(Integer.parseInt(csvList.get(1)[n-1]));
			 home_n.setCC(Integer.parseInt(csvList.get(2)[n-1]));
			 home_n.setCO(Integer.parseInt(csvList.get(3)[n-1]));
		 } else { 
			 System.out.println("This is not a CSV file!");  
		 }
		return home_n;
	}
	// judge whether it is a CSV file
	private boolean isCsv(String fileName) { 
		return fileName.matches("^.+\\.(?i)(csv)$"); 
	}
	// method test
	public static void main(String[] args) throws Exception {
		
		Initialize su = new Initialize();
		Home h1 = new Home();
		su.Ini(h1, 1);
		System.out.println("home1:"); 
		System.out.println("production: "+h1.getP());
		System.out.println("consummation: "+h1.getC()); 
		System.out.println("critical consummation: "+h1.getCC());  
		System.out.println("optional consummation: "+h1.getCO()); 
		
		System.out.println();
		System.out.println("home2:"); 
		Home h2 = new Home();
		su.Ini(h2, 2);
		System.out.println("production: "+h2.getP());
		System.out.println("consummation: "+h2.getC()); 
		System.out.println("critical consummation: "+h2.getCC());  
		System.out.println("optional consummation: "+h2.getCO()); 
		
		System.out.println();
		System.out.println("home3:"); 
		Home h3 = new Home();
		su.Ini(h3, 3);
		System.out.println("production: "+h3.getP());
		System.out.println("consummation: "+h3.getC()); 
		System.out.println("critical consummation: "+h3.getCC());  
		System.out.println("optional consummation: "+h3.getCO()); 
		
		System.out.println();
		System.out.println("home4:"); 
		Home h4 = new Home();
		su.Ini(h4, 4);
		System.out.println("production: "+h4.getP());
		System.out.println("consummation: "+h4.getC()); 
		System.out.println("critical consummation: "+h4.getCC());  
		System.out.println("optional consummation: "+h4.getCO()); 
		
		System.out.println();
		System.out.println("home5:"); 
		Home h5 = new Home();
		su.Ini(h5, 5);
		System.out.println("production: "+h5.getP());
		System.out.println("consummation: "+h5.getC()); 
		System.out.println("critical consummation: "+h5.getCC());  
		System.out.println("optional consummation: "+h5.getCO()); 
		
		System.out.println();
		System.out.println("home6:"); 
		Home h6 = new Home();
		su.Ini(h6, 6);
		System.out.println("production: "+h6.getP());
		System.out.println("consummation: "+h6.getC()); 
		System.out.println("critical consummation: "+h6.getCC());  
		System.out.println("optional consummation: "+h6.getCO()); 
		
		District d = new District();
		d.addHome(h1);
		d.addHome(h2);
		d.addHome(h3);
		d.addHome(h4);
		d.addHome(h5);
		d.addHome(h6);
		
		PolitiqueA2 p2 = new PolitiqueA2();
		p2.addP(d);
		int pTotal = p2.getP();
		PolitiqueD1 d1 = new PolitiqueD1();
		d1.distribuer(pTotal, d);
		
		
		}
	
		
	
	
}
