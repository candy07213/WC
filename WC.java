import java.util.*;
public class WC {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.print("��������Ҫ��ѯ������:");
		Scanner scan = new Scanner(System.in);	
		char c = scan.next().charAt(0);//charAtҲ��������������
		Count count = new Count();
		Extend extend = new Extend();
		//GraInterface gi =new GraInterface("�ļ�ͳ��");
		if(c == 'a')
			extend.Count2(c,true);
		else
			System.out.println(count.Count1(c,true));
	}

}
