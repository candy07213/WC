import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JTextArea;

public class ButtonHandler implements ActionListener{
	public static ButtonHandler instance=new ButtonHandler();
	
	public JTextArea jta1=new JTextArea(50,50);
	public File file;
    			@Override
    public void actionPerformed(ActionEvent e) {
     		// TODO Auto-generated method stub
	  if( e.getActionCommand().equals("统计结果") ){
	
		   file=GraInterface.jfc.getSelectedFile().getAbsoluteFile();   
		   if(file!=null){  
			   Count count = new Count();
			   Extend extend=new Extend();
			   try {
				   count.Count1('x',true);
				   extend.Count2('a', false);
				   this.file=null;
			   } catch (Exception e1) {
				   // TODO Auto-generated catch block
				   //e1.printStackTrace();
			   }	   
		   }
		        	      
		         }
    			} 
    	   
     }