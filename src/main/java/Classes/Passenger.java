package Classes;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Passenger {

    private int id;
    private String firstName;
    private String name;
    private int age;
    private String email;
    private String phone;

}
