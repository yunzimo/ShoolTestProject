package com.offcn.Service;

import com.offcn.Bean.Doctor;
import com.offcn.Dao.DoctorDao;

import com.offcn.Utils.LimitTool;


import java.util.List;

public class DoctorService {
    DoctorDao dd;
    public List<Doctor> QueryDoctorByKey(String name, String department, LimitTool tool){
        return dd.QueryDoctorByKey(name, department,tool);
    }
    public int QueryTotalCount(String name,String department){
        return dd.QueryTotalCount(name,department);
    }
    public boolean InsertDoctorInfo(Doctor doctor){
        return dd.InsertDoctorInfo(doctor)>0;
    }
    public Doctor QueryDoctorById(int did){
        return dd.QueryDoctorById(did);
    }
    public boolean ModifyDoctorInfo(Doctor doctor){
        return dd.ModifyDoctorInfo(doctor)>0;
    }
    public List<Doctor> QueryDoctorByDepartment(String department){
        return dd.QueryDoctorByDepartment(department);
    }
    public boolean DeleteDoctorByDids(String dids){
        return dd.DeleteDoctorByDids(dids)>0;
    }
}
