package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import PO.PlayerPO;
import bussinesslogic.PlayerBL.PlayerLineItem;
import bussinesslogic.Transfer.L2P.PlayerL2P;

public class TestPlayerL2P extends TestCase{
	public void testL2P(){
		PlayerL2P l2p = new PlayerL2P();
		PlayerLineItem pli = new PlayerLineItem();
		pli.name = "ShouShou Bin";
		pli.age = 20;
		pli.birth = "1995/5/10";
		pli.exp = 0;
		pli.height = "5-5";
		pli.position = "bottom";
		pli.school = "NJU";
		pli.uniformNum = 0;
		pli.weight = 100;
		PlayerPO result = l2p.l2p(pli);
		PlayerPO expected = new PlayerPO();
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
