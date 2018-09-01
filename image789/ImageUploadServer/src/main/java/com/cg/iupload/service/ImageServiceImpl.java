package com.cg.iupload.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iupload.beans.ImageBean;
import com.cg.iupload.beans.ProductBean;
import com.cg.iupload.repo.IProductRepo;
import com.cg.iupload.repo.ImageRepo;
@Service
public class ImageServiceImpl implements ImageService {
@Autowired
ImageRepo repo;
@Autowired
IProductRepo productRepo;
	
	@Override
	public List<ImageBean> get(String productId) {
		
		ProductBean item=productRepo.getProduct(productId);
		
		System.err.println("Service prod item:"+item);
		
		if(item==null) {
			System.out.println("not there");
		}
		else {
			System.out.println("there");
		}
		//return (List<ImageBean>) item;
		return item.getImgId();
	}

	@Transactional
	@Override
	public void addImage(ImageBean image,String productId) throws IOException {
		ProductBean product=productRepo.getOne(productId);
		System.out.println(productId);
		
		File file=new File(image.getimgPath());
		
		byte[] bfile=new byte[(int) file.length()];
		
		FileInputStream fileInputStream =new FileInputStream(file);

	     fileInputStream.read(bfile);
	     fileInputStream.close();
	     for(byte b : bfile) {     //Just to check whether bfile has any content
	         System.out.print(b +" ");
	     }
		
		
	
		image.setimgData(bfile);
		
		/*Session session = sessionFactory.getSessionFactory().openSession();
		    System.out.println(image.getImg_id()+" "+image.getImg_path()+" "+image.getImg_data());

		     session.persist(image);
		    //System.out.println("value");
*/		   
		
		
		
		
		repo.save(image);
		product.getImgId().add(image);
		productRepo.save(product);
		 System.out.println("One image uploaded into database");
		
		/*Bitmap bmImage = //Data
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				bmImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
				byte[] imageData = baos.toByteArray();
				String encodedImage = Base64.encodeArray(imageData);*/
		
	}

}
