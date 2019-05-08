package ctr;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;

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
