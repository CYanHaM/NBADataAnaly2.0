package data.playertechdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import data.DataProcessing;
import data.readFrom;
import PO.MatchPO;
import PO.PlayerTechMPO;
import PO.PlayerTechPO;

public class OperateWithFile {
	
	public void write(){
		
		
		
		ArrayList<PlayerTechMPO> mpoList = calculateTeam();
		ArrayList<PlayerTechPO> poList = new ArrayList<PlayerTechPO>();

		while(mpoList.size()!=0){
			int mpoSize = mpoList.size();
			//暂存同一球员的每场比赛数据。一轮处理完后丢弃。
			ArrayList<PlayerTechMPO> temp = new ArrayList<PlayerTechMPO>();
			temp.add(mpoList.get(0));
			String name = mpoList.get(0).name;
			String team = mpoList.get(0).team;
			for(int i=1;i<mpoSize;i++){
				PlayerTechMPO m = mpoList.get(i);
				if(m.name.equals(name)&&m.team.equals(team)){
					temp.add(m);
					m.name = "";
				}
			}
			mpoList.get(0).name = "";
			//将mpoList里已处理过的删除。
			Iterator<PlayerTechMPO> it = mpoList.iterator();
			while(it.hasNext()){  
			    PlayerTechMPO  tem = it.next();  
			    if(tem.name.equals("")){  
			    it.remove();  
			    }  
			} 
			//对temp进行处理。
			PlayerTechPO ptp = new PlayerTechPO();
			ptp.name = name;
			ptp.team = team;
			
			//场均数据相加而得
			ptp.gameNum = 0;
			ptp.startingNum = 0;
			ptp.rebound = 0;
			ptp.secondaryAttack = 0;
			ptp.time = 0;
			ptp.offensiveNum = 0;
			ptp.defensiveNum = 0;
			ptp.steal = 0;
			ptp.blockShot = 0;
			ptp.fault = 0;
			ptp.foul = 0;
			ptp.score = 0;
			ptp.shotIn = 0;
			ptp.shot = 0;
			ptp.threeShotIn = 0;
			ptp.threeShot = 0;
			ptp.penaltyShotIn = 0;
			ptp.penaltyShot = 0;
			ptp.teamAllTime = 0;
			ptp.teamOffensiveRebound = 0;
			ptp.teamDefensiveRebound = 0;
			ptp.opponentOffensiveRebound = 0;
			ptp.opponentDefensiveRebound = 0;
			ptp.teamShotIn = 0;
			ptp.opponentOffensiveNum = 0;
			ptp.opponentTwoShot = 0;
			ptp.teamShot = 0;
			ptp.teamPenaltyShot = 0;
			ptp.teamFault = 0;
			
			
			int tempSize = temp.size();
			for(int i=0;i<tempSize;i++){
				PlayerTechMPO mp = temp.get(i);
				//如果未参赛，则不必继续计算
				if(mp.ifParticipate==0)
					break;
				ptp.gameNum += mp.ifParticipate;
				ptp.startingNum += mp.ifFirstLineUp;
				ptp.rebound += mp.rebound;
				ptp.secondaryAttack += mp.secondaryAttack;
				ptp.time += mp.time;
				ptp.offensiveNum += mp.offensiveRebound;
				ptp.defensiveNum += mp.defensiveRebound;
				ptp.steal += mp.steal;
				ptp.blockShot += mp.blockShot;
				ptp.fault += mp.fault;
				ptp.foul += mp.foul;
				ptp.score += mp.score;
				ptp.shotIn += mp.shotIn;
				ptp.shot += mp.shot;
				ptp.threeShotIn += mp.threeShotIn;
				ptp.threeShot += mp.threeShot;
				ptp.penaltyShotIn += mp.penaltyShotIn;
				ptp.penaltyShot += mp.penaltyShot;
				
				ptp.teamAllTime = mp.teamAllTime;
				ptp.teamOffensiveRebound = mp.teamOffensiveRebound;
				ptp.teamDefensiveRebound = mp.teamDefensiveRebound;
				ptp.opponentOffensiveRebound = mp.opponentOffensiveRebound;
				ptp.opponentDefensiveRebound = mp.opponentDefensiveRebound;
				ptp.teamShotIn = mp.teamShotIn;
				ptp.opponentOffensiveNum = mp.opponentOffensiveNum;
				ptp.opponentTwoShot = mp.opponentTwoShot;
				ptp.teamShot = mp.teamShot;
				ptp.teamPenaltyShot = mp.teamPenaltyShot;
				ptp.teamFault = mp.teamFault;
				
			}
			//根据公式计算
			//公式疑问 球员出手数=投篮出手数还是=投篮出手数+罚球出手数？
			//除数不能为0
			ptp.shotInRate = (ptp.shot==0?0:ptp.shotIn/ptp.shot);
			ptp.threeShotInRate = (ptp.threeShot==0?0:ptp.threeShotIn/ptp.threeShot);
			ptp.penaltyShotInRate = (ptp.penaltyShot==0?0:ptp.penaltyShotIn/ptp.penaltyShot);
			ptp.efficiency = (ptp.score+ptp.rebound+ptp.secondaryAttack+ptp.steal+ptp.blockShot)-(ptp.shot-ptp.shotIn)
										-(ptp.penaltyShot-ptp.penaltyShotIn)-ptp.fault;
			ptp.GmScEfficiency = ptp.score+0.4*ptp.shotIn-0.7*ptp.shot-0.4*(ptp.penaltyShot-ptp.penaltyShotIn)+0.7*ptp.offensiveNum
					+0.3*ptp.defensiveNum+ptp.steal+0.7*ptp.secondaryAttack+0.7*ptp.blockShot-0.4*ptp.foul-ptp.fault;
			ptp.trueShotInRate = ptp.score/(2*(ptp.shot+0.44*ptp.penaltyShot));
			ptp.shootingEfficiency = (ptp.shotIn+0.5*ptp.threeShotIn)/ptp.shot;
			ptp.reboundRate = (ptp.offensiveNum+ptp.defensiveNum)*(ptp.teamAllTime/5)/ptp.time/(ptp.teamOffensiveRebound+
					ptp.teamDefensiveRebound+ptp.opponentOffensiveRebound+ptp.opponentDefensiveRebound);
			//对公式的疑问，只改篮板数？
			ptp.offensiveReboundRate = ptp.offensiveNum*(ptp.teamAllTime/5)/ptp.time/(ptp.teamOffensiveRebound+
					ptp.teamDefensiveRebound+ptp.opponentOffensiveRebound+ptp.opponentDefensiveRebound);
			ptp.defensiveReboundRate = ptp.defensiveNum*(ptp.teamAllTime/5)/ptp.time/(ptp.teamOffensiveRebound+
					ptp.teamDefensiveRebound+ptp.opponentOffensiveRebound+ptp.opponentDefensiveRebound);
			ptp.secondaryAttackRate = ptp.secondaryAttack/(ptp.time/(ptp.teamAllTime/5)*ptp.teamShotIn-ptp.shotIn);
			//公式疑问，多了个闭括号
			ptp.stealRate = ptp.steal*(ptp.teamAllTime/5)/ptp.time/ptp.opponentOffensiveNum;
			ptp.blockShotRate = ptp.blockShot*(ptp.teamAllTime/5)/ptp.time/ptp.opponentTwoShot;
			ptp.faultRate = ptp.fault/(ptp.shot-ptp.threeShot+0.44*ptp.penaltyShot+ptp.fault);
			ptp.usageRate = (ptp.shot+0.44*ptp.penaltyShot+ptp.fault)*(ptp.teamAllTime/5)/ptp.time/
					(ptp.teamShot+0.44*ptp.teamPenaltyShot+ptp.teamFault);
		
			poList.add(ptp);
		}
	  try {
        	FileOutputStream fos = new FileOutputStream("PlayerTechPO.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(poList);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	public ArrayList<PlayerTechPO> read(){
		ArrayList<PlayerTechPO> list = new ArrayList<PlayerTechPO>(); 
		try{
			FileInputStream fis = new FileInputStream("PlayerTech.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        list =  (ArrayList<PlayerTechPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return list;
	}
	
	public ArrayList<PlayerTechMPO> readMPO(){
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>(); 
		try{
			FileInputStream fis = new FileInputStream("PlayerTechMPO.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        res=  (ArrayList<PlayerTechMPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return res;
	}
	
	public ArrayList<PlayerTechMPO> calculateTeam(){
		
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>();
		
		readFrom rf = new DataProcessing();
		ArrayList<MatchPO> match = rf.matchRead();
		int matchSize = match.size();
		for(int i=0;i<matchSize;i++){
			MatchPO ma = match.get(i);
			ArrayList<PlayerTechMPO> list = ma.playerStatistic;
			
			int teamAllTime =ma.homeAllTime;                  //全队上场时间
			int teamOffensiveRebound = ma.homeTeamOffensiveRebound;                  //全队进攻篮板
			int teamDefensiveRebound = ma.homeTeamDeffensiveRebound;                //全队防守篮板
			int opponentOffensiveRebound = ma.guestTeamOffensiveRebound;                  //对手进攻篮板
			int opponentDefensiveRebound =ma.guestTeamDeffensiveRebound;                //对手防守篮板
		    int teamShotIn = ma.homeTwoShotIn+ma.homeThreeShotIn;                             //全队进球数
		    //疑问 进攻次数为进攻回合?单位不一致
			int opponentOffensiveNum = (int)ma.guestTeamOffensiveRound;                     //对手进攻次数
			int opponentTwoShot =ma.guestTwoShot;                     //对手进攻两分球出手次数
			int teamShot = ma.homeShot;                          //全队出手次数
		    int teamPenaltyShot =ma.homePenaltyShot;                   //全队罚球次数
			int teamFault = ma.homeFoul;                          //全队失误次数    
			
			int listSize = list.size();
			for(int j=0;j<listSize;j++){
				PlayerTechMPO mp = list.get(j);
				mp.teamAllTime = teamAllTime;
				mp.teamOffensiveRebound = teamOffensiveRebound;
				mp.teamDefensiveRebound = teamDefensiveRebound ;
				mp.opponentOffensiveRebound = opponentOffensiveRebound;
				mp.opponentDefensiveRebound = opponentDefensiveRebound;
				mp.teamShotIn = teamShotIn;
				mp.opponentOffensiveNum = opponentOffensiveNum;
				mp.opponentTwoShot = opponentTwoShot;
				mp.teamShot = teamShot;
				mp.teamPenaltyShot = teamPenaltyShot ;
				mp.teamFault = teamFault;
				res.add(mp);
			}
			
			//写入文件
	        try {
	        	FileOutputStream fos = new FileOutputStream("PlayerTechMPO.ser");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(res);
	            oos.flush();
	            oos.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
		return res;
	}

}
