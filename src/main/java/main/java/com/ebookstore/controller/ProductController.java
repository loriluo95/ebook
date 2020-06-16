package main.java.com.ebookstore.controller;

import main.java.com.ebookstore.dao.CustomerDao;
import main.java.com.ebookstore.dao.ProductDao;
import main.java.com.ebookstore.model.Comment;
import main.java.com.ebookstore.model.Product;
import main.java.com.ebookstore.service.CommentService;
import main.java.com.ebookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

//import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

// This controller is in charge of handling any events that control products
@Controller
public class ProductController
{
    // productDao accesses the database of products
    @Autowired
    private ProductDao productDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ProductService productService;

    // This method shows the details of a specific product
    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException
    {
        // get the product the user wants to look at
        Product product = productDao.getProductById(productId);

        // adds the product to the model
        model.addAttribute(product);

        // view product specific page
        return "viewProduct";
    }

    @RequestMapping("/productList/viewProduct/addComment/{productId}")
    public String addComment(@PathVariable(value = "productId")  int productId, Model model)
    {
        Comment comment = new Comment();

        Product product = productService.getProductById(productId);

        //Customer customer = new Customer();

        comment.setProduct(product);
        //comment.setCustomer(customer);

        model.addAttribute("comment", comment);

        return "addComment";
    }

    @RequestMapping(value="/productList/viewProduct/addComment/{productId}", method = RequestMethod.POST)
    public String addCommentPost(@ModelAttribute("productId") int productId,@Valid @ModelAttribute("comment") Comment comment, BindingResult result, HttpServletRequest request)
    {

        if(result.hasErrors()) {
            System.out.println(result.getFieldError());
            return "addComment";
        }

        Product product = productService.getProductById(productId);
        //
        double rating = product.getNumrating();
        rating++;
        product.setNumrating(rating);
        double totalRating = product.getTotal_rating();
        totalRating = totalRating + comment.getRating();
        product.setTotal_rating(totalRating);
        product.setRating();
        //

        List<Comment> commentList = product.getComment();
        commentList.add(comment);

        product.setComment(commentList);
        comment.setProduct(product);
        productService.addProduct(product);
        commentService.addComment(comment);


        return "redirect:/productList/viewProduct/"+productId;
    }

    @RequestMapping("/productList/viewProduct/editComment/{id}")
    public String editComment(@PathVariable("id") int id, Model model) {
        Comment comment = commentService.getCommentById(id);

        model.addAttribute("comment", comment);

        return "editComment";
    }

    @RequestMapping(value="/productList/viewProduct/editComment", method = RequestMethod.POST)
    public String editCommentPost(@Valid @ModelAttribute("comment") Comment comment, BindingResult result,
                                  HttpServletRequest request) {
        if(result.hasErrors()) {
            return "editComment";
        }

        commentService.editComment(comment);

        return "redirect:/productList/viewProduct";
    }

    @RequestMapping("/productList/viewProduct/deleteComment/{id}")
    public String deleteComment(@PathVariable int id, Model model, HttpServletRequest request) {

        Comment comment = commentService.getCommentById(id);
        commentService.deleteComment(comment);

        return "redirect:/productList/viewProduct";
    }


    // This method returns a list sorted by authors
    @RequestMapping("/productList/sortedAuthors")
    public String sortByAuthor(Model model)
    {
        // Creates list of products sorted by author
        List<Product> products = productDao.sortBooksByAuthor();

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by authors
        return "sortedBooks";
    }

    // This method returns a list sorted by title
    @RequestMapping("/productList/sortedTitle")
    public String sortByTitle(Model model)
    {
        // Creates list of products sorted by title
        List<Product> products = productDao.sortBooksByTitle();

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by titles
        return "sortedBooks";
    }

    // This method returns a list sorted by price
    @RequestMapping("/productList/sortedPrice")
    public String sortByPrice(Model model)
    {
        // Creates list of products sorted by price
        List<Product> products = productDao.sortBooksByPrice();

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by price
        return "sortedBooks";
    }

    // This method returns a list sorted by rating

    @RequestMapping("/productList/sortedBookRating")
    public String sortByBookRating(Model model)
    {
        // Creates list of products sorted by rating
        List<Product> products = productDao.sortBooksByRating();

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by rating
        return "sortedBooks";
    }


    @RequestMapping("/productList/sortedBookTopSellers")
    public String sortByBookTopSellers(Model model)
    {
        // Creates list of products sorted by top sellers
        List<Product> products = productDao.sortBooksByTopSellers();

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by top sellers
        return "sortedBooks";
    }

    // This method returns a list sorted by release date
    @RequestMapping("/productList/sortedReleaseDate")
    public String sortByReleaseDate(Model model)
    {
        List<Product> products = productDao.sortBooksByReleaseDate();

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by release date
        return "sortedBooks";
    }

    @RequestMapping("/productList/viewOtherBooks/{productId}")
    public String getProductsByAuthor(@PathVariable int productId, Model model)
    {
        Product product = productDao.getProductById(productId);
        List<Product> products = productDao.getAllProductsByAuthor(product.getProductAuthor());

        // adds the list to the model
        model.addAttribute("products", products);

        // view products sorted by release date
        return "sortedBooks";
    }



}
