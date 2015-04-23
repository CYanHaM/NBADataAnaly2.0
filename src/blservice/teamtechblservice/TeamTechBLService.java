package blservice.teamtechblservice;

import java.util.ArrayList;

import TypeEnum.SortEnum;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public interface TeamTechBLService {
    public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 升序
     * */
    
    public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 降序
     * */
    
    public ArrayList<TeamTechVO> refresh(SortEnum sort, TeamTechEnum DataType);
    /* 传入排序的类型，以及升序或是降序
     * */
    
    public ArrayList<TeamTechVO> findSeasonHotTeam(String condition);
    /* 传入筛选类型
     * */
}
