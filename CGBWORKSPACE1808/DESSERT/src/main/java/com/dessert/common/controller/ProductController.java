package com.dessert.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dessert.sys.orders.entity.Product;
import com.dessert.sys.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	 //查询所有用户
    @RequestMapping("/list")
    public String listUser( Model model){
        List<Product> list= productService.list();
        model.addAttribute("list",list);
        System.out.println(list);
        return "list";
    }
    
    /**
     * 保存商品
     * @param image
     * @param product
     * @param map
     * @return
     * @throws IOException
     */
    @RequestMapping("/addProduct.do")
    public String fileUpload(MultipartFile file,Product product, ModelMap map) throws IOException {

    	String filePath="D:\\tts9\\eclipse\\D：\\Maven\\Three-Dessert\\src\\main\\webapp\\images";
    	String originalFilename = file.getOriginalFilename();
    	UUID randomUUID = UUID.randomUUID();
    	String newFileName=randomUUID+originalFilename;
    	File targetFile = new File(filePath,newFileName);
    	file.transferTo(targetFile);
    	product.setPimage(newFileName);
    	productService.save(product);
    	String tomcat_path = System.getProperty( "user.dir" );
    	System.out.println(tomcat_path);
    	
    	
    	return "redirect:/list.do";
    
    }
}
	

