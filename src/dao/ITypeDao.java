package dao;

import model.Type;

public abstract interface ITypeDao {
	//添加一种类型
		public Integer addType(Type type);
	//删除一种类型
		public Integer deleteType(Type type);
	//更新一种类型
		public Integer updateType(Type type);
	//根据Id查询类型
	public Type findTypeById(Integer typeId);
	//根据Name属性查询类型
	//public Type findTypeByName(String name);
	//根据Group属性查询类型
	//public Type findTypeByGroup(int group);
}
