package main.java.com.ebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

//@SpringBootApplication
//public class EbookApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(EbookApplication.class);
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(EbookApplication.class, args);
//    }
//}
@SpringBootApplication
@RequestMapping(path="/api")
public class EbookApplication {
    public static void main(String[] args) {
        SpringApplication.run(EbookApplication.class, args);
    }
}
