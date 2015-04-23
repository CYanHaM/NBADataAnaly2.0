package presentation.mainui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

//import com.sun.awt.AWTUtilities;

public class MainFrame extends JFrame{
	/**
	 * ϵͳ�����棬���������С�����ַ�ʽ��������϶��¼�
	 * @author blisscry
	 * @date 2015��4��20��20:46:02
	 * @version 1.0
	 */

	private static final long serialVersionUID = 1L;
	//��������ܴ�С
	public static int FRAME_WIDTH=1020;
	public static int FRAME_HEIGHT=670;
	//�����������λ��
	int X;
	int Y;
	//�ж��Ƿ����϶�����
	boolean isDraging;

	JButton MINIMIZE;
	JButton CLOSE;
	JFrame Frame;

	public MainFrame(){
		//�������������С
		this.setLayout(null);
		this.setTitle("CYan HaM");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		//����ʾwindows�Դ��߿�
		this.setUndecorated(true);
		//���ô������
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		Frame=this;

		//����͸�����˴�������com.sun.awt.AWTUtilities����������
		//AWTUtilities.setWindowOpaque(this, false);
		//����͸������Ŀǰ�õ��Ľ�
		this.setBackground(new Color(0,0,0,0));
		
		

		//����¼������ڻ�ȡ����϶���λ��
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				X= e.getX();
				Y= e.getY();
			}
			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}});
		//����ƶ��¼������ڻ�ȡ�ƶ���·������
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) { 
					//��ȡ��ǰ��ܵ�λ������
					int frame_x= getLocation().x;
					int frame_y= getLocation().y;
					setLocation(frame_x+e.getX()-X, frame_y+e.getY()-Y);
				}
			}});


		MainPanel mp=new MainPanel(this,FRAME_WIDTH,FRAME_HEIGHT);
		this.add(mp);
		this.repaint();
	}



	public static void main(String[] args){

		//����ϵͳ����
		try {
			// ��LookAndFeel���ó�Windows��ʽ
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		MessageFrame messageframe=new MessageFrame();
		LoginMsgPanel loginmsgpanel=new LoginMsgPanel(messageframe);
		messageframe.add(loginmsgpanel);
		messageframe.repaint();
	}

}
