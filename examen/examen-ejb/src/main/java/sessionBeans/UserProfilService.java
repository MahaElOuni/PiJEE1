package sessionBeans;

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
 * Session Bean implementation class UserProfilService
 */
@Stateless
@LocalBean
public class UserProfilService implements UserProfilServiceRemote, UserProfilServiceLocal {

    /**
     * Default constructor. 
     */
    public UserProfilService() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public String getProfilUserById(int id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/UserProfilAPI/Get?id="+id);
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        return result;
        
		
	}

}
