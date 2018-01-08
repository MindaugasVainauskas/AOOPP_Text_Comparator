package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class SimilarityCalculator {
	//Declare classes and DB
	private TextFile tf;
	private ObjectContainer db;
	private JaccardProcessor jpr;
	private MinHashProcessor mhp;
	private BlockingQueue<TextFile> inQueue;
	private Map<String, FinalResult> outQueue;
	
	public SimilarityCalculator(){
		//Initialise the required classes
		jpr = new JaccardProcessor();
		mhp = new MinHashProcessor();
		inQueue = new LinkedBlockingQueue<TextFile>();  //Initialise the inqueue
		outQueue = new HashMap<String, FinalResult>();  //Initialise the outQueue
		db = Db4oEmbedded.openFile("TextFiles.data");  //Inititalise the DB
	}
	
	//This method calculates the jaccard and MinHash similarity indexes
	public void calculate(){
		
		try {
			try {
				tf = inQueue.take();  //Take job from inqueue if exists
				double result;
				double mhResult;
				
				ObjectSet<TextFile> texts = db.query(TextFile.class);  //get the set of TextFile objects from DB4O db.
				
				for (TextFile textFile : texts) {
					result = jpr.processSimilarity(tf.getFileContent(), textFile.getFileContent());  //calculate Jaccard Similarity
					mhResult = mhp.processSimilarity(tf.getFileContent(), textFile.getFileContent()); // Calculate MinHash Similarity
					
					FinalResult tempRes = new FinalResult(tf.getFileTitle(), result, mhResult);
					//out-queue stores task number of a job and the final result object with title and both similarity indexes.
					outQueue.put(tf.getTaskNumber(), tempRes);
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			//close db when done.
			db.close();
		}
		
	}
	
	//This method simply adds new jobs to the inqueue and to the db.
	public void addtoInQueue(TextFile t){	
		inQueue.add(t);  //store file in the inQueue
		db.store(t);  //Store file in the DB
		db.commit();  //Commit the tx		
	}
	
	public List<FinalResult> getResults(){
		List<FinalResult> temp = new ArrayList<FinalResult>();
		for (FinalResult fr : outQueue.values()) {
			temp.add(fr);
		}
		return temp;
	}


}
