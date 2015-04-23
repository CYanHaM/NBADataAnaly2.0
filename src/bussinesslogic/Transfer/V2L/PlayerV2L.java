package bussinesslogic.Transfer.V2L;

import VO.PlayerVO;
import bussinesslogic.PlayerBL.PlayerLineItem;

public class PlayerV2L {
	PlayerLineItem plt = new PlayerLineItem();
	public PlayerLineItem v2l (PlayerVO pvo){
		plt.name = (pvo.name==null) ? null : pvo.name;
		plt.uniformNum = pvo.uniformNum;
		plt.position = (pvo.position==null) ? null : pvo.position;
		plt.height = (pvo.height==null) ? null : pvo.height;
		plt.weight = pvo.weight;
		plt.birth = (pvo.birth==null) ? null : pvo.birth;
		plt.age = pvo.age;
		plt.exp = pvo.exp;
		plt.school = (pvo.school==null) ? null : pvo.school;
		return plt;
	}
}
