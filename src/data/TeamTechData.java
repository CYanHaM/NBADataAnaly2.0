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
					ttpo.gameNum++;																					//��������
					if(match.ifHomeTeamWin==1)ttpo.winningNum++;													//ʤ����
					ttpo.shotInNum = ttpo.shotInNum+match.homeShotIn;												//������
					ttpo.shotNum = ttpo.shotNum+match.homeShot;														//������
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.homeThreeShotIn;								//����������
					ttpo.threeShotNum = ttpo.threeShotNum+match.homeThreeShot;										//���ֳ�����
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.homePenaltyShotIn;							//����������
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.homePenaltyShot;								//���������
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.homeTeamOffensiveRebound;					//��������
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.homeTeamDeffensiveRebound;					//��������
					ttpo.foul = ttpo.foul+match.homeFoul;															//����
					ttpo.score = match.homeScore;																	//�÷�
					ttpo.offensiveRound = ttpo.offensiveRound+match.homeTeamOffensiveRound;							//�����غ�
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.guestTeamDeffensiveRebound;	//���ַ�������
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.guestTeamOffensiveRebound;	//���ֽ�������
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRebound+match.guestTeamOffensiveRound;		//���ֽ����غ�
					ttpo.opponentScore = ttpo.opponentScore+match.guestScore;										//���ֵ÷�
					for(int k = 0; k<match.playerStatistic.size();k++){												
						if(match.playerStatistic.get(k).team.equals(ttpo.name)){
							ttpo.secondaryAttack = ttpo.secondaryAttack+match.playerStatistic.get(k).secondaryAttack;//����
							ttpo.steal = ttpo.steal+match.playerStatistic.get(k).steal;								//����
							ttpo.blockShot = ttpo.blockShot+match.playerStatistic.get(k).blockShot;					//��ñ
							ttpo.fault = ttpo.fault+match.playerStatistic.get(k).fault;								//ʧ��
						}
					}
				}else if(match.guestTeam.equals(ttpo.name)){
					ttpo.gameNum++;																					//��������
					if(match.ifGuestTeamWin==1)ttpo.winningNum++;													//ʤ����
					ttpo.shotInNum = ttpo.shotInNum+match.guestShotIn;												//������
					ttpo.shotNum = ttpo.shotNum+match.guestShot;													//������
					ttpo.threeShotInNum = ttpo.threeShotInNum+match.guestThreeShotIn;								//����������
					ttpo.threeShotNum = ttpo.threeShotNum+match.guestThreeShot;										//���ֳ�����
					ttpo.penaltyShotInNum = ttpo.penaltyShotInNum+match.guestPenaltyShotIn;							//����������
					ttpo.penaltyShotNum = ttpo.penaltyShotNum+match.guestPenaltyShot;								//���������
					ttpo.offensiveRebound = ttpo.offensiveRebound+match.guestTeamOffensiveRebound;					//��������
					ttpo.defensiveRebound = ttpo.defensiveRebound+match.guestTeamDeffensiveRebound;					//��������
					ttpo.foul = ttpo.foul+match.guestFoul;															//����
					ttpo.score = match.guestScore;																	//�÷�
					ttpo.offensiveRound = ttpo.offensiveRound+match.guestTeamOffensiveRound;						//�����غ�
					ttpo.opponentDefensiveRebound = ttpo.opponentDefensiveRebound+match.homeTeamDeffensiveRebound;	//���ַ�������
					ttpo.opponentOffensiveRebound = ttpo.opponentOffensiveRebound+match.homeTeamOffensiveRebound;	//���ֽ�������
					ttpo.opponentOffensiveRound = ttpo.opponentOffensiveRebound+match.homeTeamOffensiveRound;		//���ֽ����غ�
					ttpo.opponentScore = ttpo.opponentScore+match.homeScore;										//���ֵ÷�
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
