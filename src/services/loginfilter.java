package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/log")
public class loginfilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		PrintWriter out = res.getWriter();
		String name = request.getParameter("log");
		String password = request.getParameter("pass");
		
		if(!name.isEmpty() &&  !password.isEmpty() ) {
			if(password.equals("vivi")) {
				req.getRequestDispatcher("Admission.jsp").forward(req,res);
			}else {
				RequestDispatcher red = req.getRequestDispatcher("forgot.jsp");
				red.forward(request, response);
				
				response.sendRedirect("forgot.jsp?log="+name+"&pass="+password);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
