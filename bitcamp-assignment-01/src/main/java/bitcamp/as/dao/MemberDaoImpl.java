package bitcamp.as.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitcamp.as.domain.Member;
@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SqlSessionTemplate sessionTemplate;
    
    @Override
    public Member getMember(String id) {
        return sessionTemplate.selectOne("getMember", id);
    }

    @Override
    public int insert(Member member) {
  
        return sessionTemplate.insert("insert", member);
    }

    @Override
    public int delete(String id) {
        
        return sessionTemplate.delete("delete", id);
    }

}
