package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.ISolutionsDao;
import model.Images;
import model.Questions;
import model.Solutions;


public class SolutionsDaoImpl extends BaseDao implements ISolutionsDao {
	//添加一条solution
		public Integer addSolution(Solutions solution){
			HibernateTemplate tmp = this.getHibernateTemplate();
			tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
			tmp.save(solution);
			return solution.getId();
		}
		//删除一条solution
		public Integer deleteSolution(Solutions solution){
			HibernateTemplate tmp = this.getHibernateTemplate();
			tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
			tmp.delete(solution);
			return solution.getId();
		}
		//更新一条solution
		public Integer updateSolution(Solutions solution){
			HibernateTemplate tmp = this.getHibernateTemplate();
			tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
			tmp.update(solution);
			return solution.getId();
		}
		//返回所有解题思路
		public List<Solutions> finaAllSolutions(){
			 String query0="from Solutions a";
			 List<Solutions> allSols=this.getHibernateTemplate().find(query0);
			 if (allSols!=null)
			 return allSols;
			 else return null;
				}
		//根据Id查询Solution
	public Solutions findSolutionsById(int solutionId){
		Solutions solution=(Solutions)this.getHibernateTemplate().get(Solutions.class,solutionId);
		return solution;
	}
	//根据问题Id查询相关的Solution
	public ArrayList<Solutions> findSolutionsByQuestionId(int QuestionId){
		String query0="from Solutions a where a.questionId=?";
		 ArrayList<Solutions> allSols=(ArrayList<Solutions>) this.getHibernateTemplate().find(query0,QuestionId);
		 System.out.print(allSols.get(0).getNlDescription());
		 if (allSols!=null)
		 return allSols;
		 else return null;
	}
	
}
