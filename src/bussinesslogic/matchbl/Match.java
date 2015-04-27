package bussinesslogic.matchbl;

import java.util.ArrayList;

import bussinesslogic.Transfer.L2V.MatchL2V;
import bussinesslogic.Transfer.P2L.MatchP2L;
import data.MatchData;
import dataservice.MatchDataService;
import PO.MatchPO;
import VO.MatchVO;

public class Match {
//查询某一天的比赛
	public ArrayList<MatchVO> showMatchList(String date){
		MatchDataService mds=new MatchData();
		ArrayList<MatchPO> mplist=new ArrayList<MatchPO>();
		ArrayList<MatchLineItem> mlilist=new ArrayList<MatchLineItem>();
		ArrayList<MatchVO> mvlist=new ArrayList<MatchVO>();
		MatchLineItem mli=new MatchLineItem();
		MatchP2L p2l=new MatchP2L();
		MatchL2V l2v=new MatchL2V();

		mplist=mds.read();
		for(MatchPO po:mplist){
			mli=p2l.p2l(po);
			mlilist.add(mli);			
		}

		for(MatchLineItem li:mlilist){
			if(li.date.equals(date))
				mvlist.add(l2v.l2v(li));
		}
		
		return mvlist;
		
	}
	
//查询某一场比赛数据
	public MatchVO showMatch(String team,String date){
		MatchDataService mds=new MatchData();
		ArrayList<MatchPO> mplist=new ArrayList<MatchPO>();
		ArrayList<MatchLineItem> mlilist=new ArrayList<MatchLineItem>();
		MatchVO mv=new MatchVO();
		MatchLineItem mli=new MatchLineItem();
		MatchP2L p2l=new MatchP2L();
		MatchL2V l2v=new MatchL2V();

		mplist=mds.read();
		for(MatchPO po:mplist){
			mli=p2l.p2l(po);
			mlilist.add(mli);			
		}
		String homeTeam=date.split("_")[1];
		String guestTeam=date.split("_")[0];
		for(MatchLineItem li:mlilist){
			if(li.date.equals(date)&&li.homeTeam.equals(homeTeam)&&li.guestTeam.equals(guestTeam))
				mv=l2v.l2v(li);
			break;
		}
		
		return mv;
		
	}
	
//更新数据列表
	public ArrayList<MatchVO> refresh(String date){
		ArrayList<MatchVO> mvlist=new ArrayList<MatchVO>();
		mvlist=showMatchList(date);
		return mvlist;

	}
}
