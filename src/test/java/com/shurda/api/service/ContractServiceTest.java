package com.shurda.api.service;

import com.shurda.api.entity.Contract;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ContractServiceTest {

    private List<Contract> contracts = new ArrayList<>();

    @Before
    public void setup() {
        contracts.add(new Contract("Jean"));
        contracts.add(new Contract("Tom"));
        contracts.add(new Contract("Yooan"));
    }

    @Test
    public void getFilterContract() {
        ContractService contractService = mock(ContractService.class);
        when(contractService.getFilterContract("^A.*$")).thenReturn(contracts);
        List<Contract> filterContracts = contractService.getFilterContract("^A.*$");

        assertEquals(contracts,filterContracts);
    }
}