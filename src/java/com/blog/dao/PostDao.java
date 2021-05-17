package com.blog.dao;
import com.blog.entities.Category;
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
    
}
