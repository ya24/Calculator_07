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
 * @author 叶雅芳
 * @date 2015-06-06
 * @desc 设计主界面
 *
 */
public class MainView extends JFrame{

	public StandardCalculator standardView;	//标准计算器界面设计类
	public ScienceCalculator scienceView;	//科学计算器界面设计类
	public ProgrammerCalculator programmerView;	//程序员计算器界面设计类
	public MainViewEvent viewControl;	//主界面动作事件处理类
	
	public Font font=new Font("宋体",Font.PLAIN,18);	//菜单字体设计
	
	public JPanel pan;		//面板，设置为卡片式布局管理器
	public CardLayout card;	//卡片式布局管理器
	
	public JMenuBar menuBar;	//菜单栏
	public JMenu visit,edit,help;	//查看，编辑 ，帮助菜单
	
	//标准型，科学型，程序员，复制，粘贴，查看帮助，关于计算器菜单项
	public JMenuItem standard,science,programmer,copy,paste,vhelp,about;	
	
	
	/**
	 * @desc 构造方法传入参数，实例化界面设计类和动作事件类，同时对成员变量进行相关设计
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
		
		found();	//实例化成员变量的方法
		
		insert();	//添加组件的方法
		
		Accelerator();	//设置快捷键的方法
		
		font();	//设置字体的方法
		
		addListener();	//注册监听
		
		this.setTitle("计算器");	//主界面标题为计算器
		this.setBounds(300,100,700,500);	//设置窗口的位置和大小
		this.setIconImage((new ImageIcon("iconpng.png")).getImage());	//设置图标
		this.setResizable(false);	//设置窗口大小不可改变
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/**
	 * @desc 菜单注册动作事件监听
	 */
	private void addListener() {
		
		standard.addActionListener(viewControl);
		science.addActionListener(viewControl);
		programmer.addActionListener(viewControl);
		copy.addActionListener(viewControl);
		paste.addActionListener(viewControl);
		vhelp.addActionListener(viewControl);
		about.addActionListener(viewControl);
		
		viewControl.insert(this,standardView);	//向主界面事件处理类传入主界面设计类对象
	}


	/**
	 * @desc 设置字体的方法
	 */
	private void font() {
		
		//设置菜单的字体
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
	 * @desc 设置快捷键的方法
	 */
	private void Accelerator() {
		
		standard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));//设置快捷键Alt+1
		science.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));//设置快捷键Alt+2
		programmer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.ALT_MASK));//设置快捷键Alt+3
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));//设置快捷键Ctrl+C
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));//设置快捷键Ctrl+V
		
	}


	/**
	 * @desc 添加组件的方法
	 */
	private void insert() {
		
		pan.add(standardView,"n1");	//将标准计算器对象添加 到面板中
		pan.add(scienceView,"n2");	//将科学计算器对象添加 到面板中
		pan.add(programmerView,"n3");	//将程序员计算器对象添加 到面板中
		card.show(pan, "n1");		//将面板pan中的标准计算器显示在容器
		this.add(pan);
		
		//将菜单添加到菜单栏
		menuBar.add(visit);
		menuBar.add(edit);
		menuBar.add(help);
		
		//将菜单项添加到查看菜单中
		visit.add(standard);
		visit.add(science);
		visit.add(programmer);
		
		
		//将菜单项添加到编辑菜单中
		edit.add(copy);
		edit.add(paste);
		
		//将菜单项添加到帮助菜单中		
		help.add(vhelp);
		help.add(about);
		
		
	}


	/**
	 * @desc 实例化成员变量的方法
	 */
	private void found() {
		
		card=new CardLayout();	//卡片式布局管理器
		pan=new JPanel(card);	//将面板设置为卡片式布局管理器
		
		menuBar=new JMenuBar();	//创建菜单栏
		this.setJMenuBar(menuBar);	//将菜单栏设置到窗体中
		
		//创建菜单
		visit=new JMenu("查看（V）");
		edit=new JMenu("编辑（E）");
		help=new JMenu("帮助（H）");
		
		//创建查看菜单下的菜单项
		standard=new JMenuItem("标准型（T）");
		science=new JMenuItem("科学型（S）");
		programmer=new JMenuItem("程序员（P）");
		
		//创建编辑菜单下的菜单项
		copy=new JMenuItem("复制（C）");
		paste=new JMenuItem("粘贴（P）");
		

		//创建帮助下的菜单项
		vhelp=new JMenuItem("查看帮助（V）");
		about=new JMenuItem("关于计算器（A）");
		
		
	}
	
	
	
}
