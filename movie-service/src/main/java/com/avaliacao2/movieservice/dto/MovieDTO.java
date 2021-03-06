package com.avaliacao2.movieservice.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String id;
    private String name;
    private String genre;
    private String urlStream;

}
