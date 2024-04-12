package by.javaguru.jakartaservletrequest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Root{
    public String info;
    public ArrayList<Employee> employees;
}
