package myServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.analysis.Analyzer;

import myServelet.WSDMSearch;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	//len是一共搜索多少条
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String content = request.getParameter("search_text");
		String type = request.getParameter("choice");
//		response.setContentType("text/html");       // 实际的逻辑是在这里      
//		PrintWriter out = response.getWriter();      
//		out.println("<h1>content:" + content + "</h1>");
//		out.println("<h1>type:" + type + "</h1>");
		
		String con[][];
		
		con = WSDMSearch.servlet(type, content);
		
		request.setAttribute("search_contents", con);
		
//		response.setContentType("text/html");       // 实际的逻辑是在这里      
//		PrintWriter out1 = response.getWriter();      
//		out1.println("important:" + con[0][0]);
//		out1.println("important:" + con[0][1]);
//		out1.println("A B <font color=\"red\">C</font>");
		
		
	    request.setAttribute("type",type);
	    request.setAttribute("content",content);
	    request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
