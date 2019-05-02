package gui;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionBeans.EventServiceRemote;

public class EventClient {

	public static void main(String[] args) throws NamingException {
		InitialContext ctx=new InitialContext();
		Object obj=ctx.lookup("/examen-ear/examen-ejb/EventService!sessionBeans.EventServiceRemote");
		EventServiceRemote client=(EventServiceRemote) obj;
		client.consomation();

	}

}
