package com.anta.news.service;

import com.anta.news.repository.TypeRepository;
import com.anta.news.entity.Type;
import com.anta.news.exception_handling.NoSuchNewsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getType(int id) {
        Optional<Type> typeOptional = typeRepository.findById(id);

        if (typeOptional.isPresent()) {
            return typeOptional.get();
        } else throw new NoSuchNewsException();
    }

    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    public Type updateType(int id, Type type) {
        return typeRepository.save(type);
    }

    public boolean deleteType(int id) {
        Optional<Type> typeOptional = typeRepository.findById(id);

        if (typeOptional.isPresent()) {
            typeRepository.deleteById(id);
            return true;
        } else return false;
    }
}
