package presentation.preset;


import java.awt.Color;
import java.awt.Font;

public class TeamTechPre{
	//��ɫԤ��
	public Color OddTableLine;//��������ɫ
	public Color EvenTableLine;//ż������ɫ
	public Color LineSelected;//��Ԫ��ѡ����ɫ
	public Color TableFg;//��������������ɫ
	public Color CellFg;//���Ԫ��������ɫ
	public Color TableBg;//��������������ɫ
	public Color TableSelBg;//��������ѡ�б���
	//����Ԥ��
	public Font switchbox;//����������
	public Font CellFont;//��Ԫ������
	public Font HeaderFont;//��ͷ����

	public TeamTechPre(){
		
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
		
		switchbox=new Font("��Բ",0,12);
		CellFont=new Font("��Բ",0,12);
		HeaderFont=new Font("����",0,11);
		
	}
	
}
