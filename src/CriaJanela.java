import javax.swing.*;
import java.awt.*;

public class CriaJanela {

	private static JTextArea jt= new JTextArea(5,20);
	private static JFrame frame;
	private static JScrollPane painelRolagem;

	public CriaJanela(){
		frame = new JFrame("Gauss Vs Cramer");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		Container content = frame.getContentPane();
		painelRolagem = new JScrollPane(jt);
		jt.setEditable(false);
		content.add(painelRolagem);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static JFrame getFrame(){
		return frame;	
	}

	public static JTextArea getJt(){
		return jt;
	}	


}
