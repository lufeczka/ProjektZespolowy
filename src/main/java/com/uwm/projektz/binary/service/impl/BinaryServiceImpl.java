package com.uwm.projektz.binary.service.impl;

import com.uwm.projektz.binary.dto.BinaryDTO;
import com.uwm.projektz.binary.service.IBinaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-20.
 */

@Service
@Transactional
public class BinaryServiceImpl implements IBinaryService {

    @Override
    public BinaryDTO saveBinary(BinaryDTO aBinaryDTO) {
        return null;
    }

    @Override
    public BinaryDTO findBinaryById(Long aId) {
        return null;
    }

    @Override
    public List<BinaryDTO> findAllBinary() {
        return null;
    }

    @Override
    public void deleteBinaryById(Long aId) {

    }
}
