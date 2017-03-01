package mainControl;

import mainView.MainView;
import programmerControl.ProgrammerEvent;
import programmerView.ProgrammerCalculator;
import scienceControl.ScienceEvent;
import scienceView.ScienceCalculator;
import standardControl.StandardEvent;
import standardView.StandardCalculator;

/**
 * @author Ҷ�ŷ�
 * @version V7.0
 * @date 2015-06-06
 * @desc ��win8�Դ�������
 */
public class Calculator7 {

	/**
	 * @desc ��������ʵ��������Ŀ�漰����������
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		StandardEvent standardControl=new StandardEvent();	//��׼�������¼�������
		ScienceEvent scienceControl=new ScienceEvent();	//��ѧ�������¼�������
		ProgrammerEvent programControl=new ProgrammerEvent();	//����Ա�������¼�������
		MainViewEvent viewControl=new MainViewEvent();	//�����涯���¼�������
		
		StandardCalculator standardView=new StandardCalculator(standardControl);	//��׼���������������
		ScienceCalculator scienceView=new ScienceCalculator(scienceControl);	//��ѧ���������������
		ProgrammerCalculator programmerView =new ProgrammerCalculator(programControl);	//����Ա���������������
		
		MainView view=new MainView(standardView,scienceView,programmerView,viewControl);	//��������
	}

}




/*���ߴ�������
 * һ��������
 * ���沼�ֲ���ֻ�ǵ�һ��׼��������������һЩ�˵����ܡ�
 * 
 *
 *���� �Խ������:
 * 1.����������������ֹ�������ʹ�÷��������沼�ָ�����
 * 2.�����ѿ�ʵ��ֻɾ��ʹ������������ֻ���ż���������ɾ�������Ľ��
 * 3.��ʾ�����ڣ����������󣬽�ǰ��������ȥ��ֻ��ʾ����������̣��������������ʾ���ݵ�����������ı��򣬵�Ϊʲô��ǩ�޷�ʵ����㹦�ܣ���
 * 4.�������ܣ�����������ʵ�����������ڸ���֮��׷��������
 * 5.������jar�ļ�����Ƶ�ͼ�������ʾ�������������ͼ��ͼ���ļ���jar�ļ�����ͬһ���ļ����£�
 * 
 * 
 * ������������⣺
 * 1.���ںŲ��������µȺż������˴����㡣���µ��ں�ʱ�����Խ����ı����е���������������ı�������ʾ��������������л�ԭ��Ĭ��
 * 2.win8ϵͳ�Դ�������%�Ź�����δ������
 * 3.MS�����⣺flag=true����ʹ���������������ֵ�����޷����б���֮��ļ������㣬����flag=false�������ʵ�ּ������㹦�ܣ����޷�ʵ������������ֵ����
 * 	 MR,M+,M-������ͬMS������
 * 4.1��3��������������calculate()�����У��Դ˷������и��ƣ�������Խ�����⣻�ֻ�����һЩ��־�ж�
 * 
 * 
 * �ġ�ϸ�����⣺
 * 1.�󵼹��ܣ�1/x�������ƣ������У���ĳ���󵼺����������ʵ�֣�����ĳ���󵼺󲻽��󵼽���������㣬����������һ�����ֲ������������Ĺ����޷�ʵ�֡����幦���������win8�Դ�������
 * 2.�����������������󵼹�������
 * 
 * 
 * �塢�����ĸĽ�
 * 1.���ñȽ�equals()����ʱ����input��Ϊ�������ô������ַ����������equals()��������ֹ������ָ���쳣
 * 2.����MVC��˼�룬�������з�ģ�����ʹ�ṹ������
 * 3.�������������¼�������ֿ���ʹ��ṹ��Ƹ�����
 * 4.����רҵע�ͷ�����ͬʱ����������һ�������еĴ���
 * 
 */








