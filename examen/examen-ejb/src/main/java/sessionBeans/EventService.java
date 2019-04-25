package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EventService
 */
@Stateless
@LocalBean
public class EventService implements EventServiceRemote, EventServiceLocal {

    /**
     * Default constructor. 
     */
    public EventService() {
        // TODO Auto-generated constructor stub
    }

}
