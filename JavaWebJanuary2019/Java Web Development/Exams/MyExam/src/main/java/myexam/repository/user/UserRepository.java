package myexam.repository.user;

import myexam.domain.entities.User;
import myexam.repository.GenericRepository;

public interface UserRepository extends GenericRepository<User, String> {
    User findByUsername(String username);
}
