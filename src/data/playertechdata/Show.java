package data.playertechdata;

import java.util.ArrayList;

import PO.PlayerTechPO;
import dataservice.playertechdataservice.ShowDataService;

public class Show implements ShowDataService {

	OperateWithFile owf = new OperateWithFile();
	@Override
	public ArrayList<PlayerTechPO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.read();
		return list;
	}

	@Override
	public PlayerTechPO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.read();
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechPO po = list.get(i);
			if(po.name.equals(name)&&po.team.equals(team))
				return po;
		}
		return null;
	}

	@Override
	public ArrayList<PlayerTechPO> ascend(String type)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerTechPO> descend(String type) throws {
		// TODO Auto-generated method stub
		return null;
	}

}
