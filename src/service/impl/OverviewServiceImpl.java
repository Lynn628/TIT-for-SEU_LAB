package service.impl;

import java.util.ArrayList;

import dao.IQuestionTypeDao;
import dao.IQuestionsDao;
import dao.ITypeDao;
import model.OverviewModel;
import model.Questions;
import service.OverviewService;

public class OverviewServiceImpl implements OverviewService {
	private IQuestionsDao queDao;
	private IQuestionTypeDao queAndTypeDao;
	private ITypeDao typeDao;

	public ITypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(ITypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public IQuestionTypeDao getQueAndTypeDao() {
		return queAndTypeDao;
	}

	public void setQueAndTypeDao(IQuestionTypeDao queAndTypeDao) {
		this.queAndTypeDao = queAndTypeDao;
	}

	public IQuestionsDao getQueDao() {
		return queDao;
	}

	public void setQueDao(IQuestionsDao queDao) {
		this.queDao = queDao;
	}

	public ArrayList<OverviewModel> overview() {
		ArrayList<Questions> queList = queDao.findAllQuestions();
		ArrayList<OverviewModel> overModel = new ArrayList<OverviewModel>();

		for (Questions que : queList) {
			OverviewModel overviews = new OverviewModel();
			overviews.setQueId(que.getId());
			overviews.setContent(que.getContent());
			ArrayList<Integer> typeIdList = queAndTypeDao
					.findTypeByQuestionId(que.getId());
			//System.out.println(typeIdList.get(0));
			ArrayList<String> typeBuffer=new ArrayList<String>();
			for (Integer typeId : typeIdList) {
				String Question_type=typeDao.findTypeById(typeId).getName();
				System.out.println(Question_type);
				typeBuffer.add(Question_type);
				System.out.println(typeBuffer.get(0));
				//overviews.getQuestion_type().add(Question_type);
			}
			overviews.setQuestion_type(typeBuffer);
			overModel.add(overviews);
		}
		return overModel;
	}

}
