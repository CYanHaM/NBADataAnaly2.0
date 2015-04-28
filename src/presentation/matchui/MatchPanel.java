package presentation.matchui;


import java.awt.Graphics;

import javax.swing.*;

import presentation.mainui.DateLabel;

public class MatchPanel extends JPanel{
	/**
	 * ����������ʾ����
	 * @author blisscry
	 * @date 2015��4��21��21:31:29
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	JLabel callendar;
	JScrollPane jsp;
	
	public MatchPanel() {
		callendar = new JLabel();
		callendar.setBounds(870, 85, 95, 30);
		callendar.setFont(new java.awt.Font("΢���ź�",0,15));
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
