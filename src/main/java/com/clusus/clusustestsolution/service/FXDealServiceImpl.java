package com.clusus.clusustestsolution.service;

import com.clusus.clusustestsolution.entity.FXDeal;
import com.clusus.clusustestsolution.error.FXDealAlreadyExistsException;
import com.clusus.clusustestsolution.error.FXDealInvalidDataException;
import com.clusus.clusustestsolution.error.FXDealNotFoundException;
import com.clusus.clusustestsolution.repository.FXDealRepository;
import com.clusus.clusustestsolution.utils.CurrencyCode;
import com.clusus.clusustestsolution.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FXDealServiceImpl implements FXDealService {

    @Autowired
    private FXDealRepository fxDealRepository;

    public FXDealServiceImpl(FXDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    @Override
    public List<FXDeal> getAllDeals() {
        return fxDealRepository.findAll();
    }

    @Override
    public FXDeal saveFxDeal(FXDeal fxDeal) throws FXDealInvalidDataException, FXDealAlreadyExistsException {

        if (fxDealAlreadyExists(fxDeal)) {
            throw new FXDealAlreadyExistsException("Deal Already exists with dealId :" + fxDeal.getDealId());
        }
        if (!isValidFXDeal(fxDeal)) {
            throw new FXDealInvalidDataException("Deal is not valid. Please review");
        }
        return fxDealRepository.save(fxDeal);
    }


    @Override
    public FXDeal findFXDealById(Long fxDealId) throws FXDealNotFoundException {
        Optional<FXDeal> fxDeal = fxDealRepository.findById(fxDealId);
        if (fxDeal.isEmpty()) {
            throw new FXDealNotFoundException("FX Deal not available");
        }
        return fxDeal.get();
    }


    private boolean fxDealAlreadyExists(FXDeal fxDeal) {
        return fxDealRepository.findById(fxDeal.getDealId()).isPresent();
    }

    public boolean isValidFXDeal(FXDeal fxDeal) {
        return StringUtils.isNotEmpty(fxDeal.getFromCurrencyIsoCode()) && StringUtils.isNotEmpty(CurrencyCode.getValue(fxDeal.getFromCurrencyIsoCode())) && StringUtils.isNotEmpty(CurrencyCode.getValue(fxDeal.getToCurrencyIsoCode())) && StringUtils.isNotEmpty(fxDeal.getToCurrencyIsoCode()) && fxDeal.getDealAmount() != 0.0;
    }


}
