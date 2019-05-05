package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface EventServiceRemote {
	public String consomation();
	public String consomationPresidentEvent();

}
