package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    Changer changer;

    public List<Company> searchCompanyByFragmentOfName(String fragmentOfName) {
        return companyDao.retrieveCompanyByFragmentOfName(changer.changeWord(fragmentOfName));
    }

    public List<Employee> searchEmployeeByFragmentOfName(String fragmentOfName) {
        return employeeDao.retrieveEmployeeByFragmentOfName(changer.changeWord(fragmentOfName));
    }

}
