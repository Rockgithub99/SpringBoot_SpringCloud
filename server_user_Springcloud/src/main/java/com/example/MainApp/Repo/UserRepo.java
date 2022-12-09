package com.example.MainApp.Repo;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MainApp.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {


}
