package dataservice.playertechdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PlayerTechPO;

public interface ShowDataService {
	
	   //杩斿洖璧涘鐞冨憳鏁版嵁
		public ArrayList<PlayerTechPO> showSeasonPlayerData ();
		
		//鏌ョ湅鏌愪竴鐞冨憳鍏抽敭鏁版嵁
		public PlayerTechPO showKeyData (String name,String team );
		
		public ArrayList<PlayerTechPO> ascend(String type);
		//鎸夌収type鎵�绀烘潯浠跺崌搴忔帓搴�
		
		public ArrayList<PlayerTechPO> descend(String type);
		//鎸夌収type鎵�绀烘潯浠堕檷搴忔帓搴�

}
