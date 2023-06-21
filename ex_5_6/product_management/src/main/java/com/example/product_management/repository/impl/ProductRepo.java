package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.ConnectionUtils;
import com.example.product_management.repository.IProductRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static final String SELECT_ALL= "from Product";

//    private static List<Product> products=new ArrayList<>();
//    static {
//        products.add(new Product(1,"SamSung Note 9",12000,"Super AMOLED 6.4 Quad HD+ (2K+)","Sam Sung"));
//        products.add(new Product(2,"SamSung Note 10",13000," Dynamic AMOLED, HDR10+ ; Size, 6.3 inches,","Sam Sung"));
//        products.add(new Product(3,"Iphone 13 ",14000,"Super Retina XDR OLED, HDR10, Dolby Vision","Apple"));
//        products.add(new Product(4,"Iphone 14",15000," Super Retina XDR OLED, HDR10, Dolby Vision, 800 nits (HBM), 1200 nits (peak) ; Size, 6.1 inches, 90.2 cm2)","Apple"));
//        products.add(new Product(5,"Oppo F11",16000,"Dimensions: 76.1 x 162 x 8.3 mm ; Weight: 188 g ; SoC: MediaTek Helio P70","OPPO"));
//        products.add(new Product(6,"Oppo Reno 11",17000,"DISPLAY: 6.77 inches · Camera: 5+16+108 MP · RAM: 12/14 GB ","OPPO"));
//    }


    @Override
    public List<Product> getProducts() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL).getResultList();
    }

    @Override
    public void create(Product product) {
        Session session=null;
        Transaction transaction=null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        Session session=null;
        Transaction transaction=null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            session.update(product);
            transaction.commit();
            ConnectionUtils.getEntityManager().clear();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session=null;
        Transaction transaction=null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            session.remove(findByID(id));
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public Product detail(int id) {
        return (Product) ConnectionUtils.getEntityManager().createQuery("from Product where id=" + id).getSingleResult();
    }

    @Override
    public List<Product> search(String name) {
        try{
            return  ConnectionUtils.getEntityManager().createQuery("from Product where name like '%" + name + "%'").getResultList();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Product findByID(int id) {
//        Session session=ConnectionUtils.getSessionFactory().openSession();
//        TypedQuery<Product> typedQuery=session.createQuery("from Product where id=:id");
//        typedQuery.setParameter("id",id);
//        typedQuery.getSingleResult();
        try{
            return (Product) ConnectionUtils.getEntityManager().createQuery("from Product where id=" + id).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
}
