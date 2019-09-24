import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Extend {

	public void Count2(char c,boolean ifClear) throws IOException {
		// TODO Auto-generated method stub
		int nullnum = 0;//空行：全部空行或格式控制字符，或最多一个可以显示的字符
		int codenum = 0;//代码行：本行包括多于一个字符的代码
		int signnum = 0;//注释行
		//String lineStr = null;
		boolean isSign = false;
		int notSign = 0;

		BufferedReader bf2=null; 
		try {
			if(ButtonHandler.instance.file!=null)
				bf2 = new BufferedReader(new FileReader(ButtonHandler.instance.file));
			else{
				Scanner scanner=new Scanner(System.in);
				System.out.println("请输入路径:");
				String path=scanner.next();    //把这个加上之后就会让图形界面那里直接变成输入路径			
				InputStreamReader isr = new InputStreamReader( new FileInputStream(path) ); 
				bf2 = new BufferedReader(isr);
				scanner.close();
				
			}
				
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		 }
		catch(NullPointerException e){
		}
 		 
 		 String lineStr="";
 		 String s;
 		 while(( s = bf2.readLine()) != null ){
 			 lineStr=s+"\n";
 			 
 			 //空行
 			 if(lineStr.length()==1||lineStr.matches("^[\\s&&[^\n]]*$")){ 
 				 nullnum++;
 			 }
 			 
 			 //  多行注释/*
 			 else if(lineStr.startsWith("/*")&&!lineStr.endsWith("*/")||
 					 ((lineStr.startsWith("{/*")||lineStr.startsWith("}/*"))
 							 &&!lineStr.endsWith("*/"))){
 				 
 				 signnum++;
 				 isSign = true;
 			 }
 			 
 			 //  代码段没有*/开头
 			 else if(isSign&&!lineStr.endsWith("*/")&&!lineStr.startsWith("*/")){
 				 notSign++;
 				 signnum++;
 			 }
 			 
 			 //  有*/开头
 			 else if(isSign == true && (lineStr.endsWith("*/")||lineStr.startsWith("*/"))){
 				 signnum++;
 				 isSign = false;
 			 }
 			 
 			 //  注释行
 			 else if (lineStr.startsWith("//")|| lineStr.startsWith("}//")||lineStr.startsWith("{//")
 					 ||((lineStr.startsWith("{/*") ||lineStr.startsWith("}/*")||
 							 lineStr.startsWith("/*"))&& lineStr.endsWith("*/"))){
 				 signnum++;
 			 }
 			 
 			 else{
 				 codenum++;
 			 }
 			 
 			 signnum -= notSign;//计算注释要减去notSign，即只有/*，没有*/
 			 codenum += notSign;//代码行：除了空行、注释行外属于代码行；
 			 
 		 }
		
        if(ButtonHandler.instance.file!=null){
        	if(ifClear==true)
        		ButtonHandler.instance.jta1.setText("");
        	if(c == 'a'){
        		ButtonHandler.instance.jta1.append("\n\t空行:"+Integer.toString(nullnum)+"\n\t代码行:"+Integer.toString(codenum)+"\n\t注释行:"+Integer.toString(signnum)+"\n");
        		
        	}
        	
        }
        else{
        	System.out.println("\n\t空行:"+Integer.toString(nullnum)+"\n\t代码行:"+Integer.toString(codenum)+"\n\t注释行:"+Integer.toString(signnum)+"\n");
        		
        }
        
	}
}


