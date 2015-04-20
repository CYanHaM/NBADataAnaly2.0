package presentation.playerui;

import java.awt.Graphics;

import javax.swing.*;

public class PlayerInfoPanel extends JPanel{
	/**
	 * 球员信息显示界面
	 * @author blisscry
	 * @date 2015年4月1日00:55:39
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	
	private static int locx=201;
	private static int locy=232;
	private static int Button_width=113;
	private static int Button_height=61;
	
	private JButton ATL;
	private JButton CHA;
	private JButton MIA;
	private JButton ORL;
	private JButton WAS;
	
	private JButton CHI;
	private JButton CLE;
	private JButton DET;
	private JButton IND;
	private JButton MIL;
	
	private JButton BOS;
	private JButton BKN;
	private JButton NYK;
	private JButton PHI;
	private JButton TOR;
	
	private JButton GSW;
	private JButton LAC;
	private JButton LAL;
	private JButton PHX;
	private JButton SAC;
	
	private JButton DEN;
	private JButton MIN;
	private JButton OKC;
	private JButton POR;
	private JButton UTA;
	
	private JButton DAL;
	private JButton HOU;
	private JButton MEM;
	private JButton NOP;
	private JButton SAS;
	
	
	
	
	JLabel player;
	public PlayerInfoPanel(){
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		
		addbutton();

		
		player=new JLabel("jsjsj");
		player.setBounds(100, 100, 500, 500);
		player.setIcon(new ImageIcon("images/teams/ATL.svg"));
		this.add(player);
		
	}
	
	public void button_config(JButton button){
		this.add(button);
	}
	
	public void addbutton(){
		ATL=new JButton("老鹰");
		ATL.setBounds(locx, locy, Button_width, Button_height);
		button_config(ATL);
		CHA=new JButton("黄蜂");
		CHA.setBounds(locx, locy+13+Button_height, Button_width, Button_height);
		button_config(CHA);
		MIA=new JButton("热火");
		MIA.setBounds(locx, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(MIA);
		ORL=new JButton("魔术");
		ORL.setBounds(locx, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(ORL);
		WAS=new JButton("奇才");
		WAS.setBounds(locx, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(WAS);
		
		CHI=new JButton("公牛");
		CHI.setBounds(locx+20+Button_width, locy, Button_width, Button_height);
		button_config(CHI);
		CLE=new JButton("骑士");
		CLE.setBounds(locx+20+Button_width, locy+13+Button_height, Button_width, Button_height);
		button_config(CLE);
		DET=new JButton("活塞");
		DET.setBounds(locx+20+Button_width, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(DET);
		IND=new JButton("步行者");
		IND.setBounds(locx+20+Button_width, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(IND);
		MIL=new JButton("雄鹿");
		MIL.setBounds(locx+20+Button_width, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(MIL);
		
		BOS=new JButton("凯尔特人");
		BOS.setBounds(locx+(20+Button_width)*2, locy, Button_width, Button_height);
		button_config(BOS);
		BKN=new JButton("篮网");
		BKN.setBounds(locx+(20+Button_width)*2, locy+13+Button_height, Button_width, Button_height);
		button_config(BKN);
		NYK=new JButton("尼克斯");
		NYK.setBounds(locx+(20+Button_width)*2, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(NYK);
		PHI=new JButton("76人");
		PHI.setBounds(locx+(20+Button_width)*2, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(PHI);
		TOR=new JButton("猛龙");
		TOR.setBounds(locx+(20+Button_width)*2, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(TOR);
		
		GSW=new JButton("勇士");
		GSW.setBounds(locx+(20+Button_width)*3, locy, Button_width, Button_height);
		button_config(GSW);
		LAC=new JButton("快船");
		LAC.setBounds(locx+(20+Button_width)*3, locy+13+Button_height, Button_width, Button_height);
		button_config(LAC);
		LAL=new JButton("湖人");
		LAL.setBounds(locx+(20+Button_width)*3, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(LAL);
		PHX=new JButton("太阳");
		PHX.setBounds(locx+(20+Button_width)*3, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(PHX);
		SAC=new JButton("国王");
		SAC.setBounds(locx+(20+Button_width)*3, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(SAC);
		
		DEN=new JButton("掘金");
		DEN.setBounds(locx+(20+Button_width)*4, locy, Button_width, Button_height);
		button_config(DEN);
		MIN=new JButton("森林狼");
		MIN.setBounds(locx+(20+Button_width)*4, locy+13+Button_height, Button_width, Button_height);
		button_config(MIN);
		OKC=new JButton("雷霆");
		OKC.setBounds(locx+(20+Button_width)*4, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(OKC);
		POR=new JButton("开拓者");
		POR.setBounds(locx+(20+Button_width)*4, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(POR);
		UTA=new JButton("爵士");
		UTA.setBounds(locx+(20+Button_width)*4, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(UTA);
		
		DAL=new JButton("小牛");
		DAL.setBounds(locx+(20+Button_width)*5, locy, Button_width, Button_height);
		button_config(DAL);
		HOU=new JButton("火箭");
		HOU.setBounds(locx+(20+Button_width)*5, locy+13+Button_height, Button_width, Button_height);
		button_config(HOU);
		MEM=new JButton("灰熊");
		MEM.setBounds(locx+(20+Button_width)*5, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(MEM);
		NOP=new JButton("鹈鹕");
		NOP.setBounds(locx+(20+Button_width)*5, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(NOP);
		SAS=new JButton("马刺");
		SAS.setBounds(locx+(20+Button_width)*5, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(SAS);
	}
	
	//绘制赛季数据界面背景
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/teams_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}
}
