# UnidaysPlacementChallenge
Approach:
- Test class(main class_:
	- create a rule list of items
	- start shopping by adding items in bag
	- calculate result
	- output result

- Item class:
	- has type, price, discount

- Unidays class:
	- contains all pricing rules
	- basket is a hashMap with key - type of item and value - frequency of item added into basket
	- the addToBasket method adds the items selected by the user.
	- the calculateTotalPrice method takes all items from basket, verifies to which it correspons from the pricingRules list and with that, based on the discount of that specific item it calculates total price and delivery charge.

- Result class:
	- has a total;
	- has a deliveryCharge;
	- getTotal method calculates for each type of discount the price for a member of some item.
	- I considered discount given as Strig and classified them based on key words such as "free" or "price". That's how I know how to make use of numbers in the discount string in order to calculate the total price amount.

Run:
- take the whole package and run it on an IDE such as NetBeans or Eclipse.
- the test class lets you change the pricingRule items and also based on those items, change the type of items added in basket.
