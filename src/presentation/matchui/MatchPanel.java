package presentation.matchui;


import javax.swing.*;

public class MatchPanel extends JPanel{
	/**
	 * 比赛数据显示界面
	 * @author blisscry
	 * @date 2015年4月21日21:31:29
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	JLabel DateLabel;
	JScrollPane jsp;
	
	public MatchPanel() {
		DateLabel = new JLabel("比赛信息");
	
		jsp = new JScrollPane();
		jsp.setViewportView(DateLabel);
	}
	
	
	
}
