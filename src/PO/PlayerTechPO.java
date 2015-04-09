package PO;
import java.io.Serializable;

import VO.PlayerTechVO;


public class PlayerTechPO implements Serializable{
	/**
	 * 赛季球员总数据
	 */
	public static final long serialVersionUID = 1L;
	public int index ;                             //编号
	public String name;                            //球员名称
	public String season;                          //赛季
	public String team;                            //所属球队
	public int gameNum;                         //参赛场数
	public int startingNum;                     //先发场数
	public int rebound;                         //篮板数
	public int secondaryAttack;                 //助攻数
	public int time;                            //在场时间
	public double shotInRate;                      //投篮命中率
	public double threeShotInRate;                 //三分命中率
	public double penaltyShotInRate;               //罚球命中率
	public int offensiveNum;                    //进攻数
	public int defensiveNum;                    //防守数
	public int steal;                           //抢断数
	public int blockShot;                       //盖帽数
	public int fault;                           //失误数
	public int foul;                            //犯规数
	public int score;                           //得分
	public double efficiency;                        //效率
	public double GmScEfficiency;                    //GmSc效率值
	public double trueShotInRate;                  //真实命中率
	public double shootingEfficiency;                //投篮效率
	public double reboundRate;                     //篮板率
	public double offensiveReboundRate;            //进攻篮板率
	public double defensiveReboundRate;            //防守篮板率
	public double secondaryAttackRate;             //助攻率
	public double stealRate;                       //抢断率
	public double blockShotRate;                   //盖帽率
	public double faultRate;                       //失误率	
	public double usageRate;                       //使用率
	public int shotIn;                       //投篮命中数
	public int shot;                         //投篮出手数
	public int threeShotIn;                  //三分命中数
	public int threeShot;                    //三分出手数
	public int penaltyShotIn;                //罚球命中数
	public int penaltyShot;                  //罚球出手数
	public int teamAllTime;                  //全队上场时间
	public int teamOffensiveRebound;                  //全队进攻篮板
	public int teamDefensiveRebound;                //全队防守篮板
	public int opponentOffensiveRebound;                  //对手进攻篮板
	public int opponentDefensiveRebound;                //对手防守篮板
	public int teamShotIn;                             //全队进球数
	public int opponentOffensiveNum;                     //对手进攻次数
	public int opponentTwoShot;                     //对手进攻两分球出手次数
	public int teamShot;                          //全队出手次数
	public int teamPenaltyShot;                   //全队罚球次数
	public int teamFault;                          //全队失误次数    

	
	public boolean equals(PlayerTechPO ptpo){
		if(!this.name.equals(ptpo.name)){
			System.out.println("name");
			return false;
		}
		if(!this.season.equals(ptpo.season)){
			System.out.println("season");
			return false;
		}
		if(!this.team.equals(ptpo.team)){
			System.out.println("team");
			return false;
		}
		if(this.gameNum!=ptpo.gameNum){
			System.out.println("gameNum");
			return false;
		}
		if(this.startingNum!=ptpo.startingNum){
			System.out.println("startingNum");
			return false;
		}
		if(this.shotInRate!=ptpo.shotInRate){
			System.out.println("shotInRate");
			return false;
		}
		if(this.threeShotInRate!=ptpo.threeShotInRate){
			System.out.println("threeShotInRate");
			return false;
		}
		if(this.penaltyShotInRate!=ptpo.penaltyShotInRate){
			System.out.println("penaltyShotInRate");
			return false;
		}
		if(this.efficiency!=ptpo.efficiency){
			System.out.println("efficiency");
			return false;
		}
		if(this.GmScEfficiency!=ptpo.GmScEfficiency){
			System.out.println("GmScEfficiency");
			return false;
		}
		if(this.trueShotInRate!=ptpo.trueShotInRate){
			System.out.println("trueShotInRate");
			return false;
		}
		if(this.shootingEfficiency!=ptpo.shootingEfficiency){
			System.out.println("shootingEfficiency");
			return false;
		}
		if(this.reboundRate!=ptpo.reboundRate){
			System.out.println("reboundRate");
			return false;
		}
		if(this.offensiveReboundRate!=ptpo.offensiveReboundRate){
			System.out.println("offensiveReboundRate");
			return false;
		}
		if(this.defensiveReboundRate!=ptpo.defensiveReboundRate){
			System.out.println("defensiveReboundRate");
			return false;
		}
		if(this.secondaryAttackRate!=ptpo.secondaryAttackRate){
			System.out.println("secondaryAttackRate");
			return false;
		}
		if(this.stealRate!=ptpo.stealRate){
			System.out.println("stealRate");
			return false;
		}
		if(this.blockShotRate!=ptpo.blockShotRate){
			System.out.println("blockShotRate");
			return false;
		}
		if(this.faultRate!=ptpo.faultRate){
			System.out.println("faultRate");
			return false;
		}
		if(this.usageRate!=ptpo.usageRate){
			System.out.println("usageRate");
			return false;
		}
		if(this.offensiveNum!=ptpo.offensiveNum){
			System.out.println("offensiveNum");
			return false;
		}
		if(this.defensiveNum!=ptpo.defensiveNum){
			System.out.println("defensiveNum");
			return false;
		}
		if(this.steal!=ptpo.steal){
			System.out.println("steal");
			return false;
		}
		if(this.blockShot!=ptpo.blockShot){
			System.out.println("blockShot");
			return false;
		}
		if(this.fault!=ptpo.fault){
			System.out.println("fault");
			return false;
		}
		if(this.foul!=ptpo.foul){
			System.out.println("foul");
			return false;
		}
		if(this.score!=ptpo.score){
			System.out.println("score");
			return false;
		}
		if(this.rebound!=ptpo.rebound){
			System.out.println("rebound");
			return false;
		}
		if(this.secondaryAttack!=ptpo.secondaryAttack){
			System.out.println("secondaryAttack");
			return false;
		}
		if(this.time!=ptpo.time){
			System.out.println("time");
			return false;
		}
		return true;
	}
}