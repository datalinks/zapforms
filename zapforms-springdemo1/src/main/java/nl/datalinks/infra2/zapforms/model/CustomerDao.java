package nl.datalinks.infra2.zapforms.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Chris
 */

@ComponentScan("nl.datalinks.infra2.zapforms.model")
public class CustomerDao {
 

    private static final org.slf4j.Logger log  = LoggerFactory.getLogger(CustomerDao.class);


    public static List<Customer> getCustomers(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        List<Customer> customers = null;
        try{
            customers = (List<Customer>)session.createQuery("FROM Customer").list();
        }catch(Exception ex){
            String exceptionMessage = "Exception getting customer, message: "+ex.getMessage();
            log.error(exceptionMessage);
        }finally{
            session.close();
        }
        return customers;
    }

    
    public static Customer getCustomer(String idParam, SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Customer customer = null;
        try{
            int id = new Integer(idParam).intValue();
            customer = (Customer)session.get(Customer.class,id);
        }catch(Exception ex){
            String exceptionMessage = "Exception getting customer, message: "+ex.getMessage();
            log.error(exceptionMessage);
        }finally{
            session.close();
            if(customer==null){
                customer = new Customer();
                customer.setId(0);
                customer.setName("not found");
                customer.setBalance(0);
            }
        }
        return customer;
    }

    
    public static void saveBalance(String idParam, double newBalance, SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        try{
            Transaction tx = session.beginTransaction();
            int id = new Integer(idParam).intValue();
            Customer customer = (Customer)session.get(Customer.class,id);
            customer.setBalance(newBalance);
            System.out.println("saving customer with balance: "+customer.getBalance());
            tx.commit();
        }catch(Exception ex){
            String exceptionMessage = "Exception getting customer, message: "+ex.getMessage();
            log.error(exceptionMessage);
        }finally{
            session.close();
        }
    }

    
}
