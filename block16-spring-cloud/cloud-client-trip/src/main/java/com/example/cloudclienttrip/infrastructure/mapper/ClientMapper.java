package com.example.cloudclienttrip.infrastructure.mapper;

import com.example.cloudclienttrip.domain.entity.Client;
import com.example.cloudclienttrip.infrastructure.controller.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {

     Client clientDtoToClient(ClientDTO clientDTO);

    ClientDTO clientToClientDTO(Client client);

    List<ClientDTO> map(List<Client> listclient);

}
