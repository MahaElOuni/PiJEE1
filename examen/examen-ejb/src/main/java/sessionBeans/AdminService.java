package sessionBeans;

import java.util.ArrayList;
import java.util.List;

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
	public List<User> getPendingUser() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/PendingUser");
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        
        JSONArray array = new JSONArray(result);
        List<User> listUser = new ArrayList<User>(); 
        
        if (array != null) { 
            for (int i=0;i<array.length();i++){ 
            	
            	JSONObject object = array.getJSONObject(i);
            	User u = new User();
            	
            	u.setId(object.getInt("Id"));
            	u.setFirstName(object.getString("FName"));
            	u.setLastName(object.getString("LName"));
            	u.setEmail(object.getString("Email"));
            	u.setEtat(object.getString("Etat"));
            	u.setRole(object.getString("Role"));
            	
            	listUser.add(u);
             
            } 
         }
        
        return listUser;

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
	
	@Override
	public String getEtatByIdUser(int id){
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/GetUserId?id="+id);
        String s = target.request().get().readEntity(String.class);
        JSONObject jo = new JSONObject(s);
		String etat = jo.getString("Etat");
		return etat;
	}
	
	@Override
	public String getRoleByIdUser(int id){
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/GetUserId?id="+id);
        String s = target.request().get().readEntity(String.class);
        JSONObject jo = new JSONObject(s);
		String role = jo.getString("Role");
		return role;	
	}
	
	@Override
	public void changeState(int id,String state){
		System.out.println("mel service admin "+id);
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/changeState?id="+id+"&state="+state);
        String s = target.request().get().readEntity(String.class);
        
	}
	@Override
	public String getAllUsers() {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/AdminAPI/Get");
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		return result;
		
	}
}
