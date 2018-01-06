package ie.gmit.sw;

import java.util.ArrayList;

public class ShingleFactory {
	
	//shingle array list variable
	private ArrayList<String> sal;
	
	//returns sal value
	public ArrayList<String> getSal() {
		return sal;
	}

	//sets sal to the given array list value.
	public void setSal(ArrayList<String> sal) {
		this.sal = sal;
	}

	//takes in string and shingle length int value, creates shingles out of it and sets shingle array list to its value.
	public void createShingles(String s, int l){
		sal = new ArrayList<String>();
		for (int i = 0; i < s.length()-l; i+=l) {
			sal.add(s.substring(i, i+l));
		}
	}

}
