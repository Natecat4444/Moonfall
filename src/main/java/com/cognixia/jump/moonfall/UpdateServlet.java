package com.cognixia.jump.moonfall;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement pstmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement("select Shows.Title, User_Show.Progress, Progress.ProgressStatus\n"
					+ "from Shows\n"
					+ "join User_Show\n"
					+ "on Shows.ShowID = User_Show.ShowID\n"
					+ "join Progress\n"
					+ "on User_Show.Progress = Progress.ProgressID\n"
					+ "where User_Show.UserID = ?");
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		User user = UserHolder.getUser();
		
		Show show = new Show(request.getParameter("show"));
		int progress = Integer.parseInt(request.getParameter("progress"));
		
		User_Show us = new User_Show(user.getId(), show.getShowID());
		us.setProgress(progress);
		us.update();
		
		try {
			int userId = user.getId();
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Moonfall Streaming</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<ul>");
			pw.println("<li><a href='/Update'>Update Show</a></li>");
			pw.println("</ul>");
			pw.println("<table>");
			pw.println("<tr> <th>Title</th> <th>Progress</th></tr>");
			
			while(rs.next()) {
				pw.println("<tr> <td>"+rs.getString("Title")+"</td> <td>"+rs.getString("ProgressStatus")+"</td> </tr>");
			}
			
			pw.println("</table>");
			pw.println("<br />");
			pw.println("<br />");
			pw.println("<h2>Update Show</h2>");
			pstmt= conn.prepareStatement("select Shows.Title\n"
					+ "from Shows\n"
					+ "join User_Show\n"
					+ "on Shows.ShowID = User_Show.ShowID\n"
					+ "join Progress\n"
					+ "on User_Show.Progress = Progress.ProgressID\n"
					+ "where User_Show.UserID = ?");
			pstmt.setInt(1, userId);
			
			pw.println("<form Action='UpdateServlet' method='POST'>");
			pw.println("<label>Show Title<select name = show>");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pw.println("<option value = "+rs.getString("Title")+">"+rs.getString("Title")+"</option>");
			}
			pw.println("</select></label> <br />");
			pw.println("<label> Select new Progress <select name='progress'>");
			pw.println("<option value='1'>Plan to Watch</option>");
			pw.println("<option value='2'>In progress</option>");
			pw.println("<option value='3'>Completed</option>");
			pw.println("<option value='4'>Dropped</option>");
			pw.println("</select></label> <br />");
			pw.println("<input type=\"submit\" class=\"button\" value=\"Login\">");
			pw.println("</form> <br />");
			
			pstmt = conn.prepareStatement("select Shows.Title from Shows join User_Show on Shows.ShowID = User_Show.ShowID where User_Show.UserID != ?");
			pstmt.setInt(1, userId);
			
			pw.println("<h2>Add new show</h2>");
			pw.println("<form Action='UpdateServlet' method='POST'>");
			pw.println("<label>Show Title<select name = 'show'>");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pw.println("<option value = "+rs.getString("Title")+">"+rs.getString("Title")+"</option>");
			}
			pw.println("</select></label> <br />");
			pw.println("<label> Select new Progress <select name='progress'>");
			pw.println("<option value='1'>Plan to Watch</option>");
			pw.println("<option value='2'>In progress</option>");
			pw.println("<option value='3'>Completed</option>");
			pw.println("<option value='4'>Dropped</option>");
			pw.println("</select></label> <br />");
			pw.println("<input type=\"submit\" class=\"button\" value=\"Login\">");
			pw.println("</form> <br />");
			
			pw.println("</body>");
			pw.println("</html>");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
