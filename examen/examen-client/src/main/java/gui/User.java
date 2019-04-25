package gui;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionBeans.LoginServiceRemote;



public class User {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ctx = new InitialContext();
		Object obj = ctx.lookup("/examen-ear/examen-ejb/LoginService!sessionBeans.LoginServiceRemote");
		
		LoginServiceRemote user=(LoginServiceRemote) obj;
		user.getUsers();
	}

}
