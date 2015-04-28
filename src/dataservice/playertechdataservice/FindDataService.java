package dataservice.playertechdataservice;

import java.util.ArrayList;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;

public interface FindDataService {
	
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, String keyword);
	
	//璧涘鐑偣鐞冨憳
	public ArrayList<PlayerTechPO> findSeasonHotPlayer(String keyword);
	
	//杩涙鏈�蹇悆鍛�
	public ArrayList<PlayerTechPO> findFastImprovingPlayer();
	
	public ArrayList<PlayerTechPO> sift(PlayerTechPO po);
}
