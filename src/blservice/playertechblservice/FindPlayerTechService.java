package blservice.playertechblservice;

import java.util.ArrayList;

import VO.PlayerTechMVO;
import VO.PlayerTechVO;

public interface FindPlayerTechService {
	
	//褰撳ぉ鐑偣鐞冨憳
	public ArrayList<PlayerTechMVO> findHotPlayerToday(String date, String keyword);
	
	//璧涘鐑偣鐞冨憳
	public ArrayList<PlayerTechVO> findSeasonHotPlayer();
	
	//杩涙鏈�蹇悆鍛�
	public ArrayList<PlayerTechVO> findFastImprovingPlayer();
	
	public ArrayList<PlayerTechVO> sift(PlayerTechVO vo);

}
