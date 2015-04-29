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
		
		ttli.shotInNumave = ttli.shotInNum/ttpo.gameNum;
		ttli.shotNumave = ttli.shotNum/ttpo.gameNum;
		ttli.threeShotInNumave = ttli.threeShotInNum/ttpo.gameNum;
		ttli.threeShotNumave = ttli.threeShotNum/ttpo.gameNum;
		ttli.penaltyShotInNumave = ttli.penaltyShotInNum/ttpo.gameNum;
		ttli.penaltyShotNumave = ttli.penaltyShotNum/ttpo.gameNum;
		ttli.offensiveReboundave = ttli.offensiveRebound/ttpo.gameNum;
		ttli.defensiveReboundave = ttli.defensiveRebound/ttpo.gameNum;
		ttli.reboundave = ttli.rebound/ttpo.gameNum;
		ttli.secondaryAttackave = ttli.secondaryAttack/ttpo.gameNum;
		ttli.stealave = ttli.steal/ttpo.gameNum;
		ttli.blockShotave = ttli.blockShot/ttpo.gameNum;
		ttli.faultave = ttli.fault/ttpo.gameNum;
		ttli.foulave = ttli.foul/ttpo.gameNum;
		ttli.scoreave = ttli.score/ttpo.gameNum;
		ttli.offensiveRoundave = ttli.offensiveRound/ttpo.gameNum;
		
		ttli.winningNum = ttpo.winningNum;
		return ttli;
	}
}
