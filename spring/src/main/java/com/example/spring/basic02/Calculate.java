package com.example.spring.basic02;

public class Calculate {
   // 전역 변수로 MapData 객체를 참조하는 mapData 참조 변수
   private MapData mapData;
   
   // mapData 참조 변수를 통해 findLong 메서드를 호출하여 인자로 전달하는 key값에 대한 value값을 불러오고 그 값을 나눠주는 메서드
   public String devide() {
      Long first = this.mapData.findLong("first");
      Long second = this.mapData.findLong("second");
      
      // 첫번째 값과 두번째 값을 나눈 결과를 String 형태로 반환해준다.
      return String.valueOf(first / second);
   }
   
   // mapData 객체를 인자로 전달받아 전역변수에 저장하는 메서드
   public void setMapData(MapData mapData) {
      this.mapData = mapData;
   }

   
}