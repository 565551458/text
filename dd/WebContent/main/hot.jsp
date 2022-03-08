<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>廉价商品
</h2>
<div class="book_c_04">
  <c:forEach items="${bookList }" var="book">
	<div class="second_d_wai">
		<div class="img">
			<a href="#" target='_blank'><img
					src="../productImages/${book.product_pic }"  border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">${book.product_name }</a><a href="#" target="_blank"></a>
		</div>
			<div class="price">
				定价：￥${book.fixed_price }
			</div>
			<div class="price">
				当当价：￥${book.dang_price }
			</div>
	</div>
	</c:forEach>
	<div class="book_c_xy_long"></div>

</div>
<div class="clear"></div>