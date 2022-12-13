package com.bosonit.block11uploaddownloadfiles.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FileData")
@Builder
public class Fichero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    Date update_date;

    @Lob
    @Column(name = "filedata",length = 1000)
    byte[] fileData;

}
