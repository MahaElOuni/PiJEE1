package sessionBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.User;



/**
 * Session Bean implementation class EventService
 */
@Stateless
@LocalBean
public class EventService implements EventServiceRemote, EventServiceLocal {

    /**
     * Default constructor. 
     */
    public EventService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String consomation() {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/Get");
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		
		//response.close();
		
		return result;
	}

	@Override
	public String consomationPresidentEvent(int id) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetEventPresident/"+id);
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		
		//response.close();
		
		return result;
	}

	@Override
	public String consomationEvent(int eventId) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/Get/"+eventId);
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		//System.out.println(result);
		//response.close();
		
		return result;
	}

	@Override
	public String consomationScheduler(int eventId) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetScheduler/"+eventId);
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		//System.out.println(result);
		//response.close();
		
		return result;
	}
	
	@Override
	public String consomationEventLikers(int eventId) {
		 int like=0;
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetEventLikers/"+eventId);
		
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
		
		return result;
	}

	@Override
	public int consomationParticipantNumber(int eventId) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetParticipantNumber/"+eventId);
		
		Response response=target.request().get();
		int result=response.readEntity(int.class);
		
		//response.close();
		
		return result;
	}

	@Override
	public String consomationOrganizerTasks(int eventId) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetOrganizerTasks/"+eventId);
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		
		//response.close();
		
		return result;
	}

	@Override
	public String consomationOrganizerEmail(int organizerID) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Event/GetOrganizerEmail/"+organizerID);
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		
		//response.close();
		
		return result;
	}
	

}
