package com.euihee.repository;

import com.euihee.domian.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository {

    @Select({"SELECT id, name, url FROM EUIHEE_PHOTO.IMAGE"})
    List<Image> getPhotos();

    @Select({"SELECT id, name, url FROM EUIHEE_PHOTO.IMAGE WHERE id"})
    Image getPhoto();

    @Insert({"INSERT INTO EUIHEE_PHOTO.IMAGE (name, url) VALUES (#{name}, #{url})"})
    void postPhoto(Image image);
}
