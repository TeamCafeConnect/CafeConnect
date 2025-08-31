package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.Cafe;
import com.yash.cafeconnect.dao.CafeDao;
import com.yash.cafeconnect.daoImpl.CafeDaoImpl;
import com.yash.cafeconnect.service.CafeService;

import java.util.List;

public class CafeServiceImpl implements CafeService {

    private CafeDao cafeDao = new CafeDaoImpl();

    // Add Cafe
    public void addCafe(Cafe cafe){

        // Check if cafe name is provided
        if(cafe.getCafeName() == null || cafe.getCafeName().isEmpty()){
            throw new IllegalArgumentException("Cafe name cannot be empty");
        }

        // Check if cafe with same Id exists to avoid duplicates
        if(cafeDao.getCafe(cafe.getCafeId()) != null){
            throw new IllegalStateException("Cafe with this Id already exists");
        }
        cafeDao.saveCafe(cafe);
    }

    public Cafe getCafeById(int cafeId){
        return cafeDao.getCafe(cafeId);
    }

    //Update Cafe
    public void updateCafeById(Cafe cafe){
        if(cafeDao.getCafe(cafe.getCafeId()) == null){
            throw new IllegalStateException("Cafe with this Id does not exist");
        }
        cafeDao.updateCafe(cafe);
    }

    //Remove Cafe
    public void removeCafeById(int cafeId){
        if(cafeDao.getCafe(cafeId) == null){
            throw new IllegalStateException("Cafe with this Id does not exist");
        }
        cafeDao.deleteCafe(cafeId);
    }

    public List<Cafe> getCafes(){
        return cafeDao.getCafes();
    }
}
