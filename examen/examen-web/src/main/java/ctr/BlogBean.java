package ctr;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;

import sessionBeans.BlogService;

@ManagedBean(name = "blogBean")
@SessionScoped
public class BlogBean implements Serializable {
	 @EJB
	 BlogService blogService;
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getAll(){
		
			String lr= blogService.consomation();		       
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
