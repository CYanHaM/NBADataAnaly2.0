package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.OperateWithFile;
import data.playertechdata.Show;
import dataservice.playertechdataservice.PlayerTechInitial;
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

	@Override
	public void PlayerTechIni() {
		// TODO Auto-generated method stub
		PlayerTechInitial ini = new OperateWithFile();
		ini.write();
	}

	@Override
	public ArrayList<PlayerTechVO> ascend(String type) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> all = sd.ascend(type);
		ArrayList<PlayerTechVO> res = tr.list2vo(all);
		return res;
	}

	@Override
	public ArrayList<PlayerTechVO> descend(String type) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> all = sd.descend(type);
		ArrayList<PlayerTechVO> res = tr.list2vo(all);
		return res;
	}

}
