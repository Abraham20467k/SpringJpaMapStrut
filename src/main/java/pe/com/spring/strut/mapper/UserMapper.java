package pe.com.spring.strut.mapper;

import javax.swing.text.html.*;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.spring.strut.expose.UserRequestDTO;
import pe.com.spring.strut.model.User;
import pe.com.spring.strut.util.NumberUtils;

//@Mapper(imports = {NumberUtils.class}, uses = {UserMapper.class}, componentModel = "spring")
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target ="sendDate" , source="src.fechaEnvio"   )
    @Mapping(target = "age", constant = "90")
//    @Mapping(target = "age", expression = "java(asSendDate(src.getEdad()))" )
    User asUser(UserRequestDTO src);

    default Integer asSendDate(final Integer FechaEnvio){
        return Optional.of(FechaEnvio).isPresent()? FechaEnvio : 0;
    }

    @Mapping(source = "src.id", target = "idUser")
    @Mapping(constant = "30", target = "edad")
//    @Mapping(source = "src.age", target = "edad")
    @Mapping(source = "src.sendDate", target = "fechaEnvio")
    UserRequestDTO asUserRequestDTO(User src);

    
}

