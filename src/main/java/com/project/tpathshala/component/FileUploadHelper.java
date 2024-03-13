package com.project.tpathshala.component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UPLOAD_DIR ="C:\\Users\\hp\\eclipse-workspace\\application\\src\\main\\resources\\static\\images";
//	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile multipartFile)
	{
		boolean f = false;
		
		try {
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			f = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
}
