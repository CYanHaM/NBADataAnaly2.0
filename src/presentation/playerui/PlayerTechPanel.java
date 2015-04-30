package presentation.playerui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.preset.PlayerTechPre;
import presentation.teamui.TeamInfoPanel;
import presentation.teamui.TeamTechPanel;
import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;

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
	private static int TABLEHEIGHT=450;
	//表格行高
	private static int ROWHEIGHT=28;
	//表格列宽
	private static int[] COLUMNWIDTH={50,120,200,
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
	
	private JComboBox<String> positionbox;
	private String[] positionItem={"球员位置","前锋","中锋","后卫"};
	private String[] positionstring={"F","C","G"};
	private JComboBox<String> divisionbox;
	private String[] divisionItem={"球员联盟","东部","西部"};
	private String[] divisionstring={"E","W"};
	private JComboBox<String> ordergistbox;
	private String[] ordergistItem={"排序依据","得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
	private String[] ordergiststring={"score","rebound","secondaryattack","srs","blockshot","steal","foul","fault","time","efficiency","shot","threeshot","penaltyshot","doubledouble"};
	//排序方式单选按钮组
	private JRadioButton order_Asc;
	private JRadioButton order_Des;
	private ButtonGroup group;
	//排序依据显示行
	private JLabel message;
	//筛选提交按钮
	private JButton commit;
	//表格重置按钮
	private JButton reset;
	//侧边栏按钮
	private JButton TeamTech;
	private JButton PlayerTech;
	private JButton TeamData;
//	private JButton PlayerData;
	
	//----------------------------------------------------
	public PlayerTechPre PTPre;
	public ImportPlayer importdata;
	public ArrayList<PlayerTechVO> initial_data;

	public int HeaderColumn=0;
	public JFrame Frame; 
	public PlayerTechPanel(JFrame frame){
		Frame=frame;
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
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
		//添加单选按钮组
		addradiobutton();
		//添加提示信息
		addmessage();
		//添加提交，重置按钮
		addbutton();
		
		this.repaint();
		
		
	}
	
//	public void init(){
//		switchbox.setSelectedIndex(0);
//		positionbox.setSelectedIndex(0);
//		divisionbox.setSelectedIndex(0);
//		ordergistbox.setSelectedIndex(0);
//		initial_data=importdata.getPlayerTechAscend(PlayerTechEnum.name);
//		playerinfo=new Object[initial_data.size()][columnName.length];
//		//加载初始表格，显示队伍总数据
//		handleinitial(initial_data);
//
//		//加载表格配置
//		table_config();
//		//加载滑动面板配置
//		scrollpane_config();
//		this.repaint();
//	}

	//===================================================================
	private void addbox(){
		//下拉框
		switchbox=new JComboBox<String>();
		switchbox.setFocusable(false);
		switchbox.setBackground(PTPre.LineSelected);
		switchbox.addItem("赛季总数据");
		switchbox.addItem("场均数据");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-100,BOXWIDTH,BOXHEIGHT);
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


		positionbox=new JComboBox<String>(positionItem);
		positionbox.setFocusable(false);
		positionbox.setBackground(PTPre.LineSelected);
		positionbox.setFont(PTPre.switchbox);
		positionbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);

		divisionbox=new JComboBox<String>(divisionItem);
		divisionbox.setFocusable(false);
		divisionbox.setBackground(PTPre.LineSelected);
		divisionbox.setFont(PTPre.switchbox);
		divisionbox.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+10,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);

		ordergistbox=new JComboBox<String>(ordergistItem);
		ordergistbox.setFocusable(false);
		ordergistbox.setBackground(PTPre.LineSelected);
		ordergistbox.setFont(PTPre.switchbox);
		ordergistbox.setBounds(WIDTH-TABLEWIDTH-e_space-space+(BOXWIDTH+10)*2,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		
		this.add(switchbox);
		this.add(positionbox);
		this.add(divisionbox);
		this.add(ordergistbox);
	}
	
	private void addradiobutton(){
		order_Asc=new JRadioButton("升序");
		order_Asc.setFont(PTPre.switchbox);
		order_Asc.setForeground(PTPre.TableFg);
		order_Asc.setBorderPainted(false);
		order_Asc.setContentAreaFilled(false);
		order_Asc.setFocusPainted(false);
//		order_Asc.setSelected(true);
		order_Asc.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+10,HEIGHT-TABLEHEIGHT-e_space-space-92,50,15);
		
		order_Des=new JRadioButton("降序");
		order_Des.setFont(PTPre.switchbox);
		order_Des.setForeground(PTPre.TableFg);
		order_Des.setBorderPainted(false);
		order_Des.setContentAreaFilled(false);
		order_Des.setFocusPainted(false);
		order_Des.setSelected(true);
		order_Des.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+60,HEIGHT-TABLEHEIGHT-e_space-space-92,50,15);
		
		group=new ButtonGroup();
		group.add(order_Asc);
		group.add(order_Des);
		
		this.add(order_Asc);
		this.add(order_Des);
	}
	
	private void addmessage(){
		message=new JLabel();
		message.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+120, HEIGHT-TABLEHEIGHT-e_space-space-92, 200, 15);
		message.setFont(PTPre.switchbox);
		message.setForeground(PTPre.TableFg);
		
		this.add(message);
	}
	
	private void addbutton(){
		TeamTech=new JButton(new ImageIcon("images/buttons/teamtech/TeamTech_initial.png"));
		TeamTech.setBounds(26, 145, 148, 40);
		TeamTech.setBorderPainted(false);
		TeamTech.setContentAreaFilled(false);
		TeamTech.setFocusPainted(false);
		TeamTech.setRolloverIcon(new ImageIcon("images/buttons/teamtech/TeamTech_rollover.png"));
		TeamTech.setPressedIcon(new ImageIcon("images/buttons/teamtech/TeamTech_pressed.png"));
		TeamTech.addActionListener(this);
		
		PlayerTech=new JButton(new ImageIcon("images/buttons/playertech/PlayerTech_selected.png"));
		PlayerTech.setBounds(26, 185, 148, 40);
		PlayerTech.setBorderPainted(false);
		PlayerTech.setContentAreaFilled(false);
		PlayerTech.setFocusPainted(false);
		
		TeamData=new JButton(new ImageIcon("images/buttons/team/Team_initial.png"));
		TeamData.setBounds(26, 225, 148, 40);
		TeamData.setBorderPainted(false);
		TeamData.setContentAreaFilled(false);
		TeamData.setFocusPainted(false);
		TeamData.setRolloverIcon(new ImageIcon("images/buttons/team/Team_rollover.png"));
		TeamData.setPressedIcon(new ImageIcon("images/buttons/team/Team_pressed.png"));
		TeamData.addActionListener(this);
		
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
		this.add(TeamTech);
		this.add(PlayerTech);
		this.add(TeamData);
	}
	//===================================================================
	
	private void handleinitial(ArrayList<PlayerTechVO> totaldata){
		int a=0;
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
	}
	
	private void handleTotalData(ArrayList<PlayerTechVO> totaldata){
		int a=0;
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

	private String switchTeamName(String name){
		switch(name){
		case "ATL":
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
		case "SAS":
			return "马刺 San Antonio-Spurs";
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
		this.repaint();
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
			orderPlayerTechVO=importdata.getPlayerTechAscend("rebound");
			break;
		case "助攻数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("secondaryAttack");
			break;
		case "在场时间":
			orderPlayerTechVO=importdata.getPlayerTechAscend("time");
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
			orderPlayerTechVO=importdata.getPlayerTechAscend("offensivenum");
			break;
		case "防守数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("defensivenum");
			break;
		case "抢断数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("steal");
			break;
		case "盖帽数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("blockshot");
			break;
		case "失误数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("fault");
			break;
		case "犯规数":
			orderPlayerTechVO=importdata.getPlayerTechAscend("foul");
			break;
		case "得分":
			orderPlayerTechVO=importdata.getPlayerTechAscend("score");
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
				orderPlayerTechVO=importdata.getPlayerTechDescend("rebound");
				break;
			case "助攻数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("secondaryAttack");
				break;
			case "在场时间":
				orderPlayerTechVO=importdata.getPlayerTechDescend("time");
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
				orderPlayerTechVO=importdata.getPlayerTechDescend("offensivenum");
				break;
			case "防守数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("defensivenum");
				break;
			case "抢断数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("steal");
				break;
			case "盖帽数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("blockshot");
				break;
			case "失误数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("fault");
				break;
			case "犯规数":
				orderPlayerTechVO=importdata.getPlayerTechDescend("foul");
				break;
			case "得分":
				orderPlayerTechVO=importdata.getPlayerTechDescend("score");
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
		// TODO Auto-generated method stub
		if(arg0.getSource()==commit){
			String positionsel=(String)positionbox.getSelectedItem();
			String divisionsel=(String)divisionbox.getSelectedItem();
			String ordergistsel=(String)ordergistbox.getSelectedItem();
			int positionnum=positionbox.getSelectedIndex();
			int divisionnum=divisionbox.getSelectedIndex();
			int ordergistnum=ordergistbox.getSelectedIndex();
			
			if(!positionsel.equals(positionItem[0])&&
					!divisionsel.equals(divisionItem[0])&&
					!ordergistsel.equals(ordergistItem[0])){
				ArrayList<PlayerTechVO> siftVO = importdata.sift(positionstring[positionnum-1], divisionstring[divisionnum-1], ordergiststring[ordergistnum-1]);
				playerinfo=new Object[siftVO.size()][columnName.length];
				String switchboxsel=(String) switchbox.getSelectedItem();
				if(switchboxsel.equals("赛季总数据")){
					handleTotalData(siftVO);
				}else if(switchboxsel.equals("场均数据")){
					handleAverageData(siftVO);
				}
			}
			//去除表头监听器
//			playertable.getTableHeader().removeMouseListener();
			
		}
		
		if(arg0.getSource()==reset){
			Frame.remove(this);
			PlayerTechPanel ptp=new PlayerTechPanel(Frame);
			Frame.add(ptp);
			Frame.repaint();
		}
		
		if(arg0.getSource()==TeamTech){
			Frame.remove(this);
			TeamTechPanel ttp=new TeamTechPanel(Frame);
			Frame.add(ttp);
			Frame.repaint();
		}
		if(arg0.getSource()==TeamData){
			Frame.remove(this);
			TeamInfoPanel tip=new TeamInfoPanel(Frame);
			Frame.add(tip);
			Frame.repaint();
		}
	}
}
