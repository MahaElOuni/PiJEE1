package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class FormService
 */
@Stateless
@LocalBean
public class FormService implements FormServiceRemote, FormServiceLocal {

    /**
     * Default constructor. 
     */
    public FormService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String consommationGet() {
		// TODO Auto-generated method stub
		
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:9233/api/FormAPIController/Get");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	}

	@Override
	public String consommationGetByEvent(int id) {
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:9233/api/FormAPIController/ByEvent/"+id);
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	

		
	}

	@Override
	public String consommationGetById(int id) {
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:9233/api/FormAPIController/Get/"+id);
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;

	}

	
    
    

}
