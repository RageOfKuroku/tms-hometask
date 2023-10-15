package springWebFProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @NotBlank(message = "Fill with letters")
    private String name;

    @NotNull(message = "Fill with numbers")
    @Min(10) @Max(10000)
    private Integer secondName;


}
