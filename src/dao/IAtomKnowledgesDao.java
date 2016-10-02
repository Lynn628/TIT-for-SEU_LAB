package dao;

import java.util.List;

import model.AtomKnowledges;

public abstract interface IAtomKnowledgesDao {
	// 添加一条原子知识点
	public Integer addAtomKnowledge(AtomKnowledges atom);

	// 删除一条原子知识点
	public Integer deleteAtomKnowledge(AtomKnowledges atom);

	// 更新一条原子知识点
	public Integer updateAtomKnowledges(AtomKnowledges atom);

	// 根据Id查询原子知识点
	public AtomKnowledges findAtomKnowledgesById(int atomId);

	// 返回所有原子知识点
	public List<AtomKnowledges> finaAllAtomKnowledges();

	// 根据Context查询原子知识点
	public List<AtomKnowledges> findAtomKnowledgesByContext(String context);

	// 根据来源查询原子知识点
	public List<AtomKnowledges> findAtomKnowledgesBySource(String source);

	public long findCountAtomknowledges();

	public long findCountAtomknowledgesByType(int typeId);

}
