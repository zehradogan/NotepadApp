import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class TextSaver {
	private String filename;
	private JTextArea txtArea;
	public TextSaver(String filename) {
		this.filename = filename;
	}
	
	public String fileToSave() throws IOException {
		
		String text = ""; 
		JFileChooser save = new JFileChooser();
		int option = save.showSaveDialog(save);
		if(option == JFileChooser.APPROVE_OPTION) {
	
		
		try(BufferedWriter fw = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()))){
			((BufferedWriter) fw).write(this.txtArea.getText());
			fw.close();
		}
			
			
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
				
	}
		return text;
}}