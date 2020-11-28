package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

import java.util.List;

public interface UserService {
    public User save(User user);
    public void delete (User user);
    public User findOneById(Long id);
    public User findOneByEmail(String email);
    long count();
    List<User> getAll(String sortType);
    User findByUserName(String username);
    public void userToggleBan(Long id);
    List<User> findAll();
}
