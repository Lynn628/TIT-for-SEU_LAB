package action;

import java.util.ArrayList;

import service.OverviewService;
import model.OverviewModel;

public class OverviewAction extends BaseAction {
	ArrayList<OverviewModel> overview;
	private OverviewService overSer;

	public ArrayList<OverviewModel> getOverview() {
		return overview;
	}

	public void setOverview(ArrayList<OverviewModel> overview) {
		this.overview = overview;
	}

	public String execute() throws Exception {
		System.out.println("here is overviewtAction");
		overview = overSer.overview();
		return "done";

	}

	/**
	 * @return the overSer
	 */
	public OverviewService getOverSer() {
		return overSer;
	}

	/**
	 * @param overSer
	 *            the overSer to set
	 */
	public void setOverSer(OverviewService overSer) {
		this.overSer = overSer;
	}
}
