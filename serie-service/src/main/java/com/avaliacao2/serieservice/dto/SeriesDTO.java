package com.avaliacao2.serieservice.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeriesDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String name;
    private String genre;
    private Set<SeasonsDTO> seasons;

}
