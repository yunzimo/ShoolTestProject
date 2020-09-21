package com.offcn.Dao;

import com.offcn.Bean.Register;
import com.offcn.Utils.LimitTool;

import java.util.List;

public interface RegisterDao {
    public int TotalCount(String rid, String name, String department);
    public List<Register> QueryRegisterByKey(String rid, String name, String department, LimitTool tool);
    public int InsertRegisterInfo(Register register);
    public Register QueryRegisterByRid(String rid);
    public int DeleteRegisterByRids(String rids);
    public int ModifyRegisterByKey(Register register);
    public void DeleteByDids(String dids);
}
