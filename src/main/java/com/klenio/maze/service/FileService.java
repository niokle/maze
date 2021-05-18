package com.klenio.maze.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class FileService {
    public String getDataFromFile(MultipartFile multipartFile) throws IOException {
        return new String(multipartFile.getBytes());
    }
}
