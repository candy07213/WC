import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GraInterface extends JFrame   {
	
	private static final long serialVersionUID = 1L;
	public static JButton jbt1,jbt2;	
	public static JTextArea jta;
	public static JTextField jtf;
	public static JFileChooser jfc;
	
	public  GraInterface(String str){
			super(str);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub   转移了位置
		GraInterface gi =new GraInterface("文件统计");
		//GraInterface gi =new GraInterface("文件统计");
		gi.setLayout(new FlowLayout());
		
		JButton jbt1 = new JButton("选择文件");
		jbt1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        jfc = new JFileChooser();
		     if(jfc.showOpenDialog(gi)==JFileChooser.APPROVE_OPTION ){
		      //弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了
		    	 jtf.setText(jfc.getSelectedFile().getAbsolutePath());
		     }
		    }
		   });
		
		JButton jbt2 = new JButton("统计结果");
		JLabel jb1=new JLabel();
		JLabel jb2=new JLabel();
		
		ButtonHandler.instance.jta1.setSize(400, 400);
		jbt2.addActionListener(ButtonHandler.instance);
		jtf = new JTextField(10);
		jtf.setLocation(30, 50);//设置位置
		jtf.setSize(220, 20);//设置大小
		
		gi.add(jtf);
		gi.add(jbt1);
		gi.add(jbt2);
		gi.add(jb1);
		gi.add(ButtonHandler.instance.jta1);
		gi.add(jb2);
		
		gi.setSize(600,600);
		gi.setBackground(null);
		gi.setVisible(true);
		
	
   }
}
    