package presentation.preset;

import java.awt.Color;
import java.awt.Font;

public class HotPre {
	
	public Color LineSelected;
	
	public Font switchbox;//下拉框字体
	public Font firstname;
	public Font nextname;
	public Font info;
	
	public HotPre() {
		
		LineSelected=new Color(245,245,245);
		
		switchbox=new Font("幼圆",0,12);
		firstname=new Font("华文细黑",0,27);
		nextname=new Font("华文细黑",0,17);
		info=new Font("华文细黑",0,20);
	}
}
