package service;
import com.example.narnia.model.Visitor;
import com.example.narnia.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import model.Visitor;

import java.util.List;

@Service
public class VisitorService {
    @Autowired
    private Repository repository;
    public Visitor saveVisitor(Visitor visitor){
        return repository.save(visitor);
    }

    public List<Visitor> getAllVisitors(){
        return repository.findAll();
    }
    public void deleteVisitor(Long id){
        return repository.countByInside(true);
    }
}
