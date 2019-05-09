package sessionBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

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
		WebTarget target= client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/FormAPIController/Get");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
		
			}

	@Override
	public String consommationGetByEvent() {
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/FormAPIController/ByEvent/");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	

		
	}

	@Override
	public Form getById(int id) {
			System.out.println("***** get condidate *****");
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api"); 
			WebTarget hello = target.path("FormAPIController/Get/"+id);     	
	    	Response res=(Response) hello.request().get();
	    	
	    	String s = res.readEntity(String.class);
	    	JSONObject object = new JSONObject(s);
	    	Form condi = new Form();
	    	
	    	condi.setAddress(object.getString("Address"));
	    	condi.setFormDate(object.getString("FormDate"));
	    	condi.setFormId(object.getInt("FormId"));
	    	condi.setPseudo(object.getString("Pseudo"));
	    	condi.setCin(object.getString("CIN"));
	    	condi.setSex(object.getInt("Sex"));
	    	condi.setAge(object.getInt("Age"));
	    	condi.setProfession(object.getString("Profession"));
	    	condi.setMail(object.getString("Mail"));
	    	condi.setCountrie(object.getString("Countrie"));
	    	condi.setParticipant(object.getBoolean("Participant"));
	    	condi.setEventId(object.getInt("EventId"));
	    	condi.setTitle(object.getString("Title"));
	    	condi.setMethodeDePayemment(object.getInt("MethodeDePayemment"));
	    	
	    	
	    	
	    	  
	    	
			 
			return condi;
	    }
		
	}

	
    
    


