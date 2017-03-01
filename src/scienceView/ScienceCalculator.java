package scienceView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import scienceControl.ScienceEvent;

/**
 * 
 * @author 叶雅芳
 * @date 2015-06-06
 * @desc 科学计算器界面设计类——此功能尚待开发
 *
 */
public class ScienceCalculator extends JPanel{
	JLabel lab;
	ScienceEvent scienceControl;
	
	public ScienceCalculator(ScienceEvent scienceControl){
		
		this.scienceControl=scienceControl;
		
		lab=new JLabel();
		lab.setBounds(100,100,300,100);
		lab.setText("作者能力有限，此功能尚待开发");
		lab.setFont(new Font("宋体",Font.PLAIN,18));
		lab.setForeground(Color.RED);
		this.setLayout(null);
		add(lab);
	}
}
