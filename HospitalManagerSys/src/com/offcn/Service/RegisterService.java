package com.offcn.Service;

import com.offcn.Bean.Doctor;
import com.offcn.Bean.Register;
import com.offcn.Dao.DoctorDao;

import com.offcn.Dao.RegisterDao;
import com.offcn.Utils.LimitTool;

import java.util.List;

public class RegisterService {
    RegisterDao rd;
    DoctorDao dd;
    public int QueryTotalCount(String rid, String name, String department){
        return rd.TotalCount(rid,name,department);
    }
    public List<Register> QueryRegisterByKey(String rid, String name, String department, LimitTool tool){
        List<Register> registers = rd.QueryRegisterByKey(rid, name, department, tool);
        for(Register register:registers){
            Doctor doctor = dd.QueryDoctorById(register.getDid());
            register.setDoctor(doctor);
        }
        return registers;
    }
    public boolean InsertRegisterInfo(Register register){
        return  rd.InsertRegisterInfo(register)>0;
    }
    public Register QueryRegisterByRid(String rid){
        Register register = rd.QueryRegisterByRid(rid);
        Doctor doctor=dd.QueryDoctorById(register.getDid());
        register.setDoctor(doctor);
        return register;
    }
    public boolean DeleteRegisterByRids(String rids){
        return  rd.DeleteRegisterByRids(rids)>0;
    }
    public boolean ModifyRegisterByKey(Register register){
        return  rd.ModifyRegisterByKey(register)>0;
    }
}
