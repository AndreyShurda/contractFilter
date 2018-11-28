package com.shurda.api.service;

import com.shurda.api.entity.Contract;
import com.shurda.api.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Transactional
    @Cacheable("contracts")
    public List<Contract> getFilterContract(String regexp){
        List<Contract> contracts = contractRepository.findAll().parallelStream()
                .filter(e -> !e.getName().matches(regexp))
                .collect(Collectors.toList());
        return contracts;
    }
}
