package bussinesslogic.Transfer.P2L;

import PO.PlayerTechPO;
import bussinesslogic.PlayerTechBL.PlayerTechLineItem;

public class PlayerTechP2L {
	PlayerTechLineItem ptli = new PlayerTechLineItem();
	public PlayerTechLineItem p2l(PlayerTechPO ptpo){
		ptli.name = (ptpo.name==null) ? null : ptpo.name;
		ptli.season = (ptpo.season==null) ? null : ptpo.season;
		ptli.team = (ptpo.team==null) ? null : ptpo.team;
		ptli.gameNum = ptpo.gameNum;
		ptli.startingNum = ptpo.startingNum;
		ptli.rebound = ptpo.rebound;
		ptli.secondaryAttack = ptpo.secondaryAttack;
		ptli.time = ptpo.time;
		ptli.shotInRate = ptpo.shotInRate;
		ptli.threeShotInRate = ptpo.threeShotInRate;
		ptli.penaltyShotInRate = ptpo.penaltyShotInRate;
		ptli.offensiveNum = ptpo.offensiveNum;
		ptli.defensiveNum = ptpo.defensiveNum;
		ptli.steal = ptpo.steal;
		ptli.blockShot = ptpo.blockShot;
		ptli.fault = ptpo.fault;
		ptli.foul = ptpo.foul;
		ptli.score = ptpo.score;
		ptli.efficiency = ptpo.efficiency;
		ptli.GmScEfficiency = ptpo.GmScEfficiency;
		ptli.trueShotInRate = ptpo.trueShotInRate;
		ptli.shootingEfficiency = ptpo.shootingEfficiency;
		ptli.reboundRate = ptpo.reboundRate;
		ptli.offensiveReboundRate = ptpo.offensiveReboundRate;
		ptli.defensiveReboundRate = ptpo.defensiveReboundRate;
		ptli.secondaryAttackRate = ptpo.secondaryAttackRate;
		ptli.stealRate = ptpo.stealRate;
		ptli.blockShotRate = ptpo.blockShotRate;
		ptli.faultRate = ptpo.faultRate;
		ptli.usageRate = ptpo.usageRate;
		
		ptli.offensiveNumave = ptli.offensiveNum/82;
		ptli.defensiveNumave = ptli.defensiveNum/82;
		ptli.stealave = ptli.steal/82;
		ptli.blockShotave = ptli.blockShot/82;
		ptli.faultave = ptli.fault/82;
		ptli.foulave = ptli.foul/82;
		ptli.scoreave = ptli.score/82;
		ptli.reboundave = ptli.rebound/82;
		ptli.secondaryAttackave = ptli.secondaryAttack/82;
		ptli.timeave = ptli.time/82;
		return ptli;
	}
}
