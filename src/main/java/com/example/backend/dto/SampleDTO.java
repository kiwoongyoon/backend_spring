package com.example.backend.dto;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Builder(toBuilder = true)
public class SampleDTO {
    private long sno;
    private String first;
    private String last ;
    private LocalDateTime regTime;

//    개발자의 의도대로 하기 위해 setter를 설정한다 (에러를 잡아내기)
//
}
