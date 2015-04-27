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
	 * ��Աͳ�����ݽ���
	 * @author blisscry
	 * @date 2015��3��30��15:40:16
	 * @version 1.3
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------���泣��-------------------
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//�����Ե͸���հ�����߽��С����λpx
	public static int e_space=10;
	//����ճ�λ�ô�С
	private static int space=20;
	//������Ա��������
	private static int PLAYERNUM=443;

	//����С
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=450;
	//����и�
	private static int ROWHEIGHT=28;
	//����п�
	private static int[] COLUMNWIDTH={50,120,200,
		60,60,60,60,60,
		70,70,70,
		60,60,60,60,60,60,60,
		70,80,70,70,70,70,70,70,70,70,70,70};

	//�������С
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	//----------------------------------------------------

	//-------------------------�������--------------------
	//���ñ������
	private JTable playertable;
	private Object[][] playerinfo;
	private JScrollPane players;
	private String[] columnName={
			"����","��Ա����","�������",
			"��������","�ȷ�����","������","������","�ڳ�ʱ��",
			"Ͷ��������","����������","����������",
			"������","������","������","��ñ��","ʧ����","������","�÷�",
			"Ч��","GmSc Ч��ֵ","��ʵ������","Ͷ��Ч��","������","����������","����������","������","������","��ñ��","ʧ����","ʹ����"};
	//�������볡�������л�������
	private JComboBox<String> switchbox;
	
	private JComboBox<String> positionbox;
	private String[] positionItem={"��Աλ��","ǰ��","�з�","����"};
	private String[] positionstring={"F","C","G"};
	private JComboBox<String> divisionbox;
	private String[] divisionItem={"��Ա����","����","����"};
	private String[] divisionstring={"E","W"};
	private JComboBox<String> ordergistbox;
	private String[] ordergistItem={"��������","�÷�","����","����","�÷�/����/����","��ñ","����","����","ʧ��","����","Ч��","Ͷ��","����","����","��˫"};
	private String[] ordergiststring={"score","rebound","secondaryattack","srs","blockshot","steal","foul","fault","time","efficiency","shot","threeshot","penaltyshot","doubledouble"};
	//����ʽ��ѡ��ť��
	private JRadioButton order_Asc;
	private JRadioButton order_Des;
	private ButtonGroup group;
	//����������ʾ��
	private JLabel message;
	//ɸѡ�ύ��ť
	private JButton commit;
	//������ð�ť
	private JButton reset;
	//�������ť
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
		//������ɫԤ�����
		PTPre=new PlayerTechPre();
//		importdata=new ImportPlayer();
//		initial_data=importdata.getPlayerTechAscend(PlayerTechEnum.name);

//		playerinfo=new Object[initial_data.size()][columnName.length];
		playerinfo=new Object[PLAYERNUM][columnName.length];
		//���س�ʼ�����ʾ����������
//		handleinitial(initial_data);

		//���ر������
		table_config();
		//���ػ����������
		scrollpane_config();

		//���������
		addbox();
		//��ӵ�ѡ��ť��
		addradiobutton();
		//�����ʾ��Ϣ
		addmessage();
		//����ύ�����ð�ť
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
//		//���س�ʼ�����ʾ����������
//		handleinitial(initial_data);
//
//		//���ر������
//		table_config();
//		//���ػ����������
//		scrollpane_config();
//		this.repaint();
//	}

	//===================================================================
	private void addbox(){
		//������
		switchbox=new JComboBox<String>();
		switchbox.setFocusable(false);
		switchbox.setBackground(PTPre.LineSelected);
		switchbox.addItem("����������");
		switchbox.addItem("��������");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-100,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(PTPre.switchbox);
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
		order_Asc=new JRadioButton("����");
		order_Asc.setFont(PTPre.switchbox);
		order_Asc.setForeground(PTPre.TableFg);
		order_Asc.setBorderPainted(false);
		order_Asc.setContentAreaFilled(false);
		order_Asc.setFocusPainted(false);
//		order_Asc.setSelected(true);
		order_Asc.setBounds(WIDTH-TABLEWIDTH-e_space-space+BOXWIDTH+10,HEIGHT-TABLEHEIGHT-e_space-space-92,50,15);
		
		order_Des=new JRadioButton("����");
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
		for(int i=0;i<playerinfo.length;i++){
			playerinfo[i][0]=i+1;
		}
		//�����������
		playertable=new JTable(playerinfo, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//������Ŀ���Զ������п�
		playertable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//���ñ���в����ƶ�
		playertable.getTableHeader().setReorderingAllowed(false);
		//������������
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) playertable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//���ñ�����ݼ���ͷ�����ֺ�
		playertable.setFont(PTPre.CellFont);
		playertable.setForeground(PTPre.CellFg);
		playertable.getTableHeader().setFont(PTPre.HeaderFont);
		playertable.getTableHeader().setForeground(PTPre.TableFg);
		playertable.getTableHeader().setOpaque(false);
		playertable.getTableHeader().setBackground(PTPre.TableBg);
		//ȥ���߿�
		playertable.setBorder(null);

		//�����޸ı�񱳾�
		TableColumnModel model = playertable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//����ʾ��Ԫ��߿���
		playertable.setShowHorizontalLines(false);
		playertable.setShowVerticalLines(false);
		//����ѡ����ɫ
		playertable.setSelectionBackground(PTPre.LineSelected);

		//�����и�
		playertable.setRowHeight(ROWHEIGHT);
		//�����п�
		for(int i=0;i<COLUMNWIDTH.length;i++){
			playertable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}
		//-----------------------------------------------------------------
		//���table��ͷ����¼�
		playertable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=playertable.columnAtPoint(e.getPoint());
				String orderSource=playertable.getColumnName(HeaderColumn);
				//System.out.println(orderSource);
				if(!orderSource.equals("����")){
					message.setText("��ǰ��������:"+orderSource);
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

		case "��Ա����":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.name);
			break;
		case "�������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.team);
			break;
		case "��������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.gameNum);
			break;
		case "�ȷ�����":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.startingNum);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.rebound);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.secondaryAttack);
			break;
		case "�ڳ�ʱ��":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.time);
			break;
			
		case "Ͷ��������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.shotInRate);
			break;
		case "����������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.threeshotInRate);
			break;
		case "����������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.penaltyShotInRate);
			break;
			
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.offensiveNum);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.defensiveNum);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.steal);
			break;
		case "��ñ��":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.blockShot);
			break;
		case "ʧ����":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.fault);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.foul);
			break;
		case "�÷�":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.score);
			break;
		case "Ч��":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.efficiency);
			break;
		case "GmSc Ч��ֵ":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.GmScEfficiency);
			break;
		case "��ʵ������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.trueShotInRate);
			break;
		case "Ͷ��Ч��":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.shootingEfficiency);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.reboundRate);
			break;
		case "����������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.offensiveReboundRate);
			break;
		case "����������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.defensiveReboundRate);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.secondaryAttackRate);
			break;
		case "������":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.stealRate);
			break;
		case "��ñ��":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.blockShotRate);
			break;
		case "ʧ����":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.faultRate);
			break;
		case "ʹ����":
			orderPlayerTechVO=importdata.getPlayerTechAscend(PlayerTechEnum.usageRate);
			break;
		}
		
		}
		if(order_Des.isSelected()){
			switch(ordersource){
			case "��Ա����":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.name);
				break;
			case "�������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.team);
				break;
			case "��������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.gameNum);
				break;
			case "�ȷ�����":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.startingNum);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.rebound);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.secondaryAttack);
				break;
			case "�ڳ�ʱ��":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.time);
				break;
				
			case "Ͷ��������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.shotInRate);
				break;
			case "����������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.threeshotInRate);
				break;
			case "����������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.penaltyShotInRate);
				break;
				
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.offensiveNum);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.defensiveNum);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.steal);
				break;
			case "��ñ��":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.blockShot);
				break;
			case "ʧ����":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.fault);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.foul);
				break;
			case "�÷�":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.score);
				break;
			case "Ч��":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.efficiency);
				break;
			case "GmSc Ч��ֵ":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.GmScEfficiency);
				break;
			case "��ʵ������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.trueShotInRate);
				break;
			case "Ͷ��Ч��":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.shootingEfficiency);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.reboundRate);
				break;
			case "����������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.offensiveReboundRate);
				break;
			case "����������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.defensiveReboundRate);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.secondaryAttackRate);
				break;
			case "������":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.stealRate);
				break;
			case "��ñ��":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.blockShotRate);
				break;
			case "ʧ����":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.faultRate);
				break;
			case "ʹ����":
				orderPlayerTechVO=importdata.getPlayerTechDescend(PlayerTechEnum.usageRate);
				break;
			}
		}
		
		if(AvgOrTotal.equals("����������")){
			handleTotalData(orderPlayerTechVO);
			}else if(AvgOrTotal.equals("��������")){
				handleAverageData(orderPlayerTechVO);
			}
	}
	
	//�����������
	public void scrollpane_config(){
		//���������Ϣ
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
				setBackground(PTPre.EvenTableLine);
			else
				setBackground(PTPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}
	

	//������Ա���ݽ��汳��
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/main_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}
	

	//��ť�������¼�
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
				if(switchboxsel.equals("����������")){
					handleTotalData(siftVO);
				}else if(switchboxsel.equals("��������")){
					handleAverageData(siftVO);
				}
			}
			//ȥ����ͷ������
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
