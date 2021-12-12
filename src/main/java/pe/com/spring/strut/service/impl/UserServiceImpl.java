package pe.com.spring.strut.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.spring.strut.model.User;
import pe.com.spring.strut.repository.IGenericRepo;
import pe.com.spring.strut.repository.IUserRepo;
import pe.com.spring.strut.service.IUserService;


@Service
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    @Autowired
    private  IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
