package com.uwm.projektz.role.api;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
@RestController
@Transactional
@RequestMapping(value = "/projektz/roles")
public class RoleController {
}
