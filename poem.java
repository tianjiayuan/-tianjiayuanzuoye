package stringexp;
import java.util.regex.*; 

public class poem {
	public static void main(String[] args) {
		//�����ַ���
		String ss = "������ɫ˼�����������󲻵������Ů���������������δʶ��������������һ��ѡ�ھ�����"
				  + "����һЦ������������������ɫ������ԡ�������Ȫˮ��ϴ��֬�̶���������ʼ���³ж���ʱ"
				  + "���޻��ս�ҡܽ����ů�ȴ�����������ո���Ӵ˾������糯�л���������Ͼ���Ӵ���ҹרҹ"
				  + "�󹬼�����ǧ����ǧ�谮��һ�����ױ�ɽ���ҹ��¥�����ʹ���õ��ֽ���������������Ż�"
				  + "�������¸�ĸ�Ĳ�����������Ů�깬�ߴ����������ַ�Ʈ�����Ż���������˿���վ���������"
				  + "����ܱ�Ķ����������������������س����̳���ǧ�����������д仪ҡҡ�и�ֹ�������Ű�����"
				  + "�����������κ���ת��ü��ǰ������ί�������մ��̽�ȸ��ɦͷ��������Ȳ��ûؿ�Ѫ������� ";
		
		try{
		char[] chars = ss.toCharArray();//��������
		StringBuffer s = new StringBuffer();//׷�����ݵ���ǰStringBuffer�����ĩβ
		
		//�����ַ����йؼ��ֳ��ֵĴ���
		countString(ss,"����");
		
		
		for (int i =0; i <chars.length; i++) {
			//�ڱ�ѡԪ�صĽ�β�������
			s.append(chars[i]);
		
			if ((i+1)%7==0&&(i+1)%2==1||(i+1)%14==0&&(i+1)%2==0) {
				//i%7����0����iΪ����ʱ���ڽ�β�ӣ�
				if((i+1)%7==0&&(i+1)%2==1)
					s.append(",");
				
				//i%14����0����iΪż��ʱ���ڽ�β�ӡ�
				else
					s.append("��\n");
			}
			}
		System.out.println(s.toString());
		}
		//�쳣����
		catch(Exception   e){
			System.out.print("�����쳣:"+e.toString());
			e.printStackTrace();
		}
		
	}

	private static void countString(String ss, String string) {
		// TODO Auto-generated method stub
		int count=0;
		while(ss.indexOf(string)!=-1){//�����ִ���ָ���ַ��״γ��ֵ�λ��
			//����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����
			ss = ss.substring(ss.indexOf(string)+1,ss.length());    
            count++;
		}
		System.out.println(string+" ���ֵĴ���Ϊ:"+count+"��");
	}

		
	}




