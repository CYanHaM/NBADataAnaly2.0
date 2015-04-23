package bussinesslogic.Transfer.L2P;

import PO.PlayerTechPO;
import bussinesslogic.PlayerTechBL.PlayerTechLineItem;

public class PlayerTechL2P {
	PlayerTechPO ptpo = new PlayerTechPO();
	public PlayerTechPO l2p(PlayerTechLineItem ptli){
		ptpo.name = (ptli.name==null) ? null : ptli.name;
		ptpo.season = (ptli.season==null) ? null : ptli.season;
		ptpo.team = (ptli.team==null) ? null : ptli.team;
		ptpo.gameNum = ptli.gameNum;
		ptpo.startingNum = ptli.startingNum;
		ptpo.rebound = ptli.rebound;
		ptpo.secondaryAttack = ptli.secondaryAttack;
		ptpo.time = ptli.time;
		ptpo.shotInRate = ptli.shotInRate;
		ptpo.threeShotInRate = ptli.threeShotInRate;
		ptpo.penaltyShotInRate = ptli.penaltyShotInRate;
		ptpo.offensiveNum = ptli.offensiveNum;
		ptpo.defensiveNum = ptli.defensiveNum;
		ptpo.steal = ptli.steal;
		ptpo.blockShot = ptli.blockShot;
		ptpo.fault = ptli.fault;
		ptpo.foul = ptli.foul;
		ptpo.score = ptli.score;
		ptpo.efficiency = ptli.efficiency;
		ptpo.GmScEfficiency = ptli.GmScEfficiency;
		ptpo.trueShotInRate = ptli.trueShotInRate;
		ptpo.shootingEfficiency = ptli.shootingEfficiency;
		ptpo.reboundRate = ptli.reboundRate;
		ptpo.offensiveReboundRate = ptli.offensiveReboundRate;
		ptpo.defensiveReboundRate = ptli.defensiveReboundRate;
		ptpo.secondaryAttackRate = ptli.secondaryAttackRate;
		ptpo.stealRate = ptli.stealRate;
		ptpo.blockShotRate = ptli.blockShotRate;
		ptpo.faultRate = ptli.faultRate;
		ptpo.usageRate = ptli.usageRate;
		return ptpo;
	}
}
