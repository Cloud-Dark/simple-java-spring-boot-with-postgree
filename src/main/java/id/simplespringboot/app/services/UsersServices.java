package id.simplespringboot.app.services;

import id.simplespringboot.app.model.Users;
import id.simplespringboot.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServices {

    @Autowired protected UsersRepository usersRepository;

    @Transactional
    public Users insertUsers(Users users) {
        return usersRepository.save(users);
    }

    @Transactional
    public Users updateUsers(Long id, Users users) {
        users.setId(id);
        usersRepository.save(users);

        return users;
    }

    public Users getUsersById(Long id) {
        return usersRepository.getById(id);
    }

    @Transactional
    public void deleteUsers(Long id) {
        Users users = usersRepository.getById(id);
        usersRepository.delete(users);
    }

    public List<Users> getList() {
        return usersRepository.findAll();
    }
}
