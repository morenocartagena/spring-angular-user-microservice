package com.crud.user.service;

import com.crud.user.model.User;
import com.crud.user.repository.InterfaceUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements InterfaceUserService {

    @Autowired
    private InterfaceUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        List<User> users;
        try {
            users = iUserRepository.findAll();

        } catch (Exception ex) {
            throw ex;
        }
        return users;
    }

    @Override
    public int save(User user) {
        int row;
        try {
            row = iUserRepository.save(user);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(User user) {
        int row;
        try {
            row = iUserRepository.update(user);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iUserRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

}
