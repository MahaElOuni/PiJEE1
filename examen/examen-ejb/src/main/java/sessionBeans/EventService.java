package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
		System.out.println(result);
		return result;
		
		
	}

}
