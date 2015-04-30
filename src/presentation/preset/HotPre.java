package presentation.preset;

import java.awt.Color;
import java.awt.Font;

public class HotPre {
	
	public Color LineSelected;
	
	public Font switchbox;//下拉框字体
	public Font name;
	public Font teamandinfo;
	public Font data;
	
	public Font name_small;
	public Font teamandinfo_small;
	public Font data_small;
	
	public HotPre() {
		
		LineSelected=new Color(245,245,245);
		
		switchbox=new Font("幼圆",0,12);
		name=new Font("华文细黑",0,27);
		teamandinfo=new Font("华文细黑",0,15);
		data=new Font("华文细黑",0,30);
		
		name_small=new Font("华文细黑",0,15);
		teamandinfo_small=new Font("华文细黑",0,10);
		data_small=new Font("华文细黑",0,20);
	}
}
