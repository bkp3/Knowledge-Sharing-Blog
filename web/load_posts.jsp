<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.blog.entities.Post"%>
<%@page import="com.blog.dao.PostDao"%>
<%@page import="com.blog.helper.ConnectionProvider"%>

<div class="row">
    <%

        Thread.sleep(500);
        PostDao d = new PostDao(ConnectionProvider.getConnection());
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Post> posts = new ArrayList<>();
        if (cid == 0) {

            posts = d.getAllPosts();
        } else {
            posts = d.getPostByCatId(cid);
        }
        
        if(posts.size()==0){
            out.println("<h3 class='display-3 text-center'>No Posts in this category...</h3>");
            return;
        }
        
        for (Post p : posts) {
    %> 

    <div class="col-md-6 mt-2">
        <div class="card">
            <img class="card-img-top" src="blog_pics/<%=p.getpPic()%>" alt="Card image cap">
            <div class="card-body">
                <b><%= p.getpTitle()%></b>
                <p><%=p.getpContent()%></p>
                <pre><%=p.getpCode()%></pre>
            </div>
        </div>

    </div>


    <%
        }


    %>

</div>