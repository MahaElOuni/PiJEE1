package sessionBeans;

import javax.ejb.Local;

@Local
public interface EventServiceLocal {
	public String consomation();
	public String consomationPresidentEvent();
	public String consomationEvent(int eventId);
	public String consomationScheduler(int eventId);
	public String consomationEventLikers(int eventId);

}
