package sessionBeans;

import javax.ejb.Local;

@Local
public interface EventServiceLocal {
	public String consomation();
	public String consomationPresidentEvent(int id);
	public String consomationEvent(int eventId);
	public String consomationScheduler(int eventId);
	public String consomationEventLikers(int eventId);
	public int consomationParticipantNumber(int eventId);
	public String consomationOrganizerTasks(int eventId);
	public String consomationOrganizerEmail(int organizerID);
	public void deleteEvent(int eventID);
	public String  addOrganizer(String organizer);
	public int getOrganizerId(String email);

}
