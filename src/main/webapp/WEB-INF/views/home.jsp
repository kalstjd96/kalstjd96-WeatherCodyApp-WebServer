<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<table>
        <thead>
            <tr>
                <th>기본키</th>
                <th>상의</th>
                <th>하의</th> 
                <th>온도</th>
                <th>습도</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${weatherList}" var="weather">
                <tr>
                    <td>${weather.mno}</td>
                    <td>${weather.top}</td>
                    <td>${weather.pants}</td>
                    <td>${weather.tem}</td>
                    <td>${weather.hum}</td>   
                </tr>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>
