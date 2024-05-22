Feature: Verify main page functionality

  Scenario:
    Given user is on main page
    When user scroll down to the buttom of the page
    And user fill out Leave A Message form, giving "name", "email" and "message"
    And user clicks on send message button
    Then user see message "Thanks for contacting us"

  Scenario:
    Given user is on main page
    Then user should see all available features in top menu
      | Home                  |
      | About us              |
      | Our Approach          |
      | Products and Services |
      | Contact               |
      | LOGIN                 |

  @wip @ui
  Scenario:
    Given user is on main page
    When user hover over "Our Approach" tab
    Then user can see the options
      | Our Mission and Vision |
      | Car Fleet Management   |
      | Newest Technologies    |
      | Tailor Made Solutions  |
    And user clicks on "Car Fleet Management"
    Then user should see "Car Fleet Management | VYTrack" in the title