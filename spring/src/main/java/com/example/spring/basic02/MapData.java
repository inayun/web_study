package com.example.spring.basic02;

import java.util.HashMap;
import java.util.Map;

public class MapData {

   // 전역 변수로 Map 객체(key값이 String, value값이 Long)를 참조하는 data 참조 변수 생성
   private Map<String, Long> data = new HashMap<String, Long>();
   
   // 인자가 없는 기본 생성자가 호출되면 멤버인 Map에 아래와 같은 key값과 value 값을 넣어준다.
   public MapData() {
      this.data.put("first", 39285710L);
      this.data.put("second", 130000000L);
   }
   
   // String으로 key값을 전달 받으면 그 key 값에 해당하는 value 값을 꺼내 온다.
   public Long findLong(String entry) {
      return this.data.get(entry);
   }
   
}