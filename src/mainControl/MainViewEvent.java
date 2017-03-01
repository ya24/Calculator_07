package mainControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import standardView.StandardCalculator;
import mainView.MainView;

/**
 * 
 * @author 叶雅芳
 * @date 2015-06-06
 * @desc 主界面菜单触发的动作事件处理
 *
 */
public class MainViewEvent implements ActionListener{

	private String keep="";	//保存复制下来的内容
	private MainView view;	//主界面设计类
	StandardCalculator standardView;	//标准计算器界面设计类
	
	public void actionPerformed(ActionEvent e) {
		
		String str=e.getActionCommand();	//获取事件源内容
		if("标准型（T）".equals(str))
			view.card.show(view.pan,"n1");
		else if("科学型（S）".equals(str))
			view.card.show(view.pan, "n2");
		else if("程序员（P）".equals(str))
			view.card.show(view.pan, "n3");
		else if("复制（C）".equals(str))
			keep=standardView.jt2.getText();		//按下复制菜单项，将标准计算器界面设计类中下文本框中的内容保存起来
		else if("粘贴（P）".equals(str))
			standardView.jt2.setText(keep);	//按下粘贴菜单项，保存起来的内容显示在标准计算器界面设计类中的下文本框中
		else if(str.equals("查看帮助（V）"))
			//内容以对话框新式展现
			JOptionPane.showMessageDialog(view,"\n\n复制功能：复制的是下面显示区域的内容\n\n粘贴是将所复制的东西显示在下显示区域内","查看帮助",JOptionPane.PLAIN_MESSAGE);
		else if(str.equals("关于计算器（A）"))
			JOptionPane.showMessageDialog(view,"此计算器包括标准计算器，科学计算器，程序员计算器\n\n\n\n\n本人QQ：3066253051\n欢迎使用者对此计算器提出建议和看法","关于计算器",JOptionPane.PLAIN_MESSAGE);
	
	}

	
	/**
	 * @desc 传入主界面和标准计算器界面设计类对象，实例化相对应的成员变量
	 * @param view
	 * @param standardView
	 */
	public void insert(MainView view,StandardCalculator standardView) {
		// TODO 自动生成的方法存根
		this.view=view;
		this.standardView=standardView;
		
	}
}
