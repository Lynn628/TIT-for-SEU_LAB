package service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.struts2.components.File;

import com.opensymphony.xwork2.util.ValueStack;

import dao.IAtomKnowledgesDao;
import dao.IImagesDao;
import dao.IQuestionAtomKnowledgeDao;
import dao.IQuestionImageDao;
import dao.IQuestionTypeDao;
import dao.IQuestionsDao;
import dao.ISolutionsDao;
import model.AtomKnowledges;
import model.Images;
import model.InputModel;
import model.QuestionAtomKnowledge;
import model.QuestionImage;
import model.QuestionType;
import model.Questions;
import model.Solutions;
import service.AddService;

public class AddServiceImpl extends BaseService implements AddService {

	private IAtomKnowledgesDao atomDao;
	private IImagesDao imgDao;
	private IQuestionsDao queDao;
	private ISolutionsDao solDao;
	private IQuestionTypeDao queAndTypeDao;
	private IQuestionAtomKnowledgeDao queAndAtomDao;
	private IQuestionImageDao queAndImgDao;

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

	public IQuestionsDao getQueDao() {
		return queDao;
	}

	public void setQueDao(IQuestionsDao queDao) {
		this.queDao = queDao;
	}

	public ISolutionsDao getSolDao() {
		return solDao;
	}

	public void setSolDao(ISolutionsDao solDao) {
		this.solDao = solDao;
	}

	public IQuestionTypeDao getQueAndTypeDao() {
		return queAndTypeDao;
	}

	public void setQueAndTypeDao(IQuestionTypeDao queAndTypeDao) {
		this.queAndTypeDao = queAndTypeDao;
	}

	public IQuestionAtomKnowledgeDao getQueAndAtomDao() {
		return queAndAtomDao;
	}

	public void setQueAndAtomDao(IQuestionAtomKnowledgeDao queAndAtomDao) {
		this.queAndAtomDao = queAndAtomDao;
	}

	public IQuestionImageDao getQueAndImgDao() {
		return queAndImgDao;
	}

	public void setQueAndImgDao(IQuestionImageDao queAndImgDao) {
		this.queAndImgDao = queAndImgDao;
	}

	@Override
	public Integer splitAndAddInfo(InputModel input) {
		System.out.println(input);
		Questions que = input.getQuestion();
		// 添加问题表
		System.out.println(que.getContent());
		System.out.println(que.getAnswer());
		//queDao = null;
		Integer queId = queDao.addQuestion(que);
		// 添加原子知识点表、原子知识点-问题映射
		if (input.getAtom() != null) {
			for (AtomKnowledges at : input.getAtom()) {
				System.out.println("atom.getNlDescription()");
				System.out.println("atom.getFormalDescription()");
				System.out.println("atom.getSource()");
				//atomDao = null;
				//添加原子知识点
				atomDao.addAtomKnowledge(at);
				//添加原子知识点-问题映射
				QuestionAtomKnowledge queAndAtom = new QuestionAtomKnowledge();
				queAndAtom.setQuestionId(queId);
				queAndAtom.setAtomKnowledges(at);
				//queAndAtomDao = null;
				queAndAtomDao.addQuestionAtomKnowledge(queAndAtom);
			}
		}
		// 添加解题思路表
		if (input.getSolution() != null) {
			for (Solutions sol : input.getSolution()) {
				sol.setQuestionId(queId);
				System.out.println(sol.getFormalDescription());
				System.out.println(sol.getNlDescription());
				//solDao = null;
				solDao.addSolution(sol);
			}
		}
		// 添加问题类型映射
		
		if (input.getQuestion_type() != null) {
			for (Integer type : input.getQuestion_type()) {
				//queAndType.setQuestionId(queId);
				QuestionType queAndType = new QuestionType();
				queAndType.setTypeId(type);
				queAndType.setQuestions(input.getQuestion());
				//queAndTypeDao = null;
				queAndTypeDao.addQuestionType(queAndType);
			}
		}
		// 添加图片表、图片-问题映射
		
		System.out.println(input.getImg());
		if (input.getImg() != null) {
			for (int i = 0; i < input.getImg().size(); i++) {

				BufferedInputStream bufInputStream;
				Images img = new Images();
				try {
					bufInputStream = new BufferedInputStream(
							new FileInputStream(input.getImg().get(i)));
					// ByteArrayOutputStream arrayOutputStream = new
					// ByteArrayOutputStream();
					byte[] bytes = new byte[bufInputStream.available()];
					bufInputStream.read(bytes);

					img.setImg(bytes);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//imgDao = null;
				imgDao.addImages(img);
				QuestionImage queAndImg = new QuestionImage();
				queAndImg.setQuestionId(queId);
				queAndImg.setImages(img);
				//queAndImgDao = null;
				queAndImgDao.addQuestionImage(queAndImg);
			}
		}
		return queId;
	}

	@Override
	public void addService(ArrayList<InputModel> inputs) {
		System.out.println(inputs.size());
		InputModel headInput = inputs.get(0);
		ArrayList<Integer> typeofhead = headInput.getQuestion_type();
		Integer headId = this.splitAndAddInfo(headInput);
		for (int i = 1; i < inputs.size(); i++) {
			inputs.get(i).setQuestion_type(typeofhead);
			inputs.get(i).getQuestion().setRelatedQuestionId(headId);
			this.splitAndAddInfo(inputs.get(i));
		}
	}

}
