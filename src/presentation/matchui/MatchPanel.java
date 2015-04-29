package presentation.matchui;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import blservice.matchblservice.MatchBLService;
import bussinesslogic.matchbl.Match;
import presentation.mainui.DateLabel;
import presentation.preset.MatchPre;

public class MatchPanel extends JPanel implements ActionListener{
	/**
	 * 比赛面板
	 * @author blisscry
	 * @date 2015年4月28日22:41:05
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	public static int FRAME_WIDTH=1020;
	public static int FRAME_HEIGHT=670;

	//define kits
	private JLabel showcal;
	private JLabel callendar;
	private JButton yesterday;
	private JButton tomorrow;
	private JScrollPane jsp;
	
	private MatchBLService mbs;


	public MatchPanel() {
		mbs=new Match();
		this.setLayout(null);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//定义比赛面板预设
		MatchPre MP=new MatchPre();

		showcal = new JLabel(new ImageIcon("images/matches/calendar.png"));
		showcal.setText("日历");
		showcal.setForeground(MP.CallendarinitColor);
		showcal.setFont(MP.CallendarinitFont);
		showcal.setBounds(192, 115, 95, 30);
		callendar = new JLabel();
		callendar.setBounds(208, 140, 90, 30);
		callendar.setFont(MP.CallendarinitFont);
		callendar.setForeground(MP.CallendarinitColor);
		DateLabel date=DateLabel.getInstance();
		date.register(callendar);
		callendar.setText(date.getSelectedDate());

		yesterday = new JButton();
		yesterday.setBounds(310, 140, 60, 25);
		
		
		tomorrow = new JButton();
		tomorrow.setBounds(370, 140, 60, 25);
		
		this.add(showcal);
		this.add(callendar);
		this.add(yesterday);
		this.add(tomorrow);

		MatchInfo mi=new MatchInfo();
		jsp = new JScrollPane();
		jsp.setBounds(208, 175, 770, 450);
		jsp.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		jsp.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jsp.setBorder(null);
//		jsp.revalidate();
//		jsp.repaint();
		
		jsp.setViewportView(mi);
		this.add(jsp);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im=new ImageIcon("images/system_img/teams_bg.png");
		g.drawImage(im.getImage(),0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==yesterday){
			
		}
		if(arg0.getSource()==tomorrow){
			
		}
	}

}
