package com.example.backend.repository;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

//jpa를 이용해서 데이터베이스와 연결을 해주는 인터페이스의 역할을 수행한다.
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findById(int id) ;

    //내가 직접 만들고 싶은 쿼리가 있을 수 있으니 이런 경우에는 아래와 같이
    //작성해야 한다. 새로운 findby를 정의해서 사용한다
    @Query("select m from Member m where m.name= :name and m.id= :id")
    Member findMemberByIdAndName(@Param("name") String name , @Param("id") int id);

    @Transactional
    @Modifying
    @Query("update Member m set m.name =:name where m.id= :id")
    int updateMember(@Param("name")String name , @Param("id") int id);
    //정의는 하지 않고 ANNOTATION으로 명시를 해주면 자동으로 자바가 작동시켜준다
}