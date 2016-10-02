package dao;

import java.util.ArrayList;
import java.util.List;

import model.Questions;

public  abstract interface IQuestionsDao {
		//添加一条问题
		public Integer addQuestion(Questions que);
		//更新一条问题
		public Integer updateQuestion(Questions que);
		//删除一条问题
		public Integer deleteQuetion(Questions que);
		//返回所有原子知识点
		public ArrayList<Questions> findAllQuestions();
		//根据Id查询问题
		public Questions findQuestionById(int queId);
		//根据内容查询问题
		public List<Questions> findQuetionByContent(String content);
		//返回总问题数目（子问题与题干算作一题）
		public Integer countTotalNum();
		public Integer subQuestionNum(int queId);
		public ArrayList<Questions> subQuestions(int queId);
}
