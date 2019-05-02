package ctr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


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
	 @EJB
	 EventService eventService;
	 
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
	 
}
