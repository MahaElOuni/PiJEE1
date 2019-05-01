package sessionBeans;

import java.io.CharArrayReader;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.stream.JsonParser;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

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
    
    public int loginCheck(String email,String password){
    	
    	int i;
    	Form form = new Form();
		form.param("Email",email);
		form.param("Password",password);
		
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:9233/api/LOGIN");
		
		try{
			
		String rep=target.request(MediaType.APPLICATION_JSON).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);	
		JSONObject jo = new JSONObject(rep);
		
		i = jo.getInt("Id");
		

		}catch(Exception e){
			return 0;
		};
        
        

       return i;
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
//       @GET
//   	
//   	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
//   	public ArrayList<Object> getAll(){
//   		
//   		String lr= sug.getAll();		       
//           JSONArray array = new JSONArray(lr);
//           ArrayList<Object> listdata = new ArrayList<Object>();     
//           
//           if (array != null) { 
//              for (int i=0;i<array.length();i++){ 
//               listdata.add(array.get(i));
//               System.out.println(array.get(i));
//              } 
//           }
//         
//          // 	System.out.println(array);
//           	//System.out.println(obj.getInt("id"));
//           return listdata;
   		
  // 	}
    	
    	
    	
    }
	

}
