package com.prdx.admin.commons.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static File multipartToFile(MultipartFile file) throws IllegalStateException, IOException {
		File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
		/*File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;*/
	}

}
