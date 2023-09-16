package domain;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

   private UUID id;

   private String Title;
   private String description;
   private Integer pages;
   @Getter@Setter
   private String author;

}
