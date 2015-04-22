package blservice.playertechblservice;

import java.util.ArrayList;

import VO.PlayerTechVO;

public interface FindPlayerTechService {
	
	//当天热点球员
	public ArrayList<PlayerTechVO> findHotPlayerToday(String date);
	
	//赛季热点球员
	public ArrayList<PlayerTechVO> findSeasonHotPlayer();
	
	//进步最快球员
	public ArrayList<PlayerTechVO> findFastImprovingPlayer();

}
