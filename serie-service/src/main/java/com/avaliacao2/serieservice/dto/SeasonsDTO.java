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
public class SeasonsDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String seasonNumber;
    private Set<ChaptersDTO> chapters;

}
