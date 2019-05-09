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
		WebTarget target = client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/BlogAPI/Get");

		Response response = target.request().get();
		String result = response.readEntity(String.class);

		// response.close();

		return result;
	}

	@Override
	public String consomationBlog(int BlogId) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/BlogAPI/Get/" + BlogId);

		Response response = target.request().get();
		String result = response.readEntity(String.class);
		// System.out.println(result);
		// response.close();

		return result;
	}

	public String Add(String s) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/BlogAPI/rate");
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.post(Entity.entity(s, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}

	static javax.ws.rs.client.Client c = ClientBuilder.newClient();
	// set the appropriate URL
	static String getUrl = "http://webapicontroller1-dev.eu-west-1.elasticbeanstalk.com/api/BlogAPI/GetAllrat";

	public int getAll() {

		String lr = c.target(getUrl).request().get().readEntity(String.class);
		int count = Integer.parseInt(lr);
		return count;
	}
}
