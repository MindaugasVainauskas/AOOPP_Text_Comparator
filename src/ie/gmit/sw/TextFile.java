package ie.gmit.sw;

import java.util.Set;

//This object will be saved in the in-queue
public class TextFile {
	//Variable declarations
	private String fileTitle;
	private Set<String> fileContent;
	private String taskNumber;
	
	//constructor to create object of text file that will be stored in OODB
	public TextFile(String title, Set<String> fileContent, String taskNum) {
		this.fileTitle = title;
		this.fileContent = fileContent;
		this.taskNumber = taskNum;
	}
//---Getters and setters---
	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String title) {
		this.fileTitle = title;
	}

	public String getTaskNumber() {
		return taskNumber;
	}
	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}
	public Set<String> getFileContent() {
		return fileContent;
	}

	public void setFileContent(Set<String> fileContent) {
		this.fileContent = fileContent;
	}
	

}
