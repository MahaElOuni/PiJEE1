package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import persistence.Form;

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
	public String consommationGetByEvent() {
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:9233/api/FormAPIController/ByEvent/");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	

		
	}

	@Override
	public Form getById(int id) {
			System.out.println("***** get condidate *****");
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://localhost:9233/api"); 
			WebTarget hello = target.path("FormAPIController/Get/"+id);     	
	    	Response res=(Response) hello.request().get();
	    	Form condi = res.readEntity(Form.class);
			 
			return condi;
	    }
		
	}

	
    
    


