package com.sztx.demo.core.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sztx.demo.core.service.ImageService;
import com.sztx.demo.dataaccess.dao.fastdfs.ImageFastdfsDAO;
import com.sztx.se.common.util.validate.ValidateUtil;
import com.sztx.se.core.service.impl.BaseServiceImpl;
import com.sztx.se.dataaccess.fastdfs.config.ImageInfo;

@Service("imageService")
public class ImageServiceImpl extends BaseServiceImpl implements ImageService {

	@Autowired
	private ImageFastdfsDAO imageFastdfsDAO;
	
	@Override
	public String uploadImage(String filePath, String author, Map<String, String> extraInfo) {
		ValidateUtil.notBlank(filePath, "文件路径不允许为空");
		return imageFastdfsDAO.uploadImage(filePath, author, extraInfo);
	}

	@Override
	public ImageInfo downloadImage(String fileId) {
		ValidateUtil.notBlank(fileId, "文件id不允许为空");
		return imageFastdfsDAO.downloadImage(fileId);
	}

}
