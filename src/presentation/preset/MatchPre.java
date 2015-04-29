package presentation.preset;

import java.awt.*;

public class MatchPre {
	//颜色预设
	public Color CallendarinitColor;
	public Color MatchInfobg;
	public Color White;
	public Color Red;
	//字体预设
	public Font CallendarinitFont;
	
	public Font Score;
	public Font Teamname;
	public Font Teamabb;
	public Font Champion;
	
	public MatchPre() {
		CallendarinitColor = new Color(235,235,235);
		MatchInfobg = new Color(175,201,222);
		White = new Color(245,245,245);
		Red = new Color(209,48,48);
		
		CallendarinitFont = new Font("华文细黑",1,15);
		Score = new Font("华文细黑",0,30);
		Teamname = new Font("微软雅黑",0,15);
		Teamabb = new Font("微软雅黑",0,10);
		Champion = new Font("华文细黑",0,15);
		
	}
}
