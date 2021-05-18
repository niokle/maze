package com.klenio.maze.service;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void getDataFromFile() throws IOException {
        //given
        FileService fileService = new FileService();
        MultipartFile multipartFile = new MockMultipartFile("correct.txt", new FileInputStream(new File("src/main/resources/test_correct_file.txt")));
        //when
        String actual = fileService.getDataFromFile(multipartFile);
        String expected = "9,8\n" +
                "000000000\n" +
                "111101110\n" +
                "010101010\n" +
                "010111010\n" +
                "010000010\n" +
                "011110010\n" +
                "010011111\n" +
                "000000000";
        //then
        assertEquals(expected,actual);
    }
}