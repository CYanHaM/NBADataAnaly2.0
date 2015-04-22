package data.playertechdata;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import PO.PlayerPO;
import PO.PlayerTechPO;

public class OperateWithFile {
	
	public void write(){
		
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

}
