package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;



@Stateless
@LocalBean
public class RewardService implements RecommendationServiceLocal,RecommendationServiceRemote {

	
	/**
     * Default constructor. 
     */
    public RewardService () {
        // TODO Auto-generated constructor stub
    }
	
	
	public String consomation() {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/Reward/GET");
		
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		
		//response.close();
		System.out.println(result);
		return result;

}

	
	
}
