package service.impl;

import java.util.ArrayList;

import model.AtomKnowledges;
import model.Images;
import model.OutputModel;
import model.Questions;
import model.Solutions;
import service.OutputService;
import dao.IAtomKnowledgesDao;
import dao.IImagesDao;
import dao.IQuestionAtomKnowledgeDao;
import dao.IQuestionImageDao;
import dao.IQuestionTypeDao;
import dao.IQuestionsDao;
import dao.ISolutionsDao;
import dao.ITypeDao;

public class OutputServiceImpl implements OutputService {
	private IQuestionsDao queDao;
	private IAtomKnowledgesDao atomDao;
	private IImagesDao imgDao;
	private IQuestionAtomKnowledgeDao queAndAtomDao;
	private IQuestionTypeDao queAndTypeDao;
	private ITypeDao typeDao;
	private ISolutionsDao solDao;
	private IQuestionImageDao queAndImgDao;

	public IQuestionsDao getQueDao() {
		return queDao;
	}

	public void setQueDao(IQuestionsDao queDao) {
		this.queDao = queDao;
	}

	public IQuestionAtomKnowledgeDao getQueAndAtomDao() {
		return queAndAtomDao;
	}

	public void setQueAndAtomDao(IQuestionAtomKnowledgeDao queAndAtomDao) {
		this.queAndAtomDao = queAndAtomDao;
	}

	public IQuestionTypeDao getQueAndTypeDao() {
		return queAndTypeDao;
	}

	public void setQueAndTypeDao(IQuestionTypeDao queAndTypeDao) {
		this.queAndTypeDao = queAndTypeDao;
	}

	public ITypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(ITypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public ISolutionsDao getSolDao() {
		return solDao;
	}

	public void setSolDao(ISolutionsDao solDao) {
		this.solDao = solDao;
	}

	public IQuestionImageDao getQueAndImgDao() {
		return queAndImgDao;
	}

	public void setQueAndImgDao(IQuestionImageDao queAndImgDao) {
		this.queAndImgDao = queAndImgDao;
	}

	public OutputModel setOutputModel(int queId) {

		OutputModel outModel = new OutputModel();
		// 根据问题Id设置问题部分
		outModel.setQuestion(queDao.findQuestionById(queId));
		outModel.setAtom(queAndAtomDao.findAtomKnowledgeByQuestionId(queId));
		// 根据问题Id设置问题类型列表
		ArrayList<Integer> typeIdList = queAndTypeDao
				.findTypeByQuestionId(queId);
		ArrayList<String> typeBuffer = new ArrayList<String>();
		for (Integer typeId : typeIdList) {
			String Question_type = typeDao.findTypeById(typeId).getName();
			System.out.println(Question_type);
			typeBuffer.add(Question_type);
			System.out.println(typeBuffer.get(0));
		}
		outModel.setQuestion_type(typeBuffer);
		// 根据问题Id取图片流列表
		ArrayList<Images> imgList = queAndImgDao.findImageByQuestionId(queId);
		// ArrayList<Integer> imgIdList =
		// queAndImgDao.findImageByQuestionId(queId);
		ArrayList<byte[]> imgBuffer = new ArrayList<byte[]>();
		for (Images img : imgList) {
			imgBuffer.add(img.getImg());
		}
		outModel.setImg(imgBuffer);
		// 根据问题Id设置解题思路列表
		ArrayList<Solutions> sol = solDao.findSolutionsByQuestionId(queId);
		System.out.println(sol.get(0).getNlDescription());
		outModel.setSolution(sol);
		int subQueNum=queDao.subQuestionNum(queId);
		if(subQueNum>=0){
			for(int sub=0;sub<=subQueNum;sub++)
			{
				
			}
		}
		return outModel;
	}

	public IAtomKnowledgesDao getAtomDao() {
		return atomDao;
	}

	public void setAtomDao(IAtomKnowledgesDao atomDao) {
		this.atomDao = atomDao;
	}

	public IImagesDao getImgDao() {
		return imgDao;
	}

	public void setImgDao(IImagesDao imgDao) {
		this.imgDao = imgDao;
	}
	public ArrayList<OutputModel> setOutputModelList(int queId){
		ArrayList<OutputModel> outputList=new ArrayList<OutputModel>();
		//读出题干或单个问题
		OutputModel output=new OutputModel();
		output=this.setOutputModel(queId);
		outputList.add(output);
		//如果有子问题，依次取出，存入List中
		int subQueNum=queDao.subQuestionNum(queId);
		if(subQueNum>=0){
			ArrayList<Questions> queList=new ArrayList<Questions>();
			queList=(queDao.subQuestions(queId));
			for(Questions que:queList){
				OutputModel subOutput=new OutputModel();
				subOutput=this.setOutputModel(que.getId());
				outputList.add(subOutput);
			}
			
		}
		return outputList;
		
	}

}

