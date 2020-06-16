package main.java.com.ebookstore.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable
{

    private static final long serialVersionUID = 5140900014886997914L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty(message = "The customer name must not be null.")
    private String customerName;

    @NotEmpty (message = "The customer email must not be null.")
    private String customerEmail;
    private String customerPhone;

    private String nickname;

    @NotEmpty (message = "The customer username must not be null.")
    private String username;

    @NotEmpty (message = "The customer password must not be null.")
    private String password;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="creditCardId")
    private CreditCard creditCard;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="ratingId")
   // private Rating rating;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="commentId")
    //private Comment comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditcard) {
        this.creditCard = creditcard;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

