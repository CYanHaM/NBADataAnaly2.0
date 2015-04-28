package PO;
import java.io.Serializable;

public class PlayerTechMPO implements Serializable{
	
	/**
	 *每场比赛球员技术统计 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name;                         //姓名
	public String team;                         //队伍
	public String date;
	public String position;                     //位置
	public int time;                         //在场时间
	public int shotIn;                       //投篮命中数
	public int shot;                         //投篮出手数
	public int threeShotIn;                  //三分命中数
	public int threeShot;                    //三分出手数
	public int penaltyShotIn;                //罚球命中数
	public int penaltyShot;                  //罚球出手数
	public int offensiveRebound;             //前场篮板数
	public int defensiveRebound;             //后场篮板数
	public int rebound;                      //总篮板数
	public int secondaryAttack;              //助攻数
	public int steal;                        //抢断数
	public int blockShot;                    //盖帽数
	public int fault;                        //失误数
	public int foul;                         //犯规数
	public int score;                        //个人得分
	public int ifFirstLineUp;                 //是否先发
	public int ifParticipate;                 //是否参赛

	//场均的球队数据
	public int teamAllTime;                  //全队上场时间
	public int teamOffensiveRebound;                  //全队进攻篮板
	public int teamDefensiveRebound;                //全队防守篮板
	public int opponentOffensiveRebound;                  //对手进攻篮板
	public int opponentDefensiveRebound;                //对手防守篮板
	public int teamShotIn;                             //全队进球数
	public double opponentOffensiveNum;                     //对手进攻次数
	public int opponentTwoShot;                     //对手进攻两分球出手次数
	public int teamShot;                          //全队出手次数
	public int teamPenaltyShot;                   //全队罚球次数
	public int teamFault;                          //全队失误次数    
	

}
