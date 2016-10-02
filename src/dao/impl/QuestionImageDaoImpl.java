package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import model.AtomKnowledges;
import model.Images;
import model.QuestionImage;
import dao.IQuestionImageDao;

public class QuestionImageDaoImpl extends BaseDao implements IQuestionImageDao {
	//添加一条问题-图片映射记录
	public Integer addQuestionImage(QuestionImage que_image){
		HibernateTemplate tmp = this.getHibernateTemplate();//Don't know how to fix this bug.
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(que_image);
		return que_image.getId();
	}
	//删除一条问题-图片映射记录
	public Integer deleteQuestionImage(QuestionImage que_image){
		HibernateTemplate tmp = this.getHibernateTemplate();//Don't know how to fix this bug.
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(que_image);
		return que_image.getId();
	}
	//更新一条问题-图片映射记录
	public Integer updateQuestionImage(QuestionImage que_image){
		HibernateTemplate tmp = this.getHibernateTemplate();//Don't know how to fix this bug.
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(que_image);
		return que_image.getId();
	}
	//根据问题Id查询对应的图片
	public ArrayList<Images> findImageByQuestionId(int queId){
		String query0="select qai.images from QuestionImage qai where qai.questionId=?";
		ArrayList<Images> imageList=(ArrayList<Images>)this.getHibernateTemplate().find(query0,queId);
		return imageList;	
		}
	/*public ArrayList<Integer> findImageByQuestionId(int queId){
		String query0="select qai.imageId from QuestionImage qai where qai.questionId=?";
		ArrayList<Integer> imageIdList=(ArrayList<Integer>)this.getHibernateTemplate().find(query0,queId);
		return imageIdList;	
		}*/
	//根据图片Id查询对应的问题Id
	public Integer findQuestionByImageId(int imageId){
		String query0="selecet img.questionId from QuestionImage img where img.images.id=?";
		List<Integer> queList=(List<Integer>) this.getHibernateTemplate().find(query0,imageId);
		if(queList!=null&&queList.size()>0)
		return queList.get(0);
		else return null;
	}

}
