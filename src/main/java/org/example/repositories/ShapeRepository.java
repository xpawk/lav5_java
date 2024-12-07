package org.example.repositories;

import org.example.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShapeRepository extends JpaRepository<Shape, Long> {
    @Query("SELECT s FROM Shape s WHERE TYPE(s) = :type")
    <T extends Shape> List<T> findAllByType(String type);
}
