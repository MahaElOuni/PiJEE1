package sessionBeans;

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
	public User getProfilUserById(int id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:9233/api/UserProfilAPI/Get?id="+id);
    	WebTarget hello = target.path("");
        Response response=hello.request().get();
        String result= response.readEntity(String.class);
        
        System.out.println(result);
        JSONArray array = new JSONArray(result);
        User u = new User();
        if (array != null) { 
            for (int i=0;i<array.length();i++){ 
            	
            	JSONObject object = array.getJSONObject(i);
            	
            	
            	u.setId(object.getInt("Id"));
            	u.setFirstName(object.getString("FName"));
            	u.setLastName(object.getString("LName"));
            	u.setEmail(object.getString("Email"));
            	u.setEtat(object.getString("Etat"));
            	u.setRole(object.getString("Role"));
             
            } 
         }
        return u;
        
		
	}

}
