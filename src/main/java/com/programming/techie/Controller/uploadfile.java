package com.programming.techie.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class uploadfile {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/addfile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        return "ok";
    }

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {
        // Specify the directory where files will be uploaded
        String uploadDirPath = "C:\\Users\\ycode\\Downloads\\start\\src\\main\\java\\com\\programming\\techie\\uploads";
        File dir = new File(uploadDirPath);

        // Create the directory if it doesn't exist
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Get the original filename and extension
        String originalFileName = file.getOriginalFilename(); // Get the original file name
        if (originalFileName == null || originalFileName.isEmpty()) {
            return "You failed to upload because the file name is empty.";
        }

        // Ensure the file name is safe and remove any unwanted characters
        String safeFileName = originalFileName.replaceAll("[^a-zA-Z0-9.]", "_"); // Replace unwanted characters

        // Create the full path for the new file
        File serverFile = new File(dir.getAbsolutePath() + File.separator + safeFileName);

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Create the file on the server
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }

                return "You successfully uploaded the file as " + safeFileName;
            } catch (Exception e) {
                return "You failed to upload the file => " + e.getMessage();
            }
        } else {
            return "You failed to upload the file because it was empty.";
        }
    }


    @PostMapping("/uplaod")
    public String upload() {

        return "ok";
    }
}
