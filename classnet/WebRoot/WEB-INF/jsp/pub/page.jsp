<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div style="padding-right:20px;">
	<span class="pagecss">
		<a href="javascript: gotoPage(1)">首页</a>
		<s:if test="currentPage>1">
			<a href="javascript: gotoPage(${currentPage-1 })">上一页</a>
		</s:if>
		<s:iterator begin="begin" end="end" var="num">
			<s:if test="currentPage== #num">
				<strong>${num }</strong>
			</s:if>
			<s:else>
				<a href="javascript: gotoPage(${num })">
					${num }
				</a>
			</s:else>
		</s:iterator>
		<s:if test="currentPage < pageCount">
			<a href="javascript: gotoPage(${currentPage+1 })">下一页</a>
		</s:if>
		<a href="javascript: gotoPage(${pageCount })">尾页</a>
	</span>
</div>