<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<div class=second_c_02_b1>
			<c:forEach items="${bookList }" var="book">
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="/dd/productImages/${book.product_pic }" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='书名'>${book.product_name }</a>
				</h3>
				<h4>
					作者：${book.author } 著
					<br />
					出版社：${book.publishing }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：${book.publishTime}
				</h4>
				<h5>
					简介:${book.description }
				</h5>
				<h6>
					定价：￥${book.fixed_price }&nbsp;&nbsp;当当价：￥${book.dang_price }
				</h6>
				<div class=line_xx></div>
			</div>
				</c:forEach>
		</div>
	</div>
</div>