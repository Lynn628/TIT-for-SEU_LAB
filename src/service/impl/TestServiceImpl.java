package service.impl;

//import dao.ITestDao;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import dao.IAtomKnowledgesDao;
import dao.IImagesDao;
import model.Images;
import service.TestService;

public class TestServiceImpl extends BaseService implements TestService {
private IImagesDao imgDao;
private  Images img=new Images();
	public IImagesDao getImgDao() {
	return imgDao;
}
public void setImgDao(IImagesDao imgDao) {
	this.imgDao = imgDao;
}
public Images getImg() {
	return img;
}
public void setImg(Images img) {
	this.img = img;
}
	//添加图片表、图片-问题映射
	public void addImgTest(String imgaddress){
		  			  
        BufferedInputStream bufInputStream;
		try {
			bufInputStream = new BufferedInputStream(new FileInputStream(imgaddress));
			//ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();   
			byte[] bytes=new byte[bufInputStream.available()];
			bufInputStream.read(bytes);
			img.setImg(bytes);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgDao.addImages(img);
		//imgId=imgDao.addImages(img);
		//queAndImg.setQuestionId(queId);
		//queAndImg.setImages(img);
		//queAndImgDao.addQuestionImage(queAndImg);
	
	}

}
