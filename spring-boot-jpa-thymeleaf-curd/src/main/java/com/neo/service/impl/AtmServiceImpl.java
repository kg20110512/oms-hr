package com.neo.service.impl;

import com.neo.entity.Atm;
import com.neo.repository.AtmRepository;
import com.neo.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtmServiceImpl implements AtmService{

    @Autowired
    private AtmRepository atmRepostory;

    @Override
    public List<Atm> getAtmList(String userid) {
        return atmRepostory.findAllByUserid(userid);
    }

    public Optional<Atm> findById(String id) {
        return atmRepostory.findById(id);
    }

    @Override
    public Atm save(Atm atm) {
        Atm save = atmRepostory.save(atm);
        return save;
    }

    @Override
    public void edit(Atm atm) {
        atmRepostory.save(atm);
    }

    @Override
    public void delete(String id) {
        atmRepostory.deleteById(id);
    }

}


