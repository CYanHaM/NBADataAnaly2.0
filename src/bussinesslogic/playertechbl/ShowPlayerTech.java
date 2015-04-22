package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.Show;
import dataservice.playertechdataservice.ShowDataService;
import PO.PlayerTechPO;
import VO.PlayerTechVO;
import blservice.playertechblservice.ShowPlayerTechService;
import bussinesslogic.Transfer.playertechtrans.PO2VO;

public class ShowPlayerTech  implements ShowPlayerTechService {

	ShowDataService sd = new Show();
	PO2VO po2vo = new PO2VO();
	
	@Override
	public ArrayList<PlayerTechVO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> po = sd.showSeasonPlayerData();
		ArrayList<PlayerTechVO> vo = po2vo.list2vo(po);
		return vo;
	}

	@Override
	public PlayerTechVO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
	   PlayerTechPO po = sd.showKeyData(name, team);
	   PlayerTechVO vo = po2vo.po2vo(po);
		return vo;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		showSeasonPlayerData();
	}

}
