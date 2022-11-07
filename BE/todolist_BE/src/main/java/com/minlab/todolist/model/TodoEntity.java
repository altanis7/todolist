package com.minlab.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder                //오브젝트 생성을 위한 디자인 패턴 중 하나. 롬복이 제공하여 Builder 클래스를 따로 개발하지 않고도 Builder 패턴을 사용해 오브젝트를 생성할 수 있다.
@NoArgsConstructor      //매개변수가 없는 생성자를 구현해 준다.
@AllArgsConstructor     //클래스의 모든 멤버 변수를 매개변수로 받는 생성자를 구현해준다.
@Data                   //클래스 멤버 변수의 Getter/Setter 메서드를 구현해 준다.
@Entity                 //이름을 부여하고 싶다면 @Entity("TodoEntity") 같이 사용하면 된다.
@Table(name = "Todo")   //데이터베이스의 Todoo 테이블에 매핑된다는 뜻.
public class TodoEntity {
    @Id                                                             // 기본 키가 될 필드를 지정.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                                              // 이 오브젝트의 아이디
    private String title;                                           // Todo 타이틀(예 : 운동하기)
    private Boolean done;                                           // true - todo 를 완료한 경우(checked)
}
