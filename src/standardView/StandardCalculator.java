package standardView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import standardControl.StandardEvent;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-06-06
 * @desc ��׼������ͼ�ν��������
 *
 */
public class StandardCalculator extends JPanel{

	public StandardEvent standardControl;	//��׼�������¼�������
	
	public JPanel pan1;	//���1��������ı���
	public JPanel pan2;	//���2��Ϊ��������ֹ�����
	
	public JTextField jt1,jt2,jt3;		//����,����ı���
	
	public String[] s1={"0","1","2","3","4","5","6","7","8","9","."};	//���ְ�ť����
	public JButton[] butNum=new JButton[s1.length];	//���ְ�ť����(��".")
	
	public String[] s2={"+","-","*","/","=","��","��","1/x","%"};	//���Ű�ť����
	public JButton[] butSign=new JButton[s2.length];	//���Ű�ť����
	
	public String[] s3={"MC","MR","MS","M+","M-","��","CE","C"};	//���ܰ�ť����
	public JButton[] butFunction=new JButton[s3.length];	//���ܰ�ť����
	
	public Font font1=new Font("����",Font.PLAIN,18);	//������ı����е�����
	public Font font2=new Font("����",Font.PLAIN,24);	//������ı����е�����
	public EmptyBorder border=new EmptyBorder(0,0,0,0);;	//��ȥ�ı���ı߿�
	
	public GridBagLayout layout=new GridBagLayout();	//��������ֹ�����
	public GridBagConstraints constraints=new GridBagConstraints();	//�����Լ������
	
	
	/**
	 * @desc ���췽�������׼�������¼����������ʵ������Ӧ�ĳ�Ա������ͬʱ��������Ա�����������
	 * @param standardControl
	 */
	public StandardCalculator(StandardEvent standardControl){
		
		this.standardControl=standardControl;
		
		found();	//ʵ������Ա����
		
		insert();	//���1����ı������
		
		set();	//���ó�Ա��������
		
		buttonHandle();	//��ť��������
		
		layoutPlan();	//��ť�������Ϊ��������ֹ����������
		
	}


	/**
	 * @desc found()��������ʵ������Ա����
	 */
	private void found() {
		// TODO �Զ����ɵķ������
		
		//ʵ�������
		pan1=new JPanel();		//���1���ڷ����ı���
		pan2=new JPanel(layout);	//���2��Ϊ��������ֹ�����
		
		//ʵ�����ı���
		jt1=new JTextField();	//���ı���
		jt2=new JTextField("0");	//���ı��򣬳�ʼʱ��0
		jt3=new JTextField();	//����ı���������ʾ��������д����ֵ
		
	}


	/**
	 * @desc insert()�����������1����ı������
	 */
	private void insert() {
		// TODO �Զ����ɵķ������
		
		//���ı���������1��
		pan1.add(jt3);	
		pan1.add(jt1);
		pan1.add(jt2);
		
		this.add(pan1);	//������	
		this.add(pan2);
	
	}


	/**
	 * @desc set()�����������ó�Ա������һЩ����
	 */
	private void set() {
		// TODO �Զ����ɵķ������
		
		
		this.setLayout(null);	//��׼���������Ĳ��ֹ�������Ϊ���Բ���
		
		pan1.setLayout(null);	//���1���ڷ����ı��򣬲�������Ϊ���Բ���
		
		bound();	//���������λ�úʹ�С
		
		border();	//��������߿�
		
		font();		//��������ı������С
		
		jt1.setHorizontalAlignment(JTextField.RIGHT);	//�ı����ı��Ҷ���
		jt2.setHorizontalAlignment(JTextField.RIGHT);	//�ı����ı��Ҷ���
		
		jt1.setBackground(Color.WHITE);		//���ı���ı�����ɫ��Ϊ��ɫ
		jt2.setBackground(Color.WHITE);		//���ı���ı�����ɫ��Ϊ��ɫ
		jt3.setBackground(Color.WHITE);		//���ı���ı�����ɫ��Ϊ��ɫ
		
		
	}


	/**
	 * @desc ��������ı������С
	 */
	private void font() {
		// TODO �Զ����ɵķ������
		
		jt1.setFont(font1);		//���ı��������С
		jt2.setFont(font2);		//���ı�������ϴ�
		jt3.setFont(font2);		//���ı�������ϴ�
		
	}

	/**
	 * @desc ��������߿�
	 */
	private void border() {
		// TODO �Զ����ɵķ������
		
		jt1.setBorder(border);	//���ı���ı߿�ȥ��
		jt2.setBorder(border);	//���ı���ı߿�ȥ��
		jt3.setBorder(border);	//���ı���ı߿�ȥ��
	}

	/**
	 * @desc ���������λ�úʹ�С
	 */
	private void bound() {
		// TODO �Զ����ɵķ������
		
		pan1.setBounds(30,20,620,60);	//���1λ�úʹ�С
		pan2.setBounds(30,100,620,330);	//���2λ�úʹ�С
		
		jt3.setBounds(0,0,30,60);		//�ı���λ�úʹ�С
		jt1.setBounds(30,0,590,30);
		jt2.setBounds(30,30,590,30);
	}

	/**
	 * @desc ��ť��������
	 */
	private void buttonHandle() {
		// TODO �Զ����ɵķ������
		
		//������ť��ע�����
		for(int i=0;i<butNum.length;i++){
			butNum[i]=new JButton(s1[i]);	//���鰴ť0~9�Ұ�����.��
			butNum[i].setFont(font1);	//���ð�ť���ݵ�����
			butNum[i].addActionListener(standardControl);//ע�����
		}
				
		for(int i=0;i<butSign.length;i++){
			butSign[i]=new JButton(s2[i]);	//���Ű�ť
			butSign[i].setFont(font1);
			butSign[i].addActionListener(standardControl);//ע�����
		}
					
		for(int i=0;i<butFunction.length;i++){
			butFunction[i]=new JButton(s3[i]);	//���ܰ�ť
			butFunction[i].setFont(font1);
			butFunction[i].addActionListener(standardControl);//ע�����
		}
		
		standardControl.insert(this);	//���׼�������¼������ഫ���׼������������������
				
	}


	/**
	 * @desc ��ť�������Ϊ��������ֹ����������
	 */
	private void layoutPlan() {
		// TODO �Զ����ɵķ������
		
		constraints.fill=GridBagConstraints.BOTH;//��������������ģʽΪBOTH
		constraints.anchor=GridBagConstraints.CENTER;//���õ����С����ʾ����ʱ�����ж���
		constraints.insets = new Insets(5,5,5,5);	//������
		
		//Ϊ��ӵ������е��������Լ�������ĸ�������
		//���������壺������������������Լ����������λ�ã���λ�ã���ȣ��߶ȣ�����з������������з������
		addCom(butFunction[0],pan2,constraints,0,0,1,1,0.5,0.6);
		addCom(butFunction[1],pan2,constraints,1,0,1,1,0.5,0.6);
		addCom(butFunction[2],pan2,constraints,2,0,1,1,0.5,0.6);
		addCom(butFunction[3],pan2,constraints,3,0,1,1,0.5,0.6);
		addCom(butFunction[4],pan2,constraints,4,0,1,1,0.5,0.6);
		addCom(butFunction[5],pan2,constraints,0,1,1,1,0.5,0.6);
		addCom(butFunction[6],pan2,constraints,1,1,1,1,0.5,0.6);
		addCom(butFunction[7],pan2,constraints,2,1,1,1,0.5,0.6);
		addCom(butSign[5],pan2,constraints,3,1,1,1,0.5,0.6);
		addCom(butSign[6],pan2,constraints,4,1,1,1,0.5,0.6);
		addCom(butNum[7],pan2,constraints,0,2,1,1,0.5,0.6);
		addCom(butNum[8],pan2,constraints,1,2,1,1,0.5,0.6);
		addCom(butNum[9],pan2,constraints,2,2,1,1,0.5,0.6);
		addCom(butSign[3],pan2,constraints,3,2,1,1,0.5,0.6);
		addCom(butSign[8],pan2,constraints,4,2,1,1,0.5,0.6);
		addCom(butNum[4],pan2,constraints,0,3,1,1,0.5,0.6);
		addCom(butNum[5],pan2,constraints,1,3,1,1,0.5,0.6);
		addCom(butNum[6],pan2,constraints,2,3,1,1,0.5,0.6);
		addCom(butSign[2],pan2,constraints,3,3,1,1,0.5,0.6);
		addCom(butSign[7],pan2,constraints,4,3,1,1,0.5,0.6);
		addCom(butNum[1],pan2,constraints,0,4,1,1,0.5,0.6);
		addCom(butNum[2],pan2,constraints,1,4,1,1,0.5,0.6);
		addCom(butNum[3],pan2,constraints,2,4,1,1,0.5,0.6);
		addCom(butSign[1],pan2,constraints,3,4,1,1,0.5,0.6);
		addCom(butSign[4],pan2,constraints,4,4,1,2,0.5,0.6);
		addCom(butNum[0],pan2,constraints,0,5,2,1,0.5,0.6);
		addCom(butNum[10],pan2,constraints,2,5,1,1,0.5,0.6);
		addCom(butSign[0],pan2,constraints,3,5,1,1,0.5,0.6);
		
		
	}
	
	/**
	 * @desc ��������ֹ��������
	 * @param c
	 * @param con
	 * @param gbcon
	 * @param row
	 * @param col
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 */
	public void addCom(Component c,Container con,
			GridBagConstraints gbcon, int row, int col, int width, int height,double x,double y) {
		gbcon.gridx=row;	//�����������Ͻǵ�X����
		gbcon.gridy=col;	//�����������Ͻǵ�y����
		gbcon.gridwidth=width;	//��������Ŀ��
		gbcon.gridheight=height;	//��������ĸ߶�
		gbcon.weightx=x;	//��������з������
		gbcon.weighty=y;	//��������з������
		layout.setConstraints(c, gbcon);	//��������Լ��������ӵ���������ֹ�����setConstraints(Component comp,GridBagConstraints gbcon)
		con.add(c);	//������������
		
	}
		
}
