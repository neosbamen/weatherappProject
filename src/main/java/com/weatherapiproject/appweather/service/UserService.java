package com.weatherapiproject.appweather.service;

import com.weatherapiproject.appweather.model.User;
import com.weatherapiproject.appweather.repository.IRepositoryImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    IRepositoryImp iRepositoryImp;

    public List<User> allUserList(){

        return iRepositoryImp.findAll();
    }
    public void createUser(User user){
        iRepositoryImp.save(user);
    }
    public void deleteUser(Long id){
        Optional<User> userOptional=iRepositoryImp.findById(id);

        if (userOptional.isPresent()){
            iRepositoryImp.delete(userOptional.get());
        }else {
            System.out.println("User does not exist");
        }
    }
    public void updateUser(Long id,User user){

        Optional<User> userOptional = iRepositoryImp.findById(id);

        if (userOptional.isPresent()){
            userOptional.get().setName(user.getName());
            userOptional.get().setEmail(user.getEmail());
            userOptional.get().setValidationId(user.getValidationId());
            iRepositoryImp.save(userOptional.get());
        }else {
            System.out.println("No user match the input id");
        }
    }
}
