package action;

import service.TestService;

public class TestAction extends BaseAction {
	private TestService ser1;
	private long size;
	private String address; 
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//public TestAction()
	//{
		//System.out.println("testAction");
	//}
	public String execute()
	{
		System.out.println(address);
		ser1.addImgTest(address);
		
		return "size";
	}
	
	public String getAtomSize(){
		//size= ser1.getAtomKnowledgeSize();
		ser1.addImgTest(address);
		return "size";
	}
	
	
	public TestService getSer1() {
		return ser1;
	}
	public void setSer1(TestService ser1) {
		this.ser1 = ser1;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}
}
