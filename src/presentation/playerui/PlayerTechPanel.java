package presentation.playerui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.hotspotui.HotPlayerToday;
import presentation.matchui.MatchPanel;
import presentation.preset.PlayerTechPre;
import presentation.teamui.TeamInfoPanel;
import presentation.teamui.TeamTechPanel;
import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;
import VO.ScreeningConditionVO;

public class PlayerTechPanel extends JPanel implements ActionListener{
	/**
	 * 球员统计数据界面
	 * @author blisscry
	 * @date 2015年3月30日15:40:16
	 * @version 1.3
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------界面常量-------------------
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//定义边缘透明空白区域边界大小，单位px
	public static int e_space=10;
	//定义空出位置大小
	private static int space=20;
	//设置球员总数常量
	private static int PLAYERNUM=443;

	//表格大小
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=400;
	//表格行高
	private static int ROWHEIGHT=40;
	//表格列宽
	private static int[] COLUMNWIDTH={40,120,170,
		60,60,60,60,60,
		70,70,70,
		60,60,60,60,60,60,60,
		70,80,70,70,70,70,70,70,70,70,70,70};

	//下拉框大小
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	//----------------------------------------------------

	//-------------------------界面组件--------------------
	//设置表格属性
	private JTable playertable;
	private String[] playernames;
	private String playername;
	private Object[][] playerinfo;
	private JScrollPane players;
	private String[] columnName={
			"排名","球员名称","所属球队",
			"参赛场数","先发场数","篮板数","助攻数","在场时间",
			"投篮命中率","三分命中率","罚球命中率",
			"进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分",
			"效率","GmSc 效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"};
	//总数据与场均数据切换下拉框
	private JComboBox<String> switchbox;

	//排序方式单选按钮组
	private JRadioButton order_Asc;
	private JRadioButton order_Des;
	private ButtonGroup group;
	//排序依据显示行
	private JLabel message;
	
	//高级筛选按钮
	private JButton seniorsift;
	private JButton add;
	private JButton delete;
	private JScrollPane siftpanel;
	private SeniorSiftPanel seniorsiftpanel;
	public ArrayList<ScreeningConditionVO> screeningconditions;
	//筛选提交按钮
	private JButton commit;
	//表格重置按钮
	private JButton reset;
	//侧边栏按钮
	private JButton SeasonInfo;
	private JButton MatchInfo;
	private JButton TeamInfo;
	private JButton PlayerInfo;
	private JButton Hot;
	
	private JButton trigger;
	private boolean exit=false;
	private JButton[] letterbutton;
	private Thread showletter;
	private Thread hideletter;
	private char[] letter;
	private String letterstring="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int currentnum;
	
	//----------------------------------------------------
	public PlayerTechPre PTPre;
	public ImportPlayer importdata;
	public ArrayList<PlayerTechVO> initial_data;

	public int HeaderColumn=0;
	public JFrame Frame; 
	public JPanel panelToRemove;
	public PlayerTechPanel(JFrame frame){
		Frame=frame;
		panelToRemove=this;
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		screeningconditions=new ArrayList<ScreeningConditionVO>();
		
		letter=new char[26];
		letter=letterstring.toCharArray();
		letterbutton=new JButton[26];
		
		//创建颜色预设对象
		PTPre=new PlayerTechPre();
		importdata=new ImportPlayer();
		initial_data=importdata.getPlayerTechAscend("name");
		
		playerinfo=new Object[initial_data.size()][columnName.length];
//		playerinfo=new Object[PLAYERNUM][columnName.length];
		//加载初始表格，显示队伍总数据
		handleinitial(initial_data);

		//加载表格配置
		table_config();
		//加载滑动面板配置
		scrollpane_config();

		//添加下拉框
		addbox();
		//添加高级筛选
		addseniorsift();
		//添加单选按钮组
		addradiobutton();
		//添加提示信息
		addmessage();
		//添加提交，重置按钮
		addbutton();

		addletterbutton();

		this.repaint();
	}
	
	//===================================================================
	private void addbox(){
		//下拉框
		switchbox=new JComboBox<String>();
		switchbox.setFocusable(false);
		switchbox.setBackground(PTPre.LineSelected);
		switchbox.addItem("赛季总数据");
		switchbox.addItem("场均数据");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-100-65,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(PTPre.switchbox);
		switchbox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					if(switchbox.getSelectedItem().equals("赛季总数据")){
						//								System.out.println("赛季总数据");
						handleTotalData(initial_data);
					}
					if(switchbox.getSelectedItem().equals("场均数据")){
						//								System.out.println("场均数据");
						handleAverageData(initial_data);
					}
				}
			}
		});

		this.add(switchbox);
	}
	
	private void addletterbutton(){
		trigger=new JButton("trigger");
		trigger.setBounds(WIDTH-TABLEWIDTH-e_space-space+200, HEIGHT-TABLEHEIGHT-e_space-space-100-65, 50, 50);
		trigger.addActionListener(this);
		this.add(trigger);
		
		for(int i=0;i<letterbutton.length;i++){
			letterbutton[i]=new JButton(new ImageIcon("images/buttons/letters/"+i+"_1.png"));
			letterbutton[i].setBounds(WIDTH-TABLEWIDTH-e_space-space+i*30, HEIGHT-TABLEHEIGHT-e_space-space-100-40, 30, 30);
			letterbutton[i].setBorderPainted(false);
			letterbutton[i].setContentAreaFilled(false);
			letterbutton[i].setFocusPainted(false);
			letterbutton[i].setRolloverIcon(new ImageIcon("images/buttons/letters/"+i+"_2.png"));
			letterbutton[i].setPressedIcon(new ImageIcon("images/buttons/letters/"+i+"_3.png"));
			letterbutton[i].setSelectedIcon(new ImageIcon("images/buttons/letters/"+i+"_3.png"));
			
			currentnum=i;
			letterbutton[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(letter[currentnum]);
					ArrayList<PlayerTechVO> playervo=importdata.findPlayerByLetter(letter[currentnum]);
					playerinfo=new Object[playervo.size()][columnName.length];
					String switchboxsel=(String) switchbox.getSelectedItem();
					if(switchboxsel.equals("赛季总数据")){
						handleTotalData(playervo);
					}else if(switchboxsel.equals("场均数据")){
						handleAverageData(playervo);
					}
//					for(int j=0;)
					letterbutton[currentnum].setSelected(true);
				}
			});
			this.add(letterbutton[i]);
			letterbutton[i].setVisible(false);
		}
	}
	
	private void addseniorsift(){
//		seniorsift=new JButton("高级筛选");
//		seniorsift.setBounds(WIDTH-TABLEWIDTH-e_space-space, HEIGHT-TABLEHEIGHT-e_space-space-50, 160, 30);
//		seniorsift.addActionListener(this);
//		this.add(seniorsift);
		siftpanel=new JScrollPane();
		siftpanel.setBounds(WIDTH-TABLEWIDTH-e_space-space, HEIGHT-TABLEHEIGHT-e_space-space-100, 420, 90);
		siftpanel.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		siftpanel.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		siftpanel.setOpaque(false);
		siftpanel.getViewport().setOpaque(false);
		siftpanel.setBorder(null);
//		siftpanel.setSize(800, 600);
		seniorsiftpanel=new SeniorSiftPanel(this);
		siftpanel.setViewportView(seniorsiftpanel);
		this.add(siftpanel);
		
		add=new JButton("+");
		add.setBounds(WIDTH-TABLEWIDTH-e_space-space+420, HEIGHT-TABLEHEIGHT-e_space-space-100, 30, 30);
		add.addActionListener(this);
		this.add(add);
		
		delete=new JButton("-");
		delete.setBounds(WIDTH-TABLEWIDTH-e_space-space+420, HEIGHT-TABLEHEIGHT-e_space-space-100+30, 30, 30);
		delete.addActionListener(this);
		this.add(delete);
		
	}
	
	private void addradiobutton(){
		order_Asc=new JRadioButton("升序");
		order_Asc.setFont(PTPre.switchbox);
		order_Asc.setForeground(PTPre.TableFg);
		order_Asc.setBorderPainted(false);
		order_Asc.setContentAreaFilled(false);
		order_Asc.setFocusPainted(false);
//		order_Asc.setSelected(true);
		order_Asc.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+10,HEIGHT-TABLEHEIGHT-e_space-space-92-65,50,15);
		
		order_Des=new JRadioButton("降序");
		order_Des.setFont(PTPre.switchbox);
		order_Des.setForeground(PTPre.TableFg);
		order_Des.setBorderPainted(false);
		order_Des.setContentAreaFilled(false);
		order_Des.setFocusPainted(false);
		order_Des.setSelected(true);
		order_Des.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+60,HEIGHT-TABLEHEIGHT-e_space-space-92-65,50,15);
		
		group=new ButtonGroup();
		group.add(order_Asc);
		group.add(order_Des);
		
		this.add(order_Asc);
		this.add(order_Des);
	}
	
	private void addmessage(){
		message=new JLabel();
		message.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+120, HEIGHT-TABLEHEIGHT-e_space-space-92-65, 200, 15);
		message.setFont(PTPre.switchbox);
		message.setForeground(PTPre.TableFg);
		
		this.add(message);
	}
	
	private void addbutton(){
		SeasonInfo=new JButton(new ImageIcon("images/system_img/seasoninfo_initial.png"));
		sideButton_config(SeasonInfo, "seasoninfo", 0);
		
		MatchInfo=new JButton(new ImageIcon("images/system_img/matchinfo_initial.png"));
		sideButton_config(MatchInfo, "matchinfo", 1);
		
		TeamInfo=new JButton(new ImageIcon("images/system_img/teaminfo_initial.png"));
		sideButton_config(TeamInfo, "teaminfo", 2);
		
		PlayerInfo=new JButton(new ImageIcon("images/system_img/playerinfo_initial.png"));
		sideButton_config(PlayerInfo, "playerinfo", 3);
		PlayerInfo.setSelected(true);
		
		Hot=new JButton(new ImageIcon("images/system_img/hot_initial.png"));
		sideButton_config(Hot, "hot", 4);
		
		commit=new JButton(new ImageIcon("images/buttons/playertech/Commit_initial.png"));
		commit.setBounds(WIDTH-TABLEWIDTH-e_space-space+(BOXWIDTH+10)*3,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		commit.setBorderPainted(false);
		commit.setContentAreaFilled(false);
		commit.setFocusPainted(false);
		commit.setRolloverIcon(new ImageIcon("images/buttons/playertech/Commit_rollover.png"));
		commit.setPressedIcon(new ImageIcon("images/buttons/playertech/Commit_pressed.png"));
		commit.addActionListener(this);
		
		reset=new JButton(new ImageIcon("images/buttons/playertech/Reset_initial.png"));
		reset.setBounds(WIDTH-TABLEWIDTH-e_space-space+(BOXWIDTH+10)*4, HEIGHT-TABLEHEIGHT-e_space-space-50, 100, 30);
		reset.setBorderPainted(false);
		reset.setContentAreaFilled(false);
		reset.setFocusPainted(false);
		reset.setRolloverIcon(new ImageIcon("images/buttons/playertech/Reset_rollover.png"));
		reset.setPressedIcon(new ImageIcon("images/buttons/playertech/Reset_pressed.png"));
		reset.addActionListener(this);
		
		this.add(commit);
		this.add(reset);
	}
	
	private void sideButton_config(JButton button,String info,int count){
		button.setBounds(26, 145+50*count, 148, 50);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setRolloverIcon(new ImageIcon("images/system_img/"+info+"_rollover.png"));
		button.setPressedIcon(new ImageIcon("images/system_img/"+info+"_pressed.png"));
		button.setSelectedIcon(new ImageIcon("images/system_img/"+info+"_selected.png"));
		button.addActionListener(this);
		this.add(button);
	}
	
	//===================================================================
	
	private void handleinitial(ArrayList<PlayerTechVO> totaldata){
		int a=0;
		playernames=new String[totaldata.size()];
		for(PlayerTechVO i:totaldata){
			playerinfo[a][1]=i.name;
			playerinfo[a][2]=switchTeamName(i.team);
			playerinfo[a][3]=i.gameNum;
			playerinfo[a][4]=i.startingNum;
			playerinfo[a][5]=i.rebound;
			playerinfo[a][6]=i.secondaryAttack;
			playerinfo[a][7]=i.time;
			playerinfo[a][8]=i.shotInRate;
			playerinfo[a][9]=i.threeShotInRate;
			playerinfo[a][10]=i.penaltyShotInRate;
			playerinfo[a][11]=i.offensiveNum;
			playerinfo[a][12]=i.defensiveNum;
			playerinfo[a][13]=i.steal;
			playerinfo[a][14]=i.blockShot;
			playerinfo[a][15]=i.fault;
			playerinfo[a][16]=i.foul;
			playerinfo[a][17]=i.score;
			playerinfo[a][18]=i.efficiency;
			playerinfo[a][19]=i.GmScEfficiency;
			playerinfo[a][20]=i.trueShotInRate;
			playerinfo[a][21]=i.shootingEfficiency;
			playerinfo[a][22]=i.reboundRate;
			playerinfo[a][23]=i.offensiveReboundRate;
			playerinfo[a][24]=i.defensiveReboundRate;
			playerinfo[a][25]=i.secondaryAttackRate;
			playerinfo[a][26]=i.stealRate;
			playerinfo[a][27]=i.blockShotRate;
			playerinfo[a][28]=i.faultRate;
			playerinfo[a][29]=i.usageRate;
			playernames[a]=i.name;
			a++;
		}
	}
	
	private void handleTotalData(ArrayList<PlayerTechVO> totaldata){
		int a=0;
		playernames=new String[totaldata.size()];
		for(PlayerTechVO i:totaldata){
			playerinfo[a][1]=i.name;
			playerinfo[a][2]=switchTeamName(i.team);
			playerinfo[a][3]=i.gameNum;
			playerinfo[a][4]=i.startingNum;
			playerinfo[a][5]=i.rebound;
			playerinfo[a][6]=i.secondaryAttack;
			playerinfo[a][7]=i.time;
			playerinfo[a][8]=i.shotInRate;
			playerinfo[a][9]=i.threeShotInRate;
			playerinfo[a][10]=i.penaltyShotInRate;
			playerinfo[a][11]=i.offensiveNum;
			playerinfo[a][12]=i.defensiveNum;
			playerinfo[a][13]=i.steal;
			playerinfo[a][14]=i.blockShot;
			playerinfo[a][15]=i.fault;
			playerinfo[a][16]=i.foul;
			playerinfo[a][17]=i.score;
			playerinfo[a][18]=i.efficiency;
			playerinfo[a][19]=i.GmScEfficiency;
			playerinfo[a][20]=i.trueShotInRate;
			playerinfo[a][21]=i.shootingEfficiency;
			playerinfo[a][22]=i.reboundRate;
			playerinfo[a][23]=i.offensiveReboundRate;
			playerinfo[a][24]=i.defensiveReboundRate;
			playerinfo[a][25]=i.secondaryAttackRate;
			playerinfo[a][26]=i.stealRate;
			playerinfo[a][27]=i.blockShotRate;
			playerinfo[a][28]=i.faultRate;
			playerinfo[a][29]=i.usageRate;
			a++;
			
		}
		refreshtable();
	}

	private void handleAverageData(ArrayList<PlayerTechVO> averagedata){
		int a=0;
		for(PlayerTechVO i:averagedata){
			playerinfo[a][1]=i.name;
			playerinfo[a][2]=switchTeamName(i.team);
			playerinfo[a][3]=i.gameNum;
			playerinfo[a][4]=i.startingNum;
			playerinfo[a][5]=i.reboundave;
			playerinfo[a][6]=i.secondaryAttackave;
			playerinfo[a][7]=i.timeave;
			playerinfo[a][8]=i.shotInRate;
			playerinfo[a][9]=i.threeShotInRate;
			playerinfo[a][10]=i.penaltyShotInRate;
			playerinfo[a][11]=i.offensiveNumave;
			playerinfo[a][12]=i.defensiveNumave;
			playerinfo[a][13]=i.stealave;
			playerinfo[a][14]=i.blockShotave;
			playerinfo[a][15]=i.faultave;
			playerinfo[a][16]=i.foulave;
			playerinfo[a][17]=i.scoreave;
			playerinfo[a][18]=i.efficiency;
			playerinfo[a][19]=i.GmScEfficiency;
			playerinfo[a][20]=i.trueShotInRate;
			playerinfo[a][21]=i.shootingEfficiency;
			playerinfo[a][22]=i.reboundRate;
			playerinfo[a][23]=i.offensiveReboundRate;
			playerinfo[a][24]=i.defensiveReboundRate;
			playerinfo[a][25]=i.secondaryAttackRate;
			playerinfo[a][26]=i.stealRate;
			playerinfo[a][27]=i.blockShotRate;
			playerinfo[a][28]=i.faultRate;
			playerinfo[a][29]=i.usageRate;
			a++;
		}
		refreshtable();
	}

	//The class extends TableCellRender,however,due to the poor vision,I choose to change the way to show table in project3.0
	 private class Showplayerimg extends DefaultTableCellRenderer{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int Count;
		private String Name;
		private JLabel img;
		
		public Showplayerimg(int count,String name) {
			Count=count;
			Name=name;
		}
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			if(row==Count){
			ImageIcon Icon=new ImageIcon("images/players/portrait_long/"+Name+".png");
			img=new JLabel(Icon);
			}
			return img;
		}
	}

	 //reference
	/*
	 * case "ATL":
			return "老鹰 Atlanta-Hawks";
		case "CHA":
			return "黄蜂 Charlotte-Hornets";
		case "MIA":
			return "热火 Miami-Heat";
		case "ORL":
			return "魔术 Orlando-Magic";
		case "WAS":
			return "奇才 Washington-Wizards";
			
		case "CHI":
			return "公牛 Chicago-Bulls";
		case "CLE":
			return "骑士 Cleveland-Cavaliers";
		case "DET":
			return "活塞 Detroit-Pistons";
		case "IND":
			return "步行者 Indiana-Pacers";
		case "MIL":
			return "雄鹿 Milwaukee-Bucks";
			
		case "BOS":
			return "凯尔特人 Boston-Celtics";
		case "BKN":
			return "篮网 Brooklyn-Nets";
		case "NYK":
			return "尼克斯 New York-Knicks";
		case "PHI":
			return "76人 Philadelphia-76ers";
		case "TOR":
			return "猛龙 Toronto-Raptors";
			
			
		case "GSW":
			return "勇士 Golden State-Warriors";
		case "LAC":
			return "快船 Los Angeles-Clippers";
		case "LAL":
			return "湖人 Los Angeles-Lakers";
		case "PHX":
			return "太阳 Phoenix-Suns";
		case "SAC":
			return "国王 Sacramento-Kings";
			
		case "DEN":
			return "掘金 Denver-Nuggets";
		case "MIN":
			return "森林狼 Minnesota-Timberwolves";
		case "OKC":
			return "雷霆 Oklahoma City-Thunder";
		case "POR":
			return "开拓者 Portland-Trail Blazers";
		case "UTA":
			return "勇士 Utah-Jazz";
			
		case "DAL":
			return "小牛 Dallas-Mavericks";
		case "HOU":
			return "火箭 Houston-Rockets";
		case "MEM":
			return "灰熊 Memphis-Grizzlies";
		case "NOP":
			return "鹈鹕 New Orleans-Pelicans";
		case "NOH":
			return "鹈鹕 New Orleans-Pelicans";
		case "SAS":
			return "马刺 San Antonio-Spurs";
	 * 
	 * 
	 */
	
	private String switchTeamName(String name){
		switch(name){
		case "ATL":
			return "老鹰 - Hawks";
		case "CHA":
			return "黄蜂 - Hornets";
		case "MIA":
			return "热火 - Heat";
		case "ORL":
			return "魔术 - Magic";
		case "WAS":
			return "奇才 - Wizards";
			
		case "CHI":
			return "公牛 - Bulls";
		case "CLE":
			return "骑士 - Cavaliers";
		case "DET":
			return "活塞 - Pistons";
		case "IND":
			return "步行者 - Pacers";
		case "MIL":
			return "雄鹿 - Bucks";
			
		case "BOS":
			return "凯尔特人 - Celtics";
		case "BKN":
			return "篮网 - Nets";
		case "NYK":
			return "尼克斯 - Knicks";
		case "PHI":
			return "76人 - 76ers";
		case "TOR":
			return "猛龙 - Raptors";
			
			
		case "GSW":
			return "勇士 - Warriors";
		case "LAC":
			return "快船 - Clippers";
		case "LAL":
			return "湖人 - Lakers";
		case "PHX":
			return "太阳 - Suns";
		case "SAC":
			return "国王 - Kings";
			
		case "DEN":
			return "掘金 - Nuggets";
		case "MIN":
			return "森林狼 - Timberwolves";
		case "OKC":
			return "雷霆 - Thunder";
		case "POR":
			return "开拓者 - Trail Blazers";
		case "UTA":
			return "勇士 - Jazz";
			
		case "DAL":
			return "小牛 - Mavericks";
		case "HOU":
			return "火箭 - Rockets";
		case "MEM":
			return "灰熊 - Grizzlies";
		case "NOP":
			return "鹈鹕 - Pelicans";
		case "NOH":
			return "鹈鹕 - Pelicans";
		case "SAS":
			return "马刺 - Spurs";
		default :
				return null;
		}
	}
	
	//表格配置
    public void table_config(){
		//------------------------------表格基本属性--------------------------
		for(int i=0;i<playerinfo.length;i++){
			playerinfo[i][0]=i+1;
		}
		//表格属性设置
		playertable=new JTable(playerinfo, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//根据条目名自动调整列宽
		playertable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//设置表格列不可移动
		playertable.getTableHeader().setReorderingAllowed(false);
		//设置列名居中
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) playertable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//设置表格数据及表头字体字号
		playertable.setFont(PTPre.CellFont);
		playertable.setForeground(PTPre.CellFg);
		playertable.getTableHeader().setFont(PTPre.HeaderFont);
		playertable.getTableHeader().setForeground(PTPre.TableFg);
		playertable.getTableHeader().setOpaque(false);
		playertable.getTableHeader().setBackground(PTPre.TableBg);
		//去除边框
		playertable.setBorder(null);

//		playertable.setOpaque(false);
		//按行修改表格背景
		TableColumnModel model = playertable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//不显示单元格边框线
		playertable.setShowHorizontalLines(false);
		playertable.setShowVerticalLines(false);
		//设置选中颜色
		playertable.setSelectionBackground(PTPre.LineSelected);

		//设置行高
		playertable.setRowHeight(ROWHEIGHT);
		//设置列宽
		for(int i=0;i<COLUMNWIDTH.length;i++){
			playertable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}
		
//		for(int i=0;i<playernames.length;i++){
//			playername=playernames[i];
//			System.out.println(playername);
//		playertable.getColumnModel().getColumn(1).setCellRenderer(new Showplayerimg(i,playername));
//		}
		//-----------------------------------------------------------------
		//添加table表头点击事件
		playertable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=playertable.columnAtPoint(e.getPoint());
				String orderSource=playertable.getColumnName(HeaderColumn);
				//System.out.println(orderSource);
				if(!orderSource.equals("排名")){
					message.setText("当前排序依据:"+orderSource);
					judgeOrderSource(orderSource,(String) switchbox.getSelectedItem());
				}

			}
		});

	}

	public void refreshtable(){
		table_config();
		players.setViewportView(playertable);
		Frame.repaint();
	}

	private void judgeOrderSource(String ordersource,String AvgOrTotal){
		ArrayList<PlayerTechVO> orderPlayerTechVO = null;
		if(order_Asc.isSelected()){
		switch(ordersource){

		case "球员名称":
			orderPlayerTechVO=importdata.getPlayerTechAscend("name");
			break;
		case "所属球队":
			orderPlayerTechVO=importdata.getPlayerTechAscend("team");
			break;
		case "参赛场数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("gamenum");
			break;
		case "先发场数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("startingnum");
			break;
		case "篮板数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("reboundave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("rebound");
			}
			break;
		case "助攻数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("secondaryattackave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("secondaryattack");
			}
			break;
		case "在场时间":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("timeave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("time");
			}
			break;
			
		case "投篮命中率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("shotinrate");
			break;
		case "三分命中率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("threeshotinrate");
			break;
		case "罚球命中率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("penaltyshotinrate");
			break;
			
		case "进攻数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("offensivenumave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("offensivenum");
				}
			break;
		case "防守数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("defensivenumave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("defensivenum");
				}
			break;
		case "抢断数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("stealave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("steal");
				}
			break;
		case "盖帽数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("blockshotave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("blockshot");
				}
			break;
		case "失误数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("faultave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("fault");
				}
			break;
		case "犯规数":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("foulave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("foul");
				}
			break;
		case "得分":
			if(AvgOrTotal.equals("场均数据")){
				orderPlayerTechVO=importdata.getPlayerTechAscend("scoreave");
			}else{
				orderPlayerTechVO=importdata.getPlayerTechAscend("score");
			}
			break;
		case "效率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("efficiency");
			break;
		case "GmSc 效率值":
			orderPlayerTechVO=importdata.getPlayerTechAscend("gmscefficiency");
			break;
		case "真实命中率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("trueshotinrate");
			break;
		case "投篮效率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("shootingefficiency");
			break;
		case "篮板率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("reboundrate");
			break;
		case "进攻篮板率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("offensivereboundrate");
			break;
		case "防守篮板率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("defensivereboundrate");
			break;
		case "助攻率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("secondaryattackrate");
			break;
		case "抢断率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("stealrate");
			break;
		case "盖帽率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("blockshotrate");
			break;
		case "失误率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("faultrate");
			break;
		case "使用率":
			orderPlayerTechVO=importdata.getPlayerTechAscend("usagerate");
			break;
		}
		
		}
		if(order_Des.isSelected()){
			switch(ordersource){
			case "球员名称":
				orderPlayerTechVO=importdata.getPlayerTechDescend("name");
				break;
			case "所属球队":
				orderPlayerTechVO=importdata.getPlayerTechDescend("team");
				break;
			case "参赛场数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("gamenum");
				break;
			case "先发场数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("startingnum");
				break;
			case "篮板数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("reboundave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("rebound");
				}
				break;
			case "助攻数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("secondaryattackave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("secondaryattack");
				}
				break;
			case "在场时间":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("timeave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("time");
				}
				break;
				
			case "投篮命中率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("shotinrate");
				break;
			case "三分命中率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("threeshotinrate");
				break;
			case "罚球命中率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("penaltyshotinrate");
				break;
				
			case "进攻数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("offensivenumave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("offensivenum");
				}
				break;
			case "防守数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("defensivenumave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("defensivenum");
				}
				break;
			case "抢断数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("stealave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("steal");
				}
				break;
			case "盖帽数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("blockshotave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("blockshot");
				}
				break;
			case "失误数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("faultave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("fault");
				}
				break;
			case "犯规数":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("foulave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("foul");
				}
				break;
			case "得分":
				if(AvgOrTotal.equals("场均数据")){
					orderPlayerTechVO=importdata.getPlayerTechDescend("scoreave");
				}else{
					orderPlayerTechVO=importdata.getPlayerTechDescend("score");
				}
				break;
			case "效率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("efficiency");
				break;
			case "GmSc 效率值":
				orderPlayerTechVO=importdata.getPlayerTechDescend("gmscefficiency");
				break;
			case "真实命中率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("trueshotinrate");
				break;
			case "投篮效率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("shootingefficiency");
				break;
			case "篮板率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("reboundrate");
				break;
			case "进攻篮板率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("offensivereboundrate");
				break;
			case "防守篮板率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("defensivereboundrate");
				break;
			case "助攻率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("secondaryattackrate");
				break;
			case "抢断率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("stealrate");
				break;
			case "盖帽率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("blockshotrate");
				break;
			case "失误率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("faultrate");
				break;
			case "使用率":
				orderPlayerTechVO=importdata.getPlayerTechDescend("usagerate");
				break;
			}
		}
		
		if(AvgOrTotal.equals("赛季总数据")){
			handleTotalData(orderPlayerTechVO);
			}else if(AvgOrTotal.equals("场均数据")){
				handleAverageData(orderPlayerTechVO);
			}
	}
	
	//滑动面板配置
	public void scrollpane_config(){
		//滑动面板信息
		players=new JScrollPane(playertable);
		players.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space,TABLEWIDTH,TABLEHEIGHT);
		players.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		players.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		players.setVisible(true);
		players.setOpaque(false);
		players.getViewport().setOpaque(false);
		players.setBorder(null);

		if (players.getCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, PTPre.LineSelected,
							bounds.width, bounds.height, PTPre.LineSelected);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			players.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, component);
		}

		if (players.getCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, PTPre.TableBg,
							bounds.width, bounds.height, PTPre.TableBg);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			players.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER,component);
		}
		this.add(players);
	}

	//重载单元格标准类,用于改变单元格背景颜色
	private class RowRenderer extends DefaultTableCellRenderer 
	{
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) 
		{
			//单元格居中
			setHorizontalAlignment(JLabel.CENTER);
			//设置奇偶行的背景色
			if (row % 2 == 0)
				setBackground(PTPre.EvenTableLine);
			else
				setBackground(PTPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	//绘制球员数据界面背景
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/main_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}

	//按钮鼠标监听事件
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==trigger){
			if(!trigger.isSelected()){
				Thread show=new Thread(){
					public void run(){
						for(int i=letterbutton.length-1;i>=0;i--){
							letterbutton[i].setVisible(true);
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
			show.start();
			trigger.setSelected(true);
			}else{
				Thread hide=new Thread(){
					public void run(){
						for(int i=0;i<letterbutton.length;i++){
							letterbutton[i].setVisible(false);
							try {
								Thread.sleep(15);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
				hide.start();
				trigger.setSelected(false);
			}
		}
		
		
		if(arg0.getSource()==seniorsift){
			if(!seniorsift.isSelected()){
			seniorsift.setSelected(true);
			Frame.add(siftpanel);
			Frame.add(this);
			playertable.setEnabled(false);
			playertable.getTableHeader().setEnabled(false);
			Frame.repaint();
			}else{
				Frame.remove(siftpanel);
				seniorsift.setSelected(false);
				Frame.repaint();
			}
		}
		
		if(arg0.getSource()==add){
			seniorsiftpanel.addcondition();
			seniorsiftpanel.repaint();
		}
		if(arg0.getSource()==delete){
			seniorsiftpanel.deletecondition();
			seniorsiftpanel.repaint();
		}
		
		if(arg0.getSource()==commit){
			seniorsiftpanel.getScreeningCondition();
			//TODO test the screeningcondition and delete it when necessary
			for(int i=0;i<screeningconditions.size();i++){
				System.out.println(screeningconditions.get(i).position+"--"+screeningconditions.get(i).division+"--"+screeningconditions.get(i).condition+"--"+screeningconditions.get(i).number);
			}
			ArrayList<PlayerTechVO> siftVO=importdata.sift(screeningconditions);
			playerinfo=new Object[siftVO.size()][columnName.length];
			String switchboxsel=(String) switchbox.getSelectedItem();
			if(switchboxsel.equals("赛季总数据")){
				handleTotalData(siftVO);
			}else if(switchboxsel.equals("场均数据")){
				handleAverageData(siftVO);
			}
			
			
		}
		
		if(arg0.getSource()==reset){
			Frame.remove(this);
			PlayerTechPanel ptp=new PlayerTechPanel(Frame);
			Frame.add(ptp);
			Frame.repaint();
		}
		
		if(arg0.getSource()==SeasonInfo){
			Frame.remove(panelToRemove);
			TeamTechPanel panel=new TeamTechPanel(Frame);
			Frame.add(panel);
			Frame.repaint();
		}
		if(arg0.getSource()==MatchInfo){
			Frame.remove(panelToRemove);
			MatchPanel panel=new MatchPanel(Frame);
			Frame.add(panel);
			Frame.repaint();
		}
		if(arg0.getSource()==TeamInfo){
			Frame.remove(panelToRemove);
			TeamInfoPanel panel=new TeamInfoPanel(Frame);
			Frame.add(panel);
			Frame.repaint();
		}
		if(arg0.getSource()==Hot){
			Frame.remove(panelToRemove);
			HotPlayerToday panel=new HotPlayerToday(Frame);
			Frame.add(panel);
			Frame.repaint();
		}
	}

}
