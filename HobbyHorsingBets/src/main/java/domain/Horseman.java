package domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Horseman {
    @NonNull
    private String name;



    @Override
    public String toString() {
        return "name ='" + name + '\'';
    }
}