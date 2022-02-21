package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderRecieved;

@Repository
@Qualifier(value="OrderRecieved")

public interface OrderRecievedRepository extends JpaRepository <OrderRecieved, Long> {

}
