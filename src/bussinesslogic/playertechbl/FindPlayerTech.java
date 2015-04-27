package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.playertechdata.Find;
import dataservice.playertechdataservice.FindDataService;
import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import VO.PlayerTechMVO;
import VO.PlayerTechVO;
import blservice.playertechblservice.FindPlayerTechService;
import bussinesslogic.Transfer.PlayerTechTransfer;
import bussinesslogic.Transfer.P2L.MPO2MVO;

public class FindPlayerTech implements FindPlayerTechService{

	FindDataService fd = new Find();
	PlayerTechTransfer tr = new PlayerTechTransfer();
	@Override
	public ArrayList<PlayerTechMVO> findHotPlayerToday(String date, String keyword) {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechMPO> list = fd.findHotPlayerToday(date, keyword);
		 MPO2MVO v2p = new MPO2MVO();
		 ArrayList<PlayerTechMVO> vo = v2p.list2vo(list);
		return vo;
	}

	@Override
	public ArrayList<PlayerTechVO> findSeasonHotPlayer(String keyword) {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = fd.findSeasonHotPlayer(keyword);
		 ArrayList<PlayerTechVO> res = tr.list2vo(list);
		return res;
	}

	@Override
	//根据姓名分类。
	public ArrayList<PlayerTechVO> findFastImprovingPlayer(final String keyword) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> list = sh.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		//降序排列
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			public int compare(PlayerTechVO p1, PlayerTechVO p2) {   
				//重写比较方法
				switch(keyword){
				case "score":
					return  (p2.scoreImproving>p1.scoreImproving)?1:-1;
				case "blockshot":
					return p2.blockShotImproving>p1.blockShotImproving?1:-1;
				case "rebound":
					return p2.reboundImproving>p1.reboundImproving?1:-1;
				case "secondaryAttack":
					return p2.secondaryAttackImproving>p1.secondaryAttackImproving?1:-1;
				case "steal":
					return p2.stealImproving>p1.stealImproving?1:-1;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		Collections.sort(list, comparator);
		for(int i=0;i<5;i++){
			res.add(list.get(i));
		}
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> sift(PlayerTechVO vo) {
		// TODO Auto-generated method stub
		PlayerTechPO po = tr.vo2po(vo);
		ArrayList<PlayerTechPO> list= fd.sift(po);
		ArrayList<PlayerTechVO> res = tr.list2vo(list);
		return res;
	}

}
