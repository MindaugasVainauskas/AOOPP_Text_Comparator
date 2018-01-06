package ie.gmit.sw;

import java.util.ArrayList;

//This object will be saved in the in-queue
public class TextFile {
	//Variable declarations
	private String fileName;
	private ArrayList<String> fileContent;
	private String taskNumber;
	
	//constructor to create object of text file that will be stored in OODB?
	public TextFile(String fileName, ArrayList<String> fileContent, String taskNum) {
		this.fileName = fileName;
		this.fileContent = fileContent;
		this.taskNumber = taskNum;
	}
//---Getters and setters---
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTaskNumber() {
		return taskNumber;
	}
	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}
	public ArrayList<String> getFileContent() {
		return fileContent;
	}

	public void setFileContent(ArrayList<String> fileContent) {
		this.fileContent = fileContent;
	}
	

}
