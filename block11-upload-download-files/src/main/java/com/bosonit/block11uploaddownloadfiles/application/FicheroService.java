package com.bosonit.block11uploaddownloadfiles.application;

import com.bosonit.block11uploaddownloadfiles.application.exception.FileNotFoundException;
import com.bosonit.block11uploaddownloadfiles.domain.Fichero;
import com.bosonit.block11uploaddownloadfiles.infrastructure.dto.FicheroDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FicheroService {

     FicheroDTO uploadFile(MultipartFile file) throws IOException;

     byte[] downloadImageByName(String filename) throws FileNotFoundException;

    byte[] downloadImageById(int id) throws FileNotFoundException;

}
