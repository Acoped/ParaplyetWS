/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParaplyModel;

import RESTResource.ParaplyetWSResource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Molnet
 */
public class EnrollCode {
    private String EnrollCode;
    
    private EnrollCode(){}
    
    public EnrollCode(String courseCode, String semesterCode)   {
        DbConnection db = new DbConnection();
        setEnrollCode("No enrollcode exists for that course/semester combo.");
        
        try {
            ResultSet rs = db.runSql("SELECT EnrollCode FROM new_table WHERE CourseCode = '"
                    + courseCode
                    + "' AND SemesterCode = '"
                    + semesterCode
                    + "';");
            while (rs.next()) {
                setEnrollCode(rs.getString("EnrollCode"));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(ParaplyetWSResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the EnrollCode
     */
    public String getEnrollCode() {
        return EnrollCode;
    }

    /**
     * @param EnrollCode the EnrollCode to set
     */
    public void setEnrollCode(String EnrollCode) {
        this.EnrollCode = EnrollCode;
    }
    
}
