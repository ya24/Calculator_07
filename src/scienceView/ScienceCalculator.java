package scienceView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import scienceControl.ScienceEvent;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-06-06
 * @desc ��ѧ��������������ࡪ���˹����д�����
 *
 */
public class ScienceCalculator extends JPanel{
	JLabel lab;
	ScienceEvent scienceControl;
	
	public ScienceCalculator(ScienceEvent scienceControl){
		
		this.scienceControl=scienceControl;
		
		lab=new JLabel();
		lab.setBounds(100,100,300,100);
		lab.setText("�����������ޣ��˹����д�����");
		lab.setFont(new Font("����",Font.PLAIN,18));
		lab.setForeground(Color.RED);
		this.setLayout(null);
		add(lab);
	}
}
