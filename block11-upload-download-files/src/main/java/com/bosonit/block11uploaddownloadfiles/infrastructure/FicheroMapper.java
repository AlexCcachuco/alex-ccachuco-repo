package com.bosonit.block11uploaddownloadfiles.infrastructure;

import com.bosonit.block11uploaddownloadfiles.domain.Fichero;
import com.bosonit.block11uploaddownloadfiles.infrastructure.dto.FicheroDTO;
import org.mapstruct.Mapper;

@Mapper
public interface FicheroMapper {

   FicheroDTO fileToFileDto(Fichero fichero);

}
