package presentation.playerui;

import java.util.ArrayList;

import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;
import VO.PlayerVO;
import VO.TeamVO;
import blservice.PlayerBLservice;
import blservice.PlayerTechBLservice;
import bussinesslogic.PlayerBL.Player;
import bussinesslogic.PlayerTechBL.PlayerTech;

public class ImportPlayer {
	/**
	 * �����ͨ��BL��Ľӿڵ��벢��������
	 * @author blisscry
	 * @date 2015��3��31��01:35:32
	 * @version 1.0
	 */
	//�����䴫��ӿ�
	PlayerTechBLservice PTbs;
	PlayerBLservice Pbs;

	public ImportPlayer(){
		PTbs = new PlayerTech();
		Pbs = new Player();
	}

	public ArrayList<PlayerTechVO> getPlayerTechAscend(PlayerTechEnum DataType){
		return PTbs.Ascend(DataType);
	}

	public ArrayList<PlayerTechVO> getPlayerTechDescend(PlayerTechEnum DataType){
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
