package data.playertechdata;

import java.util.ArrayList;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.FindDataService;
import dataservice.playertechdataservice.ShowDataService;

public class Find implements FindDataService {

	ShowDataService sh = new Show();
	OperateWithFile owf = new OperateWithFile();
	
	@Override
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, String keyword)  {
		// TODO Auto-generated method stub
		
    	return null;
	}

	@Override
	public ArrayList<PlayerTechPO> findSeasonHotPlayer(String keyword) {
		// TODO Auto-generated method stub
		String type = "";
		ArrayList<PlayerTechPO> list = sh.descend(type);
		ArrayList<PlayerTechPO> res = new ArrayList<PlayerTechPO>();
		for(int i=0;i<5;i++){
			res.add(list.get(i));
		}
		return res;
	}

	@Override
	public ArrayList<PlayerTechPO> findFastImprovingPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerTechPO> sift(PlayerTechPO po) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> res = new ArrayList<PlayerTechPO>();
		ArrayList<PlayerTechPO> list = owf.read();
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechPO temp = list.get(i);
			if(temp.score>=po.score&&temp.blockShot>=po.blockShot&&temp.rebound>=po.rebound
					&&temp.steal>=po.steal&&temp.secondaryAttack>=po.secondaryAttack){
				res.add(temp);
			}
		}
		return res;
	}

}
