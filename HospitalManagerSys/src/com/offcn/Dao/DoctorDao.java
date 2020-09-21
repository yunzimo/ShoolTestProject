package com.offcn.Dao;

import com.offcn.Bean.Doctor;
import com.offcn.Utils.LimitTool;


import java.util.List;

public interface DoctorDao {
    public int QueryTotalCount(String name, String department);
    public List<Doctor> QueryDoctorByKey(String name, String department, LimitTool tool);
    public int InsertDoctorInfo(Doctor doctor);
    public Doctor QueryDoctorById(int did);
    public int ModifyDoctorInfo(Doctor doctor);
    public List<Doctor> QueryDoctorByDepartment(String department);
    public int DeleteDoctorByDids(String dids);
}
