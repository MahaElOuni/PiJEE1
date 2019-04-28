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
	public void ConsommationGetAll() {
		// TODO Auto-generated method stub
		
		Client client=ClientBuilder.newClient();
		
		WebTarget target=client.target("http://localhost:9233/api/FormAPIController/Get");
		
		WebTarget hello=target.path("");
		
		Response response= hello.request().get();
		
		String result=response.readEntity(String.class);
		
		System.out.println(result);
		response.close();
	

	}

	@Override
	public void ConsommationGetById(int id) {
		// TODO Auto-generated method stub
Client client=ClientBuilder.newClient();
		
		WebTarget target=client.target("http://localhost:9233/api/FormAPIController/Get/"+id);
		
		WebTarget hello=target.path("");
		
		Response response= hello.request().get();
		
		String result=response.readEntity(String.class);
		
		System.out.println(result);
		response.close();
	
		

		
	}

	@Override
	public void ConsommationGetByEvent(int id) {
		// TODO Auto-generated method stub
		Client client=ClientBuilder.newClient();
		
		WebTarget target=client.target("http://localhost:9233/api/FormAPIController/ByEvent/"+id);
		
		WebTarget hello=target.path("");
		
		Response response= hello.request().get();
		
		String result=response.readEntity(String.class);
		
		System.out.println(result);
		response.close();
	

	}

	@Override
	public void ConsommationDelete(int id) {
		// TODO Auto-generated method stub
Client client=ClientBuilder.newClient();
		
		WebTarget target=client.target("http://localhost:9233/api/FormAPIController/Delete/"+id);
		
		WebTarget hello=target.path("");
		
		Response response= hello.request().delete();
		
		String result=response.readEntity(String.class);
		
		System.out.println(result);
		response.close();

	}

	@Override
	public void ConsommationPost() {
		// TODO Auto-generated method stub
		
	}

}
