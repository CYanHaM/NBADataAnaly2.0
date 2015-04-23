package bussinesslogic.Transfer.P2L;

import PO.PlayerPO;
import bussinesslogic.PlayerBL.PlayerLineItem;

public class PlayerP2L {
	PlayerLineItem plt = new PlayerLineItem();
	public PlayerLineItem p2l(PlayerPO ppo){
		plt.name = (ppo.name==null) ? null : ppo.name;
		plt.uniformNum = ppo.uniformNum;
		plt.position = (ppo.position==null) ? null : ppo.position;
		plt.height = (ppo.height==null) ? null : ppo.height;
		plt.weight = ppo.weight;
		plt.birth = (ppo.birth==null) ? null : ppo.birth;
		plt.age = ppo.age;
		plt.exp = ppo.exp;
		plt.school = (ppo.school==null) ? null : ppo.school;
		return plt;
	}
}
