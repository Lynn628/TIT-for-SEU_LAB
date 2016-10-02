package action;

import service.CountService;
import model.CountModel;
import model.QuestionType;
import model.Questions;

public class CountAction extends BaseAction{
	private CountModel countModel = new CountModel();
	private CountService countSer;
	
	public String execute() throws Exception {
		System.out.println("here is countAction");
		countModel = countSer.getCount();
		return "done";

	}

	public CountModel getCountModel() {
		return countModel;
	}

	public void setCountModel(CountModel countModel) {
		this.countModel = countModel;
	}

	public CountService getCountSer() {
		return countSer;
	}

	public void setCountSer(CountService countSer) {
		this.countSer = countSer;
	}
}
