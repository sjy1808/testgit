package com.jt.manage.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;

	/**
	 * 当实现了文件上传后,要求重定向到file.jsp页面
	 * 要求:文件的名称必须和页面中的name属性一致
	 * 文件的上传步骤:
	 * 	1.获取文件的名称
	 * 	2.定义文件上传的文件夹
	 * 	3.判断文件夹是否存在
	 * 	4.实现文件上传
	 * @param fileImage
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/file")
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException{
		//1.获取文件的名称
		String fileName = fileImage.getOriginalFilename();
		//2.定义文件上传的文件夹
		String path="D:/images";
		//3.判断文件夹是否存在
		File file = new File(path);
		if(!file.exists()){
			//如果不存在则新建文件夹
			file.mkdirs();
		}
		//4.实现文件上传
		fileImage.transferTo(new File(file+"/"+fileName));
		return "redirect:/file.jsp";
	}
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult uploadFile(MultipartFile uploadFile){
		
		return fileService.uploadFile(uploadFile);
	}
}
