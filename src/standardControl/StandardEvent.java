package standardControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import standardView.StandardCalculator;

/**
 * 
 * @author Ҷ�ŷ�
 * @date 2015-06-06
 * @desc ��׼�������¼�������
 *
 */
public class StandardEvent implements ActionListener{

	StandardCalculator standardCalculator;	//��׼���������������
	
	//�¼��������õĳ�Ա����
	private String lastOperator="=";	//�����������Ĭ��Ϊ=
	private double result=0;	//������
	private boolean flag=true;	//����Ƿ�ʼ
	private double save=0;		//�������������洢������
	
	
	/**
	 * @desc �����׼������ͼ�ν�����������ʵ�������Ӧ�ĳ�Ա����
	 * @param standardCalculator
	 */
	public void insert(StandardCalculator standardCalculator) {
		this.standardCalculator=standardCalculator;
		
	}
	
	
	/**
	 * @desc �����¼�����
	 * @param e
	 * */
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		
		String input=e.getActionCommand();	//��ȡ��ť����
		
		//�ж��Ƿ�Ϊ������йصĹ��ܼ�
		if("C".equals(input)||"CE".equals(input)||"��".equals(input)){	
			handleClear(input);		//���幦��ʵ�ֽ���handleClear()����
		}
		
		//�ж�������Ƿ�Ϊ�Ƿ��ż�
		else if("0123456789.".indexOf(input)>=0){	
			if(flag){					//flagΪtrueʱ����ʾ���ǿ�ʼ������Ƿ�������֮��
				standardCalculator.jt2.setText("");		//������������룬Ӧ�Ȱ��±�ǩ�������
				flag=false;				//����һ������ �Ͳ�����true��
			}
			standardCalculator.jt2.setText(standardCalculator.jt2.getText()+input);	//Ϊ����ʾ������������ְ�ť
		}
		
		
		//�ж��������+-*/���ż�
		else if("+".equals(input)||"-".equals(input)||"*".equals(input)||"/".equals(input)||"=".equals(input)){
			if(flag){				
				standardCalculator.jt2.setText("");
				if(input.equals("-")){		//�������ʼ���룬Ӧ�Ը�����ʽ����
					standardCalculator.jt2.setText(input);
					flag=false;
				}
			}
			else{
				standardCalculator.jt1.setText(standardCalculator.jt1.getText()+standardCalculator.jt2.getText()+input);	//���������ʼ���룬���±�ǩ�����ݺ��ϱ�ǩ������һ����ʾ���ϱ�ǩ���Ա�ʹ�����������������Щ����
				calculate(Double.parseDouble(standardCalculator.jt2.getText()));	//�������㣬��������calculate()����
				lastOperator=input;		//��������ķ���
				flag=true;			//������ź�flag��Ϊtrue���Ա���һ�������������
			}
		}
		
		//�ж����м�������������� 1/x �� �� %
		else if(input.equals("1/x")||input.equals("��")||input.equals("��")||input.equals("%")){
			handleSpecial(input);	//���幦��ʵ�ֽ���handleSpecial()����
		}
		
		//���书�ܼ�MC MR MS M+ M-
		else if(input.equals("MC")||input.equals("MR")||input.equals("MS")||input.equals("M+")||input.equals("M-")){
			
			handleSave(input);
		}
	}

	/**
	 * @desc ���书�ܼ�MC MR MS M+ M-�Ĵ���
	 * @param input
	 */
	
	/*
	 * ���ܼ��÷���
	 * MC��������������
	 * MR���������������ʾ�������ʾ��
	 * MS�������浱ǰ���ݣ�֮ǰ�����������ȫ�����
	 * M+:����ǰ�����뱣������ݽ��м����㣬������ٴα�������
	 * M-:���������ݼ�ȥ��ǰ���ݣ�������ٴα�������
	 * 
	 * */
	private void handleSave(String input) {
		// TODO �Զ����ɵķ������
		if("MC".equals(input)){
			save=0;	//��������������
			standardCalculator.jt3.setText("");	//ͬʱ���½���ʾ��Mɾ��	
		}
		else if("MR".equals(input)){
			standardCalculator.jt2.setText(""+save);//����������������ʾ������ʾ����
			flag=false;
		}
		else if("MS".equals(input)){
			save=Double.parseDouble(standardCalculator.jt2.getText());	//������ʾ��������ݱ�������
			standardCalculator.jt3.setText(" M");	//�����½���ʾM��ʾ�洢������
			flag=false;
		}
		else if("M+".equals(input)){
			save+=Double.parseDouble(standardCalculator.jt2.getText());	//����ǰ�����뱣������ݽ��м����㣬������ٴα�������
			standardCalculator.jt3.setText(" M");	//�����½���ʾM��ʾ�洢������
			flag=false;
		}
		else if("M-".equals(input)){
			save-=Double.parseDouble(standardCalculator.jt2.getText());	//���������ݼ�ȥ��ǰ���ݣ�������ٴα�������
			standardCalculator.jt3.setText(" M");	//�����½���ʾM��ʾ�洢������
			flag=false;
		}
		
		
	}

	/**
	 * @desc ��������������� 1/x �� �� %�Ĵ���
	 * @param input
	 */
	private void handleSpecial(String input) {
		// TODO �Զ����ɵķ������
		
		if("1/x".equals(input)){	//����  1/x ��
			handleDaoshu();
		}
		
		else if("��".equals(input)){		//����  �� ��
			handleSqrt();	
		}
		
		else if("��".equals(input))		//����  ��  ��
			standardCalculator.jt2.setText("-"+standardCalculator.jt2.getText());
		
		else if("%".equals(input)){		//����  % ��
			JOptionPane.showMessageDialog(standardCalculator, "�˹������ڿ���");
		
		}
	}

	
	/**
	 * @desc ����  �� ��
	 */
	private void handleSqrt() {
		// TODO �Զ����ɵķ������
		double date=Double.parseDouble(standardCalculator.jt2.getText());
		if(date<0){
			standardCalculator.jt2.setText("�����޷���ƽ����");
			flag=true;
			lastOperator="=";
			result=0;
			standardCalculator.jt1.setText("");
		}
		else{	
			standardCalculator.jt2.setText(""+Math.sqrt(Double.parseDouble(standardCalculator.jt2.getText())));//����Math���sqrt()�������㿪��������
		}
	}

	
	/**
	 * @desc ����  1/x ��
	 */
	private void handleDaoshu() {
		// TODO �Զ����ɵķ������
		if(Double.parseDouble(standardCalculator.jt2.getText())==0){	//�������0�ĵ���ʱ
			standardCalculator.jt2.setText("0û�е���");
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
	 * @desc ��������
	 * @param parseDouble
	 */
	private void calculate(double parseDouble) {
		// TODO �Զ����ɵķ������
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
		standardCalculator.jt2.setText(""+result);		//����������ʾ���±�ǩ��
	}

	
	/**
	 * @desc ������ܴ���
	 * @param input
	 */
	private void handleClear(String input) {
		// TODO �Զ����ɵķ������
		
		//ִ���������(C)ʱȫ��Ҫ �ָ���Ĭ��ֵ
		if("C".equals(input)){	
			standardCalculator.jt1.setText("");
			standardCalculator.jt2.setText("0");
			flag=true;
			lastOperator="=";
			result=0;
		}
		
		//ִ��������ݼ���CE��,ֻ�����뵽����ʾ���������ɾ������������
		else if("CE".equals(input)){	
			standardCalculator.jt2.setText("0");
			flag=true;
		}
		
		//ִ���˸����������ʾ���������һ��һ��ɾ��
		else if("��".equals(input)){	
			backspace();
		
		}
	}

	/**
	 * @desc �˸������
	 */
	private void backspace() {
		// TODO �Զ����ɵķ������
		//��һ���жϣ������м����flag=true���˹����޷�ʵ��
		if(!flag){
			String txt=standardCalculator.jt2.getText();	//��ȡ����ʾ���������
			int i=txt.length();			//��ȡtxt���ݳ���
			if(i>0){
				txt=txt.substring(0,i-1);	//���ı����ݵ����һ��ɾ��
				if(txt.length()>0)		//���ɾ���ı������һ�����ݺ���ı����Ȳ�Ϊ0��
					standardCalculator.jt2.setText(txt);	//��������ʾ��������ʾɾ���������
				else{
					standardCalculator.jt2.setText("0");	//������ɾ���ı������һ�����ݺ���ı�����Ϊ0����������ʾ��������ʾ0
					flag=true;
				}
				
			}
		}
	}

}
