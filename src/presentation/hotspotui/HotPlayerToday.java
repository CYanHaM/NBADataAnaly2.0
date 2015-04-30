package presentation.hotspotui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.preset.HotPre;
import VO.PlayerTechMVO;
import blservice.matchblservice.MatchBLService;
import blservice.playertechblservice.FindPlayerTechService;
import bussinesslogic.matchbl.Match;
import bussinesslogic.playertechbl.FindPlayerTech;

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
	private JButton scorecompare;
	private JButton efficiency;
	
	private JLabel first;
	private JLabel second;
	private JLabel third;
	private JLabel fourth;
	private JLabel fifth;
	
	private JLabel[] name;
	private JLabel[] info;
	private JLabel[] data;
	private JLabel[] compare;
	
	
	private ArrayList<PlayerTechMVO> hotplayerslist;
	private String date;
	private String selectedkeyword;
	
	private FindPlayerTechService fts;
	//创建比赛数据接口，仅用于获得最新一次比赛日期
	private MatchBLService mbs;
	
	private HotPre HP;
	private JFrame Frame;
	public HotPlayerToday(JFrame frame) {
		Frame=frame;
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		
		name=new JLabel[5];
		info=new JLabel[5];
		data=new JLabel[5];
		compare=new JLabel[5];
		
		fts=new FindPlayerTech();
		mbs=new Match();
		date=mbs.returnPresentDate();
		
		HP=new HotPre();
		
		addbutton();
		insertData();
		addbox();
		addlabel(selectedkeyword);
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
		score.setSelected(true);
		
		rebound = new JButton("篮板");
		rebound.setBounds(200+buttonwidth, 185, buttonwidth, buttonheight);
		rebound.setSelected(false);
		
		secondAttack = new JButton("助攻");
		secondAttack.setBounds(200+buttonwidth*2, 185, buttonwidth, buttonheight);
		secondAttack.setSelected(false);
		
		blockShot = new JButton("盖帽");
		blockShot.setBounds(200+buttonwidth*3, 185, buttonwidth, buttonheight);
		blockShot.setSelected(false);
		
		steal = new JButton("抢断");
		steal.setBounds(200+buttonwidth*4, 185, buttonwidth, buttonheight);
		steal.setSelected(false);
		
		isdouble = new JButton("两双");
		isdouble.setBounds(200+buttonwidth*5, 185, buttonwidth, buttonheight);
		isdouble.setSelected(false);
		
		scorecompare = new JButton("得分比");
		scorecompare.setBounds(200+buttonwidth*6, 185, buttonwidth, buttonheight);
		scorecompare.setSelected(false);
		
		efficiency = new JButton("效率");
		efficiency.setBounds(200+buttonwidth*7, 185, buttonwidth, buttonheight);
		efficiency.setSelected(false);
		
		
		this.add(score);
		this.add(rebound);
		this.add(secondAttack);
		this.add(blockShot);
		this.add(steal);
		this.add(isdouble);
		this.add(scorecompare);
		this.add(efficiency);
		
	}
	
	private void addlabel(String keyword){
//		first = new JLabel();
//		first.setBounds(200, 185+buttonheight, 390, 400);
//		first.setBackground(Color.WHITE);
//		first.setOpaque(true);
		
		name[0]=new JLabel();
		name[0].setBounds(370, 350, 250, 30);
		name[0].setFont(HP.firstname);
		name[0].setForeground(HP.LineSelected);
		name[0].setText(hotplayerslist.get(0).name);
		
		info[0]=new JLabel();
		info[0].setBounds(370, 375, 200, 20);
		info[0].setFont(HP.info);
		info[0].setForeground(HP.LineSelected);
		info[0].setText(switchposition(hotplayerslist.get(0).position)+" / "+hotplayerslist.get(0).team);
		
		data[0]=new JLabel();
		data[0].setBounds(370, 400, 100, 30);
		data[0].setFont(HP.firstname);
		data[0].setForeground(HP.LineSelected);
		switch(keyword){
		case "score":
			data[0].setText(String.valueOf(hotplayerslist.get(0).score));
			break;
		case "rebound":
			data[0].setText(String.valueOf(hotplayerslist.get(0).rebound));
			break;
		case "secondAttack":
			data[0].setText(String.valueOf(hotplayerslist.get(0).secondaryAttack));
			break;
		case "blockShot":
			data[0].setText(String.valueOf(hotplayerslist.get(0).blockShot));
			break;
		case "steal":
			data[0].setText(String.valueOf(hotplayerslist.get(0).steal));
			break;
		case "double":
//			data[0].setText(String.valueOf(hotplayerslist.get(0).double));
			break;
		case "scoreratio":
//			data[0].setText(String.valueOf(hotplayerslist.get(0).compare));
			break;
		case "efficiency":
//			data[0].setText(String.valueOf(hotplayerslist.get(0).efficiency));
			break;
		}
		
		
		second = new JLabel();
		second.setBounds(200+393, 185+buttonheight, 390, 100);
		second.setBackground(Color.WHITE);
		second.setOpaque(true);
		third = new JLabel();
		third.setBounds(200+393, 185+buttonheight+100, 390, 100);
		third.setBackground(Color.WHITE);
		third.setOpaque(true);
		fourth = new JLabel();
		fourth.setBounds(200+393, 185+buttonheight+100*2, 390, 100);
		fourth.setBackground(Color.WHITE);
		fourth.setOpaque(true);
		fifth = new JLabel();
		fifth.setBounds(200+393, 185+buttonheight+100*3, 390, 100);
		fifth.setBackground(Color.WHITE);
		fifth.setOpaque(true);

//		this.add(first);
		this.add(name[0]);
		this.add(info[0]);
		this.add(data[0]);
		
		this.add(second);
		this.add(third);
		this.add(fourth);
		this.add(fifth);
	}
	
	private void insertData(){
		if(score.isSelected()){
			selectedkeyword="score";
			hotplayerslist=fts.findHotPlayerToday(date,"score");
		}
		if(rebound.isSelected()){
			selectedkeyword="rebound";
			hotplayerslist=fts.findHotPlayerToday(date,"rebound");
		}
		if(secondAttack.isSelected()){
			selectedkeyword="secondAttack";
			hotplayerslist=fts.findHotPlayerToday(date,"secondAttack");
		}
		if(blockShot.isSelected()){
			selectedkeyword="blockShot";
			hotplayerslist=fts.findHotPlayerToday(date,"blockShot");
		}
		if(steal.isSelected()){
			selectedkeyword="steal";
			hotplayerslist=fts.findHotPlayerToday(date,"steal");
		}
		if(isdouble.isSelected()){
			selectedkeyword="double";
			hotplayerslist=fts.findHotPlayerToday(date,"double");
		}
		if(scorecompare.isSelected()){
			selectedkeyword="compare";
			hotplayerslist=fts.findHotPlayerToday(date,"compare");
		}
		if(efficiency.isSelected()){
			selectedkeyword="efficiency";
			hotplayerslist=fts.findHotPlayerToday(date,"efficiency");
		}
	}
	
	private String switchposition(String pos){
		String position=null;
		switch(pos){
		case "F":
			position="前锋";
			break;
		case "C":
			position="中锋";
			break;
		case "G":
			position="后卫";
			break;
		}
		return position;
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
