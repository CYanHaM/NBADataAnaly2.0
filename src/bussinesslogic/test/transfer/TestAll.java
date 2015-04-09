package bussinesslogic.test.transfer;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestAll extends TestSuite{
	public static Test suite() {
        TestSuite suite = new TestSuite("TestSuite Test");
        suite.addTestSuite(TestPlayerP2L.class);
        suite.addTestSuite(TestTeamP2L.class);
        suite.addTestSuite(TestPlayerTechP2L.class);
        suite.addTestSuite(TestTeamTechP2L.class);
        
        suite.addTestSuite(TestPlayerL2V.class);
        suite.addTestSuite(TestTeamL2V.class);
        suite.addTestSuite(TestPlayerTechL2V.class);
        suite.addTestSuite(TestTeamTechL2V.class);
        
        suite.addTestSuite(TestPlayerV2L.class);
        suite.addTestSuite(TestTeamV2L.class);
        suite.addTestSuite(TestPlayerTechV2L.class);
        suite.addTestSuite(TestTeamTechV2L.class);
        
        suite.addTestSuite(TestPlayerL2P.class);
        suite.addTestSuite(TestTeamL2P.class);
        suite.addTestSuite(TestPlayerTechL2P.class);
        suite.addTestSuite(TestTeamTechL2P.class);
        return suite;
    } 
    public static void main(String args[]){
        TestRunner.run(suite());
    } 
}
