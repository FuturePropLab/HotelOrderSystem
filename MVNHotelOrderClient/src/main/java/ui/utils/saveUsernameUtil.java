package ui.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.RemoteHelper;

public class saveUsernameUtil {
	  public static void saveinfo(String username , String accountTypeChinese){
		  File file = new File("TxtData/username.txt");
			if(!file.exists())
				try {
					file.createNewFile();
				} catch (IOException e) {
				}
	        try {
	        	//FileWriter writer = new FileWriter(file);
	        	PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
	        			new FileOutputStream(file),"UTF-8")));
	            writer.write(username+":"+accountTypeChinese);  
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	        	//System.out.println(e.getMessage());
	        }
	  }
	  
	  public static String[] getSave(){
		  String[] strm ={"",""};
		  try {
				File file = new File("TxtData/username.txt");
				InputStreamReader reader = new InputStreamReader(new FileInputStream(
						file), "UTF-8");
				BufferedReader br = new BufferedReader(reader);
				String str = br.readLine();
				if(str==null || str.trim().equals(""))
					return strm;
				br.close();
				reader.close();
				return  str.split(":");
			} catch (IOException e) {
				return strm;
			}
		  
	  }
}
