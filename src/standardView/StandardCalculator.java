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
 * @author 叶雅芳
 * @date 2015-06-06
 * @desc 标准计算器图形界面设计类
 *
 */
public class StandardCalculator extends JPanel{

	public StandardEvent standardControl;	//标准计算器事件处理类
	
	public JPanel pan1;	//面板1用于添加文本框
	public JPanel pan2;	//面板2设为网格包布局管理器
	
	public JTextField jt1,jt2,jt3;		//上下,左侧文本框
	
	public String[] s1={"0","1","2","3","4","5","6","7","8","9","."};	//数字按钮内容
	public JButton[] butNum=new JButton[s1.length];	//数字按钮数组(包".")
	
	public String[] s2={"+","-","*","/","=","±","√","1/x","%"};	//符号按钮内容
	public JButton[] butSign=new JButton[s2.length];	//符号按钮数组
	
	public String[] s3={"MC","MR","MS","M+","M-","←","CE","C"};	//功能按钮内容
	public JButton[] butFunction=new JButton[s3.length];	//功能按钮数组
	
	public Font font1=new Font("宋体",Font.PLAIN,18);	//设计上文本框中的字体
	public Font font2=new Font("宋体",Font.PLAIN,24);	//设计下文本框中的字体
	public EmptyBorder border=new EmptyBorder(0,0,0,0);;	//除去文本框的边框
	
	public GridBagLayout layout=new GridBagLayout();	//网格包布局管理器
	public GridBagConstraints constraints=new GridBagConstraints();	//网格包约束条件
	
	
	/**
	 * @desc 构造方法传入标准计算器事件处理类对象，实例化相应的成员变量，同时对其他成员变量进行设计
	 * @param standardControl
	 */
	public StandardCalculator(StandardEvent standardControl){
		
		this.standardControl=standardControl;
		
		found();	//实例化成员变量
		
		insert();	//面板1添加文本框组件
		
		set();	//设置成员变量属性
		
		buttonHandle();	//按钮组件的设计
		
		layoutPlan();	//按钮组件设置为网格包布局管理器的设计
		
	}


	/**
	 * @desc found()方法用来实例化成员变量
	 */
	private void found() {
		// TODO 自动生成的方法存根
		
		//实例化面板
		pan1=new JPanel();		//面板1用于放置文本框
		pan2=new JPanel(layout);	//面板2设为网格包布局管理器
		
		//实例化文本框
		jt1=new JTextField();	//上文本框
		jt2=new JTextField("0");	//下文本框，初始时有0
		jt3=new JTextField();	//左侧文本框，用于显示运算过程中储存的值
		
	}


	/**
	 * @desc insert()方法用于面板1添加文本框组件
	 */
	private void insert() {
		// TODO 自动生成的方法存根
		
		//将文本框加入面板1中
		pan1.add(jt3);	
		pan1.add(jt1);
		pan1.add(jt2);
		
		this.add(pan1);	//添加面板	
		this.add(pan2);
	
	}


	/**
	 * @desc set()方法用于设置成员变量的一些属性
	 */
	private void set() {
		// TODO 自动生成的方法存根
		
		
		this.setLayout(null);	//标准计算器面板的布局管理器设为绝对布局
		
		pan1.setLayout(null);	//面板1用于放置文本框，布局设置为绝对布局
		
		bound();	//设置组件的位置和大小
		
		border();	//设置组件边框
		
		font();		//设置组件文本字体大小
		
		jt1.setHorizontalAlignment(JTextField.RIGHT);	//文本框文本右对齐
		jt2.setHorizontalAlignment(JTextField.RIGHT);	//文本框文本右对齐
		
		jt1.setBackground(Color.WHITE);		//将文本框的背景颜色设为白色
		jt2.setBackground(Color.WHITE);		//将文本框的背景颜色设为白色
		jt3.setBackground(Color.WHITE);		//将文本框的背景颜色设为白色
		
		
	}


	/**
	 * @desc 设置组件文本字体大小
	 */
	private void font() {
		// TODO 自动生成的方法存根
		
		jt1.setFont(font1);		//上文本框字体较小
		jt2.setFont(font2);		//下文本框字体较大
		jt3.setFont(font2);		//下文本框字体较大
		
	}

	/**
	 * @desc 设置组件边框
	 */
	private void border() {
		// TODO 自动生成的方法存根
		
		jt1.setBorder(border);	//将文本框的边框去掉
		jt2.setBorder(border);	//将文本框的边框去掉
		jt3.setBorder(border);	//将文本框的边框去掉
	}

	/**
	 * @desc 设置组件的位置和大小
	 */
	private void bound() {
		// TODO 自动生成的方法存根
		
		pan1.setBounds(30,20,620,60);	//面板1位置和大小
		pan2.setBounds(30,100,620,330);	//面板2位置和大小
		
		jt3.setBounds(0,0,30,60);		//文本框位置和大小
		jt1.setBounds(30,0,590,30);
		jt2.setBounds(30,30,590,30);
	}

	/**
	 * @desc 按钮组件的设计
	 */
	private void buttonHandle() {
		// TODO 自动生成的方法存根
		
		//创建按钮并注册监听
		for(int i=0;i<butNum.length;i++){
			butNum[i]=new JButton(s1[i]);	//数组按钮0~9且包括“.”
			butNum[i].setFont(font1);	//设置按钮内容的字体
			butNum[i].addActionListener(standardControl);//注册监听
		}
				
		for(int i=0;i<butSign.length;i++){
			butSign[i]=new JButton(s2[i]);	//符号按钮
			butSign[i].setFont(font1);
			butSign[i].addActionListener(standardControl);//注册监听
		}
					
		for(int i=0;i<butFunction.length;i++){
			butFunction[i]=new JButton(s3[i]);	//功能按钮
			butFunction[i].setFont(font1);
			butFunction[i].addActionListener(standardControl);//注册监听
		}
		
		standardControl.insert(this);	//向标准计算器事件处理类传入标准计算器界面设计类对象
				
	}


	/**
	 * @desc 按钮组件设置为网格包布局管理器的设计
	 */
	private void layoutPlan() {
		// TODO 自动生成的方法存根
		
		constraints.fill=GridBagConstraints.BOTH;//设置组件具有填充模式为BOTH
		constraints.anchor=GridBagConstraints.CENTER;//设置当组件小于显示区域时，居中对齐
		constraints.insets = new Insets(5,5,5,5);	//组件间距
		
		//为添加到容器中的组件设置约束条件的各种属性
		//各参数含义：组件，组件所在容器，约束条件，列位置，行位置，宽度，高度，组件行分配比例，组件列分配比例
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
	 * @desc 网格包布局管理器设计
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
		gbcon.gridx=row;	//设置网格左上角的X坐标
		gbcon.gridy=col;	//设置网格左上角的y坐标
		gbcon.gridwidth=width;	//设置网格的宽度
		gbcon.gridheight=height;	//设置网格的高度
		gbcon.weightx=x;	//设置组件行分配比例
		gbcon.weighty=y;	//设置组件列分配比例
		layout.setConstraints(c, gbcon);	//将容器按约束条件添加到网格包布局管理器setConstraints(Component comp,GridBagConstraints gbcon)
		con.add(c);	//向容器添加组件
		
	}
		
}
