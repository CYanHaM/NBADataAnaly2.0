package presentation.playerui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import VO.PlayerTechVO;
import VO.ScreeningConditionVO;

public class SeniorSift extends JPanel implements ActionListener{
	/**
	 * the seniorsift panel kit in playertechpanel
	 * @author blisscry
	 * @date 2015年5月4日17:18:28
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	private int width=745;
	private int height=260;
	
	private JComboBox<String> position;
	private String[] positionItem={"球员位置","前锋","中锋","后卫"};
	private String[] positionstring={"F","C","G"};
	private JComboBox<String> division;
	private String[] divisionItem={"球员联盟","东部","西部"};
	private String[] divisionstring={"E","W"};
	private JComboBox<String> condition;
	private String[] conditionItem={"筛选条件","得分","篮板","助攻","盖帽","抢断"};
	private String[] ordergiststring={"score","rebound","secondaryattack","blockshot","steal"};
	private JComboBox<String> comparison;
	private String[] comparisonItem={"大于","等于","小于"};
	private String[] comparisonstring={">","=","<"};
	
	private JTextField info;
	
	private JButton commit;
	
	public SeniorSift() {
		this.setSize(width,height);
		this.setLayout(null);
		this.setOpaque(false);
		
		addkits();
	}
	
	private void addkits(){
		position=new JComboBox<String>(positionItem);
		position.setBounds(100, 100, 100, 30);
		division=new JComboBox<String>(divisionItem);
		division.setBounds(220, 100, 100, 30);
		condition=new JComboBox<String>(conditionItem);
		condition.setBounds(100, 150, 160, 30);
		comparison=new JComboBox<String>(comparisonItem);
		comparison.setBounds(280, 150, 70, 30);
		
		info=new JTextField();
		info.setBounds(370, 150, 160, 30);
		
		commit=new JButton("提交");
		commit.setBounds(550, 150, 160, 30);
		commit.addActionListener(this);
		
		this.add(position);
		this.add(division);
		this.add(condition);
		this.add(comparison);
		this.add(info);
		this.add(commit);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon im=new ImageIcon("images/players/seniorsift.png");
		g.drawImage(im.getImage(),0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==commit){
			this.setVisible(false);
			ImportPlayer ip=new ImportPlayer();
			ScreeningConditionVO scvo=new ScreeningConditionVO();
			scvo.posotion=String.valueOf(position.getSelectedItem());
			scvo.division=String.valueOf(division.getSelectedItem());
			scvo.condition=String.valueOf(condition.getSelectedItem());
			scvo.comparison=String.valueOf(comparison.getSelectedItem());
			scvo.number=Integer.parseInt(info.getText());
			ArrayList<PlayerTechVO> resultvo=ip.sift(scvo);
		}
	}
	
	
}

