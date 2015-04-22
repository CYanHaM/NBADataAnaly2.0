package bussinesslogic.playerinfobl;

import java.util.ArrayList;

import data.playerinfodata.PlayerInfoData;
import dataservice.playerinfodataservice.PlayerInfoDataService;
import VO.PlayerVO;
import blservice.playerinfoblservice.PlayerInfoService;

public class PlayerInfo implements PlayerInfoService {

	PlayerInfoDataService fp = new PlayerInfoData();
	
	@Override
	public ArrayList<PlayerVO> showAllPlayerInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerVO showPlayerInfo(String name, String team) {
		// TODO Auto-generated method stub
		return null;
	}

}
