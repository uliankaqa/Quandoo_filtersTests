Feature: Filters function tests
  Background:
    Given user is on Berlin Restaurants page

 Scenario: Top Rated filter test
   When user click on Top Rated button
  Then  user see filtered Top Rated list of restaurants

 Scenario Outline:Cuisine filter test
   When user click on Cuisine <Kitchen> check box
   Then  user see filtered for <Kitchen> list of restaurants
   Examples:
     | Kitchen              |  |
     | cuisine_filter1.name |  |
   | cuisine_filter2.name |  |
    | cuisine_filter3.name |  |
