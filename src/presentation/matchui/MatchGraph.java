package presentation.matchui;

import java.awt.Graphics;

import javax.swing.JPanel;

import VO.MatchVO;

public class MatchGraph extends JPanel{
	/**
	 * extends the JPanel to show the changes of matchdata using graphs
	 * @author blisscry
	 * @date 2015年5月4日01:43:33
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	public MatchGraph(MatchVO mvo) {
		this.setSize(750, 450);
		this.setLayout(null);
		
	}
	
	//override the paint method to paint a rect
	public void paintComponent(Graphics g){
//		g.drawRect(arg0, arg1, arg2, arg3);
	}
}
