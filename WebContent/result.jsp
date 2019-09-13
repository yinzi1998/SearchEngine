<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Photo-Hub Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href='http://fonts.useso.com/css?family=Quicksand:300,400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/menu_jquery.js"></script>
<title>result</title>
</head>
<body>
    <div class="new">
    <div class="span_1_of_1">  
			    <div class="search">
			    <form action="search" method="get">
			      <ul class="nav1">
		            <li id="search">
						<% String content=(String)request.getAttribute("content");%>
							<input type="text" name="search_text" id="search_text" placeholder="Search" value=<%= content%>></input>
							<input type="submit" name="search_button" id="search_button" value=" ">
							
						
					</li>
					<select style="width:100px;height:50px;" name="choice" />
						<option value="1">search All</option>
						<option value="3">Abstract</option>
						<option value="4">Author</option>
						<option value="5">Title</option>
						</select>
	              </ul>
	              </form>
			
	            </div>
	            
	            
	              
	</div><br><br>
	<div class="back1" style="padding-left:10%;padding-right: 10%;padding-top: 50px">
	                
	                <a href="index.jsp">返回首页</a>
	                
	            </div>
	
	<div class="new1" style="padding-left:10%;padding-right: 10%;padding-top: 50px">
 	<% 	String [][] con=(String [][])request.getAttribute("search_contents");
 		if(con!=null){	
 			int len=con.length;	
			for(int i=0;i<len;i++){
				String title_href = con[i][0].replace("’", " ");
				title_href = title_href.replace("”", " ");
				title_href = title_href.replace("“", " ");
				title_href = title_href.replace("&", " ");
				title_href = title_href.replace("–", " ");
				con[i][1] = con[i][1].replace(".txt","");
	%>
	    <div >
	    
	        <a href="detail.jsp?title=<%=title_href %>" style="font-size:20px;display:block;color:#84AF9B" name="title"><%=con[i][0] %></a>
	        <a style="font-size:17px;display:block;color:#2C3E50"><%=con[i][1] %></a>
	    </div><br>
	    <%
	    	}
		}
		else{
		%>
			<h1>无搜索结果</h1>
		<%
		}
	    %>
	</div>	
	</div>

</body>
</html>