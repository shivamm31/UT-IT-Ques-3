package validatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
class EmployeeValidatorTest extends AnyFunSuite{

  val FirstEmployeeJohn = Employee("John", "Lee", 32,50000, "Software Consultant", "Knoldus", "johnlee123@gmail.com" )
  val SecondEmployeeMorsion = Employee("Morsion", "Gill", 26,30000, "Software Trainee", "Philips", "morsiongill@gmail.com" )
  val ThirdEmployeeKaty = Employee("Katy", "Perry", 43,65000, "Sr. Software Engineer", "CTS", "katyperry43@gmail.com" )
  val FourthEmployeeBrown = Employee("Brown", "Strowman", 22,25000, "Software Consultant", "Knoldus", "brownstrowman21?@gmail.com" )


  test("Checking if Employee- employeeOneDavid working in Knoldus(company present in Database) is a valid Employee"){
    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(FirstEmployeeJohn)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeTwoLeo working in Philips(company present in Database) is a valid Employee"){

    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(SecondEmployeeMorsion)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeThreeSimon working in company TCS(company not present in Database) is thus an invalid Employee"){

    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(ThirdEmployeeKaty)
    assert(expectResult == result)
  }

  test("Checking if Employee- employeeFourSam working in Knoldus(company present in Database) having invalid Email ID is thus an invalid Employee"){
    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(FourthEmployeeBrown)
    assert(expectResult == result)
  }

}
