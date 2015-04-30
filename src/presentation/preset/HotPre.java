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
		
		LineSelected=new Color(210,210,210);
		
		switchbox=new Font("幼圆",0,12);
		firstname=new Font("华文细黑",0,20);
		nextname=new Font("华文细黑",0,10);
		info=new Font("华文细黑",0,10);
	}
}
