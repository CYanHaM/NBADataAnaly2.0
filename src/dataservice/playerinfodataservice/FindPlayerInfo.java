package dataservice.playerinfodataservice;

import java.util.ArrayList;

import PO.PlayerPO;

public interface FindPlayerInfo {
	
	public ArrayList<PlayerPO> findAll();
	
	public PlayerPO findOne(String name, String team);

}
