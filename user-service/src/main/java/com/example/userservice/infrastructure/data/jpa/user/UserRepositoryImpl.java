package com.example.userservice.infrastructure.data.jpa.user;

import com.example.userservice.application.user.entity.User;
import com.example.userservice.application.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = (List<UserEntity>) jpaUserRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity: userEntities){
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            users.add(user);
        }
        return users;
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> userEntity = jpaUserRepository.findById(id);
        if (userEntity.isEmpty()){
            throw new NoSuchElementException();
        }
        User user = new User();
        BeanUtils.copyProperties(userEntity.get(), user);
        return user;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity = jpaUserRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public boolean deleteById(Long id) {
        jpaUserRepository.deleteById(id);
        return true;
    }
}
