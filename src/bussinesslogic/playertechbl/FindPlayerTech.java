package bussinesslogic.playertechbl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.playertechdata.Find;
import dataservice.playertechdataservice.FindDataService;
import PO.PlayerTechMPO;
import VO.PlayerTechMVO;
import VO.PlayerTechVO;
import VO.ScreeningConditionVO;
import blservice.playertechblservice.FindPlayerTechService;
import bussinesslogic.Transfer.PlayerTechTransfer;
import bussinesslogic.Transfer.P2L.MPO2MVO;

public class FindPlayerTech implements FindPlayerTechService{
/*
	public static void main(String[] args){
		FindPlayerTech fi = new FindPlayerTech();
		ArrayList<PlayerTechMVO> all = fi.findHotPlayerToday("2014-01-03", "blockshot");
		for(PlayerTechMVO mvo:all){
			System.out.println(mvo.name+" "+mvo.date);
		}
	}
*/
	
	FindDataService fd = new Find();
	PlayerTechTransfer tr = new PlayerTechTransfer();
	
	@Override
	public ArrayList<PlayerTechMVO> findHotPlayerToday(String date, String keyword) {
		// TODO Auto-generated method stub
		
		 ArrayList<PlayerTechMPO> list = fd.findHotPlayerToday(date, keyword);
		 MPO2MVO v2p = new MPO2MVO();
		 ShowPlayerTech sh = new ShowPlayerTech();
		 ArrayList<PlayerTechVO> tech = sh.showSeasonPlayerData();
		 int size = tech.size();
		 ArrayList<PlayerTechMVO> vo = v2p.list2vo(list);
		 for(int i=0;i<vo.size();i++){
			 PlayerTechMVO mvo = vo.get(i);
			 for(int j=0;j<size;j++){
				 if(tech.get(j).name.equals(mvo.name)){
					 PlayerTechVO te = tech.get(j);
					 mvo.blockShotImproving = te.blockShotImproving;
					 mvo.scoreImproving = te.scoreImproving;
					 mvo.stealImproving = te.stealImproving;
					 mvo.secondaryAttackImproving = te.secondaryAttackImproving;
					 mvo.reboundImproving = te.reboundImproving;
				 }
			 }
		 }
		return vo;
	}

	@Override
	public ArrayList<PlayerTechVO> findSeasonHotPlayer(final String keyword) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		//��������
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			
			public int compare(PlayerTechVO p2, PlayerTechVO p1) {   
				//��д�ȽϷ���
				switch(keyword){
				case "reboundave":
					if(p1.reboundave==p2.reboundave)
						return 0;
					else
						return (p1.reboundave-p2.reboundave)>0?1:-1;
				case "secondaryattackave":
					if (p1.secondaryAttackave==p2.secondaryAttackave)
						return 0;
					else
						return (p1.secondaryAttackave-p2.secondaryAttackave)>0?1:-1;	
				case "stealave":
					if(p1.stealave==p2.stealave)
						return 0;
					else
						return (p1.stealave-p2.stealave)>0?1:-1;
				case "blockshotave":
					if(p1.blockShotave==p2.blockShotave)
						return 0;
					else
						return (p1.blockShotave-p2.blockShotave)>0?1:-1;
				case "scoreave":
					if(p1.scoreave==p2.scoreave)
						return 0;
					else
						return (p1.scoreave-p2.scoreave)>0?1:-1;
				case "threeshotinrate":
					if(p1.threeShotInRate==p2.threeShotInRate)
						return 0;
					else
						return (p1.threeShotInRate-p2.threeShotInRate)>0?1:-1;
				case "shotinrate":
					if(p1.shotInRate==p2.shotInRate)
						return 0;
					else
						return (p1.shotInRate-p2.shotInRate)>0?1:-1;
				case "penaltyshotinrate":
					if(p1.penaltyShotInRate==p2.penaltyShotInRate)
						return 0;
					else
						return (p1.penaltyShotInRate-p2.penaltyShotInRate)>0?1:-1;
				case "double":
					return p1.ifDouble-p2.ifDouble;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		
		Collections.sort(all, comparator);
		for(int i=0;i<5;i++){
			res.add(all.get(i));
		}
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> findFastImprovingPlayer(final String keyword) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> list = sh.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		//��������
		Comparator<PlayerTechVO> comparator = new Comparator<PlayerTechVO>(){  
			public int compare(PlayerTechVO p1, PlayerTechVO p2) {   
				//��д�ȽϷ���
				switch(keyword){
				case "score":
					if(p2.scoreImproving==p1.scoreImproving)
						return 0;
					else
						return  (p2.scoreImproving>p1.scoreImproving)?1:-1;
				case "blockshot":
					if(p2.blockShotImproving==p1.blockShotImproving)
						return 0;
					else
						return (p2.blockShotImproving>p1.blockShotImproving)?1:-1;
				case "rebound":
					if(p2.reboundImproving==p1.reboundImproving)
						return 0;
					else
						return (p2.reboundImproving>p1.reboundImproving)?1:-1;
				case "secondaryAttack":
					if(p2.secondaryAttackImproving==p1.secondaryAttackImproving)
						return 0;
					else
						return (p2.secondaryAttackImproving>p1.secondaryAttackImproving)?1:-1;
				case "steal":
					if(p2.stealImproving==p1.stealImproving)
						return 0;
					else
						return (p2.stealImproving>p1.stealImproving)?1:-1;
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

	@Override
	public PlayerTechVO findPlayerTechByName(String name) {
		// TODO Auto-generated method stub
		ShowPlayerTech sh = new ShowPlayerTech();
		ArrayList<PlayerTechVO> all = sh.showSeasonPlayerData();
		int size = all.size();
		for(int i=0;i<size;i++){
			if(all.get(i).name.equals(name)){
				return all.get(i);
			}
		}
		return null;
	}

}
