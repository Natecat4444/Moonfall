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
			pstmt = conn.prepareStatement("select Progress from User_show where UserID = ?");
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
		
		int userId = Integer.parseInt(request.getParameter("UserID"));
		String progress = null;
		boolean retrieved = false;
		
		try {
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			progress = rs.getString("progress");
			
			retrieved = true;
			rs.close();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		if(retrieved) {
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Moonfall Streaming</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<ul>");
			pw.println("<ls>"+ progress + "</ls>");
			pw.println("<ul>");
			pw.println("</body>");
			pw.println("</html>");
		}else {
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>MoonfallServlet</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h1>ERR:</h1>");
			pw.println("</body>");
			pw.println("</html>");
		}
	}
	
}
