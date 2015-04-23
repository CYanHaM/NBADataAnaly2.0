package bussinesslogic.Transfer.L2V;

import VO.PlayerVO;
import bussinesslogic.PlayerBL.PlayerLineItem;

public class PlayerL2V {
	PlayerVO pvo = new PlayerVO();
	public PlayerVO l2v(PlayerLineItem plt){
		pvo.name = plt.name==null ? null : plt.name;
		pvo.uniformNum = plt.uniformNum;
		pvo.position = plt.position==null ? null : plt.position;
		pvo.height = plt.height==null ? null : plt.height;
		pvo.weight = plt.weight;
		pvo.birth = plt.birth==null ? null : plt.birth;
		pvo.age = plt.age;
		pvo.exp = plt.exp;
		pvo.school = plt.school==null ? null : plt.school;
		return pvo;
	}
}
