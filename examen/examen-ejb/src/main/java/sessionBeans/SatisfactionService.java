package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

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

	
	
	
}
