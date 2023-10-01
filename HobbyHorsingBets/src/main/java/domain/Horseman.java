package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Horseman {
    private String name;

    @Override
    public String toString() {
        return "name ='" + name + '\'';
    }
}