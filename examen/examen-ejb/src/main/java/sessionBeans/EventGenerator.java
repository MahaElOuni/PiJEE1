package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Date;

/**
 * Session Bean implementation class EventGenerator
 */
@Singleton
@LocalBean
public class EventGenerator {

    /**
     * Default constructor. 
     */
    public EventGenerator() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private Event<Date> dateEvent;
 
    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void fireScheduledEvent() {
        dateEvent.fire(new Date());
    }

}
