package data.playerinfodata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import PO.PlayerPO;
import data.readFrom;
import dataservice.playerinfodataservice.PlayerInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {

	//待修改
	readFrom rf ;
	
	@Override
	public ArrayList<PlayerPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> list = read();
		return list;
	}

	@Override
	public PlayerPO findOne(String name, String team) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void write(){
		ArrayList<PlayerPO> po = rf.playerRead();
		FileOutputStream fos;
        try {
            fos = new FileOutputStream("Player.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(po);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<PlayerPO> read(){
		ArrayList<PlayerPO> list = new ArrayList<PlayerPO>(); 
		try{
			FileInputStream fis = new FileInputStream("Player.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        list =  (ArrayList<PlayerPO>) ois.readObject();
	        ois.close();
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return list;
	}
}
