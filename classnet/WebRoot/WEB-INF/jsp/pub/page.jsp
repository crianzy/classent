<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<style type="text/css">
/* 分页 */
.class_page_topic {
	clear: left;
	text-align: left;
	color: #4C9DCE;
}

.class_page_topic ul,.class_page_topic li {
	padding: 0px;
	margin: 0px 0px 0px 10px;
	text-align: left;
	list-style: none;
}

.class_page_topic a,.class_page_topic strong {
	display: inline-block;
	border: 1px solid #D7E5F2;
	line-height: 160%;
	text-decoration: none;
	padding: 0 5px;
	color: #4C9DCE;
}

.class_page_topic strong {
	background: #5384AF;
	color: #fff;
}
</style>
<div class="class_page_topic">
	<span class="pagecss">
		<div style="padding-right:20px;">
			<span class="pagecss"> <a href="javascript: gotoPage(1)">首页</a>
				<s:if test="currentPage>1">
					<a href="javascript: gotoPage(${currentPage-1 })">上一页</a>
				</s:if> <s:iterator begin="begin" end="end" var="num">
					<s:if test="currentPage== #num">
						<strong>${num }</strong>
					</s:if>
					<s:else>
						<a href="javascript: gotoPage(${num })"> ${num } </a>
					</s:else>
				</s:iterator> <s:if test="currentPage < pageCount">
					<a href="javascript: gotoPage(${currentPage+1 })">下一页</a>
				</s:if> <a href="javascript: gotoPage(${pageCount })">尾页</a> </span>
		</div> </span>
</div>