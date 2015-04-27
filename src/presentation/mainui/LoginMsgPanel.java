package presentation.mainui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import presentation.playerui.PlayerTechPanel;
import presentation.playerui.PlayerInfoPanel;
import presentation.teamui.TeamInfoPanel;
import presentation.teamui.TeamPanel;
import presentation.teamui.TeamTechPanel;
import VO.TeamVO;
//import blservice.LoginBLservice;
//import bussinesslogic.LoginBL.Login;

public class LoginMsgPanel extends JPanel implements ActionListener{
	/**
	 * �����������IP��ַ����
	 * @author blisscry
	 * @date 2015��3��26��20:03:01
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	public final int POPFRAME_WIDTH=350;
	public final int POPFRAME_HEIGHT=200;
	JFrame Frame;
	JLabel message;
	JTextField messagetext;
	JLabel messagetextl;
	JButton affirm;
	JButton cancel;
//	LoginBLservice lbs;

	public LoginMsgPanel(JFrame frame){
		Frame=frame;
		this.setOpaque(false);
		this.setSize(POPFRAME_WIDTH, POPFRAME_HEIGHT);
		this.setLayout(null);

		message=new JLabel("�������������IP��ַ��");
		message.setBounds(58, 75, 180, 15);
		message.setFont(new Font("��Բ",0,15));
		message.setForeground(Color.WHITE);

//		lbs=new Login();
//		String url=lbs.getURL();
//		messagetext=new JTextField(url);
		messagetext.setBounds(60, 100, 235, 30);
		messagetext.setFont(new Font("��Բ",0,15));
		messagetext.setForeground(Color.WHITE);
		messagetext.setOpaque(false);
		messagetext.setBorder(null);

		messagetextl=new JLabel(new ImageIcon("images/messageframe/messagetext.png"));
		messagetextl.setBounds(54, 99, 241, 31);

		affirm=new JButton(new ImageIcon("images/messageframe/affirm1.png"));
		affirm.setBounds(95, 152, 70, 25);
		affirm.setBorderPainted(false);
		affirm.setContentAreaFilled(false);
		affirm.setFocusPainted(false);
		affirm.setRolloverIcon(new ImageIcon("images/messageframe/affirm2.png"));
		affirm.setPressedIcon(new ImageIcon("images/messageframe/affirm3.png"));
		affirm.addActionListener(this);

		cancel=new JButton(new ImageIcon("images/messageframe/cancel1.png"));
		cancel.setBounds(185, 152, 70, 25);
		cancel.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		cancel.setFocusPainted(false);
		cancel.setRolloverIcon(new ImageIcon("images/messageframe/cancel2.png"));
		cancel.setPressedIcon(new ImageIcon("images/messageframe/cancel3.png"));
		cancel.addActionListener(this);

		this.add(message);
		this.add(messagetext);
		this.add(messagetextl);
		this.add(affirm);
		this.add(cancel);

		Frame.getRootPane().setDefaultButton(affirm);
		this.repaint();


	}

	//���Ʊ���
	ImageIcon im=new ImageIcon("images/messageframe/caution.png");
	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		g.drawImage(im.getImage(),0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==affirm){
			String newURL=messagetext.getText();
			if(newURL.equals("")){
				JOptionPane.showMessageDialog(null ,"IP����Ϊ��","�������",JOptionPane.ERROR_MESSAGE);
			}else{
//				lbs.setURL(newURL);
				MainFrame mf=new MainFrame();
//				TeamTechPanel ttp=new TeamTechPanel(mf);
				PlayerTechPanel ttp=new PlayerTechPanel(mf);
//				TeamInfoPanel ttp=new TeamInfoPanel(mf);
//				TeamVO tvo=new TeamVO();
//				tvo.fullName="asdasd";
//				TeamPanel ttp=new TeamPanel(tvo,mf);
				mf.add(ttp);
				mf.repaint();
				Frame.dispose();
			}
		}
		if(arg0.getSource()==cancel){
			Frame.dispose();
		}
	}
}