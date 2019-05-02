package ctr;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sessionBeans.SampleLongPollingNotifier;

/**
 * Servlet implementation class SampleLongPollingRegistration
 */

@WebServlet(urlPatterns = {"/longpolling"}, asyncSupported = true, loadOnStartup = 1)
public class SampleLongPollingRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private SampleLongPollingNotifier notifier;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleLongPollingRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello"); 
        response.setContentType("Helooooooooo");
        response.setStatus(202);
        response.setHeader("Pragma", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
 
        final AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(30000);
 
        notifier.addAsyncContext(asyncContext);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
