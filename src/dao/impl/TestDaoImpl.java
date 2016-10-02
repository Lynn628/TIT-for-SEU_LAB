package dao.impl;

import dao.ITestDao;



import java.util.List;

import model.AtomKnowledges;


public class TestDaoImpl extends BaseDao implements ITestDao {

public int queryatom(){
	 String query0="from AtomKnowledges atom where atom.id=?";
	 List<AtomKnowledges> list=this.getHibernateTemplate().find(query0,Integer.valueOf(1));
	 //System.out.println(list.get(0).getSource());
	if(list!=null)
		return list.size();	
	return 0;
	 
 }

@Override
public String queryuser() {
	// TODO Auto-generated method stub
	return null;
}
}
