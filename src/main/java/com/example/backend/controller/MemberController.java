package com.example.backend.controller;

import com.example.backend.dto.MemberDTO;
import com.example.backend.entity.Member;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//조회 화면에서 제이슨 형식으로 데이터 보여주기
//사이트의 주소에 api 와 members로 데이터에 등록된 정보를 보여준다.
//localhost:8080/api/members에 들어가게 되면 id, pw , name이 출력된다.
@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberRepository memberRepository ;
    @GetMapping("/member")
    public Optional<Member> getMember(@RequestParam(value="memberId", defaultValue = "1") String memberId){
        Member member= memberRepository.findById(Integer.parseInt(memberId)) ;
        return Optional.ofNullable(member);
        //문자열을 숫자로 변형하려면 integer.parseint를 사용하면 된다.
        //RequestParam의 형식을 보면 value의 값에 받을 변수의 이름을 정하고 그 뒤에는 그 변수의 형식을 정한다. 여기선 string이다
        //
    }
    @GetMapping("/members")
    public List<MemberDTO> getMembers(){
        List<Member> _memberList= memberRepository.findAll();
        List<MemberDTO> memberList=_memberList.stream().map(_member ->{
            MemberDTO dto= MemberDTO.builder()
                    .id(_member.getId())
                    .pw(_member.getPw())
                    .name(_member.getName())
                    .build();
            return dto ;
        }).collect(Collectors.toList());
        return memberList;

    }
    //직접 만든 쿼리를 이용해보기 !!
    @GetMapping("/exactMember")
    public Member getExactMember(@RequestParam(value="memberId") String memberId, @RequestParam(value="name") String name) {
        Member member = memberRepository.findMemberByIdAndName(name, Integer.parseInt(memberId));
        return member;
    }
    @GetMapping("/updateMember")
    public Boolean updateMember(@RequestParam(value="memberId") String memberId, @RequestParam(value="name") String name) {
        if(memberRepository.updateMember(name, Integer.parseInt(memberId)) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
