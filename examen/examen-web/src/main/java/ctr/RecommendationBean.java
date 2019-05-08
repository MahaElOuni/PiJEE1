package ctr;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import persistence.Report;
import sessionBeans.RecommendationService;


@ManagedBean(name = "recommendationBean")
@SessionScoped
public class RecommendationBean implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Report report10 = new Report();
	String EmailParticipent ;
	
	 ArrayList<Object> listdata = new ArrayList<Object>();   
	 @EJB
	 RecommendationService recommendationservice;
	 
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getAll(){
		
			String lr= recommendationservice.consomation();		       
	        JSONArray array = new JSONArray(lr);
	        ArrayList<Object> listdata = new ArrayList<Object>();  
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	            listdata.add(array.get(i));
	           
	           } 
	        }
	        
		
	        return listdata;
			
		}

	public String getEmailParticipent() {
		return EmailParticipent;
	}

	public void setEmailParticipent(String emailParticipent) {
		EmailParticipent = emailParticipent;
	}

	
	public String getPageDetails(int recommendationId) {

		report10.setEventId(recommendationId);
		return "/xhtml/Recommendation?faces-redirect=true";

	}

	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Object getRecommendation() {
		String lr = recommendationservice.consomation();
		JSONObject array = new JSONObject(lr);

		return array;

	}
	 

}
