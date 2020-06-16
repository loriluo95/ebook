package main.java.com.ebookstore.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class CreditCard implements Serializable
{
    private static final long serialVersionUID = -6091579459463730482L;

    @Id
    @GeneratedValue
    private int creditCardId;

    @NotNull(message = "The credit card number must not be null.")
    private String creditCardNumber;

    @NotNull(message = "The expiration month must not be null.")
    private String expirationMonth;

    @NotNull(message = "The expiration year must not be null.")
    private String expirationYear;

    @NotNull(message = "The credit card name must not be null.")
    private String creditCardName;

    @NotNull(message = "The credit card CVV must not be null.")
    private String cardVerificationValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customerId")
    private Customer customer;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardVerificationValue() {
        return cardVerificationValue;
    }

    public void setCardVerificationValue(String cardVerificationValue) {
        this.cardVerificationValue = cardVerificationValue;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }


    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
