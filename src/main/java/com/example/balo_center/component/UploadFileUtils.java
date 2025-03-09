package com.example.balo_center.component;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.balo_center.exception.UploadFileEx;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class UploadFileUtils {

    private final Cloudinary cloudinary;

    public UploadFileUtils(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String upLoadFile(MultipartFile file) {
        try {
            String resourceType = getResourceType(file);
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", resourceType));
            return result.get("secure_url").toString();
        } catch (IOException e) {
            throw new UploadFileEx("Upload file failed");
        }
    }

    private String getResourceType(MultipartFile file) {
        String contentType = file.getContentType();
        if(contentType != null){
            if (contentType.startsWith("image/")){
                return "image";
            } else if (contentType.startsWith("video/")) {
                return "video";
            }
            else{
                return "auto";
            }
        }else {
            throw new UploadFileEx("Invalid file");
        }
    }
}
