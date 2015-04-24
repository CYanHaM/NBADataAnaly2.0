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
	public ArrayList<PlayerTechVO> findSeasonHotPlayer(String keyword) {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = fd.findSeasonHotPlayer(keyword);
		 ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		 int size = list.size();
		 for(int i=0;i<size;i++){
			 PlayerTechVO vo = l2v.l2v(p2l.p2l(list.get(i)));
			 res.add(vo);
		 }
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> findFastImprovingPlayer(String keyword) {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechMPO> list = fd.findFastImprovingPlayer();
		//最近5场比赛数据
		 ArrayList<PlayerTechMPO> latest = new ArrayList<PlayerTechMPO>();
		 //list为之前数据
		int num=0;
		while(num<5){
			latest.add(list.get(0));
			list.remove(0);
			num++;
		}
		
		int latestScore = 0;
		int latestSteal=0;
		int latestBlockShot=0;
		int latestSecondaryAttack=0;
		int latestRebound=0;
		int score = 0;
		int steal=0;
		int blockShot=0;
		int secondaryAttack=0;
		int rebound=0;
		
		for(int i=0;i<5;i++){
			PlayerTechMPO mp =  latest.get(i);
			latestScore += mp.score;
			latestSteal += mp.steal;
			latestBlockShot += mp.blockShot;
			latestSecondaryAttack +=mp.secondaryAttack;
			latestRebound += mp.rebound;
		}
		
		int listSize = list.size();
		for(int i=0;i<listSize;i++){
			PlayerTechMPO mp =  list.get(i);
			score = mp.score;
			steal=mp.steal;
			blockShot=mp.blockShot;
			secondaryAttack=mp.secondaryAttack;
			rebound=mp.rebound;
		}
		
		double scoreImproving=((latestScore/5)-score/listSize)/(score/listSize);
	    double stealImproving=((latestSteal/5)-steal/listSize)/(steal/listSize);
		double blockShotImproving=((latestBlockShot/5)-blockShot/listSize)/(blockShot/listSize);
		double secondaryAttackImproving=((latestSecondaryAttack/5)-secondaryAttack/listSize)/(secondaryAttack/listSize);
		double reboundImproving=((rebound/5)-rebound/listSize)/(rebound/listSize);
			
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
