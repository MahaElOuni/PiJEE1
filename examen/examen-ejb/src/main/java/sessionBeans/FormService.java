package sessionBeans;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import entities.Form;

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

	public List<Form> ConsommationGetAll() {
		// TODO Auto-generated method stub
		
		List<Form> LF= new ArrayList<Form>();
		Client client=ClientBuilder.newClient();
		
		WebTarget web=client.target("http://localhost:9233/api/FormAPIController/Get");
		
		
		Response response= web.request().get();
		
		String result=response.readEntity(String.class);
		JsonReader jsonReader= Json.createReader(new StringReader(result));
		JsonArray object= jsonReader.readArray();
		for (int i=0; i<object.size(); i++)
		{
			Form f= new Form();
			f.setPseudo(object.getJsonObject(i).getString("Pseudo").toString());
			f.setAge(Integer.parseInt(object.getJsonObject(i).toString()));
			LF.add(f);
		}
	return LF;	

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
