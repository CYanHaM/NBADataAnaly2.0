package presentation.matchui;


import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import VO.MatchVO;
import presentation.preset.MatchPre;

public class MatchInfo extends JPanel{
	/**
	 * 继承JPanel的内部滑动面板
	 * @author blisscry
	 * @date 2015年4月28日22:41:55
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	//定义滑动面板动态大小
	private int panel_width=750;
	private int panel_height=451;
	//
	private JLabel waterline;
	
	public MatchInfo() {
		MatchPre MP=new MatchPre();
//		this.setOpaque(false);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(panel_width,panel_height));
		this.setBackground(MP.MatchInfobg);
		
		MatchVO mvo1=new MatchVO();
		mvo1.guestTeam="CHA";
		mvo1.homeTeam="BOS";
		mvo1.score="98-100";
		mvo1.scoringChampion="Anderu Howards_30_CHA";
		mvo1.reboundChampion="Johns Harden_20_BOS";
		mvo1.assistChampion="Jam Wels_14_CHA";
		
		MatchLabel ml=new MatchLabel(mvo1);
		ml.setBounds(0, 0, 760, 150);
		
//		waterline=new JLabel(new ImageIcon("images/system_img/waterline.png"));
//		waterline.setBounds(2, 150, 750, 2);
		
		MatchVO mvo2=new MatchVO();
		mvo2.guestTeam="BKN";
		mvo2.homeTeam="ATL";
		mvo2.score="98-100";
		mvo2.scoringChampion="Anderu Howards_30_CHA";
		mvo2.reboundChampion="Johns Harden_20_BOS";
		mvo2.assistChampion="Jam Wels_14_CHA";
		
		MatchLabel m2=new MatchLabel(mvo2);
		m2.setBounds(0, 150, 760, 150);
		
		this.add(ml);
		this.add(m2);
//		this.add(waterline);
		
	}
	
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		ImageIcon img = new ImageIcon("images/");
		
	}
	
	
}
