package presentation.teamui;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.PlayerVO;
import VO.TeamTechVO;
import VO.TeamVO;
import blservice.teamblservice.TeamBLservice;
import bussinesslogic.TeamBL.Team;

public class ImportTeam {
/**
 * 界面层通过BL层的接口导入并处理数据
 * @author blisscry
 * @date 2015年3月20日20:59:42
 * @version 1.0
 */
	//定义层间传输接口
//	TeamTechBLservice TTbs;
	TeamBLservice Tbs;
//	PlayerBLservice pbs;

	public ImportTeam(){
//		TTbs = new TeamTech();
		Tbs = new Team();
//		pbs=new Player();
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
//		return pbs.Show(vo);
		return null;
	}
	
	public ArrayList<PlayerVO> findByTeam(TeamVO tvo){
//		return pbs.findByTeam(tvo);
		return null;
	}
}
