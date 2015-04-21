package data;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.MatchPO;
import PO.TeamPO;
import PO.TeamTechPO;
import dataservice.TeamTechDataService;

public class TeamTechData implements TeamTechDataService{

	readFrom rf = new DataProcessing();
	
	void WriteIn(){
		ArrayList<MatchPO> source = new ArrayList<MatchPO>();
		source = rf.matchRead();
		ArrayList<TeamPO> teams = new ArrayList<TeamPO>();
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		for(int i = 0; i<teams.size(); i++){
			TeamTechPO ttpo = new TeamTechPO();
			ttpo.name = teams.get(i).abbreviation;
			for(int j = 0; j<source.size(); j++){
				MatchPO match = new MatchPO();
				match = source.get(j);
				if(match.homeTeam.equals(ttpo.name)){
					ttpo.gameNum++;											//比赛场数
					if(match.ifHomeTeamWin==1)ttpo.winningNum++;			//胜场数
					
				}else if(match.guestTeam.equals(ttpo.name)){
					
				}
			}
			result.add(ttpo);
		}
	}
	
	@Override
	public ArrayList<TeamTechPO> ascend(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamTechPO> descend(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
