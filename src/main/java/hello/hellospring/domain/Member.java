package hello.hellospring.domain;

public class Member {

    private Long id; //시스템 저장 할때 등록되는 시스템이 정해준것
    private String name; //회원가입시 적는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
