package com.example.RegisterLogin.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.RegisterLogin.Entity.Block;

@Repository
@EnableJpaRepositories
public interface BlockRepo extends JpaRepository<Block,Integer>{

    List<Block> findAllByOrderByIdDesc();

}
