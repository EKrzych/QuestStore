package com.codecool.faniUMLa.Queststore.DAO;

import com.codecool.faniUMLa.Queststore.model.users.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOAdmin implements DAOAdminInterface {
    private DAOAdminHelper helper;
    Connection connection;

    public DAOAdmin(Connection connection) {
        this.connection = connection;
        helper = new DAOAdminHelper(connection);
    }

    public void createClass(String className) {
        helper.addClass(className);
    }

    public ArrayList<Mentor> getAllMentors() {
        ArrayList<Mentor> mentorsList = new ArrayList<>();
        ResultSet rs;
        PreparedStatement query;
        String ALL_MENTORS = " SELECT * FROM users WHERE user_access = 'MENTOR'";
        try {
            query = connection.prepareStatement(ALL_MENTORS);
            rs = query.executeQuery();
            while (rs.next()) {
                Integer id_User = rs.getInt("id_user");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                mentorsList.add(new Mentor(id_User, first_name, last_name, email, phone_number));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentorsList;
        }

        public Mentor getMentor(int index) {
            ArrayList<Mentor> mentorsList;
            mentorsList = getAllMentors();
            return mentorsList.get(index);
        }

    public void createMentor(ArrayList <String> userData) {
        helper.addUserToDataBase(userData);
        helper.updateMentors(userData);
    }

    public void editMentor(String column_name, String changedWord, Integer idUser) {
        PreparedStatement mentorUpdate = helper.prepareQueryForUpdatedMentor(column_name, changedWord, idUser);
        try {
            mentorUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createLevel(String level_name){
        helper.addLevel(level_name);
    }
}

