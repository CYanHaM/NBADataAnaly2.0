package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import PO.PlayerPO;
import bussinesslogic.PlayerBL.PlayerLineItem;
import bussinesslogic.Transfer.P2L.PlayerP2L;

public class TestPlayerP2L extends TestCase{
	public void testP2L(){
		PlayerP2L p2l = new PlayerP2L();
		PlayerPO ppo = new PlayerPO();
		ppo.name = "ShouShou Bin";
		ppo.age = 20;
		ppo.birth = "1995/5/10";
		ppo.exp = 0;
		ppo.height = "5-5";
		ppo.position = "bottom";
		ppo.school = "NJU";
		ppo.uniformNum = 0;
		ppo.weight = 100;
		PlayerLineItem result = p2l.p2l(ppo);
		PlayerLineItem expected = new PlayerLineItem();
		expected.name = "ShouShou Bin";
		expected.age = 20;
		expected.birth = "1995/5/10";
		expected.exp = 0;
		expected.height = "5-5";
		expected.position = "bottom";
		expected.school = "NJU";
		expected.uniformNum = 0;
		expected.weight = 100;
		boolean test = expected.equals(result);
		assertTrue("tell me WHY!",test);
	}
}
