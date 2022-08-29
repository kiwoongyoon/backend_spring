package com.example.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)

public class MemberDTO {
    private  int id;
    private  String pw ;
    private  String name ;
}
