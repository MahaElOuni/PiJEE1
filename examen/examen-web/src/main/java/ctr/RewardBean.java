package ctr;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;

import sessionBeans.RewardService;


@ManagedBean(name = "rewardBean")
@SessionScoped

public class RewardBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	ArrayList<Object> listdata = new ArrayList<Object>();   
	 @EJB
	 RewardService rewardservice;
	 
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getAll(){
		
			String lr= rewardservice.consomation();		       
	        JSONArray array = new JSONArray(lr);
	        ArrayList<Object> listdata = new ArrayList<Object>();  
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	            listdata.add(array.get(i));
	           
	           } 
	        }
	        
		
	        return listdata;
			
		}

	
}
