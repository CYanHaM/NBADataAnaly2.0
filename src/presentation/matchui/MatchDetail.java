package presentation.matchui;

import java.awt.Graphics;

import javax.swing.*;

import VO.MatchVO;

public class MatchDetail extends JPanel{
	/**
	 * the details of every match
	 * @author blisscry
	 * @date 2015年4月29日22:55:38
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	
	
	public MatchDetail(JFrame Frame,MatchVO mvo) {
		jsp1 = new JScrollPane();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
