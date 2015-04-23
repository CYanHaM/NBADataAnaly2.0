package bussinesslogic.Transfer.L2P;

import PO.PlayerPO;
import bussinesslogic.PlayerBL.PlayerLineItem;

public class PlayerL2P {
	PlayerPO ppo = new PlayerPO();
	public PlayerPO l2p(PlayerLineItem plt){
		ppo.name = (plt.name==null)? null : plt.name;
		ppo.uniformNum = plt.uniformNum;
		ppo.position = (plt.position==null)? null : plt.position;
		ppo.height = (plt.height==null)? null : plt.height;
		ppo.weight = plt.weight;
		ppo.birth = (plt.birth==null)? null : plt.birth;
		ppo.age = plt.age;
		ppo.exp = plt.exp;
		ppo.school = (plt.school==null)?null : plt.school;
		return ppo;
	}
}
