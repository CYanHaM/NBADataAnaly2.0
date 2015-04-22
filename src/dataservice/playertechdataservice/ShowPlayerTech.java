package dataservice.playertechdataservice;

import java.util.ArrayList;

import PO.PlayerTechPO;

public interface ShowPlayerTech {
	
	//返回赛季球员数据
		public ArrayList<PlayerTechPO> showSeasonPlayerData ();
		
		//查看某一球员关键数据
		public PlayerTechPO showKeyData (String name,String team );
		
		//刷新赛季球员数据列表
		public void refresh ();

}
