package org.example.services;

import org.example.Shape;
import org.example.repositories.ShapeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {
    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public <T extends Shape> T saveShape(T shape) {
        return shapeRepository.save(shape);
    }

    public <T extends Shape> List<T> findAll(Class<T> shapeType) {
        return shapeRepository.findAllByType(shapeType.getSimpleName());
    }
}
