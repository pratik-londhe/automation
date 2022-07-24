@streams_event_product_manager
Feature: Event3.0 product Add, Edit and Delete functionality

Scenario: Add, Edit and Delete event3.0 products.
    Given Login to streams using UI
    And Select the streams channel for automation
    And Add a Product
    | ProductTitle              | Catagories | AboutText          | FileName    | ProductPrice | ProductSalePrice | BuyNowURL               | BuyNowButtonName | AttributeName | AttributeValue |   
    | Automation Lakme Product  | Beauty     | Its beauty product | avatar1.jpg | 1000         | 999              | https://lakmeindia.com/ | Lakme            | Color         | Red            |  
    And Edit a Product
    | ProductTitle             | EditProductName     |
    | Automation Lakme Product | New Updated Product |
    And Delete a Product
    | EditProductName     |
    | New Updated Product |