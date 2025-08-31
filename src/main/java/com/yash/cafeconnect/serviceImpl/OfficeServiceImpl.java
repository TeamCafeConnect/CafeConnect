//package com.yash.cafeconnect.serviceImpl;
//
//import com.yash.cafeconnect.entity.Office;
//import com.yash.cafeconnect.dao.OfficeDao;
//import com.yash.cafeconnect.daoImpl.OfficeDaoImpl;
//import com.yash.cafeconnect.service.OfficeService;
//
//import java.util.List;
//
//public class OfficeServiceImpl implements OfficeService
//{
//    private OfficeDaoImpl officeDao = new OfficeDaoImpl();
//
//    public void addOffice(Office office){
//        if (office.getOfficeName() == null || office.getOfficeName().isEmpty()){
//            throw new IllegalArgumentException("office name cannot be empty");
//        }
//
//        if(officeDao.getOffice(office.getOfficeId()) !=null){
//            throw new IllegalStateException("office with this Id already exists");
//        }
//        officeDao.saveOffice(office);
//    }
//
//    public Office getOfficeById(int officeId){
//        return officeDao.getOffice(officeId);
//    }
//
//    public void updateOfficeById(Office office){
//        if (officeDao.getOffice(office.getOfficeId()) == null){
//            throw new IllegalStateException("Office with this Id does not exist");
//        }
//        officeDao.UpdateOffice(office);
//    }
//
//    public void removeOfficeById(int officeId) {
//        if (officeDao.getOffice(officeId) == null) {
//            throw new IllegalStateException("Office with this Id does not exist");
//        }
//        officeDao.deleteOffice(officeId);
//    }
//
////    public List<Office> getOffices() {
////        return officeDao.getOffices();
////    }
//
//}
