package gui;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionBeans.FormServiceRemote;

public class TestForm {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub

		InitialContext ctx= new InitialContext();
		Object obj=ctx.lookup("examen-ear/examen-ejb/FormService!sessionBeans.FormServiceRemote");
		FormServiceRemote client= (FormServiceRemote) obj;
		client.ConsommationGetAll();
		//client.Consommation2(19);
		//client.Consommation3(8);
		//client.delete(25);
		
	}

}
