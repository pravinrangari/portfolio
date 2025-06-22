package com.fileprocessing;
import javax.servlet.http.Part;
public interface FileIO {

	public String uploadProject(Part part,String filename);
	public String deleteProject(String filename);
	public String uploadResume(Part part);
	public byte[] downloadResume();
}
