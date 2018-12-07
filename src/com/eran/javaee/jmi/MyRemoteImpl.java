package com.eran.javaee.jmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	protected MyRemoteImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello() {
		return "hello";
	}

public static void main(String[] args) {
 
		
		try {
			MyRemote service = new MyRemoteImpl();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/Hello", service);
			
			System.out.println("Ready...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
