package pe.com.spring.strut.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {



    //@NotNull
    private LocalDateTime fecha;
    //@NotNull
    private String mensaje;
    //@NotNull
    private String detalles;
}
