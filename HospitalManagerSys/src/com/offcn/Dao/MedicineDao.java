package com.offcn.Dao;

import com.offcn.Bean.Medicine;
import com.offcn.Utils.LimitTool;

import java.util.List;

public interface MedicineDao {
    public int QueryTotaoCount(String name, String type);
    public List<Medicine> QueryMedicineByKey(String name, String type, LimitTool tool);
    public Medicine QueryMedicineById(String mid);
    public int InsertMedicine(Medicine medicine);
    public int DeleteMedicineByMids(String mids);
    public int ModifyMedicine(Medicine medicine);
}
