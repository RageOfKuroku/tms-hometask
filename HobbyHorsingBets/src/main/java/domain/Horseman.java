package domain;


import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
public class Horseman {
    @NonNull
    private String name;




public class Horseman {
    private String name;


    @Override
    public String toString() {
        return "name ='" + name + '\'';
    }
}