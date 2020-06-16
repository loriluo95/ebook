package main.java.com.ebookstore.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

// adds this class to database. An instance of this corresponds to a row
@Entity
public class Product implements Serializable
{
    private static final long serialVersionUID = -3532377236419382983L;

    @Id // unique id
    @GeneratedValue(strategy = GenerationType.AUTO) // generates products ID as they are added
    private int productId;
    private String productName;
    private String productAuthor;
    private String productAuthorBio;
    private String productCategory;
    private String productDescription;
    private double productPrice;
    private String productCondition;
    private String productStatus;
    private Date productReleaseDate;
    private int unitInStock;
    private String productPublisher;
    private String topSellerStatus;

    @JoinColumn(name="rating") // average of total ratings
    private double rating = 0.0;
    @JoinColumn(name="totalrating") // total rating
    private double total_rating= 0.0;
    @JoinColumn(name="#ofrating") // number of ratings
    private double numrating = 0.0;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    //@Column(name="commentId")
    private List<Comment> comment;

    @Transient
    private MultipartFile productImage;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductAuthor() {
        return productAuthor;
    }

    public void setProductAuthor(String productAuthor) {
        this.productAuthor = productAuthor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductPublisher() {
        return productPublisher;
    }

    public void setProductPublisher(String productPublisher) {
        this.productPublisher = productPublisher;
    }

    public Date getProductReleaseDate()
    {
        return productReleaseDate;
    }

    public void setProductReleaseDate(Date productReleaseDate)
    {
        this.productReleaseDate = productReleaseDate;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }


    public String getTopSellerStatus() {
        return topSellerStatus;
    }

    public void setTopSellerStatus(String topSellerStatus) {
        this.topSellerStatus = topSellerStatus;
    }

    public String getProductAuthorBio() {
        return productAuthorBio;
    }

    public void setProductAuthorBio(String productAuthorBio) {
        this.productAuthorBio = productAuthorBio;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating() { this.rating = total_rating/numrating; }

    public double getTotal_rating() { return total_rating; }

    public void setTotal_rating(double total_rating) { this.total_rating = total_rating; }

    public double getNumrating() { return numrating; }

    public void setNumrating(double numrating) { this.numrating = numrating; }
}
