package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.ITypeDao;
import model.Questions;
import model.Type;

public class TypeDaoImpl extends BaseDao implements ITypeDao {// 类型表Dao操作未搞清楚11.16
	// 添加一种类型
	public Integer addType(Type type) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.save(type);
		return type.getId();
	}

	// 删除一种类型
	public Integer deleteType(Type type) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.delete(type);
		return type.getId();
	}

	// 更新一种类型
	public Integer updateType(Type type) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.setFlushMode(HibernateTemplate.FLUSH_EAGER);
		tmp.update(type);
		return type.getId();
	}

	// 根据Id查询类型
	public Type findTypeById(Integer typeId) {
		Type type = (Type) this.getHibernateTemplate().get(Type.class, typeId);
		System.out.println(type.getName());
		return type;
	}
	// 根据Name属性查询类型
	/*
	 * public Type findTypeByName(String name){ Type type=new Type(); return
	 * type; } //根据Group属性查询类型 public Type findTypeByGroup(int group){ Type
	 * type=new Type(); return type; }
	 */
}
