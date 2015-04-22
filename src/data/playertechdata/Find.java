package data.playertechdata;

import java.util.ArrayList;

import PO.PlayerTechPO;
import dataservice.playertechdataservice.FindDataService;
import dataservice.playertechdataservice.ShowDataService;

public class Find implements FindDataService {

	ShowDataService sh = new Show();
	
	//待修改，将字符串改为筛选条件
	@Override
	public ArrayList<PlayerTechPO> findHotPlayerToday(String date)  {
		// TODO Auto-generated method stub
		String type = "";
		ArrayList<PlayerTechPO> list = sh.descend(type);
		ArrayList<PlayerTechPO> res = new ArrayList<PlayerTechPO>();
		int index = 0;
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechPO po = list.get(i);
		    if(po.date.equals(date)){
				res.add(list.get(i));
				index++;
				if(index==5)
					return res;
				}
			}
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

}
