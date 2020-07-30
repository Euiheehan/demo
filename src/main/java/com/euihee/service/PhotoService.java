package com.euihee.service;

import com.euihee.domian.Image;
import com.euihee.request.ImageRequest;

import java.util.List;

public interface PhotoService {

    List<Image> getPhotos();

    void postPhoto(ImageRequest request);
}
