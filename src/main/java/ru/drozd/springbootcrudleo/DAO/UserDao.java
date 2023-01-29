package ru.drozd.springbootcrudleo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.drozd.springbootcrudleo.model.User;

import java.util.List;

@Component
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers (){
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    public User getUserById(int id){
        return entityManager.find(User.class,id);
    }

    public void addUser(User user){ entityManager.persist(user); }

    public void removeUser(int id){
        entityManager.remove(getUserById(id));
    }

    public void updateUser(User user){ entityManager.merge(user); }

}
