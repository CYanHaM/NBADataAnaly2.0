package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import VO.TeamVO;
import bussinesslogic.TeamBL.TeamLineItem;
import bussinesslogic.Transfer.V2L.TeamV2L;

public class TestTeamV2L extends TestCase{
	public void testV2L(){
		TeamV2L v2l = new TeamV2L();
		TeamVO tvo = new TeamVO();
		tvo.fullName = "hahaha";
		tvo.abbreviation = "hhh";
		tvo.location = "CNN";
		tvo.division = "W";
		tvo.partition = "hey";
		tvo.homeCourt = "london";
		tvo.time = "1955";
		
		TeamLineItem result = v2l.v2l(tvo);
		TeamLineItem expected = new TeamLineItem();
		expected.fullName = "hahaha";
		expected.abbreviation = "hhh";
		expected.location = "CNN";
		expected.division = "W";
		expected.partition = "hey";
		expected.homeCourt = "london";
		expected.time = "1955";
		boolean test = expected.equals(result);
		assertTrue("tell me WHY!",test);
	}
}
