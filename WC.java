import java.util.*;
public class WC {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.print("请输入你要查询的内容:");
		Scanner scan = new Scanner(System.in);	
		char c = scan.next().charAt(0);//charAt也可以作用于数组
		Count count = new Count();
		Extend extend = new Extend();
		//GraInterface gi =new GraInterface("文件统计");
		if(c == 'a')
			extend.Count2(c,true);
		else
			System.out.println(count.Count1(c,true));
	}

}
