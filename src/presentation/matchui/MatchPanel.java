package presentation.matchui;


import java.awt.Graphics;

import javax.swing.*;

import presentation.mainui.DateLabel;

public class MatchPanel extends JPanel{
	/**
	 * 比赛数据显示界面
	 * @author blisscry
	 * @date 2015年4月21日21:31:29
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	JLabel callendar;
	JScrollPane jsp;
	
	public MatchPanel() {
		callendar = new JLabel();
		callendar.setBounds(870, 85, 95, 30);
		callendar.setFont(new java.awt.Font("微软雅黑",0,15));
		DateLabel date=DateLabel.getInstance();
		date.register(callendar);
		callendar.setText(date.getSelectedDate());
		this.add(callendar);
	
//		jsp = new JScrollPane();
//		jsp.setViewportView();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im=new ImageIcon("images/system_img/main_bg.png");
		g.drawImage(im.getImage(),0,0,this);
	}
	
}
