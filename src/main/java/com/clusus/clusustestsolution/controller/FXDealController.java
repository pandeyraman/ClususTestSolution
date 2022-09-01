package com.clusus.clusustestsolution.controller;

import com.clusus.clusustestsolution.entity.FXDeal;
import com.clusus.clusustestsolution.error.FXDealAlreadyExistsException;
import com.clusus.clusustestsolution.error.FXDealInvalidDataException;
import com.clusus.clusustestsolution.error.FXDealNotFoundException;
import com.clusus.clusustestsolution.service.FXDealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/fxdeals")
public class FXDealController {
    private final Logger LOGGER = LoggerFactory.getLogger(FXDealController.class);

    @Autowired
    private FXDealService fxDealService;

    @GetMapping()
    public List<FXDeal> getAllFxDeal() {
        LOGGER.info("Method::getAllFxDeal");
        return fxDealService.getAllDeals();
    }

    @GetMapping("{dealId}")
    public FXDeal getFXDealById(@PathVariable("dealId") Long dealId) throws FXDealNotFoundException {
        LOGGER.info("GET Method::getFXDealById | PathVariable :deal | value=" + dealId);
        return fxDealService.findFXDealById(dealId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FXDeal createFXDeal(@RequestBody FXDeal fxDeal) throws FXDealInvalidDataException, FXDealNotFoundException, FXDealAlreadyExistsException {
        LOGGER.info("POST Method::createFXDeal");
        return fxDealService.saveFxDeal(fxDeal);
    }
}
