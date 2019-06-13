package com.netcracker.spring.Data.service;


import com.netcracker.spring.Data.repository.ShopRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service("shopService")
@RequiredArgsConstructor
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

   public List<String> findNamesByDistricts(String ... districts){
        List<String> result=new ArrayList<>();
        for(String district: districts){
            result.addAll(
                    shopRepository.findByDistrict(
                            district)
                            .stream()
                            .map(x-> "name="+x.getName())
                            .collect(Collectors.toList()));
        }
        return result;
    }
}
