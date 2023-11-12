package com.example.service;

import com.example.model.Clazz;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClazzService implements IClazzService<Clazz>{
    private final Connection connection = ConnectionToMySql.getConnection();

    public List<Clazz> findAll() {
        List<Clazz> clasezList = new ArrayList<>();
        String sql = "select *from classRoom;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("classname");
                Clazz clazz = new Clazz(id, name);
                clasezList.add(clazz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clasezList;
    }
}
