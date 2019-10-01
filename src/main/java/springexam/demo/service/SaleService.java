package springexam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springexam.demo.entity.Sale;
import springexam.demo.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).orElse(null);
    }


}