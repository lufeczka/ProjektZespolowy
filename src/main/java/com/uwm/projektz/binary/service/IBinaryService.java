package com.uwm.projektz.binary.service;

import com.uwm.projektz.binary.dto.BinaryDTO;
import com.uwm.projektz.binary.dto.BinaryDTOCreate;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */
public interface IBinaryService {

    //CREATE & UPDATE
    BinaryDTO saveBinary(BinaryDTOCreate aBinaryDTO);

    //READ
    BinaryDTO findBinaryById(Long aId);
    List<BinaryDTO> findAllBinary();//odlec


    //DELETE
    void deleteBinaryById(Long aId);
}
