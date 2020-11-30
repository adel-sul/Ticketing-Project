package com.cybertek.entity;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseEntity {

    private Long id;
    private LocalDateTime insertSateTime;
    private LocalDateTime lastUpdateDateTime;
    private Long insertUserId;
    private Long lastUpdateUserId;

}
