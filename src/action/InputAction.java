package action;
import java.util.ArrayList;

import service.AddService;
import model.AtomKnowledges;
import model.InputModel;
import model.Questions;
public class InputAction extends BaseAction{
	private ArrayList<InputModel> input;
	private Questions question;
	private AtomKnowledges atomknowledge;
	private AddService addSer;

	public AddService getAddSer() {
		return addSer;
	}

	public void setAddSer(AddService addSer) {
		this.addSer = addSer;
	}

	public AtomKnowledges getAtomknowledge() {
		return atomknowledge;
	}

	public void setAtomknowledge(AtomKnowledges atomknowledge) {
		this.atomknowledge = atomknowledge;
	}

	/**
	 * @return the input
	 */
	public ArrayList<InputModel> getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(ArrayList<InputModel> input) {
		this.input = input;
	}
   public String execute() throws Exception{
	   System.out.println("here is inputAction");
   if(input!=null){
	  addSer.addService(input);
	   
	   }
   return "done";
   
   }
	
	
	   
   


/**
 * @return the question
 */
public Questions getQuestion() {
	return question;
}

/**
 * @param question the question to set
 */
public void setQuestion(Questions question) {
	this.question = question;
}
}
