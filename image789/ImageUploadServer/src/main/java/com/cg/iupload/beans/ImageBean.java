package com.cg.iupload.beans;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name="Image")
public class ImageBean {

@Id
@Column(name="imgId")
private Integer imgId;

@Column(name="imgTitle")
private String imgTitle;

/*@Column(name="ItemContent")
private String itemContent;

@Column(name="ItemImage")
private ByteArray ItemImage;

@Column(name="ItemPrice")
private int itemPrice;
*/
@Lob
@Column(name="imgData")
private byte[] imgData;

@Column(name="imgPath")
private String imgPath;

public String getimgPath() {
	return imgPath;
}

public void setimgPath(String imgPath) {
	this.imgPath = imgPath;
}

public Integer getimgId() {
	return imgId;
}

public void setimgId(Integer imgId) {
	this.imgId = imgId;
}

public String getimgTitle() {
	return imgTitle;
}

public void setimgTitle(String imgTitle) {
	this.imgTitle = imgTitle;
}

public byte[] getimgData() {
	return imgData;
}

public void setimgData(byte[] imgData) {
	this.imgData = imgData;
}

@Override
public String toString() {
	return "ImageBean [imgId=" + imgId + ", imgTitle=" + imgTitle + ", imgData=" + Arrays.toString(imgData)
			+ ", imgPath=" + imgPath + "]";
}


}