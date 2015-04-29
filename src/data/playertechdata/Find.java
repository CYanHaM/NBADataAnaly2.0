package data.playertechdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import PO.PlayerTechMPO;
import PO.PlayerTechPO;
import dataservice.playertechdataservice.FindDataService;
import dataservice.playertechdataservice.ShowDataService;

public class Find implements FindDataService {
	public static void main(String[] args){
		Find fi = new Find();
		ArrayList<PlayerTechPO> all = fi.findSeasonHotPlayer("score");
		for(PlayerTechPO mpo:all){
			System.out.println(mpo.name+" "+mpo.score);
		}
	}

	ShowDataService sh = new Show();
	OperateWithFile owf = new OperateWithFile();
	
	@Override
	public ArrayList<PlayerTechMPO> findHotPlayerToday(String date, final String keyword)  {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
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
				case "rebound":
					return p1.rebound-p2.rebound;
				case "secondaryattack":
					return p1.secondaryAttack-p2.secondaryAttack;	
				case "steal":
					return p1.steal-p2.steal;
				case "blockshot":
					return p1.blockShot-p2.blockShot;
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
