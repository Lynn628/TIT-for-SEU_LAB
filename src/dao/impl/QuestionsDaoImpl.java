package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.IQuestionsDao;
import model.AtomKnowledges;
import model.Questions;

public class QuestionsDaoImpl extends BaseDao implements IQuestionsDao {

	////添加一条问题
	public Integer addQuestion(Questions que){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(que);
		return que.getId();
	}
	//删除一条问题
	public Integer updateQuestion(Questions que){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(que);
		return que.getId();
	}
	//更新一条问题
	public Integer deleteQuetion(Questions que){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(que);
		return que.getId();
		}
	//根据Id查询问题
	public Questions findQuestionById(int queId){
		Questions que=(Questions)this.getHibernateTemplate().get(Questions.class,queId);
		return que;	
}
	//根据内容查询问题
	public List<Questions> findQuetionByContent(String content){
	String query0="from Questions a where a.content=?";
	List<Questions> que=this.getHibernateTemplate().find(query0,content);
	return que;	
}
	////返回所有问题
	public ArrayList<Questions> findAllQuestions() {
		 String query0="from Questions as q order by q.id desc where q.relatedQuestionId is NULL";
		 ArrayList<Questions> allQues=(ArrayList<Questions>)this.getHibernateTemplate().find(query0);
		 return allQues;
	}
	
	//返回所有问题的数目（不含子问题）
	@Override
	public Integer countTotalNum() {
		// TODO Auto-generated method stub
		String hql1 = "select count(*) from Questions as q";
		Query query1 = this.getSession().createQuery(hql1);
		int recordNum = ((Number)query1.uniqueResult()).intValue();
		
		String hql2 = "select count (distinct relatedQuestionId) from Questions as q where q.relatedQuestionId is not NULL";
		Query  query2 = this.getSession().createQuery(hql2);
		int stemQueNum = ((Number)query2.uniqueResult()).intValue();
		
		int totalNum = recordNum-stemQueNum;
		System.out.println("当前问题总数："+totalNum);
		return totalNum;
	}
	//判别一个问题是否有子问题
	public Integer subQuestionNum(int queId) {
		String hql1="select count(*) from Questions as q where q.relatedQuestionId="+queId;
		Query query1=this.getSession().createQuery(hql1);
		int subQueNum=((Number)query1.uniqueResult()).intValue();
		if(subQueNum>=0)
			return subQueNum;
		else return -1;
	}
	//找出所有已queId为相关问题Id的子问题的Id
	public ArrayList<Questions> subQuestions(int queId) {
		 String query0="from Questions as q where q.relatedQuestionId=?";
		 ArrayList<Questions> subQues=(ArrayList<Questions>)this.getHibernateTemplate().find(query0,queId);
		 return subQues;
	}
}
