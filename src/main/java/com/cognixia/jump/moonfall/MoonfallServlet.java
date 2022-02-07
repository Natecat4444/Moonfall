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

import com.cognixia.jump.moonfall.ConnectionManager;

@WebServlet("/MoonfallServlet")
public class MoonfallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement pstmt;
	
	
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

	public void destroy() {
		try {
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		

		User user = new User(request.getParameter("username"), request.getParameter("password"));
		boolean loggedin = user.login();
		
		if(!loggedin) {
			System.exit(1);
		}

		String progress = null;
		boolean retrieved = false;
		
		try {
			int userId = user.getId();
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Moonfall Streaming</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<table>");
			pw.println("<tr> <th>Title</th> <th>Progress</th></tr>");
			
			while(rs.next()) {
				pw.println("<tr> <td>"+rs.getString("Title")+"</td> <td>"+rs.getString("Progress")+"</td> </tr>");
			}
			
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
			
			rs.next();
			progress = rs.getString("progress");
			
			retrieved = true;
			rs.close();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
