package com.uwm.projektz.user.api;

import com.uwm.projektz.user.dto.UserDTO;
import com.uwm.projektz.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@RestController
@Transactional
@RequestMapping(value = "/projektz/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "getById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDTO> findUserByid(@PathVariable("id") Long aId){
        return new ResponseEntity<>(iUserService.findUserById(aId), HttpStatus.OK);
    }

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        return new ResponseEntity<>(iUserService.findAll(),HttpStatus.OK);
    }

    


}
