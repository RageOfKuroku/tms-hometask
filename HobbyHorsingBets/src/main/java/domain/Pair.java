package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//comment to commit



@Setter
@Getter
@ToString
@AllArgsConstructor
public class Pair {
    private Horseman horseman;
    private Horse horse;
}
