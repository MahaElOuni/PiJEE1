package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Session Bean implementation class LoginService
 */
@Stateless
@LocalBean
public class LoginService implements LoginServiceRemote, LoginServiceLocal {

    /**
     * Default constructor. 
     */
    public LoginService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Login() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("");
		WebTarget login=target.path("");
		
	}

}
