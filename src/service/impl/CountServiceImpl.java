package service.impl;

import model.CountModel;
import model.QuestionType;
import model.Questions;
import dao.IQuestionTypeDao;
import dao.IQuestionsDao;
import service.CountService;

public class CountServiceImpl implements CountService {
	private IQuestionsDao queDao;
	private IQuestionTypeDao queAndTypeDao;

	public IQuestionsDao getQueDao() {
		return queDao;
	}

	public void setQueDao(IQuestionsDao queDao) {
		this.queDao = queDao;
	}

	public IQuestionTypeDao getQueAndTypeDao() {
		return queAndTypeDao;
	}

	public void setQueAndTypeDao(IQuestionTypeDao queAndTypeDao) {
		this.queAndTypeDao = queAndTypeDao;
	}

	@Override
	public CountModel getCount() {
		// TODO Auto-generated method stub
		CountModel countModel = new CountModel();
		countModel.setCountTotal(queDao.countTotalNum());
		countModel.setCountHistory(queAndTypeDao.countQuestionByType(3));
		countModel.setCountGeo(queAndTypeDao.countQuestionByType(4));
		return countModel;
	}
}
