package collectionDemo;

import java.util.Comparator;

public class ComparatorDemo implements Comparator {


	

@Override
public int compare(Object o1, Object o2) {
	Mobiles Realme =(Mobiles) o1;
	Mobiles vivo = (Mobiles) o2;
	if(Realme.Price> vivo.Price) {
		return +1;
		}
		else if (Realme.Price < vivo.Price) {
			return -1;
		}
		else {
			if(Realme.ramGb>vivo.ramGb) {
				return 11;
			}
			else if(Realme.ramGb < vivo.ramGb){
				return -1;
			}
		}
	return 0;
	}

	
}


