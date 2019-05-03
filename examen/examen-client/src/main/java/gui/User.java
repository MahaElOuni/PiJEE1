package gui;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionBeans.AdminServiceRemote;
import sessionBeans.LoginServiceRemote;



public class User {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ctx = new InitialContext();
		Object obj = ctx.lookup("/examen-ear/examen-ejb/LoginService!sessionBeans.LoginServiceRemote");
		Object objA = ctx.lookup("examen-ear/examen-ejb/AdminService!sessionBeans.AdminServiceRemote");
		LoginServiceRemote user=(LoginServiceRemote) obj;
		//user.getUsers();
		System.out.println(user.loginCheck("consultteck2019@gmail.com", "Admin2019*"));
		
		AdminServiceRemote admin= (AdminServiceRemote) objA;
		
//		System.out.println(admin.getEtatByIdUser(1));
//		System.out.println(admin.getRoleByIdUser(1));
//		
//		System.out.println(admin.getPendingUser().toString());
		
		admin.changeState(13,"Approved");
		
		
		
		
	}

}
