package programmerView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import programmerControl.ProgrammerEvent;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-06-06
 * @desc ����Ա��������������ࡪ���˹����д�����
 *
 */

public class ProgrammerCalculator extends JPanel {
	
	JLabel jlab;
	ProgrammerEvent programControl;
	
	public ProgrammerCalculator(ProgrammerEvent programControl){
		
		this.programControl=programControl;
		
		jlab=new JLabel();
		jlab.setBounds(100,100,300,100);
		jlab.setText("�����������ޣ��˹����д�����");
		jlab.setFont(new Font("����",Font.PLAIN,18));
		jlab.setForeground(Color.BLUE);
		this.setLayout(null);
		add(jlab);
	}	
}
