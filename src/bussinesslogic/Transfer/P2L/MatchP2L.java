package bussinesslogic.Transfer.P2L;

import PO.MatchPO;
import bussinesslogic.matchbl.MatchLineItem;

public class MatchP2L {

	MatchLineItem mli=new MatchLineItem();
	public MatchLineItem p2l(MatchPO mp){
		 mli.season=mp.season;                                             //赛季
		 mli.date=mp.date;                                                 //日期
		 mli.homeTeam=mp.homeTeam;                                         //主场队伍
		 mli.guestTeam=mp.guestTeam;                                       //客场队伍
		 mli.score=mp.score;                                               //比分
		 mli.score1=mp.score1;                                             //第一节比分
		 mli.score2=mp.score2;                                             //第二节比分
		 mli.score3=mp.score3;                                             //第三节比分
		 mli.score4=mp.score4;                                             //第四节比分
		 mli.scoreExtra=mp.scoreExtra;                                     //加时赛比分
		 mli.playerStatistic=mp.playerStatistic;                           //球员技术统计
		 mli.scoringChampion=mp.scoringChampion;                           //得分王
		 mli.reboundChampion=mp.reboundChampion;                           //篮板王
		 mli.assistChampion=mp.assistChampion;                             //助攻王
		 mli.ifHomeTeamWin=mp.ifHomeTeamWin;                               //主队是否胜利
		 mli.ifGuestTeamWin=mp.ifGuestTeamWin;                             //客队是否胜利
		 mli.homeTeamDeffensiveRebound=mp.homeTeamDeffensiveRebound;       //主队防守篮板
		 mli.guestTeamDeffensiveRebound=mp.guestTeamDeffensiveRebound;     //客队防守篮板
		 mli.homeTeamOffensiveRebound=mp.homeTeamOffensiveRebound;         //主队进攻篮板
		 mli.guestTeamOffensiveRebound=mp.guestTeamOffensiveRebound;       //客队进攻篮板
		 mli.homeTeamOffensiveRound=mp.homeTeamOffensiveRound;             //主队进攻回合
		 mli.guestTeamOffensiveRound=mp.guestTeamOffensiveRound;           //客队进攻回合
		 mli.homeScore=mp.homeScore;                                       //主队得分
		 mli.guestScore=mp.guestScore;                                     //客队得分
		 mli.homeAllTime=mp.homeAllTime;                                   //主队全员上场时间
		 mli.guestAllTime=mp.guestAllTime;                                 //客队全员上场时间
		 mli.homeShotIn=mp.homeShotIn;                                     //主队总进球数
		 mli.guestShotIn=mp.guestShotIn;                                   //客队总进球数
		 mli.homeShot=mp.homeShot;                                         //主队出手次数
		 mli.guestShot=mp.guestShot;                                       //客队出手次数
		 mli.homeTwoShot=mp.homeTwoShot;                                   //主队两分出手次数
		 mli.guestTwoShot=mp.guestTwoShot;                                 //客队两分出手次数
		 mli.homeTwoShotIn=mp.homeTwoShotIn;                               //主队两分进球数
		 mli.guestTwoShotIn=mp.guestTwoShotIn;                             //客队两分进球数
		 mli.homeThreeShot=mp.homeThreeShot;                               //主队三分出手次数
		 mli.guestThreeShot=mp.guestThreeShot;                             //客队三分出手次数
		 mli.homeThreeShotIn=mp.homeThreeShotIn;                           //主队三分进球数
		 mli.guestThreeShotIn=mp.guestThreeShotIn;                         //客队三分进球数
		 mli.homePenaltyShot=mp.homePenaltyShot;                           //主队罚球次数
		 mli.guestPenaltyShot=mp.guestPenaltyShot;                         //客队罚球次数
		 mli.homePenaltyShotIn=mp.homePenaltyShotIn;                       //主队罚球进球数
		 mli.guestPenaltyShotIn=mp.guestPenaltyShotIn;                     //客队罚球进球数
		 mli.homeFoul=mp.homeFoul;                                         //主队失误次数
		 mli.guestFoul=mp.guestFoul;                                       //客队失误次数

		
		return mli;
		
	}

}
