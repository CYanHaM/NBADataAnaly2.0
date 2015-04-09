package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import VO.PlayerVO;
import bussinesslogic.PlayerBL.PlayerLineItem;
import bussinesslogic.Transfer.V2L.PlayerV2L;

public class TestPlayerV2L extends TestCase{
	public void testV2L(){
		PlayerV2L v2l = new PlayerV2L();
		PlayerVO pvo = new PlayerVO();
		pvo.name = "ShouShou Bin";
		pvo.age = 20;
		pvo.birth = "1995/5/10";
		pvo.exp = 0;
		pvo.height = "5-5";
		pvo.position = "bottom";
		pvo.school = "NJU";
		pvo.uniformNum = 0;
		pvo.weight = 100;
		PlayerLineItem result = v2l.v2l(pvo);
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
