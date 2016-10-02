package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.IAtomKnowledgesDao;
import model.AtomKnowledges;
import model.HibernateSessionFactory;
import model.Questions;

public class AtomKnowledgesDaoImpl extends BaseDao implements
		IAtomKnowledgesDao {
	//添加一条原子知识点
	public Integer addAtomKnowledge(AtomKnowledges atom)
	{
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(atom);
		return atom.getId();
	}
	//删除一条原子知识点
	public Integer deleteAtomKnowledge(AtomKnowledges atom){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(atom);
		return atom.getId();
	}
	//更新一条原子知识点
	public Integer updateAtomKnowledges(AtomKnowledges atom){
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(atom);
		return atom.getId();
	}
	//返回所有原子知识点
	public List<AtomKnowledges> finaAllAtomKnowledges() {
		 String query0="from AtomKnowledges a where a.id= ?";
		 List<AtomKnowledges> allAtoms=this.getHibernateTemplate().find(query0);
		 return allAtoms;
		 
	}
	//根据Id查询原子知识点
	public AtomKnowledges findAtomKnowledgesById(int atomId){
		
		AtomKnowledges atom=(AtomKnowledges)this.getHibernateTemplate().get(AtomKnowledges.class,atomId);
		return atom;
	}
	//根据Context查询原子知识点
	public List<AtomKnowledges> findAtomKnowledgesByContext(String context){
		String query0="from AtomKnowledges atom where atom.nlDescription=?";
		 List<AtomKnowledges> atomList=this.getHibernateTemplate().find(query0,context);
		if(atomList!=null)
			return atomList;
		else return null;
	}
	//根据来源查询原子知识点
	public List<AtomKnowledges> findAtomKnowledgesBySource(String source){
		String query0="from AtomKnowledges atom where atom.source=?";
		 List<AtomKnowledges> atomList=this.getHibernateTemplate().find(query0,source);
			if(atomList!=null)
			return atomList;
		else return null;
	}
	public long findCountAtomknowledges(){
		 String query0="select count(*) from AtomKnowledges atom";
		 long sizeOfAtom=(long) this.getHibernateTemplate().find(query0).listIterator().next();
		 //System.out.println(list.get(0).getSource());
		if(sizeOfAtom>0)
			return sizeOfAtom;	
		else return 0;
	}
	@Override
	public long findCountAtomknowledgesByType(int typeId) {
		 String query0="select count(*) from AtomKnowledges atom where atom.type=?";
		 long sizeOfAtomByType=(long) this.getHibernateTemplate().find(query0,typeId).listIterator().next();
		 //System.out.println(list.get(0).getSource());
		if(sizeOfAtomByType>0)
			return sizeOfAtomByType;	
		else return 0;
		
	}

}
