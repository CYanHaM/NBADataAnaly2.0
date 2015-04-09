package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import VO.TeamVO;
import bussinesslogic.TeamBL.TeamLineItem;
import bussinesslogic.Transfer.L2V.TeamL2V;

public class TestTeamL2V extends TestCase{
	public void testL2V(){
		TeamL2V l2v = new TeamL2V();
		TeamLineItem tli = new TeamLineItem();
		tli.fullName = "hahaha";
		tli.abbreviation = "hhh";
		tli.location = "CNN";
		tli.division = "W";
		tli.partition = "hey";
		tli.homeCourt = "london";
		tli.time = "1955";
		
		TeamVO result = l2v.l2v(tli);
		TeamVO expected = new TeamVO();
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
