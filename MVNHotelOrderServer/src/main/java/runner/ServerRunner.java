package runner;

import Exception.DBException;
import dataservice.datahelper.LoginCheckDatahelper;
import dataservice.datahelper.impl.LoginCheckDatahelperImpl;
import rmi.RemoteHelper;
import tools.ResultMessage_Account;

public class ServerRunner {
	
	public ServerRunner() {
		new RemoteHelper();
	}
	
	public static void main(String[] args) throws DBException {
		System.out.println("Ready.....");
		new ServerRunner();
		System.out.println("Ready Well");
		
		LoginCheckDatahelper loginCheckDatahelper  = LoginCheckDatahelperImpl.getInstance();
		ResultMessage_Account rs = loginCheckDatahelper.deleteAll();
		if(rs==ResultMessage_Account.Fail){
			throw new DBException();
		}
		System.out.println("success!!!!!" );
	}
	
}
