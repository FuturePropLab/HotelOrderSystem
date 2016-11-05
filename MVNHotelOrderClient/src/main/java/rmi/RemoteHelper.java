package rmi;

import java.rmi.Remote;

import dataservice.LoginCheckService;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public LoginCheckService getLoginCheckService(){
		return (LoginCheckService )remote;
	}
	
	
}
