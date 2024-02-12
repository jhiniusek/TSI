Feature: Actors
  Actor entities can be initialised and store details

  Scenario: An actor has an ID
    Given an actor
    When I set the actor's id to 500
    Then Actor's id is 500

  Scenario: An actor has a first name
    Given an actor
    When I set the actor's first name to "Fergus"
    Then Actor's first name is "Fergus"

  Scenario: An actor has a last name
    Given an actor
    When I set the actor's last name to "Sigma"
    Then Actor's last name is "Sigma"