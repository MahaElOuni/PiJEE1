package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RecommendationService
 */
@Stateless
@LocalBean
public class RecommendationService implements RecommendationServiceRemote, RecommendationServiceLocal {

    /**
     * Default constructor. 
     */
    public RecommendationService() {
        // TODO Auto-generated constructor stub
    }

}
