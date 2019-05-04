package sessionBeans;

import javax.ejb.Local;

@Local
public interface FormServiceLocal {

	public String consommationGet();
	public String consommationGetById(int id);
	public String consommationGetByEvent(int id);

}
