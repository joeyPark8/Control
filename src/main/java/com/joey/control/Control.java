package com.joey.control;

import java.util.HashMap;
import java.util.Map;

public class Control {
    public static Map<String, Boolean> controlMap = new HashMap<>() {{
        put("chat", true);
        put("command", true);
        put("movement", true);
        put("attack", true);
        put("damage", true);
        put("interaction", true);
        put("breaking", true);
        put("placement", true);
        put("crafting", true);
        put("join-message", true);
        put("quit-message", true);
    }};
}
