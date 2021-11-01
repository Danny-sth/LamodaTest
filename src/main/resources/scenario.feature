Feature: Filling Cart
  Scenario: Add clothes to cart
    Given url of Lamoda 'https://www.lamoda.ru/'
    When website is open accept cookie
    Then start search 'кроссовки'
    Then click on first image
    And choose the size
    Then click add button
    Then assert that clothes have been added to cart