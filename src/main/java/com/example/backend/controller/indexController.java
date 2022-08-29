package com.example.backend.controller;
import com.example.backend.dto.SampleDTO;
import com.example.backend.entity.Member;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
@Controller
@RequestMapping("/")
public class indexController {
    @Autowired
//   repository에서 엔티디의 리스트를 갖고온다
    MemberRepository memberRepository ;


    @GetMapping({"/ex2"})
    public void exModel(Model model){
        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(
            i->{
                SampleDTO dto =SampleDTO.builder()
                        .sno(i)
                        .first("First.."+ i)
                        .last("last.." +i)
                        .regTime(LocalDateTime.now())
                        .build() ;
                return dto ;
            }
        ).collect(Collectors.toList());
        model.addAttribute("list",list);
    }
}
