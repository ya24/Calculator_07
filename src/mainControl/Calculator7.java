package mainControl;

import mainView.MainView;
import programmerControl.ProgrammerEvent;
import programmerView.ProgrammerCalculator;
import scienceControl.ScienceEvent;
import scienceView.ScienceCalculator;
import standardControl.StandardEvent;
import standardView.StandardCalculator;

/**
 * @author 叶雅芳
 * @version V7.0
 * @date 2015-06-06
 * @desc 仿win8自带计算器
 */
public class Calculator7 {

	/**
	 * @desc 主类用来实例化此项目涉及到的所有类
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		StandardEvent standardControl=new StandardEvent();	//标准计算器事件处理类
		ScienceEvent scienceControl=new ScienceEvent();	//科学计算器事件处理类
		ProgrammerEvent programControl=new ProgrammerEvent();	//程序员计算器事件处理类
		MainViewEvent viewControl=new MainViewEvent();	//主界面动作事件处理类
		
		StandardCalculator standardView=new StandardCalculator(standardControl);	//标准计算器界面设计类
		ScienceCalculator scienceView=new ScienceCalculator(scienceControl);	//科学计算器界面设计类
		ProgrammerCalculator programmerView =new ProgrammerCalculator(programControl);	//程序员计算器界面设计类
		
		MainView view=new MainView(standardView,scienceView,programmerView,viewControl);	//主界面类
	}

}




/*第七代计算器
 * 一、新增：
 * 界面布局不再只是单一标准计算器，新增了一些菜单功能。
 * 
 *
 *二、 以解决问题:
 * 1.已摸索出网格包布局管理器的使用方法，界面布局更完善
 * 2.←键已可实现只删除使用者输入的数字或符号键，而不能删除运算后的结果
 * 3.显示区域内，当内容满后，将前面内容隐去而只显示后面运算过程（解决方法：将显示内容的组件换成了文本框，但为什么标签无法实现这般功能？）
 * 4.求负数功能：±键，可以实现求负数后再在负数之后追加新内容
 * 5.导出的jar文件所设计的图标可以显示（解决方法，将图标图形文件与jar文件放在同一个文件夹下）
 * 
 * 
 * 三、待解救问题：
 * 1.等于号操作：按下等号即结束此次运算。按下等于号时，可以将上文本框中的内容清除，在下文本框中显示最后结果，而后所有还原成默认
 * 2.win8系统自带计算器%号功能尚未摸索出
 * 3.MS键问题：flag=true，可使保存后重新输入新值，但无法进行保存之后的继续运算，若设flag=false，则可以实现继续运算功能，但无法实现重新输入新值功能
 * 	 MR,M+,M-键问题同MS键类似
 * 4.1和3问题出在运算操作calculate()方法中，对此方法进行改善，或许可以解决问题；抑或少了一些标志判断
 * 
 * 
 * 四、细节问题：
 * 1.求导功能：1/x键不完善；运算中，对某数求导后再运算可以实现；但对某数求导后不将求导结果参与运算，而重新输入一个数字参与运算这样的功能无法实现。具体功能体验参照win8自带计算器
 * 2.求根功能所遇问题跟求导功能类似
 * 
 * 
 * 五、所做的改进
 * 1.调用比较equals()方法时，把input作为参数，用创建的字符串对象调用equals()方法，防止产生空指针异常
 * 2.运用MVC的思想，将包进行分模块管理，使结构更清晰
 * 3.将界面设计类和事件处理类分开，使类结构设计更合理
 * 4.增加专业注释方法，同时尽量减少了一个方法中的代码
 * 
 */








