import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Count {
	public  int Count1(char c,boolean ifClear) throws Exception{
//		
		BufferedReader bf1 = null;
		String path="";
		
		try{
			if(ButtonHandler.instance.file!=null)
				path=ButtonHandler.instance.file.getAbsolutePath();
			else{
				Scanner scanner=new Scanner(System.in);
				System.out.println("请输入路径:");
				path=scanner.next();    	
				scanner.close();
			}
			
		}
		catch(NullPointerException e){
		}
		InputStreamReader isr = new InputStreamReader( new FileInputStream(path) ); 
		bf1 = new BufferedReader(isr);
		
//		
		int charnum= 0 ;
		int wordsnum= 0;
		int linenum = 0;
		
		String s;
		//统计字符数
		while(( s = bf1.readLine()) != null ){
			for(int i=0; i<s.split(" ").length; i++){
				charnum += s.split(" ")[i].length();
			}
		//统计单词数
		ArrayList<String[]> array = new ArrayList<String[]>();
		String[] str= s.split("[ |.|,|(]");
		array.add(str);
		String regex = ".*[a-zA-Z]+.*";
		Pattern p = Pattern.compile(regex);
		Iterator<String[]> it = array.iterator();
		while(it.hasNext()){
			String[] str1 = (String[]) it.next();
			for(int i=0; i<str1.length; i++){
				//System.out.println(str1[i]);
				Matcher m = p.matcher(str1[i]);
				if(m.matches()){
				wordsnum++;
				}
			}
		}
		//统计行数
		linenum ++; 
		}
		try{
			if(ifClear==true)
				ButtonHandler.instance.jta1.setText("");	
		}
		catch(NullPointerException e){
			
		}
		
		bf1.close();
		
		if(c == 'c'){

			return charnum;
		}else if(c == 'w'){
			
			return wordsnum;
		}else if(c == 'l'){
			
			return linenum;
		}else if(c == 'x'){
			String str="\n\t字符数:"+Integer.toString(charnum)+"\n\t单词数:"+Integer.toString(wordsnum)+"\n\t行数:"+Integer.toString(linenum)+"\n";
			try{
				if(ButtonHandler.instance.file!=null)
					ButtonHandler.instance.jta1.append(str);
				
			}
			catch(NullPointerException e){
				System.out.println(str);
				
			}
			
		}
		
		return 0;
	 }	  		  
	
}
