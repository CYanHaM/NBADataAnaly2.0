package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.Find;
import dataservice.playertechdataservice.FindDataService;
import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import VO.PlayerTechMVO;
import VO.PlayerTechVO;
import blservice.playertechblservice.FindPlayerTechService;
import bussinesslogic.Transfer.L2P.PlayerTechL2P;
import bussinesslogic.Transfer.L2V.PlayerTechL2V;
import bussinesslogic.Transfer.P2L.MPO2MVO;
import bussinesslogic.Transfer.P2L.PlayerTechP2L;
import bussinesslogic.Transfer.V2L.PlayerTechV2L;

public class FindPlayerTech implements FindPlayerTechService{

	FindDataService fd = new Find();
	PlayerTechP2L p2l = new PlayerTechP2L();
	PlayerTechL2V l2v = new PlayerTechL2V();
	
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
		 ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		 int size = list.size();
		 for(int i=0;i<size;i++){
			 PlayerTechVO vo = l2v.l2v(p2l.p2l(list.get(i)));
			 res.add(vo);
		 }
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> findFastImprovingPlayer() {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = fd.findFastImprovingPlayer();
		 ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		 int size = list.size();
		 for(int i=0;i<size;i++){
			 PlayerTechVO vo = l2v.l2v(p2l.p2l(list.get(i)));
			 res.add(vo);
		 }
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> sift(PlayerTechVO vo) {
		// TODO Auto-generated method stub
		PlayerTechV2L v2l = new PlayerTechV2L();
		PlayerTechL2P l2p = new PlayerTechL2P();
		PlayerTechPO po = l2p.l2p(v2l.v2l(vo));
		ArrayList<PlayerTechPO> list= fd.sift(po);
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		 int size = list.size();
		 for(int i=0;i<size;i++){
			 PlayerTechVO v = l2v.l2v(p2l.p2l(list.get(i)));
			 res.add(v);
		 }
		return res;
	}

}
