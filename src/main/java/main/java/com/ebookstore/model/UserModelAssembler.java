package main.java.com.ebookstore.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import main.java.com.ebookstore.controller.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {
        return new EntityModel(user, //
                linkTo(methodOn(UserController.class).get(user.getUserId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users"));
    }
}
