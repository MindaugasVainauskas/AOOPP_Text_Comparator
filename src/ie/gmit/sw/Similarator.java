package ie.gmit.sw;

import java.util.Set;

public interface Similarator {
	
	//declaration of method to process 2 sets and return their similarity.
	public double processSimilarity(Set<String> s1, Set<String> s2);

}
