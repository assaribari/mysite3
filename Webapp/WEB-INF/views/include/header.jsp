<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<a href="/mysite3/index"><h1>MySite</h1></a>
	
	<ul>
	<c:choose>
		<c:when test = "${empty sessionScope.authMember}">
		<li><a href="/mysite3/member/login">로그인</a><li>
		<li><a href="/mysite3/member/join">회원가입</a><li>
		</c:when>
		<c:otherwise>
		<li><a href="/mysite3/member?a=uinfo">회원정보수정</a><li>
		<li><a href="/mysite3/member/logout">로그아웃</a><li>
		<li>${authMember.getName() }님 안녕하세요 ^^;</li>
		</c:otherwise>
	</c:choose>	

		
	</ul>