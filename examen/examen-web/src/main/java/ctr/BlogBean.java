package ctr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import persistence.Report;
import sessionBeans.BlogService;

@ManagedBean(name = "blogBean")
@SessionScoped
public class BlogBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Report report1 = new Report();
	@EJB
	BlogService blogService;

	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)

	public ArrayList<Object> getAll() {

		String lr = blogService.consomation();
		JSONArray array = new JSONArray(lr);
		ArrayList<Object> listdata = new ArrayList<Object>();

		if (array != null) {
			for (int i = 0; i < array.length(); i++) {

				listdata.add(array.get(i));

			}
		}
		return listdata;
	}

	

	public String getPageDetails(int BlogId) {

		report1.setEventId(BlogId);
		return "/xhtml/BlogDetails?faces-redirect=true";

	}

	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Object getBlogDetail() {
		String lr = blogService.consomationBlog(report1.getEventId());
		JSONObject array = new JSONObject(lr);

		return array;

	}

}
