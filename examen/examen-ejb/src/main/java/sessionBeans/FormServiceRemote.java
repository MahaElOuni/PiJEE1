package sessionBeans;

import java.util.List;

import javax.ejb.Remote;

import persistence.Form;

@Remote
public interface FormServiceRemote {
	public String consommationGet();
	public Form getById(int id);
	public String consommationGetByEvent();

}
