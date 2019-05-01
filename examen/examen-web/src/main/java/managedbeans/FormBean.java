package managedbeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
public class FormBean implements Serializable{

	private static final long serialVersionUID=1L;
	
	private int formId;
	private int EventId;
	private SexWeb sex;
	private int age;
	private String profession;
	private String mail;
	private String countrie;
	private String address;
	private Date FormDate;
	private String Pseudo;
	private String photos= "aaa";
	
	
	

	

}
