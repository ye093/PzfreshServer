package cn.yejy.repository;

import static cn.yejy.jooq.domain.tables.CrmMember.CRM_MEMBER;

import cn.yejy.jooq.domain.tables.CrmMember;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRepository {
    @Autowired
    DSLContext dsl;

    public Record findMemberByMobile(String mobile) {
        CrmMember m = CRM_MEMBER.as("m");
        return dsl.select().from(m).where(m.MOBILE.eq(mobile)).fetchOne();
    }

}
