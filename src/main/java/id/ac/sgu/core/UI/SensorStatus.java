
package id.ac.sgu.core.UI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class SensorStatus {
	JFrame frame;
	JTextArea logTextArea;
	JLabel title;
	private String currentTimeString;
	
	public SensorStatus() {
		frame = new JFrame();
        frame.setTitle("Homy");
        
        title = new JLabel ("Current Time : " + currentTimeString);
        title.setBounds(100,30, 200, 100);
        Font labelFont = title.getFont();
        title.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        
        frame.add(title);
        
        logTextArea = new JTextArea(5,20);
        logTextArea.setText("Hello");
        logTextArea.setEditable(true);
        frame.add(logTextArea);
        
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(960,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	public void setCurrentTimeString(String text) {
		this.title.setText(text);
	}
	
	public void logData(String text) {
		this.logTextArea.append(text);
	}
    
}
