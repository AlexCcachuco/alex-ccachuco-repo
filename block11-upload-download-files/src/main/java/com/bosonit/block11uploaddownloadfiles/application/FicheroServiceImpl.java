package com.bosonit.block11uploaddownloadfiles.application;

import com.bosonit.block11uploaddownloadfiles.application.exception.FileNotFoundException;
import com.bosonit.block11uploaddownloadfiles.application.util.ImageUtils;
import com.bosonit.block11uploaddownloadfiles.domain.Fichero;
import com.bosonit.block11uploaddownloadfiles.infrastructure.FicheroMapper;
import com.bosonit.block11uploaddownloadfiles.infrastructure.dto.FicheroDTO;
import com.bosonit.block11uploaddownloadfiles.infrastructure.repository.FicheroRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Date;

@Service
public class FicheroServiceImpl implements FicheroService {

    @Autowired
    FicheroRepository fichRepo;

    FicheroMapper mapper = Mappers.getMapper(FicheroMapper.class);
    public FicheroDTO uploadFile(MultipartFile file) throws IOException {
        Fichero fichero = fichRepo.save(Fichero.builder()
                .name(file.getOriginalFilename())
                .update_date(new Date())
                .fileData(ImageUtils.compressImage(file.getBytes())).build());
        if(fichero != null){
            return mapper.fileToFileDto(fichero);
        }
        return null;
    }

    public byte[] downloadImageByName(String filename) throws FileNotFoundException {
        Fichero fichero = fichRepo.findByName(filename).orElseThrow(()-> new FileNotFoundException("File with name: "+ filename + " not exists"));
        byte[] file = ImageUtils.decompressImage(fichero.getFileData());
        return file;
    }

    public byte[] downloadImageById(int id) throws FileNotFoundException  {
        Fichero fichero = fichRepo.findById(id).orElseThrow(()-> new FileSystemNotFoundException("File with id: "+ id+ " not exists"));
        byte[] file = ImageUtils.decompressImage(fichero.getFileData());
        return file;
    }


}
