package com.offcn.Dao.Imp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.Bean.Medicine;
import com.offcn.Dao.MedicineDao;
import com.offcn.Utils.LimitTool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class MedicineDaoImp implements MedicineDao {
    @Override
    public int QueryTotaoCount(String name, String type) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        StringBuilder sql=new StringBuilder("select count(*) from medicine where 1=1");
        int count=0;

        if(name!=null&&(!name.equals(""))){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(type!=null&&(!type.equals("0"))&&(!type.equals(""))){
            sql.append(" and type=").append(type);
        }
        try{
            Long l=(long)qr.query(sql.toString(),new ScalarHandler<>());
            count=l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Medicine> QueryMedicineByKey(String name, String type, LimitTool tool) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        StringBuilder sql=new StringBuilder("select * from medicine where 1=1");

        if(name!=null&&(!name.equals(""))){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(type!=null&&(!type.equals("0"))&&(!type.equals(""))){
            sql.append(" and type=").append(type);
        }
        sql.append(" limit ?,?");
        try{
             return qr.query(sql.toString(), new BeanListHandler<Medicine>(Medicine.class), tool.getStartIndex(), tool.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medicine QueryMedicineById(String mid) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from medicine where mid=?";
        try{
            return qr.query(sql,new BeanHandler<Medicine>(Medicine.class),mid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int InsertMedicine(Medicine medicine) {
//        String mid, String picture, double inPrice, double salPrice, String name, int type, String descs, int qualityDate, String description, String produceFirm, String readme, String remark
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="insert into medicine values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            return  qr.update(sql,medicine.getMid(),medicine.getPicture(),medicine.getInPrice(),medicine.getSalPrice(),medicine.getName(),medicine.getType(),medicine.getDescs(),medicine.getQualityDate(),medicine.getDescription(),medicine.getProduceFirm(),medicine.getReadme(),medicine.getRemark());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int DeleteMedicineByMids(String mids) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="delete from medicine where mid in ("+mids+")";
        try{
           return qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int ModifyMedicine(Medicine medicine) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="update medicine set mid=?,picture=?,inPrice=?,salPrice=?,name=?,type=?,descs=?,qualityDate=?,description=?,produceFirm=?,readme=?,remark=? where mid=?";
        try{
            return  qr.update(sql,medicine.getMid(),medicine.getPicture(),medicine.getInPrice(),medicine.getSalPrice(),medicine.getName(),medicine.getType(),medicine.getDescs(),medicine.getQualityDate(),medicine.getDescription(),medicine.getProduceFirm(),medicine.getReadme(),medicine.getRemark(),medicine.getMid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
