package dao;
import java.util.ArrayList;
import model.Type;
import model.QuestionType;
public abstract interface IQuestionTypeDao {
	//添加一条问题-类型映射记录
		public Integer addQuestionType(QuestionType que_type);
		//删除一条问题-类型映射记录
		public Integer deleteQuestionType(QuestionType que_type);
		//更新一条问题-类型映射记录
		public Integer updateQuestionType(QuestionType que_type);
		//根据问题Id查询对应的类型
		public ArrayList<Integer> findTypeByQuestionId(int queId);
		//根据问题类型统计对应的数目
		public Integer countQuestionByType(int queId);
}
