package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entities.Form;

@Local
public interface FormServiceLocal {

	public List<Form> ConsommationGetAll();
	public void ConsommationGetById(int id);
	public void ConsommationGetByEvent(int id);
	public void ConsommationDelete(int id);
	public void ConsommationPost();
}
