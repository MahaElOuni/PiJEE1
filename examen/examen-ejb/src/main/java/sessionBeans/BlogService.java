package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BlogService
 */
@Stateless
@LocalBean
public class BlogService implements BlogServiceRemote, BlogServiceLocal {

    /**
     * Default constructor. 
     */
    public BlogService() {
        // TODO Auto-generated constructor stub
    }

    
}
