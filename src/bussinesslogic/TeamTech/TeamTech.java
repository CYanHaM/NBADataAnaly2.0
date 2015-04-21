package bussinesslogic.TeamTech;

import java.util.ArrayList;

import PO.TeamTechPO;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import bussinesslogic.Transfer.L2V.TeamTechL2V;
import bussinesslogic.Transfer.P2L.TeamTechP2L;

public class TeamTech implements TeamTechBLservice{

	TeamTechDataservice ttdataservice = new TeamTechData();

	@Override
	public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType) {
		ArrayList<TeamTechPO> resultpo = new ArrayList<TeamTechPO>();
		String send = DataType.toString();
		resultpo = ttdataservice.ascend(send);
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			TeamTechP2L P2L = new TeamTechP2L();
			TeamTechL2V L2V = new TeamTechL2V();
			TeamTechLineItem tmp = new TeamTechLineItem();
			TeamTechVO temp = new TeamTechVO();
			tmp = P2L.p2l(resultpo.get(i));
			temp = L2V.l2v(tmp);
			result.add(temp);
		}
		return result;
	}

	@Override
	public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType) {
		ArrayList<TeamTechPO> resultpo = new ArrayList<TeamTechPO>();
		String send = DataType.toString();
		resultpo = ttdataservice.descend(send);
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			TeamTechP2L P2L = new TeamTechP2L();
			TeamTechL2V L2V = new TeamTechL2V();
			TeamTechLineItem tmp = new TeamTechLineItem();
			TeamTechVO temp = new TeamTechVO();
			tmp = P2L.p2l(resultpo.get(i));
			temp = L2V.l2v(tmp);
			result.add(temp);
		}
		return result;
	}
	
}
