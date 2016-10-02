package service;

import java.util.ArrayList;

import model.OutputModel;

public abstract interface OutputService {
	public OutputModel setOutputModel(int queId);
	public ArrayList<OutputModel> setOutputModelList(int queId);
}
