package com.uwm.projektz.user.service.impl;

import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Override
    public UserDTO findUserById(Long aId) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
