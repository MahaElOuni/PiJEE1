package sessionBeans;

import javax.ejb.Remote;

@Remote
public interface EventServiceRemote {
	public String consomation();
	public String consomationPresidentEvent();
	public String consomationEvent(int eventId);
	public String consomationScheduler(int eventId);
	public String consomationEventLikers(int eventId);
	public int consomationParticipantNumber(int eventId);
	public String consomationOrganizerTasks(int eventId);
	public String consomationOrganizerEmail(int organizerID);

}
