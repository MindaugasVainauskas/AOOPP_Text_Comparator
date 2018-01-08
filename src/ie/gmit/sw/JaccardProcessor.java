package ie.gmit.sw;

import java.util.Set;

public class JaccardProcessor implements Similarator{
	//set variables
	private Set<String> temp1;
	private Set<String> temp2;
	//set length variables
	private int l1;
	private int l2;
	
	//variable to store intersection
	private int intersection;
	
	//variable to keep the similarity index
	private double similarity;

	//implementation of the Similarator interface
	@Override
	public double processSimilarity(Set<String> s1, Set<String> s2) {
		//Calculate Jaccard Similarity
		temp1 = s1;
		temp2 = s2;
		
		//set variable sto sizes of 2 sets
		l1 = temp1.size();
		l2 = temp2.size();
		//apply method to only leave same shingles in the temp1
		temp1.retainAll(temp2);
		intersection = temp1.size();  //Intersection number is the temp1 set size
		//if intersection is 0(files contain no same shingles at all) just return similarity of zero.
		//Otherwise calculate similarity index.
		if(!(intersection == 0)){
			similarity = (l1+l2-intersection)/intersection;
		}else{
			similarity = 0.0;
		}
		
		return similarity; //return the similarity index
	}

}
