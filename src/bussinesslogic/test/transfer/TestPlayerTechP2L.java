package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import PO.PlayerTechPO;
import bussinesslogic.PlayerTechBL.PlayerTechLineItem;
import bussinesslogic.Transfer.P2L.PlayerTechP2L;

public class TestPlayerTechP2L extends TestCase{
	public void testP2L(){
		PlayerTechP2L p2l = new PlayerTechP2L();
		PlayerTechPO ptpo = new PlayerTechPO();
		ptpo.name = "ShouShou Bin";
		ptpo.season = "13-14";
		ptpo.team = "JiLao";
		ptpo.gameNum = 82;
		ptpo.startingNum = 81;
		ptpo.shotInRate = 1;
		ptpo.threeShotInRate = 2;
		ptpo.penaltyShotInRate = 3;
		ptpo.efficiency = 4;
		ptpo.GmScEfficiency = 5;
		ptpo.trueShotInRate = 6;
		ptpo.shootingEfficiency = 7;
		ptpo.reboundRate = 8;
		ptpo.offensiveReboundRate = 9;
		ptpo.defensiveReboundRate = 10;
		ptpo.secondaryAttackRate = 11;
		ptpo.stealRate = 12;
		ptpo.blockShotRate = 13;
		ptpo.faultRate = 14;
		ptpo.usageRate = 15;
		
		ptpo.offensiveNum = 82*16;
		ptpo.defensiveNum = 82*17;
		ptpo.steal = 82*18;
		ptpo.blockShot = 82*19;
		ptpo.fault = 82*20;
		ptpo.foul = 82*21;
		ptpo.score = 82*22;
		ptpo.rebound = 82*23;
		ptpo.secondaryAttack = 82*24;
		ptpo.time = 82*25;
		
		PlayerTechLineItem result = p2l.p2l(ptpo);
		PlayerTechLineItem expected = new PlayerTechLineItem();
		expected.name = "ShouShou Bin";
		expected.season = "13-14";
		expected.team = "JiLao";
		expected.gameNum = 82;
		expected.startingNum = 81;
		expected.shotInRate = 1;
		expected.threeShotInRate = 2;
		expected.penaltyShotInRate = 3;
		expected.efficiency = 4;
		expected.GmScEfficiency = 5;
		expected.trueShotInRate = 6;
		expected.shootingEfficiency = 7;
		expected.reboundRate = 8;
		expected.offensiveReboundRate = 9;
		expected.defensiveReboundRate = 10;
		expected.secondaryAttackRate = 11;
		expected.stealRate = 12;
		expected.blockShotRate = 13;
		expected.faultRate = 14;
		expected.usageRate = 15;
		expected.offensiveNum = 82*16;
		expected.defensiveNum = 82*17;
		expected.steal = 82*18;
		expected.blockShot = 82*19;
		expected.fault = 82*20;
		expected.foul = 82*21;
		expected.score = 82*22;
		expected.rebound = 82*23;
		expected.secondaryAttack = 82*24;
		expected.time = 82*25;
		expected.offensiveNumave = 16;
		expected.defensiveNumave = 17;
		expected.stealave = 18;
		expected.blockShotave = 19;
		expected.faultave = 20;
		expected.foulave = 21;
		expected.scoreave = 22;
		expected.reboundave = 23;
		expected.secondaryAttackave = 24;
		expected.timeave = 25;
		boolean test = expected.equals(result);
		assertTrue("tell me WHY!",test);
	}

}
