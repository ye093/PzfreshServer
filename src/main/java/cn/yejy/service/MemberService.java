package cn.yejy.service;

import cn.yejy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Map<String, Object> findUserByMobile(String mobile) {
        return memberRepository.findMemberByMobile(mobile).intoMap();
    }
}
