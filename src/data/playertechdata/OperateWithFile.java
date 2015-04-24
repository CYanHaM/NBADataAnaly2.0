package data.playertechdata;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import data.DataProcessing;
import data.readFrom;
import PO.MatchPO;
import PO.PlayerTechMPO;
import PO.PlayerTechPO;

public class OperateWithFile {
	
	public void write(){
		
		readFrom rf = new DataProcessing();
		ArrayList<MatchPO> match = rf.matchRead();
		ArrayList<PlayerTechMPO> mpoList = new ArrayList<PlayerTechMPO>();
		ArrayList<PlayerTechPO> poList = new ArrayList<PlayerTechPO>();
		int size = match.size();
		for(int i=0;i<size;i++){
			mpoList.addAll(match.get(i).playerStatistic);
		}
		int mpoSize = mpoList.size();
		for(int i=0;i<size;i++){
			ArrayList<PlayerTechMPO> temp = new ArrayList<PlayerTechMPO>();
			
		}
		
	}
	
	public ArrayList<PlayerTechPO> read(){
		ArrayList<PlayerTechPO> list = new ArrayList<PlayerTechPO>(); 
		try{
			FileInputStream fis = new FileInputStream("PlayerTech.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        list =  (ArrayList<PlayerTechPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return list;
	}
	
	public ArrayList<PlayerTechMPO> readMPO(){
		ArrayList<PlayerTechMPO> res = new ArrayList<PlayerTechMPO>(); 
		try{
			FileInputStream fis = new FileInputStream("PlayerTechMPO.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        res=  (ArrayList<PlayerTechMPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return res;
	}

}
