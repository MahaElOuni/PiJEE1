package sessionBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

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
   
    public void getUsers(){
    	 Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/api/AdminAPI/Get");
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        System.out.println(result);
        response.close();

    }
	

}
