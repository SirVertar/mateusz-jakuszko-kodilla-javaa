package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTaskSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    Facade facade;

    @Test
    public void getCompaniesByFragmentOfName() {
        //Given
        Company company1 = new Company("STRABAG");
        Company company2 = new Company("EMINEM");
        Company company3 = new Company("WMRABAG");

        //When
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        int company1Id = company1.getId();
        int company2Id = company2.getId();
        int company3Id = company3.getId();

        //Then
        assertEquals(2, facade.searchCompanyByFragmentOfName("RAB").size());

        //Clean
        try {
            companyDao.deleteById(company1Id);
            companyDao.deleteById(company2Id);
            companyDao.deleteById(company3Id);
        } catch (Exception e) {

        }
    }

    @Test
    public void getEmployeesByFragmentOfName() {
        //Given
        Employee employee1 = new Employee("Mateusz", "Jakuszko");
        Employee employee2 = new Employee("Mikolaj", "Broda");
        Employee employee3 = new Employee("Marcin", "Wąsy");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        int employee1Id = employee1.getId();
        int employee2Id = employee2.getId();
        int employee3Id = employee3.getId();

        //Then
        assertEquals(3, facade.searchEmployeeByFragmentOfName("M").size());

        //CleanUp
        employeeDao.deleteById(employee1Id);
        employeeDao.deleteById(employee2Id);
        employeeDao.deleteById(employee3Id);
    }

}
