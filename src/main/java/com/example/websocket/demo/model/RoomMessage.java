package com.example.websocket.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RoomMessage {
    private String userId;
    private String msg;
}
