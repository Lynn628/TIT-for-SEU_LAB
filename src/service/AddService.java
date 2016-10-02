package service;

import java.util.ArrayList;

import model.InputModel;

public abstract interface  AddService {
 
	public Integer splitAndAddInfo(InputModel input);
	public void addService(ArrayList<InputModel> inputs);
}
