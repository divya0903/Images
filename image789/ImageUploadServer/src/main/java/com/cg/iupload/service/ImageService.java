package com.cg.iupload.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.cg.iupload.beans.ImageBean;
import com.cg.iupload.beans.ProductBean;

public interface ImageService {

	

	

	public List<ImageBean> get(String productId);

	public void addImage(ImageBean image,String productId) throws FileNotFoundException, IOException;

}
