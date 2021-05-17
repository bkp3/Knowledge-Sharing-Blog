<%@page import="java.util.List"%>
<%@page import="com.blog.entities.Post"%>
<%@page import="com.blog.dao.PostDao"%>
<%@page import="com.blog.helper.ConnectionProvider"%>

<div class="row">
<%

    PostDao d = new PostDao(ConnectionProvider.getConnection());
    List<Post> posts = d.getAllPosts();
    for(Post p:posts){
       %> 
       
       <div class="col-md-6 mt-2">
           <div class="card">
               <img class="card-img-top" src="blog_pics/<%=p.getpPic() %>" alt="Card image cap">
               <div class="card-body">
                   <b><%= p.getpTitle() %></b>
                   <p><%=p.getpContent() %></p>
                   <pre><%=p.getpCode() %></pre>
               </div>
           </div>
           
       </div>
       
       
       <%
    }





%>

</div>