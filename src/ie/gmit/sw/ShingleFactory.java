package ie.gmit.sw;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

//This class splits the given text string into set of characters.
//Can be either set length character substrings or single word shingles.
public class ShingleFactory {

	/*
	 * I am leaving both methods in on purpose to show that there are 2 ways of splitting the string
	 * Only the second method ended up being used, although first one is also a valid option in my opinion
	 */
	
	//takes in string and shingle length int value, creates shingles out of it and sets shingle array list to its value.
	public Set<String> createShingles(String s, int l){
		Set<String> temp = new TreeSet<String>();
		for (int start = 0; start < s.length(); start += l) {
	        temp.add(s.substring(start, Math.min(s.length(), start + l)));
	    }
		return temp;		
	}

	//This method will split the text with every space. Since all specia characters have been removed it is easy to split it into single words
	public Set<String> createShingles2(String s){
		Set<String> temp;
		temp = new TreeSet<String>(Arrays.asList(s.split(" ")));
		return temp;		
	}
}
