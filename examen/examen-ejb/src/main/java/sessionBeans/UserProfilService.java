package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

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
	public void getProfilUserById(int id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/api/UserProfilAPI/Get/{id}");
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        System.out.println(result);
        response.close();
		
	}

}
