package com.offcn.Service;

import com.offcn.Bean.Medicine;
import com.offcn.Dao.Imp.MedicineDaoImp;
import com.offcn.Dao.MedicineDao;
import com.offcn.Utils.LimitTool;

import java.util.List;

public class MedicineService {
    MedicineDao md=new MedicineDaoImp();
    public int QueryTotaoCount(String name,String type){
        return md.QueryTotaoCount(name,type);
    }
    public List<Medicine> QueryMedicineByKey(String name, String type, LimitTool tool){
        return md.QueryMedicineByKey(name,type,tool);
    }
    public Medicine QueryMedicineById(String mid){
        return md.QueryMedicineById(mid);
    }
    public boolean InsertMedicine(Medicine medicine){
        return md.InsertMedicine(medicine)>0;
    }
    public boolean DeleteMedicineByMids(String mids){
        return md.DeleteMedicineByMids(mids)>0;
    }
    public boolean ModifyMedicine(Medicine medicine){
        return md.ModifyMedicine(medicine)>0;
    }
}
