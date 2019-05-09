package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class RecommendationService
 */
@Stateless
@LocalBean
public class RecommendationService implements RecommendationServiceRemote, RecommendationServiceLocal {

    
 
                 
    public RecommendationService() {
        // TODO Auto-generated constructor stub
    }
    	public String consomation() {
    		Client client=ClientBuilder.newClient();
    		WebTarget target=client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/Event/GetRecomByEvent");
    		
    		Response response=target.request().get();
    		String result=response.readEntity(String.class);
    		
    		//response.close();
    		System.out.println(result);
    		return result;
    
    }

}

