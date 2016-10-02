package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.IImagesDao;
import model.Images;
import model.Questions;

public class ImagesDaoImpl extends BaseDao implements IImagesDao {
	//添加一张图片记录
	public Integer addImages(Images image){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(image);
		return image.getId();
		}
	//删除一张图片记录
	public Integer deleteIamges(Images image){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(image);
		return image.getId();
	}
	//更新一张图片
	public Integer updateImages(Images image){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(image);
		return image.getId();
	}
	//返回所有图片
		public List<Images> finaAllImages(){
			 String query0="from Images a";
			 List<Images> allImages=this.getHibernateTemplate().find(query0);
			 if(allImages!=null)
			 return allImages;
			 else return null;
		}
	//根据Id查询图片
	public Images findImagesById(int imageId){
		Images img=(Images)this.getHibernateTemplate().get(Images.class,imageId);
		return img;
}
}
