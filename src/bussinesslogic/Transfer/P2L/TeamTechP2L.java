package bussinesslogic.Transfer.P2L;

import PO.TeamTechPO;
import bussinesslogic.TeamTech.TeamTechLineItem;

public class TeamTechP2L {
	TeamTechLineItem ttli = new TeamTechLineItem();
	public TeamTechLineItem p2l(TeamTechPO ttpo){
		ttli.name = (ttpo.name==null) ? null : ttpo.name;
		ttli.season = (ttpo.season==null) ? null : ttpo.season;
		ttli.gameNum = ttpo.gameNum;
		ttli.shotInNum = ttpo.shotInNum;
		ttli.shotNum = ttpo.shotNum;
		ttli.threeShotInNum = ttpo.threeShotInNum;
		ttli.threeShotNum = ttpo.threeShotNum;
		ttli.penaltyShotInNum = ttpo.penaltyShotInNum;
		ttli.penaltyShotNum = ttpo.penaltyShotNum;
		ttli.offensiveRebound = ttpo.offensiveRebound;
		ttli.defensiveRebound = ttpo.defensiveRebound;
		ttli.rebound = ttpo.rebound;
		ttli.secondaryAttack = ttpo.secondaryAttack;
		ttli.steal = ttpo.steal;
		ttli.blockShot = ttpo.blockShot;
		ttli.fault = ttpo.fault;
		ttli.foul = ttpo.foul;
		ttli.score = ttpo.score;
		ttli.shotInRate = ttpo.shotInRate;
		ttli.threeShotInRate = ttpo.threeShotInRate;
		ttli.penaltyShotInRate = ttpo.penaltyShotInRate;
		ttli.winningRate = ttpo.winningRate;
		ttli.offensiveRound = ttpo.offensiveRound;
		ttli.offensiveEfficiency = ttpo.offensiveEfficiency;
		ttli.defensiveEfficiency = ttpo.defensiveEfficiency;
		ttli.reboundEfficiency = ttpo.reboundEfficiency;
		ttli.stealEfficiency = ttpo.stealEfficiency;
		ttli.secondaryAttackEfficiency = ttpo.secondaryAttackEfficiency;
		
		ttli.shotInNumave = ttli.shotInNum/82;
		ttli.shotNumave = ttli.shotNum/82;
		ttli.threeShotInNumave = ttli.threeShotInNum/82;
		ttli.threeShotNumave = ttli.threeShotNum/82;
		ttli.penaltyShotInNumave = ttli.penaltyShotInNum/82;
		ttli.penaltyShotNumave = ttli.penaltyShotNum/82;
		ttli.offensiveReboundave = ttli.offensiveRebound/82;
		ttli.defensiveReboundave = ttli.defensiveRebound/82;
		ttli.reboundave = ttli.rebound/82;
		ttli.secondaryAttackave = ttli.secondaryAttack/82;
		ttli.stealave = ttli.steal/82;
		ttli.blockShotave = ttli.blockShot/82;
		ttli.faultave = ttli.fault/82;
		ttli.foulave = ttli.foul/82;
		ttli.scoreave = ttli.score/82;
		ttli.offensiveRoundave = ttli.offensiveRound/82;
		
		ttli.winningNum = ttpo.winningNum;
		return ttli;
	}
}
