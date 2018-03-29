package com.example.spring.service.board;

public class PagingService {

	   //---------------페이지가 총 몇개인지 테스트 하는 메소드 -------------------------------------------------
	   public String testDivider(int totalCount, int countUnit, int currentCount) {
	      String result = "";                                 // 결과값을 담을 변수

	      // 총 글 수를 단위로 나누었을때 맞아떨어지지 않으면 +1을 한다.
	      int page =                                        // 전체 페이지의 수
	            (   totalCount % countUnit == 0 ?                // 
	               totalCount / countUnit       : 
	               totalCount / countUnit + 1    );
	      for (int i = 1; i <= page; i++) {
	         if (currentCount == i) {
	            result += ("[" + i + "] ");
	         } else {
	            result += (i + " ");
	         }
	         // 하나씩 숫자를 더하여 출력한다.
	      }
	      return result;
	   }
	   //-----------------------------------------------------------------------------------------
	   
	   //-----------------------------페이지 나눠주는 메소드----------------------------------------------
	   public static String pageDivider(int totalCount, int countUnit, int unitCount, int currentCount) {
	      
	        StringBuffer stringBuffer = new StringBuffer();
	      String result = "";
	      int temp = 0;
	   
	      int page = (totalCount % countUnit == 0 ? totalCount / countUnit : totalCount / countUnit + 1);
	      // 총 글 수를 단위로 나누었을때 맞아떨어지지 않으면 +1을 한다.

	   // -------------------------시작점, 끝점을 알기 위한 계산-------------------------
	         int end = (currentCount / unitCount) + 1;
	         if (currentCount % unitCount == 0)
	            end--;
	         int endNum = end * unitCount;
	         int startNum = endNum - unitCount + 1;
	         int formal = 0; //이전 화살표의 목표번호 값이 얼마인가 나중에 대입해줄때 필요한 변수
	         stringBuffer.append("<p id='down'>");
	           
	         if (currentCount > unitCount) {
	            stringBuffer.append("<a href='javascript:goPage("+(startNum-1)+")'> << &nbsp &nbsp</a>");
	         }
	         //--------------------시작 숫자부터 마지막 숫자까지 순환----------------------
	         for (int i = startNum; i <= page; i++) {
	         //지금 페이지 표시
	            if (i <= unitCount * end) {
	               if (currentCount == i) {
	              
	                  stringBuffer.append("[" + i + "]&nbsp &nbsp");
	               
	               
	               } else {
	               
	                  stringBuffer.append("<a href='javascript:goPage("+i+")'>"+i+"&nbsp &nbsp</a>");
	               
	               
	               }
	               
	            } else {
	               stringBuffer.append("<a href='javascript:goPage("+(i)+")'> >> &nbsp &nbsp</a>");
	               break;
	            }
	         }
	         stringBuffer.append("</p>");
	         return stringBuffer.toString();
	      }
	      //-----------------------------------------------------------------------------------------
	
	
}
