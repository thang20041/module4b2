package com.example.service;

import com.example.model.Clazz;
import com.example.model.Student;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService implements IStudentService<Student> {
    private final Connection connection = ConnectionToMySql.getConnection();

    @Override
    public List<Student> FindAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select s.*,cR.className from student s join classRoom cR on cR.id = s.classRoomId;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String date = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phoneNumber");
                int classId = resultSet.getInt("classRoomId");
                String classname = resultSet.getString("className");
                Clazz clazz = new Clazz(classId, classname);
                Student student = new Student(id, name, date, email, address, phone, clazz);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        String sql = "INSERT INTO student (name, email, dateOfBirth, address, phoneNumber, classRoomId) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDob());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhone());
            statement.setInt(6, student.getClazz().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean edit(int id, Student student) {
        String sql = "update student set name =?,email=?,dateOfBirth=?,address=?,phoneNumber=?,classRoomId=? where id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDob());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhone());
            statement.setInt(6, student.getClazz().getId());
            statement.setInt(7, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }

    public Student findStudentById(int id) {
        String sql = "select * from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String date = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phoneNumber");
                int classId = resultSet.getInt("classRoomId");
                Clazz clazz = new Clazz(classId);
                Student student = new Student(id, name, email, date, address, phone, clazz);
                return student;
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
