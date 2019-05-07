package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class BlogService
 */
@Stateless
@LocalBean
public class BlogService implements BlogServiceRemote, BlogServiceLocal {

	/**
	 * Default constructor.
	 */
	public BlogService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String consomation() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9233/api/BlogAPI/Get");

		Response response = target.request().get();
		String result = response.readEntity(String.class);

		// response.close();

		return result;
	}

	@Override
	public String consomationBlog(int BlogId) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9233/api/BlogAPI/Get/" + BlogId); 

		Response response = target.request().get();
		String result = response.readEntity(String.class);
		// System.out.println(result);
		// response.close();

		return result;
	}

}
