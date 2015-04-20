package presentation.preset;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class PlayerPre {
	//��ɫԤ��
	public Color OddTableLine;//��������ɫ
	public Color EvenTableLine;//ż������ɫ
	public Color LineSelected;//��Ԫ��ѡ����ɫ
	public Color TableFg;//��������������ɫ
	public Color CellFg;//���Ԫ��������ɫ
	public Color TableBg;//��������������ɫ
	public Color TableSelBg;//��������ѡ�б���
	
	public Color label;
	//����Ԥ��
	public Font switchbox;//����������
	public Font CellFont;//��Ԫ������
	public Font HeaderFont;//��ͷ����
	
	public Font message;
	public Font messageSmall;
	public Font fullName;//���ȫ��
	public Font abbreviation;//��д
	public Font location;//���ڵ�
	public Font division;//����
	public Font partition;//����
	public Font homeCourt;//����
	public Font time;//����ʱ��

	public PlayerPre(){

		//ż���л���ɫRGB 211,221,240
		OddTableLine=new Color(255,255,255);
		//�����а�ɫRGB 255,255,255
		EvenTableLine=new Color(211,221,240);
		//ѡ����Ϊ��ɫRGB 210,210,210
		LineSelected=new Color(210,210,210);
		//������������ɫ��ɫRGB 255,255,255
		TableFg=new Color(255,255,255);
		//������������ɫ��ɫRGB 40,40,40
		CellFg=new Color(80,80,80);
		//������������ɫ�Һ�ɫRGB 135,138,143
		TableBg=new Color(135,138,143);
		//������ѡ�б�����ɫ�Ұ�ɫRGB 
		TableSelBg=new Color(153,153,153);
		
		//��ʾ�����Ϣ��������ɫ
		label=new Color(235,235,235);

		switchbox=new Font("��Բ",0,12);
		CellFont=new Font("Arial",0,12);
		HeaderFont=new Font("����",0,11);
		
		
		message=new Font("΢���ź�",0,15);
		messageSmall=new Font("΢���ź�",0,13);
		fullName=new Font("Arial",0,25);
		abbreviation=new Font("Arial",0,11);
		location=new Font("Arial",0,15);
		division=new Font("Arial",0,15);
		partition=new Font("Arial",0,15);
		homeCourt=new Font("Arial",0,15);
		time=new Font("Arial",0,12);
	}
}
