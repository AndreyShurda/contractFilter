package com.shurda.api.dto;

import com.shurda.api.entity.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractDTO {

    private List<Contract> contracts = new ArrayList<>();

    public ContractDTO() {
    }

    public ContractDTO(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
