import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Main extends JFrame{
	private JTextArea txtArea;
	
	public Main() {
		setTitle("Text Area");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();

	}
	
	public void initComponents() {
		JToolBar tb = new JToolBar();
		JButton button = new JButton("Open");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();// it opens a file which already exists
				
			}
		});
		
		tb.add(button);
		
		JButton button2 = new JButton("save");
		button2.addActionListener(new ActionListener() {
			
			private JTextArea txtArea;

			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					saveFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		tb.add(button2);
		
        txtArea = new JTextArea("", 0,0);
		
		setLayout(new BorderLayout());
		add(tb, BorderLayout.PAGE_START);
		add(txtArea, BorderLayout.CENTER);
		
		setSize(500, 500);
		
	}
	
	public void openFile() {
		TextReader reader = new TextReader("C:\\Users\\ASUS\\Documents\\hello.txt");
		txtArea.setText(reader.readFile()); 
	}
	
	public void saveFile() throws IOException {
		TextSaver saver = new TextSaver("");
		txtArea.setText(saver.fileToSave());
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.setVisible(true);
	}

}
