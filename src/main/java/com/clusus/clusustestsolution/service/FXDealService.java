package com.clusus.clusustestsolution.service;

import com.clusus.clusustestsolution.entity.FXDeal;
import com.clusus.clusustestsolution.error.*;

import java.util.List;

public interface FXDealService {
   List<FXDeal> getAllDeals();

   FXDeal saveFxDeal(FXDeal fxDeal) throws FXDealNotFoundException, FXDealInvalidDataException, FXDealAlreadyExistsException;

   FXDeal findFXDealById(Long fxDealId) throws FXDealNotFoundException;

}
