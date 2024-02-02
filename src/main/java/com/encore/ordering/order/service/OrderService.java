package com.encore.ordering.order.service;

import com.encore.ordering.member.domain.Member;
import com.encore.ordering.member.repository.MemberRepository;
import com.encore.ordering.order.domain.Ordering;
import com.encore.ordering.order.dto.request.OrderRequest;
import com.encore.ordering.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, MemberRepository memberRepository) {
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
    }

    public Ordering create(OrderRequest orderRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member findMember = memberRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new EntityNotFoundException("Member Email Not Found"));

        return null;
    }
}
