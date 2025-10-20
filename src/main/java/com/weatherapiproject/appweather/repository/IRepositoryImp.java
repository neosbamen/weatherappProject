package com.weatherapiproject.appweather.repository;


import com.weatherapiproject.appweather.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryImp extends JpaRepository<User,Long> {
}
