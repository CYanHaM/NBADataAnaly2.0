package blservice.playertechblservice;

import java.util.ArrayList;

import VO.PlayerTechMVO;
import VO.PlayerTechVO;

public interface FindPlayerTechService {
	
	//褰撳ぉ鐑偣鐞冨憳
	public ArrayList<PlayerTechMVO> findHotPlayerToday(String date, String keyword);
	
	//璧涘鐑偣鐞冨憳
	public ArrayList<PlayerTechVO> findSeasonHotPlayer(String keyword);
	
	//杩涙鏈�蹇悆鍛�
	public ArrayList<PlayerTechVO> findFastImprovingPlayer(String keyword);
	
	public ArrayList<PlayerTechVO> sift(PlayerTechVO vo);
	
	public ArrayList<PlayerTechVO> findPlayerByLetter(char letter);   //按照字母查询

}
