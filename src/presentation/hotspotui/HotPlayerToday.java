package presentation.hotspotui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.preset.HotPre;

public class HotPlayerToday extends JPanel implements ActionListener{
	/**
	 * 当天热点球员
	 * @author blisscry
	 * @date 2015年4月29日21:43:23
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	
	//当天热点球员，赛季热点球员，赛季热点球队，进步最快球员切换下拉框
	private JComboBox<String> switchbox;

	//下拉框大小
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	
	private int buttonwidth=98;
	private int buttonheight=40;
	
	//得分，篮板，助攻，盖帽，抢断，两双，得分比，效率
	private JButton score;
	private JButton rebound;
	private JButton secondAttack;
	private JButton blockShot;
	private JButton steal;
	private JButton isdouble;
	private JButton compare;
	private JButton efficiency;
	

	HotPre HP;
	JFrame Frame;
	public HotPlayerToday(JFrame frame) {
		Frame=frame;
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		
		HP=new HotPre();
		addbox();
		addbutton();
	}

	private void addbox(){
		//下拉框
		switchbox=new JComboBox<String>();
		switchbox.setFocusable(false);
		switchbox.setBackground(HP.LineSelected);
		switchbox.addItem("当天热点球员");
		switchbox.addItem("赛季热点球员");
		switchbox.addItem("赛季热点球队");
		switchbox.addItem("进步最快球员");
		switchbox.setBounds(200,135,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(HP.switchbox);
		//TODO change the index when change panel
		switchbox.setSelectedIndex(0);
		switchbox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					if(switchbox.getSelectedItem().equals("当天热点球员")){
						
					}
					if(switchbox.getSelectedItem().equals("赛季热点球员")){

					}
					if(switchbox.getSelectedItem().equals("赛季热点球队")){

					}
					if(switchbox.getSelectedItem().equals("进步最快球员")){

					}
				}
			}
		});

		this.add(switchbox);
	}

	private void addbutton(){
		score = new JButton("得分");
		score.setBounds(200, 185, buttonwidth, buttonheight);
		rebound = new JButton("篮板");
		rebound.setBounds(200+buttonwidth, 185, buttonwidth, buttonheight);
		secondAttack = new JButton("助攻");
		secondAttack.setBounds(200+buttonwidth*2, 185, buttonwidth, buttonheight);
		blockShot = new JButton("盖帽");
		blockShot.setBounds(200+buttonwidth*3, 185, buttonwidth, buttonheight);
		steal = new JButton("抢断");
		steal.setBounds(200+buttonwidth*4, 185, buttonwidth, buttonheight);
		isdouble = new JButton("两双");
		isdouble.setBounds(200+buttonwidth*5, 185, buttonwidth, buttonheight);
		compare = new JButton("得分比");
		compare.setBounds(200+buttonwidth*6, 185, buttonwidth, buttonheight);
		efficiency = new JButton("效率");
		efficiency.setBounds(200+buttonwidth*7, 185, buttonwidth, buttonheight);
		
		this.add(score);
		this.add(rebound);
		this.add(secondAttack);
		this.add(blockShot);
		this.add(steal);
		this.add(isdouble);
		this.add(compare);
		this.add(efficiency);
		
	}
	
	
	//绘制赛季数据界面背景
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/teams_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
