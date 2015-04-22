package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.MatchPO;
import PO.TeamPO;
import PO.TeamTechPO;
import dataservice.TeamTechDataService;

public class TeamTechData implements TeamTechDataService{

	readFrom rf = new DataProcessing();
	File file = new File("database/teamtech.txt");
	
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
					ttpo.gameNum++;																					//比赛场数
					if(match.ifHomeTeamWin==1)ttpo.winningNum++;													//胜场数
					ttpo.shotInNum = ttpo.shotInNum+match.homeShotIn;												//进球数
					ttpo.shotNum = ttpo.shotNum+match.homeShot;														//出手数
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.homeThreeShotIn;								//三分命中数
					ttpo.threeShotNum = ttpo.threeShotNum+match.homeThreeShot;										//三分出手数
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.homePenaltyShotIn;							//罚球命中数
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.homePenaltyShot;								//罚球出手数
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.homeTeamOffensiveRebound;					//进攻篮板
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.homeTeamDeffensiveRebound;					//防守篮板
					ttpo.foul = ttpo.foul+match.homeFoul;															//犯规
					ttpo.score = match.homeScore;																	//得分
					ttpo.offensiveRound = ttpo.offensiveRound+match.homeTeamOffensiveRound;							//进攻回合
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.guestTeamDeffensiveRebound;	//对手防守篮板
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.guestTeamOffensiveRebound;	//对手进攻篮板
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRebound+match.guestTeamOffensiveRound;		//对手进攻回合
					ttpo.opponentScore = ttpo.opponentScore+match.guestScore;										//对手得分
					for(int k = 0; k<match.playerStatistic.size();k++){												
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;//助攻
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;								//抢断
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;					//盖帽
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;								//失误
						}
					}
				}else if(match.guestTeam.equals(ttpo.name)){
					ttpo.gameNum++;																					//比赛场数
					if(match.ifGuestTeamWin==1)ttpo.winningNum++;													//胜场数
					ttpo.shotInNum = ttpo.shotInNum+match.guestShotIn;												//进球数
					ttpo.shotNum = ttpo.shotNum+match.guestShot;													//出手数
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.guestThreeShotIn;								//三分命中数
					ttpo.threeShotNum = ttpo.threeShotNum+match.guestThreeShot;										//三分出手数
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.guestPenaltyShotIn;							//罚球命中数
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.guestPenaltyShot;								//罚球出手数
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.guestTeamOffensiveRebound;					//进攻篮板
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.guestTeamDeffensiveRebound;					//防守篮板
					ttpo.foul = ttpo.foul+match.guestFoul;															//犯规
					ttpo.score = match.guestScore;																	//得分
					ttpo.offensiveRound = ttpo.offensiveRound+match.guestTeamOffensiveRound;						//进攻回合
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.homeTeamDeffensiveRebound;	//对手防守篮板
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.homeTeamOffensiveRebound;	//对手进攻篮板
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRebound+match.homeTeamOffensiveRound;		//对手进攻回合
					ttpo.opponentScore = ttpo.opponentScore+match.homeScore;										//对手得分
					for(int k = 0; k<match.playerStatistic.size();k++){
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;
						}
					}
				}
				ttpo.rebound = ttpo.offensiveRebound + ttpo.defensiveRebound;
				ttpo.shotInRate = ttpo.shotInNum/ttpo.shotNum;
				ttpo.threeShotInRate = ttpo.threeShotInNum/ttpo.threeShotNum;
				ttpo.penaltyShotInRate = ttpo.penaltyShotInNum/ttpo.penaltyShotNum;
				ttpo.offensiveEfficiency = ttpo.score/(ttpo.offensiveRound/100);
				ttpo.defensiveEfficiency = ttpo.score/(ttpo.opponentOffensiveRound/100);
				//ttpo.reboundEfficiency = ttpo.offensiveRebound/(ttpo.offensiveRebound+ttpo.opponentDefensiveRebound);
				ttpo.stealEfficiency = ttpo.steal/(ttpo.opponentOffensiveRound/100);
				ttpo.secondaryAttackEfficiency = ttpo.secondaryAttack/(ttpo.offensiveRound/100);
			}
			result.add(ttpo);
			try{
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(result);
				oos.close();
				oos.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
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
