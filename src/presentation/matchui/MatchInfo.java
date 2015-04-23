package presentation.matchui;


import java.awt.Dimension;

import javax.swing.*;

public class MatchInfo extends JPanel{
	/**
	 * 添加到matchpanel中的子面板
	 * @author blisscry
	 * @date 2015年4月22日22:11:12
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	//定义动态面板大小
	private int panel_width;
	private int panel_height;
	//
	
	
	public MatchInfo() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(panel_width,panel_height));
		
	}
	
	
	
}
