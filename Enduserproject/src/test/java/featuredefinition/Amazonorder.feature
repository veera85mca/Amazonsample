@First
Feature: Test amazon application purchase order

Background:
Given User launch the url in browser

@Firstapp
Scenario: First scenario user book check out the order
When User landed on homepage
Given User enter the book in search bar
When User landed on add to cart button page
And User validate the product price in add to cart page
But User slick the proceed cart page
Then User landed on billing page

