package data;

import java.util.ArrayList;
import dataservice.MatchDataService;
import PO.MatchPO;

public class MatchData implements MatchDataService{
	
	public ArrayList<MatchPO> read(){
		readFrom rf=new DataProcessing();
		ArrayList<MatchPO> mlist=new ArrayList<MatchPO>();
		mlist=rf.matchRead();
		return mlist;
		
	}
	

}

