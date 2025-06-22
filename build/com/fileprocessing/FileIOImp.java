package com.fileprocessing;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileUtils;
public class FileIOImp implements FileIO {

	private String status;
	private String path;
	

	@SuppressWarnings("finally")
	@Override
	public String uploadProject(Part part,String filename) {

		try {

			InputStream is = part.getInputStream();//Actual photo
			byte b[]=new byte[is.available()];
			is.read(b);
			String path ="C:\\Users\\Pravi\\eclipse-workspace\\MyPortfolio\\WebContent\\myproject\\"+filename;
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			fos.close();
			status="uploaded";
			
		} catch (Exception e) {
			System.out.println("FileIOImp->saveProject:" + e);
			status="failed";
		} finally {
			return status;
		}
	}

	@SuppressWarnings("finally")
	public String deleteProject(String filename) {
		try {

			String path="C:\\Users\\Pravi\\eclipse-workspace\\MyPortfolio\\WebContent\\myproject\\"+filename;                         
		    new java.io.File(path).delete();
			status="deleted";
			
		} catch (Exception e) {
			System.out.println("FileIOImp->saveProject:"+e);
			status="failed";
		} finally {
			return status;
		}
	}

	@SuppressWarnings("finally")
	public String uploadResume(Part part) {
		try {
			String filename = "";
			String actualfilename = part.getSubmittedFileName();
			path = "C:\\Users\\Pravi\\eclipse-workspace\\MyPortfolio\\WebContent\\MyResume\\";
			
			//Delete all files from a directory :
			File file = new File(path);
			FileUtils.cleanDirectory(file);
			
			if (actualfilename.endsWith(".pdf")) {
				
				filename = "myresume.pdf";
				
			} else {
				
				filename = "myresume.doc";
			}
			
			InputStream is = part.getInputStream();// Actual pdf
			byte b[] = new byte[is.available()];
			is.read(b);
			path = "C:\\Users\\Pravi\\eclipse-workspace\\MyPortfolio\\WebContent\\MyResume\\"+filename;              
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			fos.close();
			status = "uploaded";

		} catch (Exception e) {
			System.out.println("FileIOImp->saveProject:" + e);
			status = "failed";
		} finally {
			return status;
		}
	}

	@SuppressWarnings("finally")
	public byte[] downloadResume() {
		byte b[]=null;
		try
		{
			String filename = getFileName();
			path = "C:\\Users\\Pravi\\eclipse-workspace\\MyPortfolio\\WebContent\\MyResume\\";
			
			
			
	    	FileInputStream fis = new FileInputStream(path+filename);
	    	b=new byte[fis.available()];
	    	fis.read(b);
	    	fis.close();
		}
		catch(Exception e)
		{
			System.out.println("******"+e);
		}
		finally {
		   return b;
		}
	}

	public String getFileName() {
		path = "C:\\Users\\Pravi\\eclipse-workspace\\MyPortfolio\\WebContent\\MyResume\\";
		File file = new File(path);
		File[] f = file.listFiles();
		File file2 = f[0];
		String filename = file2.getName();
		return filename;
	}

}