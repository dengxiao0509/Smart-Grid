package INF380;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	
	public static void main(String[] args) throws IOException {
		
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
		
	}

}
