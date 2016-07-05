package com.kochiu.javaPasser.core.service.impl;

import java.util.Map;

import com.kochiu.javaPasser.core.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.dataaccess.dao.fastdfs.ImageFastdfsDAO;
import com.kochiu.se.common.util.validate.ValidateUtil;
import com.kochiu.se.core.service.impl.BaseServiceImpl;
import com.kochiu.se.dataaccess.fastdfs.config.ImageInfo;

@Service("imageService")
public class ImageServiceImpl extends BaseServiceImpl implements ImageService {

    @Autowired
    private ImageFastdfsDAO imageFastdfsDAO;

    @Override
    public String uploadImage(String filePath, String author, Map<String, String> extraInfo) {
        ValidateUtil.isNotBlank(filePath, "文件路径不允许为空");
        return imageFastdfsDAO.uploadImage(filePath, author, extraInfo);
    }

    @Override
    public ImageInfo downloadImage(String fileId) {
        ValidateUtil.isNotBlank(fileId, "文件id不允许为空");
        return imageFastdfsDAO.downloadImage(fileId);
    }

}
