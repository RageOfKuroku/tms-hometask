package hometask.org.domain;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private UUID id;
    private String Title;
    private String description;
    private Integer pages;
    private String author;
}
