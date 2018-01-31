package com.chj.cloud.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public String handleFileUpload(@RequestParam(value="file", required=true) MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		File f = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes, f);
		
		return f.getAbsolutePath();
	}

}
