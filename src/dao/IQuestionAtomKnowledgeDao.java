package dao;
import java.util.ArrayList;
import java.util.List;

import model.AtomKnowledges;
import model.QuestionAtomKnowledge;
public interface IQuestionAtomKnowledgeDao {
		//添加一条问题-原子知识点映射记录
		public Integer addQuestionAtomKnowledge(QuestionAtomKnowledge que_atom);
		//删除一条问题-原子知识点映射记录
		public Integer deleteQuestionAtomKnowledge(QuestionAtomKnowledge que_atom);
		//更新一条问题-原子知识点映射记录
		public Integer updateQuestionAtomKnowledge(QuestionAtomKnowledge que_atom);
		//根据问题Id查询对应的原子知识点Id
		public ArrayList<AtomKnowledges> findAtomKnowledgeByQuestionId(int queId);
		//public ArrayList<Integer> findAtomKnowledgeByQuestionId(int queId);
		//根据原子知识点Id查询对应的问题Id
		public List<Integer> findQuestionByAtomKnowledgeId(int atomId);
}
