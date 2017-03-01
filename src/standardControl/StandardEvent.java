package standardControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import standardView.StandardCalculator;

/**
 * 
 * @author 叶雅芳
 * @date 2015-06-06
 * @desc 标准计算器事件处理类
 *
 */
public class StandardEvent implements ActionListener{

	StandardCalculator standardCalculator;	//标准计算器界面设计类
	
	//事件处理所用的成员变量
	private String lastOperator="=";	//保存运算符，默认为=
	private double result=0;	//计算结果
	private boolean flag=true;	//标记是否开始
	private double save=0;		//定义变量存放所存储的数据
	
	
	/**
	 * @desc 传入标准计算器图形界面设计类对象，实例化相对应的成员变量
	 * @param standardCalculator
	 */
	public void insert(StandardCalculator standardCalculator) {
		this.standardCalculator=standardCalculator;
		
	}
	
	
	/**
	 * @desc 动作事件方法
	 * @param e
	 * */
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		String input=e.getActionCommand();	//获取按钮内容
		
		//判断是否为与清除有关的功能键
		if("C".equals(input)||"CE".equals(input)||"←".equals(input)){	
			handleClear(input);		//具体功能实现交给handleClear()方法
		}
		
		//判断输入的是否为非符号键
		else if("0123456789.".indexOf(input)>=0){	
			if(flag){					//flag为true时，表示的是开始输入或是符号输入之后
				standardCalculator.jt2.setText("");		//如果是数字输入，应先把下标签内容清空
				flag=false;				//输入一个数后 就不再是true了
			}
			standardCalculator.jt2.setText(standardCalculator.jt2.getText()+input);	//为了显示连续输入的数字按钮
		}
		
		
		//判断输入的是+-*/符号键
		else if("+".equals(input)||"-".equals(input)||"*".equals(input)||"/".equals(input)||"=".equals(input)){
			if(flag){				
				standardCalculator.jt2.setText("");
				if(input.equals("-")){		//如果是起始输入，应以负数形式体现
					standardCalculator.jt2.setText(input);
					flag=false;
				}
			}
			else{
				standardCalculator.jt1.setText(standardCalculator.jt1.getText()+standardCalculator.jt2.getText()+input);	//如果不是起始输入，则将下标签的内容和上标签的内容一起显示在上标签，以便使用者清楚都进行了哪些运算
				calculate(Double.parseDouble(standardCalculator.jt2.getText()));	//进行运算，将他交给calculate()方法
				lastOperator=input;		//保存输入的符号
				flag=true;			//输入符号后flag设为true，以便下一步数字输入操作
			}
		}
		
		//判断其中几个特殊运算符键 1/x √ ± %
		else if(input.equals("1/x")||input.equals("√")||input.equals("±")||input.equals("%")){
			handleSpecial(input);	//具体功能实现交给handleSpecial()方法
		}
		
		//记忆功能键MC MR MS M+ M-
		else if(input.equals("MC")||input.equals("MR")||input.equals("MS")||input.equals("M+")||input.equals("M-")){
			
			handleSave(input);
		}
	}

	/**
	 * @desc 记忆功能键MC MR MS M+ M-的处理
	 * @param input
	 */
	
	/*
	 * 功能键用法：
	 * MC：清除保存的数据
	 * MR：将保存的数据显示在左边显示区
	 * MS：仅保存当前数据，之前所保存的数据全部清空
	 * M+:将当前数据与保存的数据进行加运算，将结果再次保存起来
	 * M-:将保存数据减去当前数据，将结果再次保存起来
	 * 
	 * */
	private void handleSave(String input) {
		// TODO 自动生成的方法存根
		if("MC".equals(input)){
			save=0;	//清除所保存的数据
			standardCalculator.jt3.setText("");	//同时左下角显示的M删除	
		}
		else if("MR".equals(input)){
			standardCalculator.jt2.setText(""+save);//将保存起来的数显示在下显示区域
			flag=false;
		}
		else if("MS".equals(input)){
			save=Double.parseDouble(standardCalculator.jt2.getText());	//将下显示区域的内容保存起来
			standardCalculator.jt3.setText(" M");	//在左下角显示M表示存储有数据
			flag=false;
		}
		else if("M+".equals(input)){
			save+=Double.parseDouble(standardCalculator.jt2.getText());	//将当前数据与保存的数据进行加运算，将结果再次保存起来
			standardCalculator.jt3.setText(" M");	//在左下角显示M表示存储有数据
			flag=false;
		}
		else if("M-".equals(input)){
			save-=Double.parseDouble(standardCalculator.jt2.getText());	//将保存数据减去当前数据，将结果再次保存起来
			standardCalculator.jt3.setText(" M");	//在左下角显示M表示存储有数据
			flag=false;
		}
		
		
	}

	/**
	 * @desc 几个特殊运算符键 1/x √ ± %的处理
	 * @param input
	 */
	private void handleSpecial(String input) {
		// TODO 自动生成的方法存根
		
		if("1/x".equals(input)){	//处理  1/x 键
			handleDaoshu();
		}
		
		else if("√".equals(input)){		//处理  √ 键
			handleSqrt();	
		}
		
		else if("±".equals(input))		//处理  ±  键
			standardCalculator.jt2.setText("-"+standardCalculator.jt2.getText());
		
		else if("%".equals(input)){		//处理  % 键
			JOptionPane.showMessageDialog(standardCalculator, "此功能正在开发");
		
		}
	}

	
	/**
	 * @desc 处理  √ 键
	 */
	private void handleSqrt() {
		// TODO 自动生成的方法存根
		double date=Double.parseDouble(standardCalculator.jt2.getText());
		if(date<0){
			standardCalculator.jt2.setText("负数无法开平方根");
			flag=true;
			lastOperator="=";
			result=0;
			standardCalculator.jt1.setText("");
		}
		else{	
			standardCalculator.jt2.setText(""+Math.sqrt(Double.parseDouble(standardCalculator.jt2.getText())));//调用Math类的sqrt()方法计算开根号运算
		}
	}

	
	/**
	 * @desc 处理  1/x 键
	 */
	private void handleDaoshu() {
		// TODO 自动生成的方法存根
		if(Double.parseDouble(standardCalculator.jt2.getText())==0){	//当求的是0的倒数时
			standardCalculator.jt2.setText("0没有倒数");
			flag=true;
			lastOperator="=";
			result=0;
			standardCalculator.jt1.setText("");
		}
		else{
			standardCalculator.jt2.setText(""+1/(Double.parseDouble(standardCalculator.jt2.getText())));
		}		
			
	}

	
	/**
	 * @desc 四则运算
	 * @param parseDouble
	 */
	private void calculate(double parseDouble) {
		// TODO 自动生成的方法存根
		if(lastOperator.equals("+"))
			result+=parseDouble;
		else if(lastOperator.equals("-"))
			result-=parseDouble;
		else if(lastOperator.equals("*"))
			result*=parseDouble;
		else if(lastOperator.equals("/"))
				result/=parseDouble;
		else if(lastOperator.equals("="))
				result=parseDouble;	
		standardCalculator.jt2.setText(""+result);		//将运算结果显示在下标签中
	}

	
	/**
	 * @desc 清除功能处理
	 * @param input
	 */
	private void handleClear(String input) {
		// TODO 自动生成的方法存根
		
		//执行清零操作(C)时全部要 恢复成默认值
		if("C".equals(input)){	
			standardCalculator.jt1.setText("");
			standardCalculator.jt2.setText("0");
			flag=true;
			lastOperator="=";
			result=0;
		}
		
		//执行清除数据键（CE）,只将输入到下显示区域的内容删除，其他保留
		else if("CE".equals(input)){	
			standardCalculator.jt2.setText("0");
			flag=true;
		}
		
		//执行退格键，将下显示区域的内容一个一个删除
		else if("←".equals(input)){	
			backspace();
		
		}
	}

	/**
	 * @desc 退格键处理
	 */
	private void backspace() {
		// TODO 自动生成的方法存根
		//加一个判断，当进行计算后（flag=true）此功能无法实现
		if(!flag){
			String txt=standardCalculator.jt2.getText();	//获取下显示区域的内容
			int i=txt.length();			//获取txt内容长度
			if(i>0){
				txt=txt.substring(0,i-1);	//将文本内容的最后一个删除
				if(txt.length()>0)		//如果删除文本的最后一个内容后的文本长度不为0，
					standardCalculator.jt2.setText(txt);	//则在下显示区域内显示删除后的内容
				else{
					standardCalculator.jt2.setText("0");	//如果如果删除文本的最后一个内容后的文本长度为0，则在下显示区域内显示0
					flag=true;
				}
				
			}
		}
	}

}
