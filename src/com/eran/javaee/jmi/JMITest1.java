package com.eran.javaee.jmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
/*
 * 1.小试牛刀，感觉还是很有意思的远程调用
 */
public class JMITest1 {
	public static void main(String[] args) {
		try {
			MyRemote service = (MyRemote)Naming.lookup("rmi://localhost:1099/Hello");
			String sayHello = service.sayHello();
			System.out.println(sayHello);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
