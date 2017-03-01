package mainView;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import mainControl.MainViewEvent;
import programmerView.ProgrammerCalculator;
import scienceView.ScienceCalculator;
import standardView.StandardCalculator;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-06-06
 * @desc ���������
 *
 */
public class MainView extends JFrame{

	public StandardCalculator standardView;	//��׼���������������
	public ScienceCalculator scienceView;	//��ѧ���������������
	public ProgrammerCalculator programmerView;	//����Ա���������������
	public MainViewEvent viewControl;	//�����涯���¼�������
	
	public Font font=new Font("����",Font.PLAIN,18);	//�˵��������
	
	public JPanel pan;		//��壬����Ϊ��Ƭʽ���ֹ�����
	public CardLayout card;	//��Ƭʽ���ֹ�����
	
	public JMenuBar menuBar;	//�˵���
	public JMenu visit,edit,help;	//�鿴���༭ �������˵�
	
	//��׼�ͣ���ѧ�ͣ�����Ա�����ƣ�ճ�����鿴���������ڼ������˵���
	public JMenuItem standard,science,programmer,copy,paste,vhelp,about;	
	
	
	/**
	 * @desc ���췽�����������ʵ�������������Ͷ����¼��࣬ͬʱ�Գ�Ա��������������
	 * @param standardView
	 * @param scienceView
	 * @param programmerView
	 * @param viewControl
	 */
	public MainView(StandardCalculator standardView,ScienceCalculator scienceView,
			ProgrammerCalculator programmerView,MainViewEvent viewControl){
		
		this.standardView=standardView;
		this.scienceView=scienceView;
		this.programmerView=programmerView;
		this.viewControl=viewControl;
		
		found();	//ʵ������Ա�����ķ���
		
		insert();	//�������ķ���
		
		Accelerator();	//���ÿ�ݼ��ķ���
		
		font();	//��������ķ���
		
		addListener();	//ע�����
		
		this.setTitle("������");	//���������Ϊ������
		this.setBounds(300,100,700,500);	//���ô��ڵ�λ�úʹ�С
		this.setIconImage((new ImageIcon("iconpng.png")).getImage());	//����ͼ��
		this.setResizable(false);	//���ô��ڴ�С���ɸı�
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/**
	 * @desc �˵�ע�ᶯ���¼�����
	 */
	private void addListener() {
		
		standard.addActionListener(viewControl);
		science.addActionListener(viewControl);
		programmer.addActionListener(viewControl);
		copy.addActionListener(viewControl);
		paste.addActionListener(viewControl);
		vhelp.addActionListener(viewControl);
		about.addActionListener(viewControl);
		
		viewControl.insert(this,standardView);	//���������¼������ഫ����������������
	}


	/**
	 * @desc ��������ķ���
	 */
	private void font() {
		
		//���ò˵�������
		visit.setFont(font);
		edit.setFont(font);
		help.setFont(font);
		standard.setFont(font);
		science.setFont(font);
		programmer.setFont(font);
		copy.setFont(font);
		paste.setFont(font);
		vhelp.setFont(font);
		about.setFont(font);
		
	}


	/**
	 * @desc ���ÿ�ݼ��ķ���
	 */
	private void Accelerator() {
		
		standard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));//���ÿ�ݼ�Alt+1
		science.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));//���ÿ�ݼ�Alt+2
		programmer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.ALT_MASK));//���ÿ�ݼ�Alt+3
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));//���ÿ�ݼ�Ctrl+C
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));//���ÿ�ݼ�Ctrl+V
		
	}


	/**
	 * @desc �������ķ���
	 */
	private void insert() {
		
		pan.add(standardView,"n1");	//����׼������������� �������
		pan.add(scienceView,"n2");	//����ѧ������������� �������
		pan.add(programmerView,"n3");	//������Ա������������� �������
		card.show(pan, "n1");		//�����pan�еı�׼��������ʾ������
		this.add(pan);
		
		//���˵���ӵ��˵���
		menuBar.add(visit);
		menuBar.add(edit);
		menuBar.add(help);
		
		//���˵�����ӵ��鿴�˵���
		visit.add(standard);
		visit.add(science);
		visit.add(programmer);
		
		
		//���˵�����ӵ��༭�˵���
		edit.add(copy);
		edit.add(paste);
		
		//���˵�����ӵ������˵���		
		help.add(vhelp);
		help.add(about);
		
		
	}


	/**
	 * @desc ʵ������Ա�����ķ���
	 */
	private void found() {
		
		card=new CardLayout();	//��Ƭʽ���ֹ�����
		pan=new JPanel(card);	//���������Ϊ��Ƭʽ���ֹ�����
		
		menuBar=new JMenuBar();	//�����˵���
		this.setJMenuBar(menuBar);	//���˵������õ�������
		
		//�����˵�
		visit=new JMenu("�鿴��V��");
		edit=new JMenu("�༭��E��");
		help=new JMenu("������H��");
		
		//�����鿴�˵��µĲ˵���
		standard=new JMenuItem("��׼�ͣ�T��");
		science=new JMenuItem("��ѧ�ͣ�S��");
		programmer=new JMenuItem("����Ա��P��");
		
		//�����༭�˵��µĲ˵���
		copy=new JMenuItem("���ƣ�C��");
		paste=new JMenuItem("ճ����P��");
		

		//���������µĲ˵���
		vhelp=new JMenuItem("�鿴������V��");
		about=new JMenuItem("���ڼ�������A��");
		
		
	}
	
	
	
}
