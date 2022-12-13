package com.bosonit.block11uploaddownloadfiles.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheroDTO {

    int id;

    String name;

    Date update_date;
}
