package bussinesslogic.Transfer.L2V;

import VO.PlayerTechVO;
import bussinesslogic.PlayerTechBL.PlayerTechLineItem;

public class PlayerTechL2V {
	PlayerTechVO ptvo = new PlayerTechVO();
	public PlayerTechVO l2v(PlayerTechLineItem ptli){
		ptvo.name = (ptli.name==null) ? null : ptli.name;
		ptvo.season = (ptli.season==null) ? null : ptli.season;
		ptvo.team = (ptli.team==null) ? null : ptli.team;
		ptvo.gameNum = ptli.gameNum;
		ptvo.startingNum = ptli.startingNum;
		ptvo.shotInRate = ptli.shotInRate;
		ptvo.threeShotInRate = ptli.threeShotInRate;
		ptvo.penaltyShotInRate = ptli.penaltyShotInRate;
		ptvo.efficiency = ptli.efficiency;
		ptvo.GmScEfficiency = ptli.GmScEfficiency;
		ptvo.trueShotInRate = ptli.trueShotInRate;
		ptvo.shootingEfficiency = ptli.shootingEfficiency;
		ptvo.reboundRate = ptli.reboundRate;
		ptvo.offensiveReboundRate = ptli.offensiveReboundRate;
		ptvo.defensiveReboundRate = ptli.defensiveReboundRate;
		ptvo.secondaryAttackRate = ptli.secondaryAttackRate;
		ptvo.stealRate = ptli.stealRate;
		ptvo.blockShotRate = ptli.blockShotRate;
		ptvo.faultRate = ptli.faultRate;
		ptvo.usageRate = ptli.usageRate;
		ptvo.offensiveNum = ptli.offensiveNum;
		ptvo.defensiveNum = ptli.defensiveNum;
		ptvo.steal = ptli.steal;
		ptvo.blockShot = ptli.blockShot;
		ptvo.fault = ptli.fault;
		ptvo.foul = ptli.foul;
		ptvo.score = ptli.score;
		ptvo.rebound = ptli.rebound;
		ptvo.secondaryAttack = ptli.secondaryAttack;
		ptvo.time = ptli.time;
		ptvo.offensiveNumave = ptli.offensiveNumave;
		ptvo.defensiveNumave = ptli.defensiveNumave;
		ptvo.stealave = ptli.stealave;
		ptvo.blockShotave = ptli.blockShotave;
		ptvo.faultave = ptli.faultave;
		ptvo.foulave = ptli.foulave;
		ptvo.scoreave = ptli.scoreave;
		ptvo.reboundave = ptli.reboundave;
		ptvo.secondaryAttackave = ptli.secondaryAttackave;
		ptvo.timeave = ptli.timeave;
		return ptvo;
	}
}
