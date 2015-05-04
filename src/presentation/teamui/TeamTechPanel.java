package presentation.teamui;

<<<<<<< HEAD
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
=======
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
>>>>>>> 371dc0a93333d7cd8a656e6ccaaa1009f2e8afa9
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.hotspotui.HotPlayerToday;
import presentation.matchui.MatchPanel;
import presentation.playerui.PlayerTechPanel;
import presentation.preset.TeamTechPre;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;


public class TeamTechPanel extends JPanel implements ActionListener{
	/**
	 * 球队统计数据界面
	 * @author blisscry
	 * @date 2015年3月21日16:35:28
	 * @version 1.6
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------界面常量-------------------
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//定义边缘透明空白区域边界大小，单位px
	public static int e_space=10;
	//定义空出位置大小
	private static int space=20;
	//设置球队总数常量
	private static int TEAMNUM=30;
	
	//表格大小
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=450;
	//表格行高
	private static int ROWHEIGHT=28;
	//表格列宽
	private static int[] COLUMNWIDTH={50,200,60,80,80,80,80,80,80,80,80,60,60,60,60,60,60,80,80,80,80,80,80,80,80,80};

	//下拉框大小
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	//----------------------------------------------------

	//-------------------------界面组件--------------------
	//设置表格属性
	private static JTable teamtable;
	private static Object[][] teaminfo;
	private JScrollPane teams;
	private String[] columnName={
			"排名","球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数",
			"三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数",
			"篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分",
			"投篮命中率","三分命中率","罚球命中率","胜率","进攻回合",
			"进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	//	
	//	private String[] columnName={"","","","","","","","","","","","","","","","",""};
	//总数据与场均数据切换下拉框
	private JComboBox<String> switchbox;
//	private JComboBox<String> search;
	
	private JRadioButton order_Asc;
	private JRadioButton order_Des;
	private ButtonGroup group;
	
	private JLabel message;
	
	private JButton SeasonInfo;
	private JButton MatchInfo;
	private JButton TeamInfo;
	private JButton PlayerInfo;
	private JButton Hot;

	//----------------------------------------------------
	public TeamTechPre TTPre;
	public ImportTeam importdata;
	public ArrayList<TeamTechVO> initial_data;

	public int HeaderColumn=0;
	public JFrame Frame;
	public JPanel panelToRemove;
	public TeamTechPanel(JFrame frame){
		Frame=frame;
		panelToRemove=this;
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		//创建颜色预设对象
		TTPre=new TeamTechPre();
		importdata=new ImportTeam();
		initial_data=importdata.getTeamTechAscend(TeamTechEnum.name);
//		System.out.println(initial_data.size());

		teaminfo=new Object[initial_data.size()][columnName.length];
//		teaminfo=new Object[TEAMNUM][columnName.length];
		//加载初始表格，显示队伍总数据
		handleinitial(initial_data);

		//加载表格配置
		table_config();
		//加载滑动面板配置
		scrollpane_config();
		//添加下拉框
		addbox();
		//添加单选按钮
		addradiobutton();
		//添加侧边栏按钮
		addbutton();
		
		message=new JLabel();
		message.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+130, HEIGHT-TABLEHEIGHT-e_space-space-42, 200, 15);
		message.setFont(TTPre.switchbox);
		message.setForeground(TTPre.TableFg);
		
		this.add(message);
		this.repaint();
	}
	
	private void addbutton(){
		SeasonInfo=new JButton(new ImageIcon("images/system_img/seasoninfo_initial.png"));
		sideButton_config(SeasonInfo, "seasoninfo", 0);
		SeasonInfo.setSelected(true);
		
		MatchInfo=new JButton(new ImageIcon("images/system_img/matchinfo_initial.png"));
		sideButton_config(MatchInfo, "matchinfo", 1);
		
		TeamInfo=new JButton(new ImageIcon("images/system_img/teaminfo_initial.png"));
		sideButton_config(TeamInfo, "teaminfo", 2);
		
		PlayerInfo=new JButton(new ImageIcon("images/system_img/playerinfo_initial.png"));
		sideButton_config(PlayerInfo, "playerinfo", 3);
		
		Hot=new JButton(new ImageIcon("images/system_img/hot_initial.png"));
		sideButton_config(Hot, "hot", 4);
		
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

	private void addbox(){
		//下拉框
		switchbox=new JComboBox<String>();
		switchbox.setFocusable(false);
		switchbox.setBackground(TTPre.LineSelected);
		switchbox.addItem("赛季总数据");
		switchbox.addItem("场均数据");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(TTPre.switchbox);
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
	
	private void addradiobutton(){
		order_Asc=new JRadioButton("升序");
		order_Asc.setFont(TTPre.switchbox);
		order_Asc.setForeground(TTPre.TableFg);
		order_Asc.setBorderPainted(false);
		order_Asc.setContentAreaFilled(false);
		order_Asc.setFocusPainted(false);
//		order_Asc.setSelected(true);
		order_Asc.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+10,HEIGHT-TABLEHEIGHT-e_space-space-42,50,15);
		
		order_Des=new JRadioButton("降序");
		order_Des.setFont(TTPre.switchbox);
		order_Des.setForeground(TTPre.TableFg);
		order_Des.setBorderPainted(false);
		order_Des.setContentAreaFilled(false);
		order_Des.setFocusPainted(false);
		order_Des.setSelected(true);
		order_Des.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+60,HEIGHT-TABLEHEIGHT-e_space-space-42,50,15);
		
		group=new ButtonGroup();
		group.add(order_Asc);
		group.add(order_Des);
		
		this.add(order_Asc);
		this.add(order_Des);
	}
	
	private void handleinitial(ArrayList<TeamTechVO> totaldata){
		int a=0;
<<<<<<< HEAD
=======
		DecimalFormat f = new DecimalFormat("#,##0.0000");  
		
>>>>>>> 371dc0a93333d7cd8a656e6ccaaa1009f2e8afa9
		for(TeamTechVO i:totaldata){
			teaminfo[a][1]=switchTeamName(i.name);
			teaminfo[a][2]=i.gameNum;
			teaminfo[a][3]=i.shotInNum;
			teaminfo[a][4]=i.shotNum;
			teaminfo[a][5]=i.threeShotInNum;
			teaminfo[a][6]=i.threeShotNum;
			teaminfo[a][7]=i.penaltyShotInNum;
			teaminfo[a][8]=i.penaltyShotNum;
			teaminfo[a][9]=i.offensiveRebound;
			teaminfo[a][10]=i.defensiveRebound;
			teaminfo[a][11]=i.rebound;
			teaminfo[a][12]=i.secondaryAttack;
			teaminfo[a][13]=i.steal;
			teaminfo[a][14]=i.blockShot;
			teaminfo[a][15]=i.fault;
			teaminfo[a][16]=i.foul;
			teaminfo[a][17]=i.score;
			teaminfo[a][18]=f.format(i.shotInRate);
			teaminfo[a][19]=f.format(i.threeShotInRate);
			teaminfo[a][20]=f.format(i.penaltyShotInRate);
			teaminfo[a][21]=f.format(i.winningRate);
			teaminfo[a][22]=f.format(i.offensiveRound);
			teaminfo[a][23]=f.format(i.offensiveEfficiency);
			teaminfo[a][24]=f.format(i.defensiveEfficiency);
			teaminfo[a][25]=f.format(i.reboundEfficiency);
			teaminfo[a][26]=f.format(i.stealEfficiency);
			teaminfo[a][27]=f.format(i.secondaryAttackEfficiency);
			a++;
		}
	}
	
	private void handleTotalData(ArrayList<TeamTechVO> totaldata){
		DecimalFormat f = new DecimalFormat("#,##0.0000"); 
		int a=0;
		for(TeamTechVO i:totaldata){
			teaminfo[a][1]=switchTeamName(i.name);
			teaminfo[a][2]=i.gameNum;
			teaminfo[a][3]=i.shotInNum;
			teaminfo[a][4]=i.shotNum;
			teaminfo[a][5]=i.threeShotInNum;
			teaminfo[a][6]=i.threeShotNum;
			teaminfo[a][7]=i.penaltyShotInNum;
			teaminfo[a][8]=i.penaltyShotNum;
			teaminfo[a][9]=i.offensiveRebound;
			teaminfo[a][10]=i.defensiveRebound;
			teaminfo[a][11]=i.rebound;
			teaminfo[a][12]=i.secondaryAttack;
			teaminfo[a][13]=i.steal;
			teaminfo[a][14]=i.blockShot;
			teaminfo[a][15]=i.fault;
			teaminfo[a][16]=i.foul;
			teaminfo[a][17]=i.score;
			teaminfo[a][18]=f.format(i.shotInRate);
			teaminfo[a][19]=f.format(i.threeShotInRate);
			teaminfo[a][20]=f.format(i.penaltyShotInRate);
			teaminfo[a][21]=f.format(i.winningRate);
			teaminfo[a][22]=f.format(i.offensiveRound);
			teaminfo[a][23]=f.format(i.offensiveEfficiency);
			teaminfo[a][24]=f.format(i.defensiveEfficiency);
			teaminfo[a][25]=f.format(i.reboundEfficiency);
			teaminfo[a][26]=f.format(i.stealEfficiency);
			teaminfo[a][27]=f.format(i.secondaryAttackEfficiency);
			a++;
		}
		refreshtable();
	}

	private void handleAverageData(ArrayList<TeamTechVO> averagedata){
		DecimalFormat f = new DecimalFormat("#,##0.0000"); 
		int a=0;
		for(TeamTechVO i:averagedata){
			teaminfo[a][1]=switchTeamName(i.name);
			teaminfo[a][2]=i.gameNum;
			teaminfo[a][3]=f.format(i.shotInNumave);
			teaminfo[a][4]=f.format(i.shotNumave);
			teaminfo[a][5]=f.format(i.threeShotInNumave);
			teaminfo[a][6]=f.format(i.threeShotNumave);
			teaminfo[a][7]=f.format(i.penaltyShotInNumave);
			teaminfo[a][8]=f.format(i.penaltyShotNumave);
			teaminfo[a][9]=f.format(i.offensiveReboundave);
			teaminfo[a][10]=f.format(i.defensiveReboundave);
			teaminfo[a][11]=f.format(i.reboundave);
			teaminfo[a][12]=f.format(i.secondaryAttackave);
			teaminfo[a][13]=f.format(i.stealave);
			teaminfo[a][14]=f.format(i.blockShotave);
			teaminfo[a][15]=f.format(i.faultave);
			teaminfo[a][16]=f.format(i.foulave);
			teaminfo[a][17]=f.format(i.scoreave);
			teaminfo[a][18]=f.format(i.shotInRate);
			teaminfo[a][19]=f.format(i.threeShotInRate);
			teaminfo[a][20]=f.format(i.penaltyShotInRate);
			teaminfo[a][21]=f.format(i.winningRate);
			teaminfo[a][22]=f.format(i.offensiveRoundave);
			teaminfo[a][23]=f.format(i.offensiveEfficiency);
			teaminfo[a][24]=f.format(i.defensiveEfficiency);
			teaminfo[a][25]=f.format(i.reboundEfficiency);
			teaminfo[a][26]=f.format(i.stealEfficiency);
			teaminfo[a][27]=f.format(i.secondaryAttackEfficiency);
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
		case "NOH":
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
//		for(int i=0;i<initial_data.size();i++){
//			teaminfo[i][0]=i+1;
//		}
		for(int i=0;i<TEAMNUM;i++){
			teaminfo[i][0]=i+1;
		}
		//表格属性设置
		teamtable=new JTable(teaminfo, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//根据条目名自动调整列宽
		teamtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//设置表格列不可移动
		teamtable.getTableHeader().setReorderingAllowed(false);
		//设置列名居中
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) teamtable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//设置表格数据及表头字体字号
		teamtable.setFont(TTPre.CellFont);
		teamtable.setForeground(TTPre.CellFg);
		teamtable.getTableHeader().setFont(TTPre.HeaderFont);
		teamtable.getTableHeader().setForeground(TTPre.TableFg);
		teamtable.getTableHeader().setOpaque(false);
		teamtable.getTableHeader().setBackground(TTPre.TableBg);
		//去除边框
		teamtable.setBorder(null);

		//按行修改表格背景
		TableColumnModel model = teamtable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//不显示单元格边框线
		teamtable.setShowHorizontalLines(false);
		teamtable.setShowVerticalLines(false);
		//设置选中颜色
		teamtable.setSelectionBackground(TTPre.LineSelected);
		
		//设置行高
		teamtable.setRowHeight(ROWHEIGHT);
		//设置列宽
		for(int i=0;i<COLUMNWIDTH.length;i++){
		teamtable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}
		
		//-----------------------------------------------------------------

		//添加table表头点击事件
		teamtable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=teamtable.columnAtPoint(e.getPoint());
				String orderSource=teamtable.getColumnName(HeaderColumn);
//				System.out.println(orderSource);
				if(!orderSource.equals("排名")&&!orderSource.equals("比赛场数")){
					message.setText("当前排序依据:"+orderSource);
				judgeOrderSource(orderSource,(String) switchbox.getSelectedItem());
				}
				
			}
		});

	}

	public void refreshtable(){
		table_config();
		teams.setViewportView(teamtable);
		this.repaint();
	}

	private void judgeOrderSource(String ordersource,String AvgOrTotal){
		ArrayList<TeamTechVO> orderTeamTechVO = null;
		if(order_Asc.isSelected()){
		switch(ordersource){
		case "球队名称":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.name);
			break;
		case "投篮命中数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.shotInNum);
			break;
		case "投篮出手次数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.shotNum);
			break;
		case "三分命中数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.threeShotInNum);
			break;
		case "三分出手数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.threeShotNum);
			break;
		case "罚球命中数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.penaltyShotInNum);
			break;
		case "罚球出手数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.penaltyShotNum);
			break;
		case "进攻篮板数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.offensiveRebound);
			break;
		case "防守篮板数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.defensiveRebound);
			break;
		case "篮板数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.rebound);
			break;
		case "助攻数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.secondaryAttack);
			break;
		case "抢断数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.steal);
			break;
		case "盖帽数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.blockShot);
			break;
		case "失误数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.fault);
			break;
		case "犯规数":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.foul);
			break;
		case "比赛得分":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.score);
			break;
		case "投篮命中率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.shotInRate);
			break;
		case "三分命中率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.threeShotInRate);
			break;
		case "罚球命中率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.penaltyShotInRate);
			break;
		case "胜率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.winningRate);
			break;
		case "进攻回合":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.offensiveRound);
			break;
		case "进攻效率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.offensiveEfficiency);
			break;
		case "防守效率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.defensiveEfficiency);
			break;
		case "篮板效率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.reboundEfficiency);
			break;
		case "抢断效率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.stealEfficiency);
			break;
		case "助攻效率":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.secondaryAttackEfficiency);
			break;
		}
		
		}
		if(order_Des.isSelected()){
			switch(ordersource){
			case "球队名称":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.name);
				break;
			case "比赛场数":
//				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.gameNum);
				break;
			case "投篮命中数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.shotInNum);
				break;
			case "投篮出手次数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.shotNum);
				break;
			case "三分命中数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.threeShotInNum);
				break;
			case "三分出手数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.threeShotNum);
				break;
			case "罚球命中数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.penaltyShotInNum);
				break;
			case "罚球出手数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.penaltyShotNum);
				break;
			case "进攻篮板数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.offensiveRebound);
				break;
			case "防守篮板数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.defensiveRebound);
				break;
			case "篮板数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.rebound);
				break;
			case "助攻数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.secondaryAttack);
				break;
			case "抢断数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.steal);
				break;
			case "盖帽数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.blockShot);
				break;
			case "失误数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.fault);
				break;
			case "犯规数":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.foul);
				break;
			case "比赛得分":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.score);
				break;
			case "投篮命中率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.shotInRate);
				break;
			case "三分命中率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.threeShotInRate);
				break;
			case "罚球命中率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.penaltyShotInRate);
				break;
			case "胜率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.winningRate);
				break;
			case "进攻回合":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.offensiveRound);
				break;
			case "进攻效率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.offensiveEfficiency);
				break;
			case "防守效率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.defensiveEfficiency);
				break;
			case "篮板效率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.reboundEfficiency);
				break;
			case "抢断效率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.stealEfficiency);
				break;
			case "助攻效率":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.secondaryAttackEfficiency);
				break;
			}
		}
		
		if(AvgOrTotal.equals("赛季总数据")){
			handleTotalData(orderTeamTechVO);
			}else if(AvgOrTotal.equals("场均数据")){
				handleAverageData(orderTeamTechVO);
			}
	}

	//滑动面板配置
	public void scrollpane_config(){
		//滑动面板信息
		teams=new JScrollPane(teamtable);
		teams.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space,TABLEWIDTH,TABLEHEIGHT);
		teams.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		teams.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		teams.setVisible(true);
		teams.setOpaque(false);
		teams.getViewport().setOpaque(false);
		teams.setBorder(null);

		if (teams.getCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, TTPre.LineSelected,
							bounds.width, bounds.height, TTPre.LineSelected);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			teams.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, component);
		}

		if (teams.getCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, TTPre.TableBg,
							bounds.width, bounds.height, TTPre.TableBg);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			teams.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER,component);
		}
		
		this.add(teams);
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
				setBackground(TTPre.EvenTableLine);
			else
				setBackground(TTPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	//绘制赛季数据界面背景
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/main_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
		if(arg0.getSource()==PlayerInfo){
			Frame.remove(panelToRemove);
			PlayerTechPanel panel=new PlayerTechPanel(Frame);
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