package sessionBeans;

import javax.ejb.Local;

import persistence.Form;

@Local
public interface FormServiceLocal {

	public String consommationGet();
	public Form getById(int id);
	public String consommationGetByEvent();

}
