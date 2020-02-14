<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html lang="kr">
	<head>

	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>http://www.blueb.co.kr</title>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
input[type="checkbox"]#menu_state {
  display: none;
}
input[type="checkbox"]:checked ~ nav {
  width: 250px;
}
input[type="checkbox"]:checked ~ nav label[for="menu_state"] i::before {
  content: "\f053";
}
input[type="checkbox"]:checked ~ nav ul {
  width: 100%;
}
input[type="checkbox"]:checked ~ nav ul li a i {
  border-right: 1px solid #2f343e;
}
input[type="checkbox"]:checked ~ nav ul li a span {
  opacity: 1;
  transition: opacity 0.25s ease-in-out;
}
input[type="checkbox"]:checked ~ main {
  left: 250px;
}
nav {
  position: fixed;
  z-index: 9;
  top: 0;
  left: 0;
  bottom: 0;
  background: #383e49;
  color: #9aa3a8;
  width: 50px;
  font-family: 'Montserrat', sans-serif;
  font-weight: lighter;
  transition: all 0.15s ease-in-out;
}
nav label[for="menu_state"] i {
  cursor: pointer;
  position: absolute;
  top: 50%;
  right: -8px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
  background: #fff;
  font-size: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 15px;
  width: 15px;
  border-radius: 50%;
  border: 1px solid #ddd;
  transition: width 0.15s ease-in-out;
  z-index: 1;
}
nav label[for="menu_state"] i::before {
  margin-top: 2px;
  content: "\f054";
}
nav label[for="menu_state"] i:hover {
  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
}
nav ul {
  overflow: hidden;
  display: block;
  width: 50px;
  list-style-type: none;
  padding: 0;
  margin: 0;
}
nav ul li {
  border: 1px solid #2f343e;
  position: relative;
}
nav ul li.unread:after {
  content: attr(data-content);
  position: absolute;
  top: 10px;
  left: 25px;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 15px;
  height: 15px;
  border-radius: 50%;
  color: #fff;
  background: #ef5952;
  font-size: 8px;
}
nav ul li:not(:last-child) {
  border-bottom: none;
}
nav ul li.active a {
  background: #4c515d;
  color: #fff;
}
nav ul li a {
  position: relative;
  display: block;
  white-space: nowrap;
  text-decoration: none;
  color: #9aa3a8;
  height: 50px;
  width: 100%;
  transition: all 0.15s ease-in-out;
}
nav ul li a:hover {
  background: #4c515d;
  color: #fff;
}
nav ul li a * {
  height: 100%;
  display: inline-block;
}
nav ul li a i {
  text-align: center;
  width: 50px;
  z-index: 999999;
}
nav ul li a i.fa {
  line-height: 50px;
}
nav ul li a span {
  padding-left: 25px;
  opacity: 0;
  line-height: 50px;
  transition: opacity 0.1s ease-in-out;


}

</style>
</head>

<body>
<input type="checkbox" id="menu_state" checked>
<nav>
	<label for="menu_state"><i class="fa"></i></label>
	<ul>
    <li>
      <a href="main.do">
        <i class="glyphicon glyphicon-home"></i>
        <span>메인으로</span>   <!--환자 대기 목록,병실 목록 및 현황-->
      </a>
    </li>
		<li>
			<a href="P_addui.do">
				<i class="glyphicon glyphicon-plus"></i>
				<span>환자 추가</span>
			</a>
		</li>
		<li>
			<a href="D_addui.do">
				<i class="glyphicon glyphicon-plus"></i>
				<span>의사 추가</span>
			</a>
		</li>
		
		<li>
			<a href="D_clsif.do">
				<i class="glyphicon glyphicon-calendar"></i>
				<span>의사 부서 정보</span>
			</a>
		</li>
		
		<li>
			<a href="cristal.do">
				<i class="glyphicon glyphicon-pencil"></i>
				<span>환자 수정</span>
			</a>
		</li>
		<li>
			<a href="delsel.do">
				<i class="fa fa-trash"></i>
				<span>환자 삭제</span>
			</a>
		</li>
      <li>
      <a href="insel.do">
        <i class="glyphicon glyphicon-log-in"></i>
        <span>입실</span>
      </a>
    </li>
        <li>
      <a href="javascript:void(0)">
        <i class="glyphicon glyphicon-log-out"></i>
        <span>퇴실</span>
      </a>
    </li>
	</ul>
</nav>

<section style="position:absolute; top:80px;left:300px">
     <table border="1" class="table table-striped">
      	<tr class="success">
      		<td>환자 번호</td>
      		<td>환자 이름</td>
      		<td>주민 번호</td>
      		<td>성별</td>
      	</tr>
      	
      	<c:forEach items="${search}" var="dto">
	      	<tr>
	      		<td>${dto.p_NUM}</td>
	      		<td>${dto.p_NAME}</td>
	      		<td>${dto.p_PERNUM}</td>
	      		<td>${dto.p_GENDER }</td>
	      	</tr>
		</c:forEach>
      </table>
</section>

<section style="position:absolute; top:80px;left:850px">
     <table border="1" class="table table-striped">
      	<tr class="success">
      		<td>의사 번호</td>
      		<td>의사 이름</td>
      		<td>주민 번호</td>
      		<td>성별</td>
      		<td>전문</td>
      	</tr>
      	

      	<c:forEach items="${search}" var="dto">
	      	<tr>
	      		<td>${dto.d_NUM}</td>
	      		<td>${dto.d_NAME}</td>
	      		<td>${dto.d_PERNUM}</td>
	      		<td>${dto.d_GENDER }</td>
	      		<td>${dto.d_CLS}</td>
	      	</tr>
		</c:forEach>
      </table>
</section>
</body>
</html>