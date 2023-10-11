package eu.tasgroup.collections.code;

import java.util.Comparator;

public class OrarioComparator implements Comparator<Orario> {

	@Override
	public int compare(Orario o1, Orario o2) {
		int compOre = o2.getOre() - o1.getOre();
		int compMinuti = o2.getMinuti() - o1.getMinuti();
		int compSecondi = o2.getSecondi() - o1.getSecondi();
		if (compOre != 0)
			return compOre;
		else if (compMinuti != 0)
			return compMinuti;
		else
			return compSecondi;
	}

}
