package pe.com.spring.strut.controller;

import javax.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.spring.strut.exception.ModeloNotFoundException;
import pe.com.spring.strut.expose.UserRequestDTO;
import pe.com.spring.strut.mapper.UserMapper;
import pe.com.spring.strut.model.User;
import pe.com.spring.strut.service.IUserService;

@Slf4j
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private  IUserService service;

    @Autowired
    private UserMapper  userMapper;

    

    @GetMapping
    public ResponseEntity<List<User>> listar() throws Exception{
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listarPorId(@PathVariable("id") Integer id) throws Exception{
        User obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

//    @PostMapping(path = {"/registrar"},produces = {MediaType.APPLICATION_JSON_VALUE}
//            ,consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping("/registrar")
    public ResponseEntity<UserRequestDTO> registrar(@RequestBody UserRequestDTO userDTO) throws Exception {
        User user = this.userMapper.asUser(userDTO);
       log.info("valores de entrada :  {}", user.getAge());
       log.info("valores de entrada :  {}", user.getSendDate());
        return new ResponseEntity<>(this.userMapper.asUserRequestDTO(service.registrar(user)), HttpStatus.CREATED); //201
    }

    @PutMapping
    public ResponseEntity<User> modificar(@Valid @RequestBody User User) throws Exception {
        return new ResponseEntity<>(service.modificar(User), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
