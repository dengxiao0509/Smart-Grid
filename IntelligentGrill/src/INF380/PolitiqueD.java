package INF380;

import java.util.Comparator;
import java.util.List;

public abstract class PolitiqueD {//politique de distribution
	
	abstract void distribuer(int pTotal,District d);
	abstract int getPT();
	abstract List<Integer> getCC();
	abstract List<Integer> getCO();
	protected abstract Comparator<Integer> comparator();


}
