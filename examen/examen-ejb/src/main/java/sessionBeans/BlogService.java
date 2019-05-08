package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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

	public String Add(String s) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9233/api/BlogAPI/rate");
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.post(Entity.entity(s, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}

	static javax.ws.rs.client.Client c = ClientBuilder.newClient();
	// set the appropriate URL
	static String getUrl = "http://localhost:9233/api/BlogAPI/GetAllrat";

	public int getAll() {

		String lr = c.target(getUrl).request().get().readEntity(String.class);
		int count = Integer.parseInt(lr);
		return count;
	}
}
