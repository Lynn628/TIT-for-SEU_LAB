package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.IQuestionAtomKnowledgeDao;
import model.AtomKnowledges;
import model.QuestionAtomKnowledge;


public class QuestionAtomKnowledgeDaoImpl extends BaseDao implements
		IQuestionAtomKnowledgeDao {
	//添加一条问题-原子知识点映射记录
	public Integer addQuestionAtomKnowledge(QuestionAtomKnowledge que_atom){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(que_atom);
		return que_atom.getId();
	}
	//删除一条问题-原子知识点映射记录
	public Integer deleteQuestionAtomKnowledge(QuestionAtomKnowledge que_atom){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(que_atom);
		return que_atom.getId();
	}
	//更新一条问题-原子知识点映射记录
	public Integer updateQuestionAtomKnowledge(QuestionAtomKnowledge que_atom){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(que_atom);
		return que_atom.getId();
	}
	//根据问题Id查询对应的原子知识点Id
	public ArrayList<AtomKnowledges> findAtomKnowledgeByQuestionId(int queId){
		String query0="select atom.atomKnowledges from QuestionAtomKnowledge atom where atom.questionId=?";
		ArrayList<AtomKnowledges> atomList=(ArrayList<AtomKnowledges>)this.getHibernateTemplate().find(query0,queId);
		return atomList;
	}
	/*public ArrayList<Integer> findAtomKnowledgeByQuestionId(int queId){
		String query0="select atom.atomKnowledgeId from QuestionAtomKnowledge atom where atom.questionId=?";
		ArrayList<Integer> atomIdList=(ArrayList<Integer>)this.getHibernateTemplate().find(query0,queId);
		return atomIdList;
	}*/
	//根据原子知识点Id查询对应的问题Id
	public List<Integer> findQuestionByAtomKnowledgeId(int atomId){
		String query0="select atom.questionId from QuestionAtomKnowledge atom where atom.atomKnowledgeId=?";
		ArrayList<Integer> queList=(ArrayList<Integer>)this.getHibernateTemplate().find(query0,atomId);
		return queList;
	}


	
}
