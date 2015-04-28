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
import VO.ScreeningConditionVO;
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
	public ArrayList<PlayerTechVO> sift(ScreeningConditionVO vo) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		int size = all.size();
		for(int i=0;i<size;i++){
			PlayerTechVO pt = all.get(i);
			if(vo.condition.equals("score")){
				if(vo.comparison.equals(">=")){
					if(pt.score>=vo.number){
						res.add(pt);
					}
				}else{
					if(pt.score<=vo.number){
						res.add(pt);
					}
				}
			}else if(vo.condition.equals("blockshot")){
				if(vo.comparison.equals(">=")){
					if(pt.blockShot>=vo.number){
						res.add(pt);
					}
				}else{
					if(pt.blockShot<=vo.number){
						res.add(pt);
					}
				}
			}else if(vo.condition.equals("steal")){
				if(vo.comparison.equals(">=")){
					if(pt.steal>=vo.number){
						res.add(pt);
					}
				}else{
					if(pt.steal<=vo.number){
						res.add(pt);
					}
				}
			}else if(vo.condition.equals("secondaryattack")){
				if(vo.comparison.equals(">=")){
					if(pt.secondaryAttack>=vo.number){
						res.add(pt);
					}
				}else{
					if(pt.secondaryAttack<=vo.number){
						res.add(pt);
					}
				}
			}else if(vo.condition.equals("rebound")){
				if(vo.comparison.equals(">=")){
					if(pt.rebound>=vo.number){
						res.add(pt);
					}
				}else{
					if(pt.rebound<=vo.number){
						res.add(pt);
					}
				}
			}else{
				System.out.println("wrong condition");
			}
		}
		
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> findPlayerByLetter(char letter) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		int size = all.size();
		for(int i=0;i<size;i++){
			if(all.get(i).name.charAt(0)==letter)
				res.add(all.get(i));
		}
		return res;
	}

}
