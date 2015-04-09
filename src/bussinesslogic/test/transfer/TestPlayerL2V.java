package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import VO.PlayerVO;
import bussinesslogic.PlayerBL.PlayerLineItem;
import bussinesslogic.Transfer.L2V.PlayerL2V;

public class TestPlayerL2V extends TestCase{
	public void testL2V(){
		PlayerL2V l2v = new PlayerL2V();
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
		PlayerVO result = l2v.l2v(pli);
		PlayerVO expected = new PlayerVO();
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
