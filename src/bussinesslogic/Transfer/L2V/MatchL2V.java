package bussinesslogic.Transfer.L2V;

import bussinesslogic.matchbl.MatchLineItem;
import VO.MatchVO;

public class MatchL2V {

	MatchVO mv=new MatchVO();
	public MatchVO l2v(MatchLineItem mli){
		 mv.season=mli.season;                                             //赛季
		 mv.date=mli.date;                                                 //日期
		 mv.homeTeam=mli.homeTeam;                                         //主场队伍
		 mv.guestTeam=mli.guestTeam;                                       //客场队伍
		 mv.score=mli.score;                                               //比分
		 mv.score1=mli.score1;                                             //第一节比分
		 mv.score2=mli.score2;                                             //第二节比分
		 mv.score3=mli.score3;                                             //第三节比分
		 mv.score4=mli.score4;                                             //第四节比分
		 mv.scoreExtra=mli.scoreExtra;                                     //加时赛比分
		 mv.playerStatistic=mli.playerStatistic;                           //球员技术统计
		 mv.scoringChampion=mli.scoringChampion;                           //得分王
		 mv.reboundChampion=mli.reboundChampion;                           //篮板王
		 mv.assistChampion=mli.assistChampion;                             //助攻王
		 mv.ifHomeTeamWin=mli.ifHomeTeamWin;                               //主队是否胜利
		 mv.ifGuestTeamWin=mli.ifGuestTeamWin;                             //客队是否胜利
		 mv.homeTeamDeffensiveRebound=mli.homeTeamDeffensiveRebound;       //主队防守篮板
		 mv.guestTeamDeffensiveRebound=mli.guestTeamDeffensiveRebound;     //客队防守篮板
		 mv.homeTeamOffensiveRebound=mli.homeTeamOffensiveRebound;         //主队进攻篮板
		 mv.guestTeamOffensiveRebound=mli.guestTeamOffensiveRebound;       //客队进攻篮板
		 mv.homeTeamOffensiveRound=mli.homeTeamOffensiveRound;             //主队进攻回合
		 mv.guestTeamOffensiveRound=mli.guestTeamOffensiveRound;           //客队进攻回合
		 mv.homeScore=mli.homeScore;                                       //主队得分
		 mv.guestScore=mli.guestScore;                                     //客队得分
		 mv.homeAllTime=mli.homeAllTime;                                   //主队全员上场时间
		 mv.guestAllTime=mli.guestAllTime;                                 //客队全员上场时间
		 mv.homeShotIn=mli.homeShotIn;                                     //主队总进球数
		 mv.guestShotIn=mli.guestShotIn;                                   //客队总进球数
		 mv.homeShot=mli.homeShot;                                         //主队出手次数
		 mv.guestShot=mli.guestShot;                                       //客队出手次数
		 mv.homeTwoShot=mli.homeTwoShot;                                   //主队两分出手次数
		 mv.guestTwoShot=mli.guestTwoShot;                                 //客队两分出手次数
		 mv.homeTwoShotIn=mli.homeTwoShotIn;                               //主队两分进球数
		 mv.guestTwoShotIn=mli.guestTwoShotIn;                             //客队两分进球数
		 mv.homeThreeShot=mli.homeThreeShot;                               //主队三分出手次数
		 mv.guestThreeShot=mli.guestThreeShot;                             //客队三分出手次数
		 mv.homeThreeShotIn=mli.homeThreeShotIn;                           //主队三分进球数
		 mv.guestThreeShotIn=mli.guestThreeShotIn;                         //客队三分进球数
		 mv.homePenaltyShot=mli.homePenaltyShot;                           //主队罚球次数
		 mv.guestPenaltyShot=mli.guestPenaltyShot;                         //客队罚球次数
		 mv.homePenaltyShotIn=mli.homePenaltyShotIn;                       //主队罚球进球数
		 mv.guestPenaltyShotIn=mli.guestPenaltyShotIn;                     //客队罚球进球数
		 mv.homeFoul=mli.homeFoul;                                         //主队失误次数
		 mv.guestFoul=mli.guestFoul;                                       //客队失误次数

		
		return mv;
		
	}

}




