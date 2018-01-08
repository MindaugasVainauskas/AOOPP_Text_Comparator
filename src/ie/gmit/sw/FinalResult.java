package ie.gmit.sw;

public class FinalResult {

	//variables for storing.
	private String fileName;
	private double jaccardSimilarity;
	private double minHashSimilarity;
	//constructor
	public FinalResult(String fileName, double jaccardSimilarity, double minHashSimilarity) {
		this.fileName = fileName;
		this.jaccardSimilarity = jaccardSimilarity;
		this.minHashSimilarity = minHashSimilarity;
	}
	
	//---Getters and setters---
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public double getJaccardSimilarity() {
		return jaccardSimilarity;
	}
	public void setJaccardSimilarity(double jaccardSimilarity) {
		this.jaccardSimilarity = jaccardSimilarity;
	}
	public double getMinHashSimilarity() {
		return minHashSimilarity;
	}
	public void setMinHashSimilarity(double minHashSimilarity) {
		this.minHashSimilarity = minHashSimilarity;
	}
}
