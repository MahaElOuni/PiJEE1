package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceRemote, AdminServiceLocal {

    /**
     * Default constructor. 
     */
    public AdminService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void getPendingUser() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/PendingUser");
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        System.out.println(result);
        response.close();
	}

	@Override
	public void getUsers() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/api/AdminAPI/Get");
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        System.out.println(result);
        response.close();
		
	}

}
