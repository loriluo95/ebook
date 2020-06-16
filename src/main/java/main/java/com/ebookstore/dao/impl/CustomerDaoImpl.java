package main.java.com.ebookstore.dao.impl;

import main.java.com.ebookstore.dao.CustomerDao;
import main.java.com.ebookstore.model.Authorities;
import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.Customer;
import main.java.com.ebookstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@ImportResource("classpath*:/resources/applicationContext.xml")
public class CustomerDaoImpl implements CustomerDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session  = sessionFactory.getCurrentSession();

        customer.getShippingAddress().setCustomer(customer);
        customer.getCreditCard().setCustomer(customer);
        if (customer.getNickname().isEmpty())
        {
            customer.setNickname("Anonymous");
        }

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getShippingAddress());
        session.saveOrUpdate(customer.getCreditCard());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = ((Query) query).list();

        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Customer WHERE username = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

    public void deleteCustomer(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getCustomerById(id));
        session.flush();
    }

    public void editCustomer(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();

        customer.getShippingAddress().setShippingAddressId(customer.getCustomerId());
        customer.getCreditCard().setCreditCardId(customer.getCustomerId());
        customer.getShippingAddress().setCustomer(customer);
        customer.getCreditCard().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getShippingAddress());
        session.saveOrUpdate(customer.getCreditCard());

        Cart newCart = new Cart();
        newCart.setCartId(customer.getCustomerId());
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }


}
