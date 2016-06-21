package com.sztx.javaPasser.core.service;

import java.util.Map;

import com.sztx.se.core.service.BaseService;
import com.sztx.se.dataaccess.fastdfs.config.ImageInfo;

public interface ImageService extends BaseService {

	/**
	 * 上传图片
	 * 
	 * @param filePath
	 * @param author
	 * @param extraInfo
	 * @return
	 */
	String uploadImage(String filePath, String author, Map<String, String> extraInfo);

	/**
	 * 下载图片
	 * 
	 * @param fileId
	 * @return
	 */
	ImageInfo downloadImage(String fileId);

}
