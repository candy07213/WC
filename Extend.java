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
		int nullnum = 0;//���У�ȫ�����л��ʽ�����ַ��������һ��������ʾ���ַ�
		int codenum = 0;//�����У����а�������һ���ַ��Ĵ���
		int signnum = 0;//ע����
		//String lineStr = null;
		boolean isSign = false;
		int notSign = 0;

		BufferedReader bf2=null; 
		try {
			if(ButtonHandler.instance.file!=null)
				bf2 = new BufferedReader(new FileReader(ButtonHandler.instance.file));
			else{
				Scanner scanner=new Scanner(System.in);
				System.out.println("������·��:");
				String path=scanner.next();    //���������֮��ͻ���ͼ�ν�������ֱ�ӱ������·��			
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
 			 
 			 //����
 			 if(lineStr.length()==1||lineStr.matches("^[\\s&&[^\n]]*$")){ 
 				 nullnum++;
 			 }
 			 
 			 //  ����ע��/*
 			 else if(lineStr.startsWith("/*")&&!lineStr.endsWith("*/")||
 					 ((lineStr.startsWith("{/*")||lineStr.startsWith("}/*"))
 							 &&!lineStr.endsWith("*/"))){
 				 
 				 signnum++;
 				 isSign = true;
 			 }
 			 
 			 //  �����û��*/��ͷ
 			 else if(isSign&&!lineStr.endsWith("*/")&&!lineStr.startsWith("*/")){
 				 notSign++;
 				 signnum++;
 			 }
 			 
 			 //  ��*/��ͷ
 			 else if(isSign == true && (lineStr.endsWith("*/")||lineStr.startsWith("*/"))){
 				 signnum++;
 				 isSign = false;
 			 }
 			 
 			 //  ע����
 			 else if (lineStr.startsWith("//")|| lineStr.startsWith("}//")||lineStr.startsWith("{//")
 					 ||((lineStr.startsWith("{/*") ||lineStr.startsWith("}/*")||
 							 lineStr.startsWith("/*"))&& lineStr.endsWith("*/"))){
 				 signnum++;
 			 }
 			 
 			 else{
 				 codenum++;
 			 }
 			 
 			 signnum -= notSign;//����ע��Ҫ��ȥnotSign����ֻ��/*��û��*/
 			 codenum += notSign;//�����У����˿��С�ע���������ڴ����У�
 			 
 		 }
		
        if(ButtonHandler.instance.file!=null){
        	if(ifClear==true)
        		ButtonHandler.instance.jta1.setText("");
        	if(c == 'a'){
        		ButtonHandler.instance.jta1.append("\n\t����:"+Integer.toString(nullnum)+"\n\t������:"+Integer.toString(codenum)+"\n\tע����:"+Integer.toString(signnum)+"\n");
        		
        	}
        	
        }
        else{
        	System.out.println("\n\t����:"+Integer.toString(nullnum)+"\n\t������:"+Integer.toString(codenum)+"\n\tע����:"+Integer.toString(signnum)+"\n");
        		
        }
        
	}
}


