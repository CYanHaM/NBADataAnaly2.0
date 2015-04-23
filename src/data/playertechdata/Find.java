package data.playertechdata;

import java.util.ArrayList;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.FindDataService;
import dataservice.playertechdataservice.ShowDataService;

public class Find implements FindDataService {

	ShowDataService sh = new Show();
	
	//待修改，将字符串改为筛选条件
	@Override
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, String keyword)  {
		// TODO Auto-generated method stub
		
    	return null;
	}

	@Override
	public ArrayList<PlayerTechPO> findSeasonHotPlayer() {
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
		return null;
	}

}
