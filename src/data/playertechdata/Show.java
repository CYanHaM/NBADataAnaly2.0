package data.playertechdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import PO.PlayerTechPO;
import dataservice.playertechdataservice.ShowDataService;

public class Show implements ShowDataService {

	OperateWithFile owf = new OperateWithFile();
	@Override
	public ArrayList<PlayerTechPO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.read();
		return list;
	}

	@Override
	public PlayerTechPO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = owf.read();
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
					return (int) (p1.shotInRate-p2.shotInRate);
				case "threeshotinrate":
					return (int) (p1.threeShotInRate-p2.threeShotInRate);
				case "penaltyshotinrate":
					return (int) (p1.penaltyShotInRate-p2.penaltyShotInRate);
				case "efficiency":
					return (int) (p1.efficiency-p2.efficiency);
				case "gmscefficiency":
					return (int) (p1.GmScEfficiency-p2.GmScEfficiency);
				case "trueshotinrate":
					return (int) (p1.trueShotInRate-p2.trueShotInRate);
				case "shootingefficiency":
					return (int) (p1.shootingEfficiency-p2.shootingEfficiency);
				case "reboundrate":
					return (int) (p1.reboundRate-p2.reboundRate);
				case "offensivereboundrate":
					return (int) (p1.offensiveReboundRate-p2.offensiveReboundRate);
				case "defensivereboundrate":
					return (int) (p1.defensiveReboundRate-p2.defensiveReboundRate);
				case "secondaryattackrate":
					return (int) (p1.secondaryAttackRate-p2.secondaryAttackRate);
				case "stealrate":
					return (int) (p1.stealRate-p2.stealRate);
				case "blockshotrate":
					return (int) (p1.blockShotRate-p2.blockShotRate);
				case "faultrate":
					return (int) (p1.faultRate-p2.faultRate);
				case "usagerate":
					return (int) (p1.usageRate-p2.usageRate);
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		ArrayList<PlayerTechPO> list = owf.read();
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
					return (int) (p1.shotInRate-p2.shotInRate);
				case "threeshotinrate":
					return (int) (p1.threeShotInRate-p2.threeShotInRate);
				case "penaltyshotinrate":
					return (int) (p1.penaltyShotInRate-p2.penaltyShotInRate);
				case "efficiency":
					return (int) (p1.efficiency-p2.efficiency);
				case "gmscefficiency":
					return (int) (p1.GmScEfficiency-p2.GmScEfficiency);
				case "trueshotinrate":
					return (int) (p1.trueShotInRate-p2.trueShotInRate);
				case "shootingefficiency":
					return (int) (p1.shootingEfficiency-p2.shootingEfficiency);
				case "reboundrate":
					return (int) (p1.reboundRate-p2.reboundRate);
				case "offensivereboundrate":
					return (int) (p1.offensiveReboundRate-p2.offensiveReboundRate);
				case "defensivereboundrate":
					return (int) (p1.defensiveReboundRate-p2.defensiveReboundRate);
				case "secondaryattackrate":
					return (int) (p1.secondaryAttackRate-p2.secondaryAttackRate);
				case "stealrate":
					return (int) (p1.stealRate-p2.stealRate);
				case "blockshotrate":
					return (int) (p1.blockShotRate-p2.blockShotRate);
				case "faultrate":
					return (int) (p1.faultRate-p2.faultRate);
				case "usagerate":
					return (int) (p1.usageRate-p2.usageRate);
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		ArrayList<PlayerTechPO> list = owf.read();
		Collections.sort(list, comparator);
		return list;
	}

}
