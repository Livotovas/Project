Feature: Users Table Page Test

Scenario: Main Interface Test
Given I am on HOME PAGE
And I login as user 'Piter_Chailovskii'
When I click on 'Service' category in the header
And I click on 'User_Table' in the header "Service" menu
Then Browser title should be 'User_Table'
  And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
  And 6 User names are displayed on Users Table on User Table Page
  And 6 Description images are displayed on Users Table on User Table Page
  And 6 Description texts under images are displayed on Users Table on User Table Page
  And 6 checkboxes are displayed on Users Table on User Table Page
  And User table contains following values:
    | Number | User             | Description                      |
    | 1      | Roman            | Wolverine                        |
    | 2      | Sergey Ivan      | Spider Man                       |
    | 3      | Vladzimir        | Punisher                         |
    | 4      | Helen Bennett    | Captain America some description |
    | 5      | Yoshi Tannamuri  | Cyclope some description         |
    | 6      | Giovanni Rovelli | Hulk some description            |

  When I select 'vip' checkbox for 'Sergey_Ivan'
  Then 1 log row has "Vip: condition changed to" 'true' text in log section

  When I click on dropdown in column "NumberType" for user 'Roman'
  Then droplist contains values
    | Admin   |
    | User    |
    | Manager |