package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import PO.TeamPO;
import bussinesslogic.TeamBL.TeamLineItem;
import bussinesslogic.Transfer.P2L.TeamP2L;

public class TestTeamP2L extends TestCase{
	public void testP2L(){
		TeamP2L p2l = new TeamP2L();
		TeamPO tpo = new TeamPO();
		tpo.fullName = "hahaha";
		tpo.abbreviation = "hhh";
		tpo.location = "CNN";
		tpo.division = "W";
		tpo.partition = "hey";
		tpo.homeCourt = "london";
		tpo.time = "1955";
		
		TeamLineItem result = p2l.p2l(tpo);
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
