package bussinesslogic.playerinfobl;

public class PlayerLineItem {
	public String name;            //����
	public int uniformNum;      //���º���
	public String position;        //λ��
	public String height;          //��ߣ�Ӣ��-Ӣ�磩
	public double weight;          //���أ�����
	public String birth;           //���գ��� �գ��꣩
	public int age;                //����
	public int exp;             //����
	public String school;          //��ҵѧУ
	
	public boolean equals(PlayerLineItem plt){
		if(!this.name.equals(plt.name)){
			System.out.println("name");
			return false;
		}
		if(this.uniformNum!=plt.uniformNum){
			System.out.println("uniformNum");
			return false;
		}
		if(!this.position.equals(plt.position)){
			System.out.println("position");
			return false;
		}
		if(!this.height.equals(plt.height)){
			System.out.println("height");
			return false;
		}
		if(this.weight!=plt.weight){
			System.out.println("weight");
			return false;
		}
		if(!this.birth.equals(plt.birth)){
			System.out.println("birth");
			return false;
		}
		if(this.age!=plt.age){
			System.out.println("age");
			return false;
		}
		if(this.exp!=plt.exp){
			System.out.println("exp");
			return false;
		}
		if(!this.school.equals(plt.school)){
			System.out.println("school");
			return false;
		}
		return true;
	}
}
