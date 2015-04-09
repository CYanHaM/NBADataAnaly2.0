package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import PO.PlayerTechPO;
import bussinesslogic.PlayerTechBL.PlayerTechLineItem;
import bussinesslogic.Transfer.L2P.PlayerTechL2P;

public class TestPlayerTechL2P extends TestCase{
	public void testL2P(){
		PlayerTechL2P l2p = new PlayerTechL2P();
		PlayerTechLineItem ptli = new PlayerTechLineItem();
		ptli.name = "ShouShou Bin";
		ptli.season = "13-14";
		ptli.team = "JiLao";
		ptli.gameNum = 82;
		ptli.startingNum = 81;
		ptli.shotInRate = 1;
		ptli.threeShotInRate = 2;
		ptli.penaltyShotInRate = 3;
		ptli.efficiency = 4;
		ptli.GmScEfficiency = 5;
		ptli.trueShotInRate = 6;
		ptli.shootingEfficiency = 7;
		ptli.reboundRate = 8;
		ptli.offensiveReboundRate = 9;
		ptli.defensiveReboundRate = 10;
		ptli.secondaryAttackRate = 11;
		ptli.stealRate = 12;
		ptli.blockShotRate = 13;
		ptli.faultRate = 14;
		ptli.usageRate = 15;
		
		ptli.offensiveNum = 82*16;
		ptli.defensiveNum = 82*17;
		ptli.steal = 82*18;
		ptli.blockShot = 82*19;
		ptli.fault = 82*20;
		ptli.foul = 82*21;
		ptli.score = 82*22;
		ptli.rebound = 82*23;
		ptli.secondaryAttack = 82*24;
		ptli.time = 82*25;
		
		PlayerTechPO result = l2p.l2p(ptli);
		PlayerTechPO expected = new PlayerTechPO();
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
		boolean test = expected.equals(result);
		assertTrue("tell me WHY!",test);
	}
}
