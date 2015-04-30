package presentation.matchui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.preset.MatchPre;
import PO.PlayerTechMPO;
import VO.MatchVO;

public class MatchDetail extends JPanel{
	/**
	 * the details of every match
	 * @author blisscry
	 * @date 2015年4月29日22:55:38
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	public static int FRAME_WIDTH=1020;
	public static int FRAME_HEIGHT=670;
	//表格大小
	private static int TABLEWIDTH=785;
	private static int TABLEHEIGHT=360;

	private int playerNum_guest=0;
	private int playerNum_home=0;

	private JScrollPane jsp_guest;
	private JTable table_guest;
	private Object[][] teaminfo_guest;
	private JScrollPane jsp_home;
	private JTable table_home;
	private Object[][] teaminfo_home;

	private String[] columnName={"姓名","分钟","命中","出手","三分命中","三分出手",
			"罚球命中","罚球出手","进攻","防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
	private static int ROWHEIGHT=28;
	//表格列宽
	private static int[] COLUMNWIDTH={123,36,36,36,57,57,57,57,36,36,36,36,36,36,36,36,36};
	public int HeaderColumn=0;

	private JLabel message;
	MatchPre MP;
	JFrame Frame;
	public MatchDetail(JFrame frame,MatchVO mvo) {
		System.out.println(mvo.guestTeam);
		Frame=frame;
		this.setLayout(null);
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		MP = new MatchPre();


		getplayerNum(mvo);


		//		teaminfo_guest=new Object[playerNum_guest][columnName.length];
		//		//define table
		//		table_guest = new JTable(teaminfo_guest, columnName){
		//			private static final long serialVersionUID = 1L;
		//			public boolean isCellEditable(int row, int column) { 
		//				return false;
		//			}
		//		};
		tableguest_config();

		//		teaminfo_home=new Object[playerNum_home][columnName.length];
		//		//define table
		//		table_home = new JTable(teaminfo_home, columnName){
		//			private static final long serialVersionUID = 1L;
		//			public boolean isCellEditable(int row, int column) { 
		//				return false;
		//			}
		//		};
		tablehome_config();

		insertData(mvo);

		jsp_guest = new JScrollPane(table_guest);
		jsp_home = new JScrollPane(table_home);
		jsp_guest.setViewportView(table_guest);
		this.repaint();
		scrollpane_config(jsp_guest,table_guest);
		scrollpane_config(jsp_home,table_home);

		message=new JLabel();
		message.setBounds(300,100, 200, 15);
		message.setFont(MP.switchbox);
		message.setForeground(MP.TableFg);
		this.add(message);

		this.repaint();

	}

	public void getplayerNum(MatchVO mvo){
		ArrayList<PlayerTechMPO> playerTech=mvo.playerStatistic;
		//calculate the num of every teams
		for(PlayerTechMPO ppo:playerTech){
			if(ppo.team.equals(mvo.guestTeam)){
				playerNum_guest++;
			}else if(ppo.team.equals(mvo.homeTeam)){
				playerNum_home++;
			}
		}
	}

	private void insertData(MatchVO mvo){
		ArrayList<PlayerTechMPO> playerTech=mvo.playerStatistic;
		int i=0;
		for(PlayerTechMPO ppo:playerTech){
			if(ppo.team.equals(mvo.guestTeam)){
				teaminfo_guest[i][0]=ppo.name;
				teaminfo_guest[i][1]=ppo.time;
				teaminfo_guest[i][2]=ppo.shotIn;
				teaminfo_guest[i][3]=ppo.shot;
				teaminfo_guest[i][4]=ppo.threeShotIn;
				teaminfo_guest[i][5]=ppo.threeShot;
				teaminfo_guest[i][6]=ppo.penaltyShotIn;
				teaminfo_guest[i][7]=ppo.penaltyShot;
				teaminfo_guest[i][8]=ppo.offensiveRebound;
				teaminfo_guest[i][9]=ppo.defensiveRebound;
				teaminfo_guest[i][10]=ppo.rebound;
				teaminfo_guest[i][11]=ppo.secondaryAttack;
				teaminfo_guest[i][12]=ppo.steal;
				teaminfo_guest[i][13]=ppo.blockShot;
				teaminfo_guest[i][14]=ppo.fault;
				teaminfo_guest[i][15]=ppo.foul;
				teaminfo_guest[i][16]=ppo.score;
				System.out.println(teaminfo_guest[i][16]);
				i++;
			}

		}
		i=0;
		for(PlayerTechMPO ppo:playerTech){
			if(ppo.team.equals(mvo.homeTeam)){
				teaminfo_home[i][0]=ppo.name;
				teaminfo_home[i][1]=ppo.time;
				teaminfo_home[i][2]=ppo.shotIn;
				teaminfo_home[i][3]=ppo.shot;
				teaminfo_home[i][4]=ppo.threeShotIn;
				teaminfo_home[i][5]=ppo.threeShot;
				teaminfo_home[i][6]=ppo.penaltyShotIn;
				teaminfo_home[i][7]=ppo.penaltyShot;
				teaminfo_home[i][8]=ppo.offensiveRebound;
				teaminfo_home[i][9]=ppo.defensiveRebound;
				teaminfo_home[i][10]=ppo.rebound;
				teaminfo_home[i][11]=ppo.secondaryAttack;
				teaminfo_home[i][12]=ppo.steal;
				teaminfo_home[i][13]=ppo.blockShot;
				teaminfo_home[i][14]=ppo.fault;
				teaminfo_home[i][15]=ppo.foul;
				teaminfo_home[i][16]=ppo.score;
				i++;
			}

		}
	}

	//表格配置
	public void tableguest_config(){
		//------------------------------表格基本属性--------------------------
		//		for(int i=0;i<;i++){
		//			teaminfo[i][0]=i+1;
		//		}
		//		for(int i=0;i<TEAMNUM;i++){
		//			teaminfo[i][0]=i+1;
		//		}

		teaminfo_guest=new Object[playerNum_guest][columnName.length];
		//define table
		table_guest = new JTable(teaminfo_guest, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};

		//根据条目名自动调整列宽
		table_guest.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//设置表格列不可移动
		table_guest.getTableHeader().setReorderingAllowed(false);
		//设置列名居中
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) table_guest.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//设置表格数据及表头字体字号
		table_guest.setFont(MP.CellFont);
		table_guest.setForeground(MP.CellFg);
		table_guest.getTableHeader().setFont(MP.HeaderFont);
		table_guest.getTableHeader().setForeground(MP.TableFg);
		table_guest.getTableHeader().setOpaque(false);
		table_guest.getTableHeader().setBackground(MP.TableBg);
		//去除边框
		table_guest.setBorder(null);

		//按行修改表格背景
		TableColumnModel model = table_guest.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//不显示单元格边框线
		table_guest.setShowHorizontalLines(false);
		table_guest.setShowVerticalLines(false);
		//设置选中颜色
		table_guest.setSelectionBackground(MP.LineSelected);

		//设置行高
		table_guest.setRowHeight(ROWHEIGHT);
		//设置列宽
		for(int i=0;i<COLUMNWIDTH.length;i++){
			table_guest.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}

		//-----------------------------------------------------------------

		//添加table表头点击事件
		/*teamtable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=teamtable.columnAtPoint(e.getPoint());
				String orderSource=teamtable.getColumnName(HeaderColumn);
				//					System.out.println(orderSource);
				if(!orderSource.equals("排名")&&!orderSource.equals("比赛场数")){
					message.setText("当前排序依据:"+orderSource);
					//					judgeOrderSource(orderSource,(String) switchbox.getSelectedItem());
				}

			}
		});
		 */

	}

	//表格配置
	public void tablehome_config(){
		//------------------------------表格基本属性--------------------------
		//		for(int i=0;i<;i++){
		//			teaminfo[i][0]=i+1;
		//		}
		//		for(int i=0;i<TEAMNUM;i++){
		//			teaminfo[i][0]=i+1;
		//		}
		teaminfo_home=new Object[playerNum_home][columnName.length];
		//define table
		table_home = new JTable(teaminfo_home, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//根据条目名自动调整列宽
		table_home.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//设置表格列不可移动
		table_home.getTableHeader().setReorderingAllowed(false);
		//设置列名居中
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) table_home.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//设置表格数据及表头字体字号
		table_home.setFont(MP.CellFont);
		table_home.setForeground(MP.CellFg);
		table_home.getTableHeader().setFont(MP.HeaderFont);
		table_home.getTableHeader().setForeground(MP.TableFg);
		table_home.getTableHeader().setOpaque(false);
		table_home.getTableHeader().setBackground(MP.TableBg);
		//去除边框
		table_home.setBorder(null);

		//按行修改表格背景
		TableColumnModel model = table_home.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//不显示单元格边框线
		table_home.setShowHorizontalLines(false);
		table_home.setShowVerticalLines(false);
		//设置选中颜色
		table_home.setSelectionBackground(MP.LineSelected);

		//设置行高
		table_home.setRowHeight(ROWHEIGHT);
		//设置列宽
		for(int i=0;i<COLUMNWIDTH.length;i++){
			table_home.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}

		//-----------------------------------------------------------------

		//添加table表头点击事件
		/*teamtable.getTableHeader().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					HeaderColumn=teamtable.columnAtPoint(e.getPoint());
					String orderSource=teamtable.getColumnName(HeaderColumn);
					//					System.out.println(orderSource);
					if(!orderSource.equals("排名")&&!orderSource.equals("比赛场数")){
						message.setText("当前排序依据:"+orderSource);
						//					judgeOrderSource(orderSource,(String) switchbox.getSelectedItem());
					}

				}
			});
		 */

	}

	public void scrollpane_config(JScrollPane jsp,JTable teamtable){
		//滑动面板信息
		jsp.setBounds(195,270,TABLEWIDTH,TABLEHEIGHT);
		jsp.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		jsp.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		jsp.setVisible(true);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jsp.setBorder(null);
		this.add(jsp);
		//		jsp.setViewportView(teamtable);
		//		this.repaint();
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
				setBackground(MP.EvenTableLine);
			else
				setBackground(MP.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im=new ImageIcon("images/system_img/teams_bg.png");
		g.drawImage(im.getImage(),0,0,this);
	}
}
