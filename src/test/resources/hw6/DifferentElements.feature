Feature: Different Elements Page Test

  Scenario: Main Interface Test
    Given I open EPAM JDI site
    Then Browser title should be 'Page_Title'
    And Home Page contains required elements

    When I login as user 'Piter_Chailovskii'
    Then User name should be 'Piter_Chailovskii'
    When I click on "Service" category in the left section
    Then Left dropdown contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGE    |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I click on 'Service' category in the header
    Then Header dropdown contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGE    |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I click on 'Different_Elements' in the header "Service" menu
    Then Different Elements Page contains requared elements
    And Right section exists
    And Left section exists

    When I select elements:
      | WATER |
      | WIND  |
    Then They are marked as 'true' on logs:
      | WATER |
      | WIND  |

    When I select 'SELEN'
    Then Log is correct for 'SELEN'

    When I select color 'YELLOW'
    Then Log is correct for 'YELLOW'

    When I select elements:
      | WATER |
      | WIND  |
    Then They are marked as 'false' on logs:
      | WATER |
      | WIND  |