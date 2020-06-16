package main.java.com.ebookstore;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:/resources/applicationContext.xml")

public class EbookApplication extends SpringBootServletInitializer {
    //    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(EbookApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(EbookApplication.class, args);
    }
}
