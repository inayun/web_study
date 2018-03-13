package web_work;

public class work4 {

	public static void main(String[] args) {

		int totalCount = 12; //총 게시글 수 
		int pageboardCount = 3; //한 페이지당 게시글 수 
		int pagepageCount = 3; //페이지의 페이지 수
		int showpageCount = 0; //출력되어야 하는 페이지의 수 
		int curPage = 2;

		if(totalCount < pageboardCount) { //한 페이지당 게시글 수보다 작을경우에는 1페이지로 설정
			showpageCount = 1;
		} else { //전체 글수를 페이지별카운트로 나눈 몫 수 + 나머지 수 
			showpageCount += (totalCount / pageboardCount) + (totalCount % pageboardCount);
		}



		if(showpageCount - pagepageCount > 0) { //출력되는 페이지 수가 페이지의 페이지수를 넘는경우 화살표 출력

			
			
			for(int i = 0; i < pagepageCount; i++) {
				if((i+1)== curPage) {
					System.out.printf("[%d] ",i+1);
				} else {
					System.out.printf("%d ",i+1);
				}
			}
			System.out.print(" ▶");

		}

		System.out.println();

		for(int i = 0; i < showpageCount; i++) {

			if((i+1)== curPage) {
				System.out.printf("[%d] ",i+1);
			} else {
				System.out.printf("%d ",i+1);
			}
		}	

	}
}
