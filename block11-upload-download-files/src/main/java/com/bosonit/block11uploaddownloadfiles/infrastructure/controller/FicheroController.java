package com.bosonit.block11uploaddownloadfiles.infrastructure.controller;

import com.bosonit.block11uploaddownloadfiles.application.FicheroService;
import com.bosonit.block11uploaddownloadfiles.application.FicheroServiceImpl;
import com.bosonit.block11uploaddownloadfiles.application.exception.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RestController
public class FicheroController {

    @Autowired
    FicheroService ficheroService;

    @PostMapping("/file")
    public ResponseEntity<?> UploadImage(@RequestParam("image")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(ficheroService.uploadFile(file));
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<?> donwloadImageByName(@PathVariable String filename) throws FileNotFoundException {

        byte[] file = ficheroService.downloadImageByName(filename);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(file);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<?> downloadImageById(@PathVariable int id) throws FileNotFoundException {
        byte[] file = ficheroService.downloadImageById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(file);
    }



}
