package myexam.service.user;

import myexam.domain.models.view.UserServiceModel;

public interface UserService {
    UserServiceModel getUserByUsername(String username);

    UserServiceModel createUser(UserServiceModel userServiceModel);
}
