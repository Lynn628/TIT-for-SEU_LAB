package dao;

import java.util.ArrayList;
import java.util.List;

import model.Images;
import model.Solutions;

public abstract interface ISolutionsDao {
	//添加一条solution
	public Integer addSolution(Solutions solution);
//删除一条solution
	public Integer deleteSolution(Solutions solution);
//更新一条solution
	public Integer updateSolution(Solutions solution);
	//返回所有解题思路
		public List<Solutions> finaAllSolutions();
//根据Id查询Solution
public Solutions findSolutionsById(int solutionId);
//根据问题Id查询相关的Solution
public ArrayList<Solutions> findSolutionsByQuestionId(int QuestionId);

}
