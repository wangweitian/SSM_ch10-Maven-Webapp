<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
 		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${userNum }条记录&nbsp;&nbsp; ${currentPage }/${pageTimes}页</li>
				<c:if test="${currentPage == 1}">
            <span class="disabled"><< 前一页</span>        
        </c:if>
         <c:if test="${currentPage != 1}">
             <a href="userList.do?page=${currentPage-1}"><< 前一页</a>
        </c:if>                                      
         <c:if test="${currentPage == pageTimes}">
             <span class="disabled">后一页 >></span>        
         </c:if>
       <c:if test="${currentPage != pageTimes}">
         <a href="userList.do?page=${currentPage+1}">后一页 >></a>
         </c:if>
				&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="page" id="inputPage" class="page-key" />页
	<a href="userList.do?"><button type="button" class="page-btn" onClick=''>GO</button></a> 
	 <!--   <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("currentPage").value)'>GO</button> -->
		</span>
		</div> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rollpage.js"></script>
</html>