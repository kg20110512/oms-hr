package com.neo.service;

import com.neo.entity.Atm;

import java.util.List;
import java.util.Optional;

public interface AtmService {

    public List<Atm> getAtmList(String userid);

    public Optional<Atm> findById(String id);

    public Atm save(Atm atm);

    public void edit(Atm atm);

    public void delete(String id);


}
