package data.playertechdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.ShowDataService;

public class Show implements ShowDataService {

	public static void main(String[] args){
		Show sh = new Show();
	/*ArrayList<PlayerTechPO> all = sh.showSeasonPlayerData();
		for(int i=0;i<30;i++){
			PlayerTechPO mpo = all.get(i);
			System.out.println(mpo.name+" "+mpo.blockShot+" "+mpo.blockShotRate+" "+mpo.team);
		}*/
		
	/*
		PlayerTechPO po = sh.showKeyData("DeMarre Carroll", "ATL");
		System.out.println(po.name+" "+po.blockShotRate+" "+po.team);
		*/
	/*	ArrayList<PlayerTechPO> all = sh.ascend("blockshot");
		for(int i=400;i<430;i++){
			PlayerTechPO mpo = all.get(i);
			System.out.println(mpo.name+" "+mpo.blockShot+" "+mpo.blockShotRate+" "+mpo.team);
		}*/
		ArrayList<PlayerTechPO> all = sh.descend("blockshotrate");
		for(int i=0;i<30;i++){
			PlayerTechPO mpo = all.get(i);
			System.out.println(mpo.name+" "+mpo.blockShotRate+" "+mpo.team);
		}
	}
	OperateWithFile owf = new OperateWithFile();
	@Override
	public ArrayList<PlayerTechPO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.readPO();
		return list;
	}

	@Override
	public PlayerTechPO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.readPO();
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechPO po = list.get(i);
			if(po.name.equals(name)&&po.team.equals(team))
				return po;
		}
		return null;
	}

	@Override
	public ArrayList<PlayerTechPO> ascend(final String type)  {
		// TODO Auto-generated method stub
		Comparator<PlayerTechPO> comparator = new Comparator<PlayerTechPO>(){  
			public int compare(PlayerTechPO p1, PlayerTechPO p2) {   
				//重写比较方法
				switch(type){
				case "gamenum":
					return p1.gameNum-p2.gameNum;
				case "startingnum":
					return p1.startingNum-p2.startingNum;
				case "rebound":
					return p1.rebound-p2.rebound;
				case "secondaryAttack":
					return p1.secondaryAttack-p2.secondaryAttack;
				case "time":
					return p1.time-p2.time;
				case "offensivenum":
					return p1.offensiveNum-p2.offensiveNum;
				case "defensivenum":
					return p1.defensiveNum-p2.defensiveNum;
				case "steal":
					return p1.steal-p2.steal;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
				case "fault":
					return p1.fault-p2.fault;
				case "foul":
					return p1.foul-p2.foul;
				case "score":
					return p1.score-p2.score;
				case "shotin":
					return p1.shotIn-p2.shotIn;
				case "shot":
					return p1.shot-p2.shot;
				case "threeshotin":
					return p1.threeShotIn-p2.threeShotIn;
				case "threeshot":
					return p1.threeShot-p2.threeShot;
				case "penaltyshotin":
					return p1.penaltyShotIn-p2.penaltyShotIn;
				case "penaltyshot":
					return p1.penaltyShot-p2.penaltyShot;
				case "shotinrate":
					return  (p1.shotInRate-p2.shotInRate)>=0?1:-1;
				case "threeshotinrate":
					return  (p1.threeShotInRate-p2.threeShotInRate)>=0?1:-1;
				case "penaltyshotinrate":
					return  (p1.penaltyShotInRate-p2.penaltyShotInRate)>=0?1:-1;
				case "efficiency":
					return  (p1.efficiency-p2.efficiency)>=0?1:-1;
				case "gmscefficiency":
					return (p1.GmScEfficiency-p2.GmScEfficiency)>=0?1:-1;
				case "trueshotinrate":
					return  (p1.trueShotInRate-p2.trueShotInRate)>=0?1:-1;
				case "shootingefficiency":
					return  (p1.shootingEfficiency-p2.shootingEfficiency)>=0?1:-1;
				case "reboundrate":
					return  (p1.reboundRate-p2.reboundRate)>=0?1:-1;
				case "offensivereboundrate":
					return (p1.offensiveReboundRate-p2.offensiveReboundRate)>=0?1:-1;
				case "defensivereboundrate":
					return  (p1.defensiveReboundRate-p2.defensiveReboundRate)>=0?1:-1;
				case "secondaryattackrate":
					return (p1.secondaryAttackRate-p2.secondaryAttackRate)>=0?1:-1;
				case "stealrate":
					return (p1.stealRate-p2.stealRate)>=0?1:-1;
				case "blockshotrate":
					return (p1.blockShotRate-p2.blockShotRate)>=0?1:-1;
				case "faultrate":
					return (p1.faultRate-p2.faultRate)>=0?1:-1;
				case "usagerate":
					return  (p1.usageRate-p2.usageRate)>=0?1:-1;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		ArrayList<PlayerTechPO> list = owf.readPO();
		Collections.sort(list, comparator);
		return list;
	}

	@Override
	public ArrayList<PlayerTechPO> descend(final String type){
		// TODO Auto-generated method stub
		Comparator<PlayerTechPO> comparator = new Comparator<PlayerTechPO>(){  
			public int compare(PlayerTechPO p2, PlayerTechPO p1) {   
				//重写比较方法
				switch(type){
				case "gamenum":
					return p1.gameNum-p2.gameNum;
				case "startingnum":
					return p1.startingNum-p2.startingNum;
				case "rebound":
					return p1.rebound-p2.rebound;
				case "secondaryAttack":
					return p1.secondaryAttack-p2.secondaryAttack;
				case "time":
					return p1.time-p2.time;
				case "offensivenum":
					return p1.offensiveNum-p2.offensiveNum;
				case "defensivenum":
					return p1.defensiveNum-p2.defensiveNum;
				case "steal":
					return p1.steal-p2.steal;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
				case "fault":
					return p1.fault-p2.fault;
				case "foul":
					return p1.foul-p2.foul;
				case "score":
					return p1.score-p2.score;
				case "shotin":
					return p1.shotIn-p2.shotIn;
				case "shot":
					return p1.shot-p2.shot;
				case "threeshotin":
					return p1.threeShotIn-p2.threeShotIn;
				case "threeshot":
					return p1.threeShot-p2.threeShot;
				case "penaltyshotin":
					return p1.penaltyShotIn-p2.penaltyShotIn;
				case "penaltyshot":
					return p1.penaltyShot-p2.penaltyShot;
				case "shotinrate":
					return  (p1.shotInRate-p2.shotInRate)>=0?1:-1;
				case "threeshotinrate":
					return  (p1.threeShotInRate-p2.threeShotInRate)>=0?1:-1;
				case "penaltyshotinrate":
					return (p1.penaltyShotInRate-p2.penaltyShotInRate)>=0?1:-1;
				case "efficiency":
					return  (p1.efficiency-p2.efficiency)>=0?1:-1;
				case "gmscefficiency":
					return (p1.GmScEfficiency-p2.GmScEfficiency)>=0?1:-1;
				case "trueshotinrate":
					return  (p1.trueShotInRate-p2.trueShotInRate)>=0?1:-1;
				case "shootingefficiency":
					return (p1.shootingEfficiency-p2.shootingEfficiency)>=0?1:-1;
				case "reboundrate":
					return  (p1.reboundRate-p2.reboundRate)>=0?1:-1;
				case "offensivereboundrate":
					return  (p1.offensiveReboundRate-p2.offensiveReboundRate)>=0?1:-1;
				case "defensivereboundrate":
					return  (p1.defensiveReboundRate-p2.defensiveReboundRate)>=0?1:-1;
				case "secondaryattackrate":
					return  (p1.secondaryAttackRate-p2.secondaryAttackRate)>=0?1:-1;
				case "stealrate":
					return  (p1.stealRate-p2.stealRate)>=0?1:-1;
				case "blockshotrate":
					return  (p1.blockShotRate-p2.blockShotRate)>=0?1:-1;
				case "faultrate":
					return  (p1.faultRate-p2.faultRate)>=0?1:-1;
				case "usagerate":
					return  (p1.usageRate-p2.usageRate)>=0?1:-1;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		ArrayList<PlayerTechPO> list = owf.readPO();
		Collections.sort(list, comparator);
		return list;
	}
	
	public void refresh(){
		owf.write();
		
	}

}
