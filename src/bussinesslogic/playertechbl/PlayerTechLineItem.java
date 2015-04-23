package bussinesslogic.playertechbl;

public class PlayerTechLineItem {
	public String name;                            //��Ա����
	public String season;                          //����
	public String team;                            //�������
	public int gameNum;                         //��������
	public int startingNum;                     //�ȷ�����
	public double shotInRate;                      //Ͷ��������
	public double threeShotInRate;                 //����������
	public double penaltyShotInRate;               //����������
	public double efficiency;                        //Ч��
	public double GmScEfficiency;                    //GmScЧ��ֵ
	public double trueShotInRate;                  //��ʵ������
	public double shootingEfficiency;                //Ͷ��Ч��
	public double reboundRate;                     //������
	public double offensiveReboundRate;            //����������
	public double defensiveReboundRate;            //����������
	public double secondaryAttackRate;             //������
	public double stealRate;                       //������
	public double blockShotRate;                   //��ñ��
	public double faultRate;                       //ʧ����	
	public double usageRate;                       //ʹ����
	
	//����������������
	
	public int offensiveNum;                    //������
	public int defensiveNum;                    //������
	public int steal;                           //������
	public int blockShot;                       //��ñ��
	public int fault;                           //ʧ����
	public int foul;                            //������
	public int score;                           //�÷�
	public int rebound;                         //������
	public int secondaryAttack;                 //������
	public int time;                            //�ڳ�ʱ��
	
	//�����ǳ�������
	
	public double offensiveNumave;                    //������
	public double defensiveNumave;                    //������
	public double stealave;                           //������
	public double blockShotave;                       //��ñ��
	public double faultave;                           //ʧ����
	public double foulave;                            //������
	public double scoreave;                           //�÷�
	public double reboundave;                         //������
	public double secondaryAttackave;                 //������
	public double timeave;                            //�ڳ�ʱ��
	
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
