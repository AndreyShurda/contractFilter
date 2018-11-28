package com.shurda.api.controller;

import com.shurda.api.entity.Contract;
import com.shurda.api.dto.ContractDTO;
import com.shurda.api.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/hello")
@Validated
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/contracts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ContractDTO> getFilterContracts(Pageable pageable,
                                                             @NotBlank @RequestParam(value = "nameFilter") String nameFilter) {

        List<Contract> contracts = contractService.getFilterContract(nameFilter);
        if (contracts.size() == 0) {
            return ResponseEntity.noContent().build();
        }

        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > contracts.size() ? contracts.size() : (start + pageable.getPageSize());
        Page<Contract> pages = new PageImpl<>(contracts.subList(start, end), pageable, contracts.size());

        return new ResponseEntity<>(new ContractDTO(pages.getContent()), HttpStatus.OK);

    }

}
