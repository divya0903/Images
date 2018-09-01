package com.cg.iupload.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iupload.beans.ImageBean;
import com.cg.iupload.service.ImageService;
@RestController
public class ImageController {

/*@Resource(name="categoryService")
private CategoryService categoryService;*/

@Autowired
private ImageService imageService;

@RequestMapping(value = "/imageDisplay/{product_id}", method = RequestMethod.GET)
  public List<ImageBean> showImage(@PathVariable( value="product_id") String productId, HttpServletResponse response,HttpServletRequest request) 
          throws ServletException, IOException
{
System.err.println(productId);
List<ImageBean> image=imageService.get(productId);

   // ImageBean image = imageService.get(imgId); 
for (ImageBean imageBean : image) {
	 
	 response.setContentType("image/jpeg; image/jpg; image/png; image/gif");
	 response.getOutputStream().write( imageBean.getimgData());
	 System.out.println(imageBean.getimgTitle());
//response.getOutputStream().println(imageBean.getimgTitle());
	 System.out.println(imageBean); 
}
    

  //response.getOutputStream().write());
    response.getOutputStream().close();
    return image;
    
}

@RequestMapping(value="/addImage",method=RequestMethod.POST)
public void addImage(ImageBean image,String productId) throws FileNotFoundException, IOException {
	
	imageService.addImage(image,productId);
}





}
