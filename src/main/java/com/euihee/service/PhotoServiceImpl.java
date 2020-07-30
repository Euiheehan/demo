package com.euihee.service;

import com.euihee.domian.Image;
import com.euihee.repository.PhotoRepository;
import com.euihee.request.ImageRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service("photoService")
public class PhotoServiceImpl implements PhotoService{

    private final PhotoRepository photoRepository;

    @Override
    public List<Image> getPhotos() {
        return photoRepository.getPhotos();
    }

    @Override
    public void postPhoto(ImageRequest request) {

        Image image = new Image();
        image.setName(request.getName());
        image.setName(request.getUrl());
        photoRepository.postPhoto(image);
    }
}
