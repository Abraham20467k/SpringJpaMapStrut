package pe.com.spring.strut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Usuario" )
public class User implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idUser"  )
    private Integer id;


    @Size(min = 4, message = "Fecha minima es 4")
    @Column(name ="fechaEnvio")
    private String sendDate;


    /**The shipping code intermal MMPP */
    @Column(name ="COD_ENVIO_DB2" )
    private Integer age;


    
}
