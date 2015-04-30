package presentation.playerui;

import java.util.ArrayList;

import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;
import VO.PlayerVO;
import VO.TeamVO;
import blservice.playerinfoblservice.PlayerInfoService;
import blservice.playertechblservice.FindPlayerTechService;
import blservice.playertechblservice.ShowPlayerTechService;
import bussinesslogic.playerinfobl.PlayerInfo;
import bussinesslogic.playertechbl.FindPlayerTech;
import bussinesslogic.playertechbl.ShowPlayerTech;

public class ImportPlayer {
	/**
	 * 界面层通过BL层的接口导入并处理数据
	 * @author blisscry
	 * @date 2015年3月31日01:35:32
	 * @version 1.0
	 */
	//定义层间传输接口
	PlayerInfoService pis;
	FindPlayerTechService fpt;
	ShowPlayerTechService spt;

	public ImportPlayer(){
		pis = new PlayerInfo();
		fpt = new FindPlayerTech();
		spt = new ShowPlayerTech();
	}

	public ArrayList<PlayerTechVO> getPlayerTechAscend(String DataType){
		return spt.ascend(DataType);
	}

	public ArrayList<PlayerTechVO> getPlayerTechDescend(String DataType){
		return PTbs.Descend(DataType);
	}
	
	public ArrayList<PlayerTechVO> sift(String position,String division,String ordergist){
		return PTbs.sift(position, division, ordergist);
	}
	
	public PlayerVO show(PlayerVO vo){
		return Pbs.Show(vo);
	}

	public ArrayList<PlayerVO> findByTeam(TeamVO tvo){
		return Pbs.findByTeam(tvo);
	}

}
