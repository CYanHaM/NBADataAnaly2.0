package blservice.playerinfoblservice;

import java.util.ArrayList;

import VO.PlayerVO;

public interface PlayerInfoService {
	
	public ArrayList<PlayerVO> showAllPlayerInfo ();
	
	public PlayerVO showPlayerInfo (String name);
	
	public ArrayList<PlayerVO> findPlayerByLetter(char letter);   //按照字母查询


}
