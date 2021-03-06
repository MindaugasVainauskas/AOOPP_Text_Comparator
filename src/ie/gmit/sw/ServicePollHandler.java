package ie.gmit.sw;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServicePollHandler extends HttpServlet {
	//default version ID
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter(); 
		
		String title = req.getParameter("txtTitle");
		String taskNumber = req.getParameter("frmTaskNumber");
		int counter = 1;
		if (req.getParameter("counter") != null){
			counter = Integer.parseInt(req.getParameter("counter"));
			counter++;
		}
		//Recover session saved int SessionHandler servlet
		HttpSession session = req.getSession();
		//Retrieve variable and a result list
		taskNumber = (String) session.getAttribute("taskNumber");
		List<FinalResult> results = (List<FinalResult>) session.getAttribute("results");

		out.print("<html><head><title>A JEE Application for Measuring Document Similarity</title>");		
		out.print("</head>");		
		out.print("<body>");
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<H3>Document Title: " + title + "</H3>");
		out.print("<b><font color=\"ff0000\">A total of " + counter + " polls have been made for this request.</font></b> ");
		//Decided to go with a simple table for result display.
		out.print("<table border='1' cellspacing='1'>");
		out.print("<tr>");
		out.print("<th>Document Title</th>");
		out.print("<th>Jaccard Similarity</th>");
		out.print("<th>MinHash Similarity</th>");
		out.print("</tr>");
			for(FinalResult res : results){
				out.print("<tr>");
				out.print("<td>" + res.getFileName() + "</td>");
				out.print("<td>" + res.getJaccardSimilarity() + "</td>");
				out.print("<td>" + res.getMinHashSimilarity() + "</td>");
				out.print("</tr>");
			}
		out.print("</table>");		
		out.print("<form name=\"frmRequestDetails\">");
		out.print("<input name=\"txtTitle\" type=\"hidden\" value=\"" + title + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("<input name=\"counter\" type=\"hidden\" value=\"" + counter + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 5000);"); //Refresh every 5 seconds
		out.print("</script>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}