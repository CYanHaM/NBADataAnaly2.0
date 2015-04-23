package bussinesslogic.playertechbl;

public class PlayerTechLineItem {
	public String name;                            //球员名称
	public String season;                          //赛季
	public String team;                            //所属球队
	public int gameNum;                         //参赛场数
	public int startingNum;                     //先发场数
	public double shotInRate;                      //投篮命中率
	public double threeShotInRate;                 //三分命中率
	public double penaltyShotInRate;               //罚球命中率
	public double efficiency;                        //效率
	public double GmScEfficiency;                    //GmSc效率值
	public double trueShotInRate;                  //真实命中率
	public double shootingEfficiency;                //投篮效率
	public double reboundRate;                     //篮板率
	public double offensiveReboundRate;            //进攻篮板率
	public double defensiveReboundRate;            //防守篮板率
	public double secondaryAttackRate;             //助攻数
	public double stealRate;                       //抢断数
	public double blockShotRate;                   //盖帽数
	public double faultRate;                       //失误数	
	public double usageRate;                       //使用率
	
	//以下是赛季总数据
	
	public int offensiveNum;                    //进攻数
	public int defensiveNum;                    //防守数
	public int steal;                           //抢断数
	public int blockShot;                       //盖帽数
	public int fault;                           //失误数
	public int foul;                            //犯规数
	public int score;                           //得分
	public int rebound;                         //篮板数
	public int secondaryAttack;                 //助攻数
	public int time;                            //在场时间
	
	//以下是场均数据
	
	public double offensiveNumave;                    //进攻数
	public double defensiveNumave;                    //防守数
	public double stealave;                           //抢断数
	public double blockShotave;                       //盖帽数
	public double faultave;                           //失误数
	public double foulave;                            //犯规数
	public double scoreave;                           //得分
	public double reboundave;                         //篮板数
	public double secondaryAttackave;                 //助攻数
	public double timeave;                            //在场时间
	
	public boolean equals(PlayerTechLineItem ptli){
		if(!this.name.equals(ptli.name)){
			System.out.println("name");
			return false;
		}
		if(!this.season.equals(ptli.season)){
			System.out.println("season");
			return false;
		}
		if(!this.team.equals(ptli.team)){
			System.out.println("team");
			return false;
		}
		if(this.gameNum!=ptli.gameNum){
			System.out.println("gameNum");
			return false;
		}
		if(this.startingNum!=ptli.startingNum){
			System.out.println("startingNum");
			return false;
		}
		if(this.shotInRate!=ptli.shotInRate){
			System.out.println("shotInRate");
			return false;
		}
		if(this.threeShotInRate!=ptli.threeShotInRate){
			System.out.println("threeShotInRate");
			return false;
		}
		if(this.penaltyShotInRate!=ptli.penaltyShotInRate){
			System.out.println("penaltyShotInRate");
			return false;
		}
		if(this.efficiency!=ptli.efficiency){
			System.out.println("efficiency");
			return false;
		}
		if(this.GmScEfficiency!=ptli.GmScEfficiency){
			System.out.println("GmScEfficiency");
			return false;
		}
		if(this.trueShotInRate!=ptli.trueShotInRate){
			System.out.println("trueShotInRate");
			return false;
		}
		if(this.shootingEfficiency!=ptli.shootingEfficiency){
			System.out.println("shootingEfficiency");
			return false;
		}
		if(this.reboundRate!=ptli.reboundRate){
			System.out.println("reboundRate");
			return false;
		}
		if(this.offensiveReboundRate!=ptli.offensiveReboundRate){
			System.out.println("offensiveReboundRate");
			return false;
		}
		if(this.defensiveReboundRate!=ptli.defensiveReboundRate){
			System.out.println("defensiveReboundRate");
			return false;
		}
		if(this.secondaryAttackRate!=ptli.secondaryAttackRate){
			System.out.println("secondaryAttackRate");
			return false;
		}
		if(this.stealRate!=ptli.stealRate){
			System.out.println("stealRate");
			return false;
		}
		if(this.blockShotRate!=ptli.blockShotRate){
			System.out.println("blockShotRate");
			return false;
		}
		if(this.faultRate!=ptli.faultRate){
			System.out.println("faultRate");
			return false;
		}
		if(this.usageRate!=ptli.usageRate){
			System.out.println("usageRate");
			return false;
		}
		if(this.offensiveNum!=ptli.offensiveNum){
			System.out.println("offensiveNum");
			return false;
		}
		if(this.defensiveNum!=ptli.defensiveNum){
			System.out.println("defensiveNum");
			return false;
		}
		if(this.steal!=ptli.steal){
			System.out.println("steal");
			return false;
		}
		if(this.blockShot!=ptli.blockShot){
			System.out.println("blockShot");
			return false;
		}
		if(this.fault!=ptli.fault){
			System.out.println("fault");
			return false;
		}
		if(this.foul!=ptli.foul){
			System.out.println("foul");
			return false;
		}
		if(this.score!=ptli.score){
			System.out.println("score");
			return false;
		}
		if(this.rebound!=ptli.rebound){
			System.out.println("rebound");
			return false;
		}
		if(this.secondaryAttack!=ptli.secondaryAttack){
			System.out.println("secondaryAttack");
			return false;
		}
		if(this.time!=ptli.time){
			System.out.println("time");
			return false;
		}
		if(this.offensiveNumave!=ptli.offensiveNumave){
			System.out.println("offensiveNumave");
			return false;
		}
		if(this.defensiveNumave!=ptli.defensiveNumave){
			System.out.println("defensiveNumave");
			return false;
		}
		if(this.stealave!=ptli.stealave){
			System.out.println("stealave");
			return false;
		}
		if(this.blockShotave!=ptli.blockShotave){
			System.out.println("blockShotave");
			return false;
		}
		if(this.faultave!=ptli.faultave){
			System.out.println("faultave");
			return false;
		}
		if(this.foulave!=ptli.foulave){
			System.out.println("foulave");
			return false;
		}
		if(this.scoreave!=ptli.scoreave){
			System.out.println("scoreave");
			return false;
		}
		if(this.reboundave!=ptli.reboundave){
			System.out.println("reboundave");
			return false;
		}
		if(this.secondaryAttackave!=ptli.secondaryAttackave){
			System.out.println("secondaryAttackave");
			return false;
		}
		if(this.timeave!=ptli.timeave){
			System.out.println("timeave");
			return false;
		}
		return true;
	}
}
