package jp.co.aforce.tool;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("*.action" )
public class FrontController extends HttpServlet {

	protected void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String path=request.getServletPath().substring(1);
			String name = path.replace(".action", "Action")
							  .replace("/", ".");
			Action action=(Action)Class.forName(
					"jp.co.aforce.servlet." + name)
					.getDeclaredConstructor().newInstance();
			String url=action.execute(request, response);
			response.sendRedirect(request.getContextPath() + "/views/" + url);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
	
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		doPost(request, response);
	}

}
