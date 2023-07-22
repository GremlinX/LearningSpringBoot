package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

/**
 * Repositories must be interfaces because "JPARepository" are also interfaces
 * For this class, it's not necessary insert the "@Repository" cause 
 * "JpaRepository" already have that.
 * So it is optional to give the annotation for this class.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
