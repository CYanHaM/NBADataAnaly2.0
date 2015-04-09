package bussinesslogic.TeamBL;

import PO.TeamPO;
import Rmi.LinkTeamService;
import VO.TeamVO;
import blservice.TeamBLservice;
import bussinesslogic.Transfer.L2P.TeamL2P;
import bussinesslogic.Transfer.L2V.TeamL2V;
import bussinesslogic.Transfer.P2L.TeamP2L;
import bussinesslogic.Transfer.V2L.TeamV2L;

public class Team implements TeamBLservice{
	LinkTeamService tdservice;
	public Team(){
			tdservice=new LinkTeamService();
	}
	
	@Override
	public TeamVO Show(TeamVO tvo) {
		// TODO Auto-generated method stub
		TeamP2L P2L = new TeamP2L();
		TeamV2L V2L = new TeamV2L();
		TeamL2P L2P = new TeamL2P();
		TeamL2V L2V = new TeamL2V();
		
		TeamLineItem temptli = V2L.v2l(tvo);
		TeamPO tpo = L2P.l2p(temptli);
		TeamPO resultpo = new TeamPO();
		resultpo = tdservice.find(tpo);
		TeamLineItem tli = P2L.p2l(resultpo);
		TeamVO result = L2V.l2v(tli);
		
		return result;
	}

}
