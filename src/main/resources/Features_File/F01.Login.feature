Feature: Login Feature

  Background:
            Given User open the browser and navigate to Login Page

  Scenario: Login With Empty Email / password ( Invalid.1)

    When Leave Email and Password Fields Empty
    And  User click on Login Button
    Then User Still on Login Page
    And  Login Fail with error message Field required user pass


  Scenario: Login With Valid User_Name and wrong Password ( Invalid.2 )

    When Enter valid user_name which is "Admin" with Wrong Password which is "ADMIN123"
    Then User click on Login Button
    And  User Still on Login Page
    And  Login Fail with error message Invalid credentials


  Scenario: Login With Invalid User_Name and Valid Password ( Invalid.3 )

    When Enter Invalid user_name which is "AdminAdmin" with Valid Password which is "admin123"
    Then User click on Login Button
    And  User Still on Login Page
    And  Login Fail with error message Invalid credentials


  Scenario: Login With Missing mandatory field password ( Invalid.4)

    When Enter Valid user_name which is "Admin" with Empty Password
    Then User click on Login Button
    And  User Still on Login Page
    And  Login Fail with error message Field required pass

  Scenario: Login With Missing mandatory field UserName ( Invalid.5)

    When Enter Valid Password which is "admin123" with Empty UserName
    Then User click on Login Button
    And  User Still on Login Page
    And  Login Fail with error message Field required user

  Scenario: Login with valid data ( User_Name / Password ) ( Valid.6)

    When Enter Valid user_name which is "Admin" with Valid Password which is "admin123"
    Then User click on Login Button
    And  Login Success and User directed to Dashboard Page