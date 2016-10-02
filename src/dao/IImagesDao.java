package dao;

import java.util.List;

import model.Images;

public abstract interface IImagesDao {
	//添加一张图片记录
	public Integer addImages(Images image);
	//删除一张图片记录
	public Integer deleteIamges(Images image);
	//更新一张图片
	public Integer updateImages(Images image);
	//返回所有图片
	public List<Images> finaAllImages();
	//根据Id查询图片
	public Images findImagesById(int imageId);
}
