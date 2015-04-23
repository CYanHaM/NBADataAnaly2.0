package bussinesslogic.playerinfobl;

import java.util.ArrayList;

import data.playerinfodata.PlayerInfoData;
import dataservice.playerinfodataservice.PlayerInfoDataService;
import PO.PlayerPO;
import VO.PlayerVO;
import blservice.playerinfoblservice.PlayerInfoService;
import bussinesslogic.Transfer.playerinfotrans.PO2VO;

public class PlayerInfo implements PlayerInfoService {

	PlayerInfoDataService fp = new PlayerInfoData();
	PO2VO p2v = new PO2VO();
	
	@Override
	public ArrayList<PlayerVO> showAllPlayerInfo() {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> po = fp.findAll();
		ArrayList<PlayerVO> vo =  p2v.list2vo(po);
		return vo;
	}

	@Override
	public PlayerVO showPlayerInfo(String name) {
		// TODO Auto-generated method stub
		PlayerPO po = fp.findOne(name);
		PlayerVO vo = p2v.po2vo(po);
		return vo;
	}

}
