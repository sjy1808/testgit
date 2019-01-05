package com.jt.manage.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileService;
@Service
public class FileServiceImpl implements FileService {

	private String localDirPath="D:/images";
	private String localUrlPath="http://image.jt.com/";
	/**
	 * 实现步骤和思路
	 * 	1.校验图片的类型(jpg|png|gif)
	 * 	2.防止恶意程序(判断是否为图片) 获取图片的属性宽度和高度
	 * 	3.为了减少图片数量,一般采用分文件存储的方式,提高检索效率
	 * 	4.为了防止文件重名,则动态的生成文件名称
	 */
	@Override
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		PicUploadResult result = new PicUploadResult();
		//1.判断文件类型  abc.jpg
		String fileName = uploadFile.getOriginalFilename();
		fileName=fileName.toLowerCase();//将字符都转化为小写
		//2.使用正则表达式判断
		if(!fileName.matches("^.*\\.(jpg|png|gif)$")){
			//表示不是图片
			result.setError(1);
			return result;
		}
		
		//3.判断是否为恶意程序
		try {
			BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
			int width=bufferedImage.getWidth();
			int height=bufferedImage.getHeight();
			//3.1判断是否为图片
			if(width==0||height==0){
				result.setError(1);
				return result;
			}
			/**
			 * 进行分文件存储
			 * 1.按照日期划分   yyyy/MM/dd
			 * 2.hash32位置8/8/8/8
			 * 3.随机数2个数字1个文件夹3级   XX/XX/XX
			 * 动态生成文件名称:UUID+随机3喂食+.jpg
			 */
			//3.2生成日期文件夹
			String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			
			//3.3判断文件夹是否存在
			String dirFilePath=localDirPath+"/"+dateDir;
			File dirFile = new File(dirFilePath);
			if(!dirFile.exists()){
				//如果文件夹不存在,则新建
				dirFile.mkdirs();
			}
			//4.1生成UUID
			String uuid=UUID.randomUUID().toString().replace("-", "");
			//4.2生成随机数
			int randomNum=new Random().nextInt(1000);
			//4.3截取文件后缀
			String fileType=fileName.substring(fileName.lastIndexOf("."));
			//4.4获取文件名
			String imageFileName=uuid+randomNum+fileType;
			uploadFile.transferTo(new File(dirFilePath+"/"+imageFileName));
			//处理返回值
			result.setWidth(width+"");
			result.setHeight(height+"");
			String url=localUrlPath+dateDir+"/"+imageFileName;
			System.out.println(url);
			result.setUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1);
			return result;
		}
		return result;
	}

}
