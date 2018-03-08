package web_work;
import java.util.Scanner;

public class Algoprac {
	 public static void main(String[] args) {
	      int totalCount = 121;                              // 가져온 전체글 수
	      int countUnit = 10;                               // 페이지당 카운트 단위
	      int unitCount = 5;                                  // 카운트단위의 카운트
	      int currentCount = 1;                               // 지금 사용자가 조회하고있는 페이지.

	      //--------------------testCase------------------------------------------
	      PagingModule pagingModule = new PagingModule();
	      totalCount = 111;
	      System.out.println(pagingModule.testDivider(totalCount, countUnit, currentCount));
	      currentCount = 5;
	      System.out.println(pagingModule.pageDivider(totalCount, countUnit, unitCount, currentCount));
	      currentCount = 2;
	      System.out.println(pagingModule.pageDivider(totalCount, countUnit, unitCount, currentCount));
	      currentCount = 7;
	      System.out.println(pagingModule.pageDivider(totalCount, countUnit, unitCount, currentCount));
	      currentCount = 11;
	      System.out.println(pagingModule.pageDivider(totalCount, countUnit, unitCount, currentCount));

	   }

}
