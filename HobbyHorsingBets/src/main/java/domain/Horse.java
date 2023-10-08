package domain;

import lombok.*;

//comment to commit



@Getter
@Setter
@RequiredArgsConstructor
public class Horse {
    @NonNull
    private String name;
    private double speedInfoCoef = 0;

    @Override
    public String toString() {
        return " name ='" + name + '\'';
    }
}
