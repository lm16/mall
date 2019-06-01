package com.store.model.viewModel;

import lombok.Data;

@Data
public class CommentsVM {

    private Integer id;
    private String time;

    private String content;
    private Byte star;

    // inner join
    private String nick;

}
