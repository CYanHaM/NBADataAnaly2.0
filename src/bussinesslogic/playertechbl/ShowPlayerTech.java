package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.Show;
import dataservice.playertechdataservice.ShowDataService;
import PO.PlayerTechPO;
import VO.PlayerTechVO;
import blservice.playertechblservice.ShowPlayerTechService;
import bussinesslogic.Transfer.PlayerTechTransfer;


public class ShowPlayerTech  implements ShowPlayerTechService {

	ShowDataService sd = new Show();
	PlayerTechTransfer tr = new PlayerTechTransfer();
	
	@Override
	public ArrayList<PlayerTechVO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = sd.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = tr.list2vo(list);
		return res;
	}

	@Override
	public PlayerTechVO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
	   PlayerTechPO po = sd.showKeyData(name, team);
	   PlayerTechVO vo = tr.po2vo(po);
		return vo;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		sd.refresh();
		showSeasonPlayerData();
	}

}
