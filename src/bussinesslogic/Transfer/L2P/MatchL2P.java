package bussinesslogic.Transfer.L2P;

import bussinesslogic.matchbl.MatchLineItem;
import PO.MatchPO;

public class MatchL2P {
	MatchPO mp=new MatchPO();
	public MatchPO l2p(MatchLineItem mli){
		 mp.season=mli.season;                                             //赛季
		 mp.date=mli.date;                                                 //日期
		 mp.homeTeam=mli.homeTeam;                                         //主场队伍
		 mp.guestTeam=mli.guestTeam;                                       //客场队伍
		 mp.score=mli.score;                                               //比分
		 mp.score1=mli.score1;                                             //第一节比分
		 mp.score2=mli.score2;                                             //第二节比分
		 mp.score3=mli.score3;                                             //第三节比分
		 mp.score4=mli.score4;                                             //第四节比分
		 mp.scoreExtra=mli.scoreExtra;                                     //加时赛比分
		 mp.playerStatistic=mli.playerStatistic;                           //球员技术统计
		 mp.scoringChampion=mli.scoringChampion;                           //得分王
		 mp.reboundChampion=mli.reboundChampion;                           //篮板王
		 mp.assistChampion=mli.assistChampion;                             //助攻王
		 mp.ifHomeTeamWin=mli.ifHomeTeamWin;                               //主队是否胜利
		 mp.ifGuestTeamWin=mli.ifGuestTeamWin;                             //客队是否胜利
		 mp.homeTeamDeffensiveRebound=mli.homeTeamDeffensiveRebound;       //主队防守篮板
		 mp.guestTeamDeffensiveRebound=mli.guestTeamDeffensiveRebound;     //客队防守篮板
		 mp.homeTeamOffensiveRebound=mli.homeTeamOffensiveRebound;         //主队进攻篮板
		 mp.guestTeamOffensiveRebound=mli.guestTeamOffensiveRebound;       //客队进攻篮板
		 mp.homeTeamOffensiveRound=mli.homeTeamOffensiveRound;             //主队进攻回合
		 mp.guestTeamOffensiveRound=mli.guestTeamOffensiveRound;           //客队进攻回合
		 mp.homeScore=mli.homeScore;                                       //主队得分
		 mp.guestScore=mli.guestScore;                                     //客队得分
		 mp.homeAllTime=mli.homeAllTime;                                   //主队全员上场时间
		 mp.guestAllTime=mli.guestAllTime;                                 //客队全员上场时间
		 mp.homeShotIn=mli.homeShotIn;                                     //主队总进球数
		 mp.guestShotIn=mli.guestShotIn;                                   //客队总进球数
		 mp.homeShot=mli.homeShot;                                         //主队出手次数
		 mp.guestShot=mli.guestShot;                                       //客队出手次数
		 mp.homeTwoShot=mli.homeTwoShot;                                   //主队两分出手次数
		 mp.guestTwoShot=mli.guestTwoShot;                                 //客队两分出手次数
		 mp.homeTwoShotIn=mli.homeTwoShotIn;                               //主队两分进球数
		 mp.guestTwoShotIn=mli.guestTwoShotIn;                             //客队两分进球数
		 mp.homeThreeShot=mli.homeThreeShot;                               //主队三分出手次数
		 mp.guestThreeShot=mli.guestThreeShot;                             //客队三分出手次数
		 mp.homeThreeShotIn=mli.homeThreeShotIn;                           //主队三分进球数
		 mp.guestThreeShotIn=mli.guestThreeShotIn;                         //客队三分进球数
		 mp.homePenaltyShot=mli.homePenaltyShot;                           //主队罚球次数
		 mp.guestPenaltyShot=mli.guestPenaltyShot;                         //客队罚球次数
		 mp.homePenaltyShotIn=mli.homePenaltyShotIn;                       //主队罚球进球数
		 mp.guestPenaltyShotIn=mli.guestPenaltyShotIn;                     //客队罚球进球数
		 mp.homeFoul=mli.homeFoul;                                         //主队失误次数
		 mp.guestFoul=mli.guestFoul;                                       //客队失误次数

		
		return mp;
		
	}

}
