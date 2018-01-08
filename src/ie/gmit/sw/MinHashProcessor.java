package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MinHashProcessor implements Similarator {
	//Declare variables and a constant for K size. I chose 100 but it can be increased or reduced as needed.
	private static final int K_SIZE = 100;
	private List<Integer> set1;
	private List<Integer> set2;

	@Override
	public double processSimilarity(Set<String> s1, Set<String> s2) {
		
		set1 = new ArrayList<Integer>();
		set2 = new ArrayList<Integer>();
		
		getHashes(s1, s2);  //Convert String sets into hash arraylists
		
		//counter for how many hashes are equal
		int equalCount = 0;
		for (int i = 0; i < K_SIZE; i++) {
			if (set1.get(i).equals(set2.get(i))) {
				equalCount++;
			}			
		}		
		//Similarity index that will be returned
		double similarityIndex = (double) equalCount/(double) K_SIZE;
		
		// TODO Auto-generated method stub
		return similarityIndex;
	}

	//method to get hash values from string sets.
	public void getHashes(Set<String> s1, Set<String> s2) {
		//convert string set into hashset of integers needed for minHash calculation.
		for (String str : s1) {
			set1.add(str.hashCode());
		}
		
		//Create the set of hash integers as random numbers
		Set<Integer> hashes = new TreeSet<Integer>();
		Random r = new Random();
		for (int i = 0; i < K_SIZE; i++){ //Create k random integers
			hashes.add(r.nextInt());
		}
		
		//XOR Integer values with second set words
		for (Integer x : hashes) {
			int min = Integer.MAX_VALUE;
			for(String s : s2){
				int minHash = s.hashCode() ^ x; //Bitwise XOR
				if(minHash < min){
					min = minHash;
				}				
				set2.add(min); //store minimum hash into set 
			}
		}
	}

}
