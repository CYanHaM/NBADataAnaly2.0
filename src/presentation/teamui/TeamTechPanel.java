package presentation.teamui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import presentation.preset.TeamTechPre;
import presentation.playerui.PlayerTechPanel;


public class TeamTechPanel extends JPanel implements ActionListener{
	/**
	 * ���ͳ�����ݽ���
	 * @author blisscry
	 * @date 2015��3��21��16:35:28
	 * @version 1.6
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------���泣��-------------------
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//�����Ե͸���հ�����߽��С����λpx
	public static int e_space=10;
	//����ճ�λ�ô�С
	private static int space=20;
	//���������������
	private static int TEAMNUM=30;
	
	//����С
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=450;
	//����и�
	private static int ROWHEIGHT=28;
	//����п�
	private static int[] COLUMNWIDTH={50,200,60,80,80,80,80,80,80,80,80,60,60,60,60,60,60,80,80,80,80,80,80,80,80,80};

	//�������С
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	//----------------------------------------------------

	//-------------------------�������--------------------
	//���ñ������
	private static JTable teamtable;
	private static Object[][] teaminfo;
	private JScrollPane teams;
	private String[] columnName={
			"����","�������","��������","Ͷ��������","Ͷ�����ִ���","����������",
			"���ֳ�����","����������","���������","����������","����������",
			"������","������","������","��ñ��","ʧ����","������","�����÷�",
			"Ͷ��������","����������","����������","ʤ��","�����غ�",
			"����Ч��","����Ч��","����Ч��","����Ч��","����Ч��"};
	//	
	//	private String[] columnName={"","","","","","","","","","","","","","","","",""};
	//�������볡�������л�������
	private JComboBox<String> switchbox;
//	private JComboBox<String> search;
	
	private JRadioButton order_Asc;
	private JRadioButton order_Des;
	private ButtonGroup group;
	
	private JLabel message;
	
	private JButton TeamTech;
	private JButton PlayerTech;
	private JButton TeamData;
//	private JButton PlayerData;

	//----------------------------------------------------
	public TeamTechPre TTPre;
	public ImportTeam importdata;
	public ArrayList<TeamTechVO> initial_data;

	public int HeaderColumn=0;
	public JFrame Frame;
	public TeamTechPanel(JFrame frame){
		Frame=frame;
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		//������ɫԤ�����
		TTPre=new TeamTechPre();
//		importdata=new ImportTeam();
//		initial_data=importdata.getTeamTechAscend(TeamTechEnum.name);
//		System.out.println(initial_data.size());

//		teaminfo=new Object[initial_data.size()][columnName.length];
		teaminfo=new Object[TEAMNUM][columnName.length];
		//���س�ʼ�����ʾ����������
//		handleinitial(initial_data);

		//���ر������
		table_config();
		//���ػ����������
		scrollpane_config();
		//���������
		addbox();
		//��ӵ�ѡ��ť
		addradiobutton();
		//��Ӳ������ť
		addbutton();
		
		message=new JLabel();
		message.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+130, HEIGHT-TABLEHEIGHT-e_space-space-42, 200, 15);
		message.setFont(TTPre.switchbox);
		message.setForeground(TTPre.TableFg);
		
		this.add(message);
		this.repaint();
	}
	
	private void addbutton(){
		TeamTech=new JButton(new ImageIcon("images/buttons/teamtech/TeamTech_selected.png"));
		TeamTech.setBounds(26, 145, 148, 40);
		TeamTech.setBorderPainted(false);
		TeamTech.setContentAreaFilled(false);
		TeamTech.setFocusPainted(false);
		
		PlayerTech=new JButton(new ImageIcon("images/buttons/playertech/PlayerTech_initial.png"));
		PlayerTech.setBounds(26, 185, 148, 40);
		PlayerTech.setBorderPainted(false);
		PlayerTech.setContentAreaFilled(false);
		PlayerTech.setFocusPainted(false);
		PlayerTech.setRolloverIcon(new ImageIcon("images/buttons/playertech/PlayerTech_rollover.png"));
		PlayerTech.setPressedIcon(new ImageIcon("images/buttons/playertech/PlayerTech_pressed.png"));
		PlayerTech.addActionListener(this);
		
		TeamData=new JButton(new ImageIcon("images/buttons/team/Team_initial.png"));
		TeamData.setBounds(26, 225, 148, 40);
		TeamData.setBorderPainted(false);
		TeamData.setContentAreaFilled(false);
		TeamData.setFocusPainted(false);
		TeamData.setRolloverIcon(new ImageIcon("images/buttons/team/Team_rollover.png"));
		TeamData.setPressedIcon(new ImageIcon("images/buttons/team/Team_pressed.png"));
		TeamData.addActionListener(this);
		
		this.add(TeamTech);
		this.add(PlayerTech);
		this.add(TeamData);
	}

	private void addbox(){
		//������
		switchbox=new JComboBox<String>();
		switchbox.setFocusable(false);
		switchbox.setBackground(TTPre.LineSelected);
		switchbox.addItem("����������");
		switchbox.addItem("��������");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(TTPre.switchbox);
		switchbox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					if(switchbox.getSelectedItem().equals("����������")){
						//								System.out.println("����������");
						handleTotalData(initial_data);
					}
					if(switchbox.getSelectedItem().equals("��������")){
						//								System.out.println("��������");
						handleAverageData(initial_data);
					}
				}
			}
		});
		
		this.add(switchbox);
	}
	
	private void addradiobutton(){
		order_Asc=new JRadioButton("����");
		order_Asc.setFont(TTPre.switchbox);
		order_Asc.setForeground(TTPre.TableFg);
		order_Asc.setBorderPainted(false);
		order_Asc.setContentAreaFilled(false);
		order_Asc.setFocusPainted(false);
//		order_Asc.setSelected(true);
		order_Asc.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+10,HEIGHT-TABLEHEIGHT-e_space-space-42,50,15);
		
		order_Des=new JRadioButton("����");
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
			teaminfo[a][18]=i.shotInRate;
			teaminfo[a][19]=i.threeShotInRate;
			teaminfo[a][20]=i.penaltyShotInRate;
			teaminfo[a][21]=i.winningRate;
			teaminfo[a][22]=i.offensiveRound;
			teaminfo[a][23]=i.offensiveEfficiency;
			teaminfo[a][24]=i.defensiveEfficiency;
			teaminfo[a][25]=i.reboundEfficiency;
			teaminfo[a][26]=i.stealEfficiency;
			teaminfo[a][27]=i.secondaryAttackEfficiency;
			a++;
		}
	}
	
	private void handleTotalData(ArrayList<TeamTechVO> totaldata){
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
			teaminfo[a][18]=i.shotInRate;
			teaminfo[a][19]=i.threeShotInRate;
			teaminfo[a][20]=i.penaltyShotInRate;
			teaminfo[a][21]=i.winningRate;
			teaminfo[a][22]=i.offensiveRound;
			teaminfo[a][23]=i.offensiveEfficiency;
			teaminfo[a][24]=i.defensiveEfficiency;
			teaminfo[a][25]=i.reboundEfficiency;
			teaminfo[a][26]=i.stealEfficiency;
			teaminfo[a][27]=i.secondaryAttackEfficiency;
			a++;
		}
		refreshtable();
	}

	private void handleAverageData(ArrayList<TeamTechVO> averagedata){
		int a=0;
		for(TeamTechVO i:averagedata){
			teaminfo[a][1]=switchTeamName(i.name);
			teaminfo[a][2]=i.gameNum;
			teaminfo[a][3]=i.shotInNumave;
			teaminfo[a][4]=i.shotNumave;
			teaminfo[a][5]=i.threeShotInNumave;
			teaminfo[a][6]=i.threeShotNumave;
			teaminfo[a][7]=i.penaltyShotInNumave;
			teaminfo[a][8]=i.penaltyShotNumave;
			teaminfo[a][9]=i.offensiveReboundave;
			teaminfo[a][10]=i.defensiveReboundave;
			teaminfo[a][11]=i.reboundave;
			teaminfo[a][12]=i.secondaryAttackave;
			teaminfo[a][13]=i.stealave;
			teaminfo[a][14]=i.blockShotave;
			teaminfo[a][15]=i.faultave;
			teaminfo[a][16]=i.foulave;
			teaminfo[a][17]=i.scoreave;
			teaminfo[a][18]=i.shotInRate;
			teaminfo[a][19]=i.threeShotInRate;
			teaminfo[a][20]=i.penaltyShotInRate;
			teaminfo[a][21]=i.winningRate;
			teaminfo[a][22]=i.offensiveRoundave;
			teaminfo[a][23]=i.offensiveEfficiency;
			teaminfo[a][24]=i.defensiveEfficiency;
			teaminfo[a][25]=i.reboundEfficiency;
			teaminfo[a][26]=i.stealEfficiency;
			teaminfo[a][27]=i.secondaryAttackEfficiency;
			a++;
		}
		refreshtable();
	}

	private String switchTeamName(String name){
		switch(name){
		case "ATL":
			return "��ӥ Atlanta-Hawks";
		case "CHA":
			return "�Ʒ� Charlotte-Hornets";
		case "MIA":
			return "�Ȼ� Miami-Heat";
		case "ORL":
			return "ħ�� Orlando-Magic";
		case "WAS":
			return "��� Washington-Wizards";
			
		case "CHI":
			return "��ţ Chicago-Bulls";
		case "CLE":
			return "��ʿ Cleveland-Cavaliers";
		case "DET":
			return "���� Detroit-Pistons";
		case "IND":
			return "������ Indiana-Pacers";
		case "MIL":
			return "��¹ Milwaukee-Bucks";
			
		case "BOS":
			return "�������� Boston-Celtics";
		case "BKN":
			return "���� Brooklyn-Nets";
		case "NYK":
			return "���˹ New York-Knicks";
		case "PHI":
			return "76�� Philadelphia-76ers";
		case "TOR":
			return "���� Toronto-Raptors";
			
			
		case "GSW":
			return "��ʿ Golden State-Warriors";
		case "LAC":
			return "�촬 Los Angeles-Clippers";
		case "LAL":
			return "���� Los Angeles-Lakers";
		case "PHX":
			return "̫�� Phoenix-Suns";
		case "SAC":
			return "���� Sacramento-Kings";
			
		case "DEN":
			return "��� Denver-Nuggets";
		case "MIN":
			return "ɭ���� Minnesota-Timberwolves";
		case "OKC":
			return "���� Oklahoma City-Thunder";
		case "POR":
			return "������ Portland-Trail Blazers";
		case "UTA":
			return "��ʿ Utah-Jazz";
			
		case "DAL":
			return "Сţ Dallas-Mavericks";
		case "HOU":
			return "��� Houston-Rockets";
		case "MEM":
			return "���� Memphis-Grizzlies";
		case "NOP":
			return "���� New Orleans-Pelicans";
		case "SAS":
			return "��� San Antonio-Spurs";
		default :
				return null;
		}
	}
	
	//�������
	public void table_config(){
		//------------------------------����������--------------------------
//		for(int i=0;i<initial_data.size();i++){
//			teaminfo[i][0]=i+1;
//		}
		for(int i=0;i<TEAMNUM;i++){
			teaminfo[i][0]=i+1;
		}
		//�����������
		teamtable=new JTable(teaminfo, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//������Ŀ���Զ������п�
		teamtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//���ñ���в����ƶ�
		teamtable.getTableHeader().setReorderingAllowed(false);
		//������������
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) teamtable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//���ñ�����ݼ���ͷ�����ֺ�
		teamtable.setFont(TTPre.CellFont);
		teamtable.setForeground(TTPre.CellFg);
		teamtable.getTableHeader().setFont(TTPre.HeaderFont);
		teamtable.getTableHeader().setForeground(TTPre.TableFg);
		teamtable.getTableHeader().setOpaque(false);
		teamtable.getTableHeader().setBackground(TTPre.TableBg);
		//ȥ���߿�
		teamtable.setBorder(null);

		//�����޸ı�񱳾�
		TableColumnModel model = teamtable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//����ʾ��Ԫ��߿���
		teamtable.setShowHorizontalLines(false);
		teamtable.setShowVerticalLines(false);
		//����ѡ����ɫ
		teamtable.setSelectionBackground(TTPre.LineSelected);
		
		//�����и�
		teamtable.setRowHeight(ROWHEIGHT);
		//�����п�
		for(int i=0;i<COLUMNWIDTH.length;i++){
		teamtable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}
		
		//-----------------------------------------------------------------

		//���table��ͷ����¼�
		teamtable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=teamtable.columnAtPoint(e.getPoint());
				String orderSource=teamtable.getColumnName(HeaderColumn);
//				System.out.println(orderSource);
				if(!orderSource.equals("����")&&!orderSource.equals("��������")){
					message.setText("��ǰ��������:"+orderSource);
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
		case "�������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.name);
			break;
		case "Ͷ��������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.shotInNum);
			break;
		case "Ͷ�����ִ���":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.shotNum);
			break;
		case "����������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.threeShotInNum);
			break;
		case "���ֳ�����":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.threeShotNum);
			break;
		case "����������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.penaltyShotInNum);
			break;
		case "���������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.penaltyShotNum);
			break;
		case "����������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.offensiveRebound);
			break;
		case "����������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.defensiveRebound);
			break;
		case "������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.rebound);
			break;
		case "������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.secondaryAttack);
			break;
		case "������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.steal);
			break;
		case "��ñ��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.blockShot);
			break;
		case "ʧ����":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.fault);
			break;
		case "������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.foul);
			break;
		case "�����÷�":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.score);
			break;
		case "Ͷ��������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.shotInRate);
			break;
		case "����������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.threeShotInRate);
			break;
		case "����������":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.penaltyShotInRate);
			break;
		case "ʤ��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.winningRate);
			break;
		case "�����غ�":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.offensiveRound);
			break;
		case "����Ч��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.offensiveEfficiency);
			break;
		case "����Ч��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.defensiveEfficiency);
			break;
		case "����Ч��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.reboundEfficiency);
			break;
		case "����Ч��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.stealEfficiency);
			break;
		case "����Ч��":
			orderTeamTechVO=importdata.getTeamTechAscend(TeamTechEnum.secondaryAttackEfficiency);
			break;
		}
		
		}
		if(order_Des.isSelected()){
			switch(ordersource){
			case "�������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.name);
				break;
			case "��������":
//				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.gameNum);
				break;
			case "Ͷ��������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.shotInNum);
				break;
			case "Ͷ�����ִ���":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.shotNum);
				break;
			case "����������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.threeShotInNum);
				break;
			case "���ֳ�����":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.threeShotNum);
				break;
			case "����������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.penaltyShotInNum);
				break;
			case "���������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.penaltyShotNum);
				break;
			case "����������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.offensiveRebound);
				break;
			case "����������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.defensiveRebound);
				break;
			case "������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.rebound);
				break;
			case "������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.secondaryAttack);
				break;
			case "������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.steal);
				break;
			case "��ñ��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.blockShot);
				break;
			case "ʧ����":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.fault);
				break;
			case "������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.foul);
				break;
			case "�����÷�":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.score);
				break;
			case "Ͷ��������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.shotInRate);
				break;
			case "����������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.threeShotInRate);
				break;
			case "����������":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.penaltyShotInRate);
				break;
			case "ʤ��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.winningRate);
				break;
			case "�����غ�":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.offensiveRound);
				break;
			case "����Ч��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.offensiveEfficiency);
				break;
			case "����Ч��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.defensiveEfficiency);
				break;
			case "����Ч��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.reboundEfficiency);
				break;
			case "����Ч��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.stealEfficiency);
				break;
			case "����Ч��":
				orderTeamTechVO=importdata.getTeamTechDescend(TeamTechEnum.secondaryAttackEfficiency);
				break;
			}
		}
		
		if(AvgOrTotal.equals("����������")){
			handleTotalData(orderTeamTechVO);
			}else if(AvgOrTotal.equals("��������")){
				handleAverageData(orderTeamTechVO);
			}
	}

	//�����������
	public void scrollpane_config(){
		//���������Ϣ
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

	//���ص�Ԫ���׼��,���ڸı䵥Ԫ�񱳾���ɫ
	private class RowRenderer extends DefaultTableCellRenderer 
	{
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) 
		{
			//��Ԫ�����
			setHorizontalAlignment(JLabel.CENTER);
			//������ż�еı���ɫ
			if (row % 2 == 0)
				setBackground(TTPre.EvenTableLine);
			else
				setBackground(TTPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	//�����������ݽ��汳��
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/main_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==PlayerTech){
			Frame.remove(this);
			PlayerTechPanel ptp=new PlayerTechPanel(Frame);
			Frame.add(ptp);
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