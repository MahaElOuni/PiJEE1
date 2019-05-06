package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface EventServiceRemote {
	public String consomation();
	public String consomationPresidentEvent();
	public String consomationEvent(int eventId);
	public String consomationScheduler(int eventId);

}
