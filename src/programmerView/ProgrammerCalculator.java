package programmerView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import programmerControl.ProgrammerEvent;

/**
 * 
 * @author 叶雅芳
 * @date 2015-06-06
 * @desc 程序员计算器界面设计类——此功能尚待开发
 *
 */

public class ProgrammerCalculator extends JPanel {
	
	JLabel jlab;
	ProgrammerEvent programControl;
	
	public ProgrammerCalculator(ProgrammerEvent programControl){
		
		this.programControl=programControl;
		
		jlab=new JLabel();
		jlab.setBounds(100,100,300,100);
		jlab.setText("作者能力有限，此功能尚待开发");
		jlab.setFont(new Font("宋体",Font.PLAIN,18));
		jlab.setForeground(Color.BLUE);
		this.setLayout(null);
		add(jlab);
	}	
}
