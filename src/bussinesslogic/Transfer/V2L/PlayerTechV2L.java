package bussinesslogic.Transfer.V2L;

import VO.PlayerTechVO;
import bussinesslogic.PlayerTechBL.PlayerTechLineItem;

public class PlayerTechV2L {
	PlayerTechLineItem ptli = new PlayerTechLineItem();
	public PlayerTechLineItem v2l (PlayerTechVO ptvo){
		ptli.name = (ptvo.name==null) ? null : ptvo.name;
		ptli.season = (ptvo.season==null) ? null : ptvo.season;
		ptli.team = (ptvo.team==null) ? null : ptvo.team;
		ptli.gameNum = ptvo.gameNum;
		ptli.startingNum = ptvo.startingNum;
		ptli.shotInRate = ptvo.shotInRate;
		ptli.threeShotInRate = ptvo.threeShotInRate;
		ptli.penaltyShotInRate = ptvo.penaltyShotInRate;
		ptli.efficiency = ptvo.efficiency;
		ptli.GmScEfficiency = ptvo.GmScEfficiency;
		ptli.trueShotInRate = ptvo.trueShotInRate;
		ptli.shootingEfficiency = ptvo.shootingEfficiency;
		ptli.reboundRate = ptvo.reboundRate;
		ptli.offensiveReboundRate = ptvo.offensiveReboundRate;
		ptli.defensiveReboundRate = ptvo.defensiveReboundRate;
		ptli.secondaryAttackRate = ptvo.secondaryAttackRate;
		ptli.stealRate = ptvo.stealRate;
		ptli.blockShotRate = ptvo.blockShotRate;
		ptli.faultRate = ptvo.faultRate;
		ptli.usageRate = ptvo.usageRate;
		ptli.offensiveNum = ptvo.offensiveNum;
		ptli.defensiveNum = ptvo.defensiveNum;
		ptli.steal = ptvo.steal;
		ptli.blockShot = ptvo.blockShot;
		ptli.fault = ptvo.fault;
		ptli.foul = ptvo.foul;
		ptli.score = ptvo.score;
		ptli.rebound = ptvo.rebound;
		ptli.secondaryAttack = ptvo.secondaryAttack;
		ptli.time = ptvo.time;
		ptli.offensiveNumave = ptvo.offensiveNumave;
		ptli.defensiveNumave = ptvo.defensiveNumave;
		ptli.stealave = ptvo.stealave;
		ptli.blockShotave = ptvo.blockShotave;
		ptli.faultave = ptvo.faultave;
		ptli.foulave = ptvo.foulave;
		ptli.scoreave = ptvo.scoreave;
		ptli.reboundave = ptvo.reboundave;
		ptli.secondaryAttackave = ptvo.secondaryAttackave;
		ptli.timeave = ptvo.timeave;
		return ptli;
	}
}
