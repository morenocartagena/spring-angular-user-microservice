
package com.crud.user.service;

import com.crud.user.model.User;
import java.util.List;

public interface InterfaceUserService {
    
    public List<User> findAll();

    public int save(User user);

    public int update(User user);

    public int deleteById(int id);
    
    
}
