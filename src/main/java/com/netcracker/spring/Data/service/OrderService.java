package com.netcracker.spring.Data.service;

import com.netcracker.spring.Data.repository.OrderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service("orderService")
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

   public List<Integer> findDistrictMonth(){
        return orderRepository.findDistinctDate().stream().map(x-> x.getMonth()).collect(Collectors.toList());
    }

    public List<String> findNameAndShopForAll(){
       return orderRepository.findAll()
               .stream()
               .map(x-> "name="+x.getCustomer().getLastName()+" shop="+x.getSeller().getName())
               .collect(Collectors.toList());

    }
    public List<String> findAllInfoForAll(){
        return orderRepository.findAll()
                .stream()
                .map(x-> "Дата="+x.getDate()
                        +" Фамилия="+x.getCustomer().getLastName()
                        +" Скидка="+x.getCustomer().getSale()
                        +" Название="+x.getBook().getName()
                        +" Количество="+x.getCount())
                .collect(Collectors.toList());
    }

    public List<String> findByCostGreaterThanEqual(Integer cost){
       return orderRepository.findByCostGreaterThanEqual(cost)
               .stream()
               .map(x->"номер заказа="+x.getId()
                       + " фамилия покупателя="+ x.getCustomer().getLastName()
                       +" дата покупки="+x.getDate())
               .collect(Collectors.toList());
    }

    public List<String> findByDateLessThanEqual(Date date){
       return orderRepository.findAll()
               .stream()
               .filter(x-> date.getMonth()<=x.getDate().getMonth())
               .filter(x-> x.getCustomer().getDistrict().equals(x.getSeller().getDistrict()))
               .map(x-> "фамилия покупателя="+x.getCustomer().getLastName()
                       + " район="+ x.getCustomer().getDistrict()
                       + " дата="+x.getDate())
               .collect(Collectors.toList());
    }

    public List<String> findBySaleExceptDistrict(int saleFrom,int saleTo,String District){
       return orderRepository.findAll()
               .stream()
               .filter(x-> !x.getSeller().getDistrict().equals(District))
               .filter(x-> x.getCustomer().getSale()>=saleFrom&& x.getCustomer().getSale()<=saleTo)
               .map(x-> x.getSeller().toString())
               .collect(Collectors.toList());

    }

    public List<String> allInfo(){
       return orderRepository.findAll()
               .stream()
               .filter(x-> x.getBook().getStorage().equals(x.getSeller().getDistrict())&& x.getBook().getCount()>10)
               .map(x->x.getBook())
               .distinct()
               .sorted(Comparator.comparingInt(a -> (a.getPrice() * a.getCount())))
               .map(x-> "название="+x.getName()
                       +" район складирования=" +x.getStorage()
                       +" количество="+x.getCount()
                        +"стоимость="+x.getCount()*x.getPrice())

               .collect(Collectors.toList());
    }
}