package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("alexg@yandex.ru", "Alexander Grishin");
        hashMap.put("zverevvasya@mail.ru", "Vasiliy Alibabaevich");
        hashMap.put("ivannosov@mail.ru", "Ivan Nosov");
        hashMap.put("zverevvasya@mail.ru", "Vasiliy Zverev");
        hashMap.put("vladsidorov@inbox.ru", "Vladimir Sidorov");
        hashMap.put("alexg@yandex.ru", "Alexander Grishkin");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("mail: " + entry.getKey() + " user: " + entry.getValue());
        }
    }
}
