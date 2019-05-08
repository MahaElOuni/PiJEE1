package sessionBeans;

import javax.ejb.Local;

@Local
public interface BlogServiceLocal {
	public String consomation();

	String consomationBlog(int BlogId);
	public String Add(String s );
	 public int getAll();
}
