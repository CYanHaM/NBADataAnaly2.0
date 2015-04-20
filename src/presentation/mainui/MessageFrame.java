package presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import com.sun.awt.AWTUtilities;

public class MessageFrame extends JFrame{
	/**
	 * ��Ϣ��ʾ��
	 * @author blisscry
	 * @date 2015��3��26��17:26:37
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	//�����½��ܴ�С
		public final int POPFRAME_WIDTH=350;
		public final int POPFRAME_HEIGHT=200;
		//���漸�������������ÿ�ܵĿ��ƶ�
		//�����������λ��
		int X;
		int Y;
		//�ж��Ƿ����϶�����
		boolean isDraging;

		public MessageFrame(){
			this.setTitle("MESSAGE");
			this.setSize(POPFRAME_WIDTH, POPFRAME_HEIGHT);
			this.setResizable(false);
			//����ʾwindows�Դ��߿�
			this.setUndecorated(true);
			this.setVisible(true);
			//���ô������
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

			//����͸�����˴�������com.sun.awt.AWTUtilities����������
			AWTUtilities.setWindowOpaque(this, false);

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
			
		}
}
