package presentation.teamui;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.PlayerVO;
import VO.TeamTechVO;
import VO.TeamVO;
import blservice.playerinfoblservice.PlayerInfoService;
import blservice.teamblservice.TeamBLservice;
import bussinesslogic.TeamBL.Team;
import bussinesslogic.playerinfobl.PlayerInfo;

public class ImportTeam {
/**
 * team panel import data
 * @author blisscry
 * @date 2015年4月29日21:07:23
 * @version 1.2
 */
	//�����䴫��ӿ�
//	TeamTechBLservice TTbs;
	TeamBLservice Tbs;
	PlayerInfoService pis;

	public ImportTeam(){
//		TTbs = new TeamTech();
		Tbs = new Team();
		pis=new PlayerInfo();
	}

	public ArrayList<TeamTechVO> getTeamTechAscend(TeamTechEnum DataType){
//		return TTbs.Ascend(DataType);
		return null;
	}

	public ArrayList<TeamTechVO> getTeamTechDescend(TeamTechEnum DataType){
//		return TTbs.Descend(DataType);
		return null;
	}
	
	public TeamVO getTeamVO(TeamVO tvo){
		return Tbs.Show(tvo);
	}
	
	public PlayerVO Show(PlayerVO vo){
		return pis.showPlayerInfo(vo.name);
	}
	
	public ArrayList<PlayerVO> findByTeam(String teamname){
		return pis.findByTeam(teamname);
	}
}
