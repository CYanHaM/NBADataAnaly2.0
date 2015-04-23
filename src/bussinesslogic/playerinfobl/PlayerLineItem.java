package bussinesslogic.playerinfobl;

public class PlayerLineItem {
	public String name;            //姓名
	public int uniformNum;      //球衣号码
	public String position;        //位置
	public String height;          //身高（英尺-英寸）
	public double weight;          //体重（磅）
	public String birth;           //生日（月 日，年）
	public int age;                //年龄
	public int exp;             //球龄
	public String school;          //毕业学校
	
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
