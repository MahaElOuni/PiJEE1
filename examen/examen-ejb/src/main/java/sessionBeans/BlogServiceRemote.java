package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface BlogServiceRemote {
	public String consomation();
	String consomationBlog(int BlogId);
	public String Add(String s );
	 public int getAll();
}
