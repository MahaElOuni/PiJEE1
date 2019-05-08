package sessionBeans;

import java.awt.Button;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

@Stateless
@LocalBean
public class SatisfactionService implements SatisfactionServiceLocal,SatisfactionServiceRemote {

	
	/**
     * Default constructor. 
     */
    public SatisfactionService () {
        // TODO Auto-generated constructor stub
    }
	
	
	public String consomation() {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Satisfaction/GET");
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		
		//response.close();
		System.out.println(result);
		return result;

}
	
	@Override
	public int EventLikers() {
		 int like=0;
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetEventLikers/4");
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		JSONArray array = new JSONArray(result);
     
        
        if (array != null) { 
            for (int i=0;i<array.length();i++){ 
            	
            	JSONObject object = array.getJSONObject(i);
            	if(object.getInt("status")==1){
            		like=like+1;
            	System.out.println(like);
            	}
             
            } 
         }
		
		return like;
	}
	
	 

	
	
	
}
