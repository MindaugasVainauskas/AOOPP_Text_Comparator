package ie.gmit.sw;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ShingleFactory {

	//takes in string and shingle length int value, creates shingles out of it and sets shingle array list to its value.
	public Set<String> createShingles(String s, int l){
		Set<String> temp = new TreeSet<String>();
		for (int start = 0; start < s.length(); start += l) {
	        temp.add(s.substring(start, Math.min(s.length(), start + l)));
	    }
		return temp;		
	}

	public Set<String> createShingles2(String s, int l){
		Set<String> temp;
		temp = new TreeSet<String>(Arrays.asList(s.split(" ")));
		return temp;		
	}
}
