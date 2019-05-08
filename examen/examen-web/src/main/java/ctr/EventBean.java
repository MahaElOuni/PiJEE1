package ctr;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.xhtmlrenderer.pdf.ITextRenderer;
import persistence.Organizer;
import persistence.Report;
import sessionBeans.AdminService;
import sessionBeans.EventService;


@ManagedBean(name = "eventBean")
@SessionScoped
public class EventBean implements Serializable{

	private static final long serialVersionUID = 1L;
	 private int id;
	 private String photo;
	 private String title;
	 private String start;
	 private String dateEnd;
	 private String description;
	 private String address;
	 private String organizedBy;
	
	 ArrayList<Object> listdata = new ArrayList<Object>();    
	 
	 static Report report1=new Report();
	 
	 static Report report=new Report();
	 @EJB
	 EventService eventService;
	 
	 @EJB
	 AdminService adminService;
	 
	 
	 //Get All Events
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getAll(){
		
			String lr= eventService.consomation();		       
	        JSONArray array = new JSONArray(lr);
	        ArrayList<Object> listdata = new ArrayList<Object>();  
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	        	  
	            listdata.add(array.get(i));
	           
	           } 
	        }
	        return listdata;
		}
	 
	 
	 //President Events
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getEventsPresident(){
		
			String lr= eventService.consomationPresidentEvent(Loginbean.idUser);		       
	        JSONArray array = new JSONArray(lr);
	        ArrayList<Object> listdata = new ArrayList<Object>();  
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	            listdata.add(array.get(i));
	           
	           } 
	        }
	        return listdata;
		}

	 //Create PDF
	 
	 public void createPDF(int eventId){
		   report.setEventId(eventId);
		   
			FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext externalContext = facesContext.getExternalContext();
		    HttpSession session = (HttpSession) externalContext.getSession(true);
		    String url = "http://localhost:18080/examen-web/xhtml/reports.xhtml;JSESSIONID="+session.getId()+"pdf=true";
		    try {
		    ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocument(url);
		    renderer.layout();
		    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		    response.reset();
		    response.setContentType("application/pdf");
		    response.setHeader("Content-Disposition","C://user//first.pdf");
		    OutputStream browserStream = response.getOutputStream();
		    renderer.createPDF(browserStream);
		    browserStream.close();
		    session.invalidate();
		    } catch (Exception ex) {
		       ex.printStackTrace();
		    }
		    facesContext.responseComplete();
		    
	}
	
	 //getRepport
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public Object getRepport(){
		    String lr= eventService.consomationEvent(report.getEventId());	
		    JSONObject array = new JSONObject(lr);
	       
	        return array;
		 
	 }
	 
	
	 
	 
	 //Get Event
	 
	 
	 public String getPageDetails(int eventId){
		    
	       report1.setEventId(eventId);
	        return "/xhtml/eventDetails?faces-redirect=true";
		 
	 }
	 
	 //Get Event Details
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public Object getEventDetail(){
		    String lr= eventService.consomationEvent(report1.getEventId());	
		    JSONObject array = new JSONObject(lr);
	       
	        return array;
		 
	 }
	 
	 // Get Event Scheduler
	 
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getEventScheduler(){
		    String lr= eventService.consomationScheduler(report1.getEventId());	
		    JSONArray array = new JSONArray(lr);
	        ArrayList<Object> listdata = new ArrayList<Object>();  
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	            listdata.add(array.get(i));
	           
	           } 
	        }
	        return listdata;
		 
	 }
	 
	/* public void sendMail(){
		 Properties props = new Properties();
		 Session session = Session.getDefaultInstance(props, null);

		 try {
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("levio.lmp@gmail.com", "Example.com Admin"));
		   msg.addRecipient(Message.RecipientType.TO,
		                    new InternetAddress("maha.ouni995@gmail.com", "Mr. User"));
		   msg.setSubject("Your Example.com account has been activated");
		   msg.setText("This is a test");
		   Transport.send(msg);
		 } catch (AddressException e) {
		   // ...
		 } catch (MessagingException e) {
		   // ...
		 } catch (UnsupportedEncodingException e) {
		   // ...
		 }
	 }*/
	 
	
	 public StreamedContent getLikersNumber(){
		    int likes=0;
		    int unLikes=0;
		    int votes=0;
		    int users=0;
		    
		    String lr= adminService.getAllUsers();		       
		 	JSONArray array = new JSONArray(lr);
		 	String likersList= eventService.consomationEventLikers(report.getEventId());		       
		 	JSONArray arrayLikers = new JSONArray(likersList);
		 	 if (arrayLikers != null) { 
		 		for (int i=0;i<arrayLikers.length();i++){ 
		 			JSONObject object = arrayLikers.getJSONObject(i);
		 			if(object.getInt("status")==1){
		 				unLikes=unLikes+1;
		 			}else{
		 				likes=likes+1;
		 			}
           
		 		} 
		 	}
		 	 users=array.length();
		 	 votes=likes+unLikes;
		 	 DefaultPieDataset dataset = new DefaultPieDataset();
		 	
			dataset.setValue("Likes= "+likes, likes);
			 dataset.setValue("UnLikes= "+unLikes, unLikes);
			
		 	
			 StreamedContent chart = null;
			 JFreeChart jfreechart = ChartFactory.createPieChart("Number Of Votes: "+votes, dataset, true, true, false);
			 File chartFile1 = new File("dynamichart");
			 try {
				ChartUtilities.saveChartAsPNG(chartFile1, jfreechart, 375, 300);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 try {
				chart = new DefaultStreamedContent(new FileInputStream(chartFile1),"image/png");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		 	
		return chart ;
		
	 }
	 
	 
	//Get Participant number
		
	public int getParticipantNumber(){
	     int number= eventService.consomationParticipantNumber(report.getEventId());	
		return number;
			 
	}
		 
	//Get Organizer and Tasks
	
	@GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Organizer> getOrganizers(){
		ArrayList<Organizer> listOrganizer=new ArrayList<Organizer>();
		    String lr= eventService.consomationOrganizerTasks(report.getEventId());	
		    JSONArray array = new JSONArray(lr);
	       
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	        	   JSONObject object = array.getJSONObject(i);
	        	   Organizer organizer=new Organizer();
	        	   organizer.setEmail(eventService.consomationOrganizerEmail(object.getInt("UserId")));
	               organizer.setTaskTitle(object.getString("TaskTitle"));
	               listOrganizer.add(organizer);
	               
	           } 
	        }
	        return listOrganizer;
		 
	 }
	public int getNumberOrganizer(){
		return getOrganizers().size();
	}
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrganizedBy() {
		return organizedBy;
	}

	public void setOrganizedBy(String organizedBy) {
		this.organizedBy = organizedBy;
	}


	public StreamedContent Bean(){
		StreamedContent chart = null;
	 JFreeChart jfreechart = ChartFactory.createPieChart("Cities",
	createDataset(), true, true, false);
	 File chartFile1 = new File("dynamichart");
	 try {
		ChartUtilities.saveChartAsPNG(chartFile1, jfreechart, 375, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		chart = new DefaultStreamedContent(new FileInputStream(chartFile1),"image/png");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return chart;
	}
	
	private PieDataset createDataset() {
	 DefaultPieDataset dataset = new DefaultPieDataset();
	 dataset.setValue("New York", new Double(45.0));
	 dataset.setValue("London", new Double(15.0));
	 dataset.setValue("Paris", new Double(25.2));
	 dataset.setValue("Berlin", new Double(14.8));
	 return dataset;
	 }


	/*public void sendEmails(){
		 try{
	            String host ="smtp.gmail.com" ;
	            String user = "maha.elouni@esprit.tn";
	            String pass = "12812152";
	            String to = "maha.ouni995@gmail.com";
	            String from = "sender email";
	            String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
	            String messageText = "Your Is Test Email :";
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");

	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	            Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);

	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("message send successfully");
	        }catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
	}*/
}
