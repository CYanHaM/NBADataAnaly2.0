package data.playertechdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.FindDataService;
import dataservice.playertechdataservice.ShowDataService;

public class Find implements FindDataService {

	ShowDataService sh = new Show();
	OperateWithFile owf = new OperateWithFile();
	
	@Override
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, final String keyword)  {
		// TODO Auto-generated method stub
		//筛选今天的比赛数据
		ArrayList<PlayerTechMPO> list = owf.readMPO();
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>();
		int size = list.size();
		for(int i=0;i<size;i++){
			if(list.get(i).date.equals(date)){
				res.add(list.get(i));
			}
		}
		
		//进行排序
		Comparator<PlayerTechMPO> comparator = new Comparator<PlayerTechMPO>(){  
			public int compare(PlayerTechMPO p2, PlayerTechMPO p1) {   
				//重写比较方法
				switch(keyword){
				case "time":
					return p1.time-p2.time;
				case "shotin":
					return p1.shotIn-p2.shotIn;
				case "shot":
					return p1.shot-p2.shot;
				case "threeshotin":
					return p1.threeShotIn-p2.threeShotIn;
				case "threeshot":
					return p1.threeShot-p2.threeShot;
				case "penaltyshotin":
					return p1.penaltyShotIn-p2.penaltyShotIn;
				case "penaltyshot":
					return p1.penaltyShot-p2.penaltyShot;
				case "offensiverebound":
					return p1.offensiveRebound-p2.offensiveRebound;
				case "defensiverebound":
					return p1.defensiveRebound-p2.defensiveRebound;
				case "rebound":
					return p1.rebound-p2.rebound;
				case "secondaryAttack":
					return p1.secondaryAttack-p2.secondaryAttack;	
				case "steal":
					return p1.steal-p2.steal;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
				case "fault":
					return p1.fault-p2.fault;
				case "foul":
					return p1.foul-p2.foul;
				case "score":
					return p1.score-p2.score;
				default:
					System.out.println("wrong type");
					return 0;
				}
			}  
		}; 
		Collections.sort(res, comparator);
		ArrayList<PlayerTechMPO> result = new ArrayList<PlayerTechMPO>();
		for(int i=0;i<5;i++){
			result.add(res.get(i));
		}
		return result;
	}

	@Override
	public ArrayList<PlayerTechPO> findSeasonHotPlayer(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> list = sh.descend(keyword);
		ArrayList<PlayerTechPO> res = new ArrayList<PlayerTechPO>();
		for(int i=0;i<5;i++){
			res.add(list.get(i));
		}
		return res;
	}

	@Override
	public ArrayList<PlayerTechPO> findFastImprovingPlayer() {
		// TODO Auto-generated method stub
		 ArrayList<PlayerTechPO> list = owf.readPO();
		return list;
	}

	@Override
	public ArrayList<PlayerTechPO> sift(PlayerTechPO po) {
		// TODO Auto-generated method stub
		ArrayList<PlayerTechPO> res = new ArrayList<PlayerTechPO>();
		ArrayList<PlayerTechPO> list = owf.readPO();
		int size = list.size();
		for(int i=0;i<size;i++){
			PlayerTechPO temp = list.get(i);
			if(temp.score>=po.score&&temp.blockShot>=po.blockShot&&temp.rebound>=po.rebound
					&&temp.steal>=po.steal&&temp.secondaryAttack>=po.secondaryAttack){
				res.add(temp);
			}
		}
		return res;
	}

}
