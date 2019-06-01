package com.store.model.basic;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String email;
    private String name;
    private String nick;
    private String passwd;

}
