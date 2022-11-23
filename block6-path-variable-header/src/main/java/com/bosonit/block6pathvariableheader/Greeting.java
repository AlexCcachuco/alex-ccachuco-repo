package com.bosonit.block6pathvariableheader;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Greeting {

    private long id;

    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
