package com.uwm.projektz.user.service;

import com.uwm.projektz.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

public interface IUserService {

    UserDTO findUserById(Long aId);
    List<UserDTO> findAll();
}
