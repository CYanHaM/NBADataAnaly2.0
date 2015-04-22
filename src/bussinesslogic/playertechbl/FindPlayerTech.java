package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.Find;
import dataservice.playertechdataservice.FindDataService;
import PO.PlayerTechPO;
import VO.PlayerTechVO;
import blservice.playertechblservice.FindPlayerTechService;
import bussinesslogic.Transfer.playertechtrans.PO2VO;

public class FindPlayerTech implements FindPlayerTechService{

	FindDataService fd = new Find();
	PO2VO p2v = new PO2VO();
	//前5名,降序，date用不着
	@Override
	public ArrayList<PlayerTechVO> findHotPlayerToday(String date) {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = fd.findHotPlayerToday(date);
		 ArrayList<PlayerTechVO> vo = p2v.list2vo(list);
		return vo;
	}

	@Override
	public ArrayList<PlayerTechVO> findSeasonHotPlayer() {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = fd.findSeasonHotPlayer();
		 ArrayList<PlayerTechVO> vo = p2v.list2vo(list);
		return vo;
	}

	@Override
	public ArrayList<PlayerTechVO> findFastImprovingPlayer() {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = fd.findFastImprovingPlayer();
		 ArrayList<PlayerTechVO> vo = p2v.list2vo(list);
		return vo;
	}

}
