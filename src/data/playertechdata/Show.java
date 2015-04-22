package data.playertechdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PlayerTechPO;
import dataservice.playertechdataservice.ShowDataService;

public class Show implements ShowDataService {

	@Override
	public ArrayList<PlayerTechPO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerTechPO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PlayerTechPO> ascend(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerTechPO> descend(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
