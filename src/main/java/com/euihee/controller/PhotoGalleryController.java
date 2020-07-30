package com.euihee.controller;

import com.euihee.domian.Image;
import com.euihee.request.ImageRequest;
import com.euihee.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class PhotoGalleryController {

    private final PhotoService photoService;

    @GetMapping("/")
    public String getPhotos(Model model) {

        List<Image> images =  photoService.getPhotos();
        model.addAttribute("imageList", images);
        return "index";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadForm() {
        return "form";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        String filePath = String.format("/%s", file.getOriginalFilename());

        InputStream initialStream =file.getInputStream();
        File targetFile = new File(String.format("D:\\Git\\demo\\build\\resources\\main\\static\\%s", file.getOriginalFilename()));
        OutputStream outStream = new FileOutputStream(targetFile);

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = initialStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        IOUtils.closeQuietly(initialStream);
        IOUtils.closeQuietly(outStream);

        modelMap.put("filePath", filePath);
        return "fileUploadView";
    }

    @PostMapping("/upload")
    public String postPhoto(ImageRequest request) {
        return "redirect:/";
    }
}
