package bussinesslogic.Transfer.V2L;

import VO.MatchVO;
import bussinesslogic.matchbl.MatchLineItem;

public class MatchV2L {

	MatchLineItem mli=new MatchLineItem();
	public MatchLineItem v2l(MatchVO mv){
		 mli.season=mv.season;                                             //赛季
		 mli.date=mv.date;                                                 //日期
		 mli.homeTeam=mv.homeTeam;                                         //主场队伍
		 mli.guestTeam=mv.guestTeam;                                       //客场队伍
		 mli.score=mv.score;                                               //比分
		 mli.score1=mv.score1;                                             //第一节比分
		 mli.score2=mv.score2;                                             //第二节比分
		 mli.score3=mv.score3;                                             //第三节比分
		 mli.score4=mv.score4;                                             //第四节比分
		 mli.scoreExtra=mv.scoreExtra;                                     //加时赛比分
		 mli.playerStatistic=mv.playerStatistic;                           //球员技术统计
		 mli.scoringChampion=mv.scoringChampion;                           //得分王
		 mli.reboundChampion=mv.reboundChampion;                           //篮板王
		 mli.assistChampion=mv.assistChampion;                             //助攻王
		 mli.ifHomeTeamWin=mv.ifHomeTeamWin;                               //主队是否胜利
		 mli.ifGuestTeamWin=mv.ifGuestTeamWin;                             //客队是否胜利
		 mli.homeTeamDeffensiveRebound=mv.homeTeamDeffensiveRebound;       //主队防守篮板
		 mli.guestTeamDeffensiveRebound=mv.guestTeamDeffensiveRebound;     //客队防守篮板
		 mli.homeTeamOffensiveRebound=mv.homeTeamOffensiveRebound;         //主队进攻篮板
		 mli.guestTeamOffensiveRebound=mv.guestTeamOffensiveRebound;       //客队进攻篮板
		 mli.homeTeamOffensiveRound=mv.homeTeamOffensiveRound;             //主队进攻回合
		 mli.guestTeamOffensiveRound=mv.guestTeamOffensiveRound;           //客队进攻回合
		 mli.homeScore=mv.homeScore;                                       //主队得分
		 mli.guestScore=mv.guestScore;                                     //客队得分
		 mli.homeAllTime=mv.homeAllTime;                                   //主队全员上场时间
		 mli.guestAllTime=mv.guestAllTime;                                 //客队全员上场时间
		 mli.homeShotIn=mv.homeShotIn;                                     //主队总进球数
		 mli.guestShotIn=mv.guestShotIn;                                   //客队总进球数
		 mli.homeShot=mv.homeShot;                                         //主队出手次数
		 mli.guestShot=mv.guestShot;                                       //客队出手次数
		 mli.homeTwoShot=mv.homeTwoShot;                                   //主队两分出手次数
		 mli.guestTwoShot=mv.guestTwoShot;                                 //客队两分出手次数
		 mli.homeTwoShotIn=mv.homeTwoShotIn;                               //主队两分进球数
		 mli.guestTwoShotIn=mv.guestTwoShotIn;                             //客队两分进球数
		 mli.homeThreeShot=mv.homeThreeShot;                               //主队三分出手次数
		 mli.guestThreeShot=mv.guestThreeShot;                             //客队三分出手次数
		 mli.homeThreeShotIn=mv.homeThreeShotIn;                           //主队三分进球数
		 mli.guestThreeShotIn=mv.guestThreeShotIn;                         //客队三分进球数
		 mli.homePenaltyShot=mv.homePenaltyShot;                           //主队罚球次数
		 mli.guestPenaltyShot=mv.guestPenaltyShot;                         //客队罚球次数
		 mli.homePenaltyShotIn=mv.homePenaltyShotIn;                       //主队罚球进球数
		 mli.guestPenaltyShotIn=mv.guestPenaltyShotIn;                     //客队罚球进球数
		 mli.homeFoul=mv.homeFoul;                                         //主队失误次数
		 mli.guestFoul=mv.guestFoul;                                       //客队失误次数

		
		return mli;
		
	}

}
