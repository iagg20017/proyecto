package com.creativa.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleFileReader {
	private String patch;
	private File file;
	private List<String> lineas;
	
	public SimpleFileReader(File file) {
		super();
		this.file = file;
		this.patch = file.getAbsolutePath();
		lineas = new ArrayList<String>();
	}
	
	public SimpleFileReader(String path){
		this(new File(path));
		
	}
	
	public void read(){
		String line = null;
		FileReader fileReader = null;
		BufferedReader reader = null;
		
		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			line = reader.readLine();
			while(line != null){
			lineas.add(line);
			line = reader.readLine();
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(reader != null){
				try {
					reader.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fileReader != null){
				try {
					fileReader.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}

	public String getPatch() {
		return patch;
	}

	public List<String> getLineas() {
		return lineas;
	}
	
	


}
