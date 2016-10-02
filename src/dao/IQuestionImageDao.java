package dao;
import java.util.ArrayList;

import model.Images;
import model.QuestionImage;
public abstract interface IQuestionImageDao {
	//添加一条问题-图片映射记录
	public Integer addQuestionImage(QuestionImage que_image);
	//删除一条问题-图片映射记录
	public Integer deleteQuestionImage(QuestionImage que_image);
	//更新一条问题-图片映射记录
	public Integer updateQuestionImage(QuestionImage que_image);
	//根据问题Id查询对应的图片
	public ArrayList<Images> findImageByQuestionId(int queId);
	//public ArrayList<Integer> findImageByQuestionId(int queId);
	//根据图片Id查询对应的问题Id
	public Integer findQuestionByImageId(int imageId);

}
