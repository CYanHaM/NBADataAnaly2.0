package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.Find;
import dataservice.playertechdataservice.FindDataService;
import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import VO.PlayerTechMVO;
import VO.PlayerTechVO;
import blservice.playertechblservice.FindPlayerTechService;
import bussinesslogic.Transfer.playertechtrans.MPO2MVO;
import bussinesslogic.Transfer.playertechtrans.PO2VO;
import bussinesslogic.Transfer.playertechtrans.VO2PO;

public class FindPlayerTech implements FindPlayerTechService{

	FindDataService fd = new Find();
	PO2VO p2v = new PO2VO();
	
	@Override
	public ArrayList<PlayerTechMVO> findHotPlayerToday(String date, String keyword) {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechMPO> list = fd.findHotPlayerToday(date, keyword);
		 MPO2MVO v2p = new MPO2MVO();
		 ArrayList<PlayerTechMVO> vo = v2p.list2vo(list);
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

	@Override
	public ArrayList<PlayerTechVO> sift(PlayerTechVO vo) {
		// TODO Auto-generated method stub
		VO2PO v2p = new VO2PO();
		PlayerTechPO po = v2p.vo2po(vo);
		ArrayList<PlayerTechPO> list= fd.sift(po);
		ArrayList<PlayerTechVO> res = p2v.list2vo(list);
		return res;
	}

}
