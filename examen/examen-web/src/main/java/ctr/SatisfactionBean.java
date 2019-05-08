package ctr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import sessionBeans.SatisfactionService;


@ManagedBean(name = "satisfactionBean")
@SessionScoped
public class SatisfactionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 int nbr = 9 ;
	 int nbb = 9  ; 
	
	ArrayList<Object> listdata = new ArrayList<Object>();   
	 @EJB
	 SatisfactionService satisfactionservice;
	 
	 
	 @GET
	 @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	 public ArrayList<Object> getAll(){
		
			String lr=  satisfactionservice.consomation();		       
	        JSONArray array = new JSONArray(lr);
	        ArrayList<Object> listdata = new ArrayList<Object>();  
	        
	        if (array != null) { 
	           for (int i=0;i<array.length();i++){ 
	            listdata.add(array.get(i));
	           
	           } 
	        }
	        
		
	        return listdata;
			
		}
	 
	 public int getLikers(){
		    int likes=0;
		 
		   
		    
		    
		 	String likersList= satisfactionservice.EventLikers(4);		       
		 	JSONArray arrayLikers = new JSONArray(likersList);
		 	 if (arrayLikers != null) { 
		 		for (int i=0;i<arrayLikers.length();i++){ 
		 			JSONObject object = arrayLikers.getJSONObject(i);
		 			if(object.getInt("status")==2){
		 				likes=likes+1;
		 			}
        
		 		} 
		 	}
		 	  	
		 	
		return likes ;
		
	 }
	 public int getUnLikes(){
		    
		    int unLikes=0;
		   
		    
		    
		 	String likersList= satisfactionservice.EventLikers(4);		       
		 	JSONArray arrayLikers = new JSONArray(likersList);
		 	 if (arrayLikers != null) { 
		 		for (int i=0;i<arrayLikers.length();i++){ 
		 			JSONObject object = arrayLikers.getJSONObject(i);
		 			if(object.getInt("status")==1){
		 				unLikes=unLikes+1;
		 			}
     
		 		} 
		 	}
		 	  	
		 	
		return unLikes ;
		
	 }


	public int getNbr() {
		return nbr;
	}


	public void setNbr(int nbr) {
		this.nbr = nbr;
	}


	public int getNbb() {
		return nbb;
	}


	public void setNbb(int nbb) {
		this.nbb = nbb;
	}
	
	
}
