package presentation.matchui;


import javax.swing.*;

public class MatchPanel extends JPanel{
	/**
	 * ����������ʾ����
	 * @author blisscry
	 * @date 2015��4��21��21:31:29
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	JLabel DateLabel;
	JScrollPane jsp;
	
	public MatchPanel() {
		DateLabel = new JLabel("������Ϣ");
	
		jsp = new JScrollPane();
		jsp.setViewportView(DateLabel);
	}
	
	
	
}
