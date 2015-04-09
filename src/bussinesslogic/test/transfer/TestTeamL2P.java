package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import PO.TeamPO;
import bussinesslogic.TeamBL.TeamLineItem;
import bussinesslogic.Transfer.L2P.TeamL2P;

public class TestTeamL2P extends TestCase{
	public void testL2P(){
		TeamL2P l2p = new TeamL2P();
		TeamLineItem tli = new TeamLineItem();
		tli.fullName = "hahaha";
		tli.abbreviation = "hhh";
		tli.location = "CNN";
		tli.division = "W";
		tli.partition = "hey";
		tli.homeCourt = "london";
		tli.time = "1955";
		
		TeamPO result = l2p.l2p(tli);
		TeamPO expected = new TeamPO();
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
