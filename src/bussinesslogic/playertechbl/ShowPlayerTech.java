package bussinesslogic.playertechbl;

import java.util.ArrayList;

import data.playertechdata.Show;
import dataservice.playertechdataservice.ShowDataService;
import PO.PlayerTechPO;
import VO.PlayerTechVO;
import blservice.playertechblservice.ShowPlayerTechService;
import bussinesslogic.Transfer.L2V.PlayerTechL2V;
import bussinesslogic.Transfer.P2L.PlayerTechP2L;


public class ShowPlayerTech  implements ShowPlayerTechService {

	ShowDataService sd = new Show();
	PlayerTechP2L p2l = new PlayerTechP2L();
	PlayerTechL2V l2v = new PlayerTechL2V();
	
	@Override
	public ArrayList<PlayerTechVO> showSeasonPlayerData() {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = sd.showSeasonPlayerData();
		ArrayList<PlayerTechVO> res = new ArrayList<PlayerTechVO>();
		 int size = list.size();
		 for(int i=0;i<size;i++){
			 PlayerTechVO vo = l2v.l2v(p2l.p2l(list.get(i)));
			 res.add(vo);
		 }
		return res;
	}

	@Override
	public PlayerTechVO showKeyData(String name, String team) {
		// TODO Auto-generated method stub
	   PlayerTechPO po = sd.showKeyData(name, team);
	   PlayerTechVO vo = l2v.l2v(p2l.p2l(po));
		return vo;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		showSeasonPlayerData();
	}

}
