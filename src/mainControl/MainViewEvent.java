package mainControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import standardView.StandardCalculator;
import mainView.MainView;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-06-06
 * @desc ������˵������Ķ����¼�����
 *
 */
public class MainViewEvent implements ActionListener{

	private String keep="";	//���渴������������
	private MainView view;	//�����������
	StandardCalculator standardView;	//��׼���������������
	
	public void actionPerformed(ActionEvent e) {
		
		String str=e.getActionCommand();	//��ȡ�¼�Դ����
		if("��׼�ͣ�T��".equals(str))
			view.card.show(view.pan,"n1");
		else if("��ѧ�ͣ�S��".equals(str))
			view.card.show(view.pan, "n2");
		else if("����Ա��P��".equals(str))
			view.card.show(view.pan, "n3");
		else if("���ƣ�C��".equals(str))
			keep=standardView.jt2.getText();		//���¸��Ʋ˵������׼��������������������ı����е����ݱ�������
		else if("ճ����P��".equals(str))
			standardView.jt2.setText(keep);	//����ճ���˵������������������ʾ�ڱ�׼����������������е����ı�����
		else if(str.equals("�鿴������V��"))
			//�����ԶԻ�����ʽչ��
			JOptionPane.showMessageDialog(view,"\n\n���ƹ��ܣ����Ƶ���������ʾ���������\n\nճ���ǽ������ƵĶ�����ʾ������ʾ������","�鿴����",JOptionPane.PLAIN_MESSAGE);
		else if(str.equals("���ڼ�������A��"))
			JOptionPane.showMessageDialog(view,"�˼�����������׼����������ѧ������������Ա������\n\n\n\n\n����QQ��3066253051\n��ӭʹ���߶Դ˼������������Ϳ���","���ڼ�����",JOptionPane.PLAIN_MESSAGE);
	
	}

	
	/**
	 * @desc ����������ͱ�׼������������������ʵ�������Ӧ�ĳ�Ա����
	 * @param view
	 * @param standardView
	 */
	public void insert(MainView view,StandardCalculator standardView) {
		// TODO �Զ����ɵķ������
		this.view=view;
		this.standardView=standardView;
		
	}
}
