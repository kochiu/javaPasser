package com.sztx.javaPasser.dataaccess.dao.fastdfs;

import java.util.Map;

import com.sztx.se.dataaccess.fastdfs.BaseFastdfsDAO;
import com.sztx.se.dataaccess.fastdfs.config.ImageInfo;

public interface ImageFastdfsDAO extends BaseFastdfsDAO {

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
