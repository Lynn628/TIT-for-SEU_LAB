package action;

import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import service.OutputService;
import model.OutputModel;

//import action.ShowImagesAction;

public class OutputAction extends BaseAction {
	private ArrayList<OutputModel> outModelList;
	private OutputService outputSer;
	private int queId;

	// private ShowImagesAction showImgAction;

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public OutputService getOutputSer() {
		return outputSer;
	}

	public void setOutputSer(OutputService outputSer) {
		this.outputSer = outputSer;
	}



	public ArrayList<OutputModel> getOutModelList() {
		return outModelList;
	}

	public void setOutModelList(ArrayList<OutputModel> outModelList) {
		this.outModelList = outModelList;
	}

	public String execute() throws Exception {
		System.out.println("here is outputAction and the queID is" + queId);
		outModelList=outputSer.setOutputModelList(queId);
		// showImgAction.fillImages(outModel, queId);
		//for(int i=0;i<=outModelList.size();i++){
		/*if (outModelList.get(i).getImg() != null) {
			for (byte[] img : outModelList.get(i).getImg()) {
				this.writeImgResponse(img);
			}
		}
		}*/
		return "done";
	}

	private void writeImgResponse(byte[] img) {

		HttpServletResponse response = null;
		ServletOutputStream out = null;
		try {
			response = ServletActionContext.getResponse();
			response.setContentType("multipart/form-data");
			out = response.getOutputStream();
			out.write(img);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
