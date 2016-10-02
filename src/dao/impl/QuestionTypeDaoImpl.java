package dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

import dao.IQuestionTypeDao;
import model.QuestionType;

public class QuestionTypeDaoImpl extends BaseDao implements IQuestionTypeDao {
	// 添加一条问题-类型映射记录
	public Integer addQuestionType(QuestionType que_type) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(que_type);
		return que_type.getId();
	}

	// 删除一条问题-类型映射记录
	public Integer deleteQuestionType(QuestionType que_type) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(que_type);
		return que_type.getId();
	}

	// 更新一条问题-类型映射记录
	public Integer updateQuestionType(QuestionType que_type) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(que_type);
		return que_type.getId();
		}

	// 根据问题Id查询对应的类型Id
	public ArrayList<Integer> findTypeByQuestionId(int queId) {
		// String
		// query0="selecet qay.TypeId from QuestionType qay where qay.questionId=?";
		String query0 = "from QuestionType qay where qay.questions.id=?";
		@SuppressWarnings("unchecked")
		ArrayList<QuestionType> typeList0 = (ArrayList<QuestionType>) this
				.getHibernateTemplate().find(query0, queId);
		ArrayList<Integer> typeList = new ArrayList<Integer>();
		for(QuestionType qt : typeList0)
			typeList.add(qt.getTypeId());
		return typeList;
	}

	@Override
	public Integer countQuestionByType(int queId) {
		// TODO Auto-generated method stub
		//String hql = "select count(*) from QuestionType as qt where qt.typeId=queId and qt.questionId in (select Questions.id from Questions where Questions.relatedQuestionId is NULL)";
		String hql = "select count(*) from QuestionType as qt where qt.typeId="+queId+" and qt.questions.relatedQuestionId is NULL";
		//String hql = "select count(*) from QuestionType as qt where qt.typeId="+queId;[当改动问题类型，将问题类型设置给子问题，题干不再设置类型之后，此句代替上句]
		Query query = this.getSession().createQuery(hql);
		int num = ((Number)query.uniqueResult()).intValue();
		System.out.println(num);
		return num;
	}

}
