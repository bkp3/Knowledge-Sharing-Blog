package com.blog.dao;
import com.blog.entities.Category;
import java.sql.*;
import java.util.ArrayList;

public class PostDao {
    
    Connection con;
    
    public PostDao(Connection con){
        this.con=con;
    }
    
    public ArrayList<Category>getAllCategory(){
        ArrayList<Category> list=null;
        
        
        return null;
    }
    
}
