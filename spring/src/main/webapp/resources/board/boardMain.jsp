<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h1 align="center">BOARD PROJECT</h1>


<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="http://images.samsung.com/is/image/samsung/sec-html-feature-galaxy-sm-a520-n-f1-before?$ORIGIN_JPG$" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="https://i1.daumcdn.net/thumb/C720x360/?fname=http://t1.daumcdn.net/brunch/service/user/mbh/image/BKSX47BN8AwI35FyGJKjM_eugYo" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="https://d-pt.ppstatic.pl/kadry/k/r/1/78/0d/5883dc76db9f4_o,size,969x565,q,71,h,a2ba9d.jpg" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>














<div align="center">
<a href="/boardInsert" >글 작성하기</a><br>
<a href="/boardList.do?" >글 전체목록보기</a><br>
</div>

</body>
</html>