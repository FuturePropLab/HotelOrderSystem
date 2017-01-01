package dataservice.impl;

import java.rmi.RemoteException;

import DataFactory.DataHelperUtils;
import dataservice.MemberDataService;
import dataservice.datahelper.MemberDataHelper;
import po.MemberPO;
import tools.ResultMessage_Member;

public class MemberDataServiceImpl implements MemberDataService {

	private MemberDataHelper memberDataHelper;
	
	public MemberDataServiceImpl(){
		this.memberDataHelper = DataHelperUtils.getMemberDataHelper();
	}
	
	public ResultMessage_Member modifyMember(MemberPO member) throws RemoteException{
		return memberDataHelper.modifyMemberPO(member);
	}

	public MemberPO getMember(String customerID) throws RemoteException{
		return memberDataHelper.getMemberByID(customerID);
	}

	@Override
	public int getLevel(String customerID) throws RemoteException {
		return memberDataHelper.getLevel(customerID);
	}

}
