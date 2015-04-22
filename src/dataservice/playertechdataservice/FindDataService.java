package dataservice.playertechdataservice;

import java.util.ArrayList;

import PO.PlayerTechPO;

public interface FindDataService {
	
	public ArrayList<PlayerTechPO> findHotPlayerToday(String date);
	
	//赛季热点球员
	public ArrayList<PlayerTechPO> findSeasonHotPlayer();
	
	//进步最快球员
	public ArrayList<PlayerTechPO> findFastImprovingPlayer();
}
