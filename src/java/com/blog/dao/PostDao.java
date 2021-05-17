package com.blog.dao;
import com.blog.entities.Category;
import com.blog.entities.Post;
import java.sql.*;
import java.util.ArrayList;

public class PostDao {
    
    private Connection con;
    
    public PostDao(Connection con){
        this.con=con;
    }
    
    public ArrayList<Category>getAllCategory(){
        ArrayList<Category> list=new ArrayList<>();
        
        try{
            
            String query="Select * from categories";
            Statement st=this.con.createStatement();
            ResultSet set=st.executeQuery(query);
            
            while(set.next()){
                int cid=set.getInt("cid");
                String name=set.getString("name");
                String description=set.getString("description");
                Category c=new Category(cid,name,description);
                list.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public boolean savePost(Post p){
        boolean flag=false;
        
        try{
            String q="insert into posts(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareCall(q);
            
            pstmt.setString(1, p.getpTitle());
            pstmt.setString(2, p.getpContent());
            pstmt.setString(3, p.getpCode());
            pstmt.setString(4, p.getpPic());
            pstmt.setInt(5, p.getCatId());
            pstmt.setInt(6, p.getUserId());
            
            pstmt.executeUpdate();
            flag=true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
}
