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
				
				switch(type){
				case "name":
					return p1.name.compareTo(p2.name);
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
					if(p1.shotInRate==p2.shotInRate)
						return 0;
					else
						return  (p1.shotInRate-p2.shotInRate)>0?1:-1;
				case "threeshotinrate":
					if(p1.threeShotInRate==p2.threeShotInRate)
						return 0;
					else
						return  (p1.threeShotInRate-p2.threeShotInRate)>0?1:-1;
				case "penaltyshotinrate":
					if(p1.penaltyShotInRate==p2.penaltyShotInRate)
						return 0;
					else
						return  (p1.penaltyShotInRate-p2.penaltyShotInRate)>0?1:-1;
				case "efficiency":
					if(p1.efficiency==p2.efficiency)
						return 0;
					else
						return  (p1.efficiency-p2.efficiency)>0?1:-1;
				case "gmscefficiency":
					if(p1.GmScEfficiency==p2.GmScEfficiency)
						return 0;
					else
						return (p1.GmScEfficiency-p2.GmScEfficiency)>0?1:-1;
				case "trueshotinrate":
					if(p1.trueShotInRate==p2.trueShotInRate)
						return 0;
					else
						return  (p1.trueShotInRate-p2.trueShotInRate)>0?1:-1;
				case "shootingefficiency":
					if(p1.shootingEfficiency==p2.shootingEfficiency)
						return 0;
					else
						return  (p1.shootingEfficiency-p2.shootingEfficiency)>0?1:-1;
				case "reboundrate":
					if(p1.reboundRate==p2.reboundRate)
						return 0;
					else
						return  (p1.reboundRate-p2.reboundRate)>0?1:-1;
				case "offensivereboundrate":
					if(p1.offensiveReboundRate==p2.offensiveReboundRate)
						return 0;
					else
						return (p1.offensiveReboundRate-p2.offensiveReboundRate)>0?1:-1;
				case "defensivereboundrate":
					if(p1.defensiveReboundRate==p2.defensiveReboundRate)
						return 0;
					else
						return  (p1.defensiveReboundRate-p2.defensiveReboundRate)>0?1:-1;
				case "secondaryattackrate":
					if(p1.secondaryAttackRate==p2.secondaryAttackRate)
						return 0;
					else
						return (p1.secondaryAttackRate-p2.secondaryAttackRate)>0?1:-1;
				case "stealrate":
					if(p1.stealRate==p2.stealRate)
						return 0;
					else
						return (p1.stealRate-p2.stealRate)>0?1:-1;
				case "blockshotrate":
					if(p1.blockShotRate==p2.blockShotRate)
						return 0;
					else
						return (p1.blockShotRate-p2.blockShotRate)>0?1:-1;
				case "faultrate":
					if(p1.faultRate==p2.faultRate)
						return 0;
					else
						return (p1.faultRate-p2.faultRate)>0?1:-1;
				case "usagerate":
					if(p1.usageRate==p2.usageRate)
						return 0;
					else
						return  (p1.usageRate-p2.usageRate)>0?1:-1;
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
				//��д�ȽϷ���
				switch(type){
				case "name":
					return p1.name.compareTo(p2.name);
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
					if(p1.shotInRate==p2.shotInRate)
						return 0;
					else
						return  (p1.shotInRate-p2.shotInRate)>0?1:-1;
				case "threeshotinrate":
					if(p1.threeShotInRate==p2.threeShotInRate)
						return 0;
					else
						return  (p1.threeShotInRate-p2.threeShotInRate)>0?1:-1;
				case "penaltyshotinrate":
					if(p1.penaltyShotInRate==p2.penaltyShotInRate)
						return 0;
					else
						return  (p1.penaltyShotInRate-p2.penaltyShotInRate)>0?1:-1;
				case "efficiency":
					if(p1.efficiency==p2.efficiency)
						return 0;
					else
						return  (p1.efficiency-p2.efficiency)>0?1:-1;
				case "gmscefficiency":
					if(p1.GmScEfficiency==p2.GmScEfficiency)
						return 0;
					else
						return (p1.GmScEfficiency-p2.GmScEfficiency)>0?1:-1;
				case "trueshotinrate":
					if(p1.trueShotInRate==p2.trueShotInRate)
						return 0;
					else
						return  (p1.trueShotInRate-p2.trueShotInRate)>0?1:-1;
				case "shootingefficiency":
					if(p1.shootingEfficiency==p2.shootingEfficiency)
						return 0;
					else
						return  (p1.shootingEfficiency-p2.shootingEfficiency)>0?1:-1;
				case "reboundrate":
					if(p1.reboundRate==p2.reboundRate)
						return 0;
					else
						return  (p1.reboundRate-p2.reboundRate)>0?1:-1;
				case "offensivereboundrate":
					if(p1.offensiveReboundRate==p2.offensiveReboundRate)
						return 0;
					else
						return (p1.offensiveReboundRate-p2.offensiveReboundRate)>0?1:-1;
				case "defensivereboundrate":
					if(p1.defensiveReboundRate==p2.defensiveReboundRate)
						return 0;
					else
						return  (p1.defensiveReboundRate-p2.defensiveReboundRate)>0?1:-1;
				case "secondaryattackrate":
					if(p1.secondaryAttackRate==p2.secondaryAttackRate)
						return 0;
					else
						return (p1.secondaryAttackRate-p2.secondaryAttackRate)>0?1:-1;
				case "stealrate":
					if(p1.stealRate==p2.stealRate)
						return 0;
					else
						return (p1.stealRate-p2.stealRate)>0?1:-1;
				case "blockshotrate":
					if(p1.blockShotRate==p2.blockShotRate)
						return 0;
					else
						return (p1.blockShotRate-p2.blockShotRate)>0?1:-1;
				case "faultrate":
					if(p1.faultRate==p2.faultRate)
						return 0;
					else
						return (p1.faultRate-p2.faultRate)>0?1:-1;
				case "usagerate":
					if(p1.usageRate==p2.usageRate)
						return 0;
					else
						return  (p1.usageRate-p2.usageRate)>0?1:-1;
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
