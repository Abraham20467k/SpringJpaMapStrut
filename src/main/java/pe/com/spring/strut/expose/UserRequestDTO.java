package pe.com.spring.strut.expose;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private Integer idUser;
    private String fechaEnvio;
    private Integer edad;

}
